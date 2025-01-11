// 在庫が十分にないときは購入に失敗する
[Fact]
public void Purchase_fails_when_not_enough_inventory()
{
  var storeMock = new Mock<IStore>();
  // 呼びされたときに返す結果を事前に準備しておく
  storeMock.Setup(x => x.HasEnoughInventory(Product.Shampoo, 5)).Returns(false);
  var sut = new Customer(storeMock.Object);

  bool success = sut.Purchase(storeMock.Object, Product.Shampoo, 5);

  Assert.False(success);
  // テスト対象システムからの呼び出しを検証する
  storeMock.Verify(x => x.RemoveInventory(Product.Shampoo, 5), Times.Never);
}
