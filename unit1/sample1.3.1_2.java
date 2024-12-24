public static bool isStringLong(string input)
// テスト対象となるコードの総行数は3行
{
  return input.length() > 5 ? true : false;
}

public void Test()
// テストコードの総行数は3行
{
  bool result = isStringLong("abc");
  Assert.Eq(result, false);
}

// よってコード網羅率は3/3 = 100%になってしまう
