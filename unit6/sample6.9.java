// インタフェースを作成
public interface IFileSystem
{
  string[] GetFiles(string directoryName);
  void WriteAllText(string filePath, string content);
  List<string> ReadAllLines(string filePath);
}

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

  public void AddRecord(string visitorName, DateTime timeOfVisit)
  {
    // インターフェースを呼び出す
    string[] filePaths = _fileSystem.GetFiles(_directoryName);
    (int index, int path)[] sorted = SortedByIndex(filePaths);

    string newRecord = visitorName + ";" + timeOfVisit;

    if (sorted.Length == 0)
    {
      string newFile = Path.Combine(_directoryName, "audit_1.txt");
      // インターフェースを呼び出す
      _fileSystem.WriteAllText(newFile, newRecord);
      return;
    }

    (int currentIndex, int currentFilePath) = sorted.Last();
    // インターフェースを呼び出す
    List<string> lines = _fileSystem.ReadAllLines(currentFilePath).ToList();

    if (lines.Count < _maxEntriesPerFile)
    {
      lines.Add(newRecord);
      string newContent = string.Join("\n", lines);
      // インターフェースを呼び出す
      _fileSystem.WriteAllText(currentFilePath, newContent);
    } else {
      int newIndex = currentIndex + 1;
      string newName = $"audit_{newIndex}.txt";
      string newFile = Path.Combine(_directoryName, newName);
      // インターフェースを呼び出す
      _fileSystem.WriteAllText(newFile, newRecord);
    }
  }
}

