package io.brinim.gestionemp

class Administratif(
                  code: Int,
                  sal: Double,
                  private var hrSupp: Double,
                  private val coutHrSupp: Double = 35
                ) extends Employe(code, sal) {
  def getHrSupp(): Double = hrSupp
  def getCoutHrSupp(): Double = coutHrSupp

  override def getSalaire(): Double = getHrSupp() * getCoutHrSupp() + getSalaireFixe()

  override def toString: String =
    f"""Administratif: ${getCode}
       |Salaire fixe: ${getSalaireFixe}
       |Salaire: ${getSalaire}
       |Heures supplémentaires travaillés: ${getHrSupp()}""".stripMargin
}
