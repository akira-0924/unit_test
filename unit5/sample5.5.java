// 実装の詳細が漏れているUserクラス
public class User
{
  public string Name { get; set; }

  public string NormalizeName(string name)
  {
    string result = (name ?? "").Trim();
    if (result.Length > 50)
      return result.Substring(0, 50);
    return result;
  }
}

public class UserController
{
  public void RenameUser(int userId, string newName)
  {
    User user = GetUserFromDatabase(userId);
    string normalizedName = user.NormalizeName(newName);
    user.name = normalizedName;
    SaveUserToDatabase(user);
  }
}