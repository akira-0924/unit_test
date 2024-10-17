public class ApplicationService
{
  private readonly string _directoryName;
  private readonly AuditManager _auditManager;
  private readonly Persister _persister;

  public ApplicationService(string directoryName, int maxEntriesPerFile)
  {
    _directoryName = directoryName;
    _auditManager = new AuditManager(maxEntriesPerFile);
    _persister = new Persister();
  }

  public void AddRecord(string visitorName, DateTime timeOfVisit)
  {
    FileContent[] files = _persister.ReadDirectory(_directoryName);
    FileUpdate update = _auditManager.AddRecord(files, visitorName, timeOfVisit);
    _persister.ApplyUpdate(_directoryName, update);
  }
}
