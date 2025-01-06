// ２つの数値の合計
public void Sum_of_two_numbers()
{
  var sut = new Calculator();

  double result = sut.Sum(1, 2);
  Assert.Equal(3, result);
}

// ２つの数値の合計
public void Sum_of_two_numbers()
{
  var sut = new Calculator();

  double result = sut.Sum(1, 2);
  result.Should().Be(3);
}
