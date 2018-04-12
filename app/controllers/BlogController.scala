package controllers

import javax.inject.{Inject, Singleton}

import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class BlogController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index =Action {
    Ok(views.html.blog.index())
  }


  def about =Action {
    Ok(views.html.blog.about())
  }
  def contact =Action {
    Ok(views.html.blog.contact())
  }
  def single =Action {
    Ok(views.html.blog.single())
  }
}
