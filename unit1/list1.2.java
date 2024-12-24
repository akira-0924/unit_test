public static bool WasLastStringLong { get; private set; }

public static bool isStringLong(string input)
// 分岐経路は2つ
{
  bool result = input.length() > 5 ? true : false;
  WasLastStringLong = result; ←1つ目の結果
  return result; ←2つ目の結果
}

public void Test()
// falseの場合のテストコードだけなので、分岐経路は1つ
{
  bool result = isStringLong("abc");
  Assert.Eq(result, false); ←ここでは2つ目の結果を検証している
}

public void Test2()
{
  bool result1 = isStringLong("abc"); ←trueを返すがその結果を検証していない
  bool result2 = isStringLong("abcdef"); ←falseを返すがその結果を検証していない
}
