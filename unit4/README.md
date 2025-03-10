# 良い単体テストを構成する 4 本の柱

## ４つの柱

- **退行(Regression)に対する保護**
- **リファクタリングへの耐性**
- **迅速なフィードバック**
- **保守のしやすさ**

以下、それぞれの柱について説明する。

### 退行(Regression)に対する保護

「退行」とはバグのことであり、何らかの変更を加えたことによって、既存の機能が壊れてしまうことを指す。
退行に対する保護がテストにどのくらい備わっているかを把握するには以下のことに目をむける。

- テスト時に実行されるプロダクションコード
- そのコードの複雑さ
- そのコードが扱っているドメインの重要性

### リファクタリングへの耐性

テストが失敗することなく、どのくらいプロダクションコードのリファクタリングを行うことができるか。

偽陽性(False Positive)とは、振る舞いは合っていても、テストコードの内容が間違っていて、失敗することを指す。
偽陽性の発生が少ないほど、リファクタリングへの耐性が高いといえる。
そもそもテストによって、問題を検出することが目的なのに、嘘のエラーでテストが失敗すると、テストを信頼できなくなる。

**何が偽陽性を引き起こすか**

そのテストケースがプロダクションコードと密接に結についてしまうとより多くの嘘のエラーを引き起こす。減らすためには、**テストコードをテスト対象の内部的なコードから切り離すこと**が必要。→ 結果を得るための細かいテストコードを書くと、テストコードがプロダクションコードに密接に結びついてしまうため、「振る舞い」を意識し、テストコードをよりシンプルにすることが必要。

## 退行に対する保護とリファクタリングへの耐性の関係

### テストの正確性を最大限にすること

プロダクションコード正しさとテストの正確性の関係は、

|                   | 実際の振る舞い       | 実際の振る舞い       |
| ----------------- | -------------------- | -------------------- |
|                   | 正しい               | 間違い               |
| テストの結果-成功 | 真陰性               | 偽陰性(第二種の過誤) |
| テストの結果-失敗 | 偽陽性(第一種の過誤) | 真陽性               |

偽陽性を抑えるのに効果があるのが、リファクタリングへの耐性。

- テストすることでどのくらいバグを検出することができるか
  - 偽陰性(見つけられないバグ)の発生を抑えることに関係し、退行に対する保護を高めることに関係する。
- テストをすることでバグがないことをどのくらい示せるか
  - 偽陽性の発生を抑えることに関係し、リファクタリングへの耐性を高めることに関係する。

### E2E テスト

E2E テストはシステムをエンドユーザーの視点を持って行うテスト。
そのプロダクトの開発者が書いたコードだけでなく、外部のライブラリやフレームワークも含めてテストするため最も多くのプロダクションコードを実行することになる。

E2E テストは嘘の警告を発する偽陽性を持ち込みにくいため、リファクタリングへの耐性が高い。
つまりリファクタリングを正しく行えば、すでに成功していた E2E テストが失敗することはほとんどない。しかし、テストを実行し終えるまでに時間がかかるため迅速なフォードバックが得られない。

このように「退行」「リファクタリング」「迅速なフィードバック」の 3 つ全てを最大限に備えることはできない。2 つを満たして 1 つを犠牲にすることはできるが、この 3 つは掛け算なので、その場合はテストケースの価値が大幅に低下する。4 つ目の「保守のしやすさ」は他の 3 つと関連性がないが、テストの際に経由しなければならない全ての依存を用意しなくてはならないためどうしても規模が大きくなってしまう。

## 理想的な単体テスト

上記を踏まえた上で、最善の単体テストは、
**リファクタリングへの耐性と保守のしやすさを最大限に備えつつ、退行に対する保護と迅速なフィードバックでどちらを優先するかバランスを取ること**
