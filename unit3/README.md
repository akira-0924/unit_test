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
    [Fact]
    public void testSum() {
        Calculator calculator = new Calculator();
        assertEquals(3, calculator.Sum(1, 2));
    }
}
```
