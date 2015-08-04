import com.sendgrid.SendGrid
import com.typesafe.config.ConfigFactory

object SendGridScalaExample extends App {
  val config = ConfigFactory.load()
  val sendgridUsername = config.getString("SENDGRID_USERNAME")
  val sendgridPassword = config.getString("SENDGRID_PASSWORD")
  val tos = config.getStringList("TOS").toArray(Array[String]())
  val from = config.getString("FROM")
  val file = new java.io.File(getClass.getResource("gif.gif").getPath)

  val email = new SendGrid.Email()
    .addSmtpApiTo(tos)
    .addSubstitution("fullname", Array("田中 太郎", "佐藤 次郎", "鈴木 三郎"))
    .addSubstitution("familyname", Array("田中", "佐藤", "鈴木"))
    .addSubstitution("place", Array("office", "home", "office"))
    .addSection("office", "中野")
    .addSection("home", "目黒")
    .addCategory("category1")
    .setFrom(from)
    .setFromName("送信者名")
    .setSubject("[sendgrid-scala-example] フクロウのお名前はfullnameさん")
    .setText("familyname さんは何をしていますか？\r\n 彼はplaceにいます。")
    .setHtml("<strong> familyname さんは何をしていますか？</strong><br />彼はplaceにいます。")
    .addAttachment("owl.gif", file)

  val sendgrid = new SendGrid(sendgridUsername, sendgridPassword)
  val response = sendgrid.send(email)
  println(response.getMessage)
}
