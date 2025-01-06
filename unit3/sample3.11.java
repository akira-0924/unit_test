public class DeliveryServiceTests
{
  // 不正な配達日を検出できる
  [InlineData(-1, false)]
  [InlineData(0, false)]
  [InlineData(1, false)]
  [InlineData(2, true)]
  [InlineData(3, true)]

  [Theory]
  public void Can_detect_an_invalid_delivery_date(int daysFromNow, bool expected)
  {
    DeliveryService sut = new DeliveryService();
    DateTime deliveryDate = DateTime.Now.AddDays(daysFromNow);
    Delivery delivery = new Delivery(Date = deliveryDate);

    bool isValid = sut.IsValidDeliveryDate(delivery);

    Assert.Equal(expected, isValid);
  }
}
