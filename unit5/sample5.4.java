// レポートを作成する
[Fact]
public void Creating_a_report()
{
  var stub = new Mock<IDatabase>();
  stub.Setup(x => x.GetNumberOfUsers()).Returns(10);
  var sut = new Controller(stub.Object);

  Report report = sut.CreateReport();

  Assert.Equal(10, report.NumberOfUsers);
  // スタブとのコミュニケーションを検証してしまっている
  stub.Verify(x => x.GetNumberOfUsers(), Times.Once);
}
