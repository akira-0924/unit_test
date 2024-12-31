# 単体テストの構造的解析

## 単体テストの構造

### AAA パターン

- Arrange（準備）
  - テストケースの事前条件を満たすようにテスト対象のシステムとその依存を状態を設定する
- Act（実行）
  - テスト対象のシステムを実行する
- Assert（検証）
  - テスト対象のシステムの実行結果を検証する

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

ほとんどの場合は上記のように 3 つの順序でテストケースを作成していくことは問題ないが、これとは別の方法として確認フェーズから書き始めるという方法もある。
