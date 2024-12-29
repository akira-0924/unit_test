// 「顧客が商品を買う」というビジネスロジックをテストする
[Fact]
public void purchase_success_when_enough_inventory() {
  // 準備(Arrange)
  var storeMock = new Mock<IStore>();
  storeMock
  // 在庫確認時に呼ばれる
  .Setup(x => x.HasEnoughInventory(Product.shampoo, 5)) 
  // 十分な在庫があることにする
  .Returns(true);


  // 実行(Act)
  bool success = customer.purchase(storeMock.Object, Product.shampoo, 5);

  // 確認(Assert)
  Assert.True(success);
  storeMock.Verify(x => x.HasEnoughInventory(Product.shampoo, 5), Times.Once);
}

[Fact]
// 在庫が十分にない場合は、購入に失敗する
public void purchase_fails_when_not_enough_inventory() {
  // 準備(Arrange)
  var storeMock = new Mock<IStore>();
  storeMock
  // 在庫確認時に呼ばれる
  .Setup(x => x.RemoveInventory(Product.shampoo, 5)) 
  // 十分な在庫がないことにする
  .Returns(false);


  // 実行(Act)
  bool success = customer.purchase(storeMock.Object, Product.shampoo, 5);

  // 確認(Assert)
  Assert.False(success);
  storeMock.Verify(x => x.RemoveInventory(Product.shampoo, 5), Times.Never);
}


public enum Product {
  shampoo,
  toothbrush,
  soap,
}
