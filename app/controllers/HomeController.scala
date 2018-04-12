package controllers

import javax.inject.{Inject, Singleton}

import models.Book
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index =Action {
    Ok(views.html.index())
  }

}
