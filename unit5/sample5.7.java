public class MessageRenderer: IRenderer
{
  public IReadOnlyList<IRenderer> SubRenderers { get; }

  public MessageRenderer()
  {
    SubRenderers = new List<IRenderer>();
    {
      new HeaderRenderer(),
      new BodyRenderer(),
      new FooterRenderer(),
    };
  }

  public string Render(Message message)
  {
    return SubRenderers.Select(x => x.Render(message)).Aggregate("", (str1, str2) => str1 + str2);
  }
}