// 現時点でファイルが上限に達した時に、新しいファイルが作成される
[Fact]
public void A_new_file_is_created_when_the_current_file_overflows()
{
  var fileSystemMock = new Mock<IFileSystem>();
  fileSystemMock
    .Setup(x => x.GetFiles("audits"))
    .Returns(new string[] { @"audit\audit_1.txt", @"audit\audit_2.txt" });
  fileSystemMock
    .Setup(x => x.ReadAllLines(@"audit\audit_2.txt"))
    .Returns(new List<string> { "John Doe;2025-01-13 10:00:00" });

  var sut = new AuditManager(3, "audits", fileSystemMock.Object);
  sut.AddRecord("Jane Doe", new DateTime(2025, 1, 14, 10, 0, 0));

  fileSystemMock.Verify(x => x.WriteAllText(@"audit\audit_3.txt", "Jane Doe;2025-01-14 10:00:00"), Times.Once);
}
