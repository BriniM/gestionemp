package io.brinim.gestionemp

abstract class Employe(
                      protected val code: Int,
                      protected val sal: Double
                      ) {
  def getCode: Int = code
  def getSalaireFixe(): Double = sal

  def getSalaire(): Double
}
