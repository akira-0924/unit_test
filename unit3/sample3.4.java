public class CalculatorTests 
{
  [Fact]
  public void Sum_of_two_numbers()
  {
    // Arrange
    double first = 10;
    double second = 20;
    // テスト対象のシステムに対して「sut」という名前をつける
    var sut = new Calculator();

    // Act
    var result = sut.Sum(first, second);

    // Assert
    Assert.Equal(30, result);
  }
}
