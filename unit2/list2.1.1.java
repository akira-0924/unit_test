// 「顧客が商品を買う」というビジネスロジックをテストする
[Fact]
public void purchase_success_when_enough_inventory() {
  // 準備(Arrange)
  var store = new Store();
  store.addInventory(Product.shampoo, 10);
  var customer = new Customer();

  // 実行(Act)
  bool success = customer.purchase(store, Product.shampoo, 5);

  // 確認(Assert)
  Assert.True(success);
  // 在庫が減っていることを確認
  Assert.Equal(5, store.inventory.get(Product.shampoo));
}

[Fact]
// 在庫が十分にない場合は、購入に失敗する
public void purchase_fails_when_not_enough_inventory() {
  // 準備(Arrange)
  var store = new Store();
  store.addInventory(Product.shampoo, 10);
  var customer = new Customer();

  // 実行(Act)
  bool success = customer.purchase(store, Product.shampoo, 15);

  // 確認(Assert)
  Assert.False(success);
  // 在庫が減っていないことを確認
  Assert.Equal(10, store.inventory.get(Product.shampoo));
}


public enum Product {
  shampoo,
  toothbrush,
  soap,
}
