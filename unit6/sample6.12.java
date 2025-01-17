// ------------------------------------------

public class FileContent
{
  public readonly string FileName;
  public readonly string[] Lines;

  public FileContent(string name, string[] lines)
  {
    FileName = name;
    Lines = lines;
  }
}

// ------------------------------------------

public class FileUpdate
{
  public readonly string FileName;
  public readonly string NewContent;

  public FileUpdate(string name, string content)
  {
    FileName = name;
    NewContent = content;
  }
}

// ------------------------------------------
public class Persister
{
  public FIleContent[] ReadDirectory(string directoryName)
  {
    return Directory
    .GetFiles(directoryName)
    .Select(x => new FileContent(Path.GetFileName(x), File.ReadAllLines(x)))
    .ToArray();
  }

  public void ApplyUpdate(string directoryName, FileUpdate update)
  {
     string filePath = Path.Combine(directoryName, update.FileName);
     File.WriteAllText(filePath, update.NewContent);
  }
}

// ------------------------------------------

public class AuditManager
{
  private readonly int _maxEntriesPerFile;

  public AuditManager(int maxEntriesPerFile)
  {
    _maxEntriesPerFile = maxEntriesPerFile;
  }

  public FileUpdate AddRecord(
    FIleContent[] files,
    string visitorName,
    DateTime timeOfVisit
  )
  {
    (int index, FIleContent file)[] sorted = SortedByIndex(files);
    string newRecord = visitorName + ";" + timeOfVisit;

    if (sorted.Length == 0)
    {
      // ファイルの更新に関する決定を下す
      return new FileUpdate("audit_1.txt", newRecord);
    }

    (int currentIndex, FIleContent currentFile) = sorted.Last();
    List<string> lines = currentFile.Lines.ToList();

    if (lines.Count < _maxEntriesPerFile)
    {
      lines.Add(newRecord);
      string newContent = string.Join("\n", lines);
      // ファイルの更新に関する決定を下す
      return new FileUpdate(currentFile.Name, newContent);
    } else {
      int newIndex = currentIndex + 1;
      string newName = $"audit_{newIndex}.txt";
      // ファイルの更新に関する決定を下す
      return new FileUpdate(newName, newRecord);
    }
  }
}

