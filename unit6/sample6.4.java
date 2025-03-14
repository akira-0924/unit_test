// 記事にコメントを追加する
[Fact]
public void Adding_a_comment_to_an_article()
{
  var sut = new Article();
  var text = "This is a test comment";
  var author = "John Doe";
  var now  = DateTime.Now;

  sut.AddComment(text, author, now);

  // テスト対象のシステムの状態を検証している
  Assert.Equal(text, sut.Comments[0].Text);
  Assert.Equal(author, sut.Comments[0].Author);
  Assert.Equal(now, sut.Comments[0].CreatedAt);
}

// ヘルパーメソッドを使った場合
[Fact]
public void Adding_a_comment_to_an_article()
{
  var sut = new Article();
  var text = "This is a test comment";
  var author = "John Doe";
  var now  = DateTime.Now;

  sut.AddComment(text, author, now);

  // テスト対象のシステムの状態を検証している
  sut.ShouldContainNumberOfComments(1).withComment(text, author, now);
}

