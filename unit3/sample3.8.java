public class CustomerTests
{
  // 在庫が十分にある場合、購入は成功する
  [Fact]
  public void Purchase_succeeds_when_enough_inventory()
  {
    Store store = CreateStoreWithInventory(Product.Shampoo, 10);
    Customer sut = CreateCustomer();

    bool success = sut.Purchase(Product.Shampoo, 5);

    Assert.True(success);
    Assert.Equal(5, store.GetInventory(Product.Shampoo));
  }

  // 在庫が十分にない場合、購入は失敗する
  [Fact]
  public void Purchase_fails_when_not_enough_inventory()
  {
    Store store = CreateStoreWithInventory(Product.Shampoo, 10);
    Customer sut = CreateCustomer();

    bool success = sut.Purchase(Product.Shampoo, 15);

    Assert.False(success);
    Assert.Equal(10, store.GetInventory(Product.Shampoo));

    // 指定した在庫を抱えるストアを作成する
    private Store CreateStoreWithInventory(Product product, int quantity)
    {
      Store store = new Store();
      store.AddInventory(product, quantity);
      return store;
    }

    // 顧客を作成する
    private Customer CreateCustomer()
    {
      return new Customer();
    }
  }
}
