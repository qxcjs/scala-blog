package controllers

import javax.inject.{Inject, Singleton}

import forms.BookForm
import play.api.mvc._
import services.BookService

@Singleton
class BooksController @Inject()(bookService: BookService, cc: MessagesControllerComponents) extends MessagesAbstractController(cc) {
  // for all books
  def index = Action {
    Ok(views.html.books.index(bookService.list()))
  }

  def create = Action { implicit request: MessagesRequestHeader =>
    Ok(views.html.books.create(BookForm.form))
  }

  // for save book
  def save() = Action { implicit request =>
    BookForm.form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.books.index(bookService.list()))
      },
      data => {
        bookService.insert(data)
        Redirect(routes.BooksController.index())
      }
    )
  }

  // for edit book
  def edit(id: Int) = Action { implicit request: MessagesRequestHeader =>
    bookService.findById(id) match {
      case Some(book) => Ok(views.html.books.edit(book))
      case None => NotFound
    }
  }

  // for update book
  def update(id: Int) = Action { implicit request =>
    BookForm.form.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.books.index(bookService.list()))
      },
      data => {
        bookService.update(id, data)
        Redirect(routes.BooksController.index())
      }
    )
  }

  // for book detail
  def show(id: Int) = Action {
    bookService.findById(id) match {
      case Some(book) => Ok(views.html.books.show(book))
      case None => NotFound
    }
  }

  // for destroy book
  def destroy(id: Int) = Action {
    bookService.delete(id)
    Redirect(routes.BooksController.index())
  }

}
