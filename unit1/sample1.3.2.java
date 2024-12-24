public static bool isStringLong(string input)
// 分岐経路は2つ
{
  return input.length() > 5 ? true : false;
}

public void Test()
// falseの場合のテストコードだけなので、分岐経路は1つ
{
  bool result = isStringLong("abc");
  Assert.Eq(result, false);
}

// よって分岐網羅率は1/2 = 50%になってしまう
