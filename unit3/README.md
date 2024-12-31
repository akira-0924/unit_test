# 単体テストの構造的解析

## 単体テストの構造

### AAA パターン

- Arrange（準備）
- Act（実行）
- Assert（検証）

例）

```
public class Calculator {
    public double Sum(double first, double second) {
        return first + second;
    }
}
```

```
public class CalculatorTest {
  <!-- テストケースであることを示すxUnitの属性 -->
    [Fact]
    <!-- テストケースの名前 -->
    public void Sum_of_two_numbers() {
        // Arrange
        double first = 10;
        double second = 20;
        var calculator = new Calculator();

        // Act
        double result = calculator.Sum(first, second);

        // Assert
        Assert.Equal(3, result);
    }
}
```
