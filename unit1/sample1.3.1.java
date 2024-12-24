public static bool isStringLong(string input)
{
  if(input.length() > 10)
  {
    return true;
  }
  return false;
}

public void Test()
{
  bool result = isStringLong("abc");
  Assert.Eq(result, false);
}