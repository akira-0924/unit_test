public class User {
  private int UserId { get; private set; }
  private string Email { get; private set; }
  private UserType Type { get; private set; }

  public void ChangeEmail(int userId, string newEmail) 
  {
     object[] data = Database.getUser(userId);
     UserId = userId;
     Email = (string)data[1];
     Type = (UserType)data[2];

     if(Email == newEmail) {
      return;
     }

     object[] companyData = Database.getCompany(UserId);
     string companyDomainName = (string)companyData[0];
     int numberOfEmployees = (int)companyData[1];

     string emailDomain = newEmail.Split('@')[1];
     bool @isEmailCorporate = emailDomain == companyDomainName;
    //  メールアドレスに含まれるドメインをもとにユーザーの種類を決める
     UserType newType = isEmailCorporate ? UserType.Employee : UserType.Customer;

     if(Type == newType)
     {
      int delta = newType == UserType.Employ
     }
  }
}
