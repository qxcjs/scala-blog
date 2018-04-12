package services

import scalikejdbc._
import models.Book


class BookService {

  implicit val session = AutoSession

  def list(): Seq[Book] = sql"select * from book".map(Book.fromDb).list.apply()

  def findById(id: Int): Option[Book] = sql"select * from book where id=${id}".map(Book.fromDb).single.apply()

  def insert(book: forms.BookForm.Data): Int = sql"insert into book(title,price,author) values(${book.title},${book.price},${book.author})".update().apply()

  //  def insert(books: Seq[Book]) = sql"insert into book(title,price,author) values()"

  def update(id: Int, book: forms.BookForm.Data): Int = sql"update book set title=${book.title}, price=${book.price}, author=${book.author} where id=${id}".update().apply()

  def delete(id: Int): Int = sql"delete from book where id=${id}".update().apply()
}
