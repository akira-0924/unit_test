public class AuditManager
{
  private readonly int _maxEntriesPerFile;
  private readonly string _directoryName;
  // インターフェースで表現されたファイルシステム
  private readonly IFileSystem _fileSystem;

  public AuditManager(
    int maxEntriesPerFile,
    string directoryName,
    IFileSystem fileSystem
  )
  {
    _maxEntriesPerFile = maxEntriesPerFile;
    _directoryName = directoryName;
    // インターフェースで表現されたファイルシステム
    _fileSystem = fileSystem;
  }
}

