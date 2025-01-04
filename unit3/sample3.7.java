public class CustomerTests
{
  // 共通として使われるテスト・フィクスチャ
  private readonly Store _store;
  private readonly Customer _sut;

  // 各テスト・ケースが実行されるときに毎回呼び出される
  public CustomerTests()
  {
    _store = new Store();
    _store.addInventory(Product.Shampoo, 10);
    _sut = new Customer();
  }

  // 在庫が十分にある場合、購入は成功する
  [Fact]
  public void Purchase_succeeds_when_enough_inventory()
  {
    bool success = _sut.Purchase(Product.Shampoo, 5);
    Assert.True(success);
    Assert.Equal(5, _store.GetInventory(Product.Shampoo));
  }

  // 在庫が十分にない場合、購入は失敗する
  [Fact]
  public void Purchase_fails_when_not_enough_inventory()
  {
    bool success = _sut.Purchase(Product.Shampoo, 15);
    Assert.False(success);
    Assert.Equal(10, _store.GetInventory(Product.Shampoo));
  }
}

