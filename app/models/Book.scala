package models

import scalikejdbc.WrappedResultSet

case class Book(
                 id: Int,
                 title: String,
                 price: Int,
                 author: String
               )

object Book {
  def fromDb(rs: WrappedResultSet): Book = {
    val id = rs.int("id")
    val title = rs.string("title")
    val price = rs.int("price")
    val author = rs.string("author")
    Book(id, title, price, author)
  }
}
