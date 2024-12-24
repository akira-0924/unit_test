public static bool isStringLong(string input)
// テスト対象となるyコードの総行数は5行
{
  if(input.length() > 10)
  {
    return true;
  }
  return false;
}

public void Test()
// テストコードの総行数は4行
{
  bool result = isStringLong("abc");
  Assert.Eq(result, false);
}

// よってコード網羅率は4/5 = 80%