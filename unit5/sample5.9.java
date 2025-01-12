// 成功時の購入
[Fact]
public void Purchase_Success()
{
  var mock = new Mock<IEmailGateway>();
  var sut = new CustomerController(mock.Object);

  bool isSuccess = sut.Purchase(customerId: 1, productId: 1, quantity: 1);

  Assert.True(isSuccess);
  mock.Verify(x => x.SendReceipt('test@example.com', 'Shampoo', 1), Times.Once);
}
