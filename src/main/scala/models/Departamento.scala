package models

import slick.jdbc.SQLiteProfile.api._

class Departamento(tag: Tag) extends Table[(Int, String)](tag, "departamentos") {
  def id = column[Int]("id", O.PrimaryKey) // This is the primary key column
  def nombre= column[String]("nombre")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, nombre)
}