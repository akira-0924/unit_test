public class AuditManager
{
  private readonly int _maxEntriesPerFile;
  private readonly string _directoryName;

  public AuditManager(int maxEntriesPerFile, string directoryName)
  {
    _maxEntriesPerFile = maxEntriesPerFile;
    _directoryName = directoryName;
  }

  public void AddRecord(string visitorName, DateTime timeOfVisit)
  {
    string[] filePaths = Directory.GetFiles(_directoryName);
    (int index, int path)[] sorted = SortedByIndex(filePaths);

    string newRecord = visitorName + ";" + timeOfVisit;

    if (sorted.Length == 0)
    {
      string newFile = Path.Combine(_directoryName, "audit_1.txt");
      File.WriteAllText(newFile, newRecord);
      return;
    }

    (int currentIndex, int currentFilePath) = sorted.Last();
    List<string> lines = File.ReadAllLines(currentFilePath).ToList();

    if (lines.Count < _maxEntriesPerFile)
    {
      lines.Add(newRecord);
      string newContent = string.Join("\n", lines);
      File.WriteAllText(currentFilePath, newContent);
    } else {
      int newIndex = currentIndex + 1;
      string newName = $"audit_{newIndex}.txt";
      string newFile = Path.Combine(_directoryName, newName);
      File.WriteAllText(newFile, newRecord);
    }
  }
}

