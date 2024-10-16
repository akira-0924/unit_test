// 現時点でファイルが上限に達した時に、新しいファイルが作成される
[Fact]
public void A_new_file_is_created_when_the_current_file_overflows()
{
  var sut = new AuditManager(3);
  var file = new FileContent[]
  {
    new FileContent("audit_1.txt", new string[0]),
    new FileContent("audit_2.txt", new string[] { "Perry Mason;2025-01-13 10:00:00" })
  };

  FileUpdate update = sut.AddRecord(file, "Jane Doe", new DateTime.Parce(2025, 1, 14, 10, 0, 0));

  Assert.Equal("audit_3.txt", update.FileName);
  Assert.Equal("Jane Doe;2025-01-14 10:00:00", update.NewContent);
}
