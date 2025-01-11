public class User
{
  public string _name;
  public string Name
  {
    get { return _name; }
    set { _name = NormalizeName(value); }
  }

  private string NormalizeName(string name)
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
    user.name = newName;
    SaveUserToDatabase(user);
  }
}