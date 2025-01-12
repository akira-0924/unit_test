// 記事にコメントを追加する
[Fact]
public void Adding_a_comment_to_an_article()
{
  var sut = new Article();
  var comment = new Comment("This is a test comment", "John Doe", DateTime.Now);

  sut.AddComment(comment);

  sut.Comments.Should().BeEquivalentTo(comment);
}
