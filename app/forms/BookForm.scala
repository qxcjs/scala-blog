package forms

object BookForm {

  import play.api.data.Forms._
  import play.api.data.Form

  case class Data(title: String, price: Int, author: String)

  val form = Form(
    mapping(
      "title" -> text,
      "price" -> number,
      "author" -> text
    )(Data.apply)(Data.unapply)
  )
}
