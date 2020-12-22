package io.brinim.gestionemp

class Commercant(
                code: Int,
                sal: Double,
                private var ventes: Double,
                private val txCommision: Float = 0.05f
                ) extends Employe(code, sal) {
  def getVentes(): Double = ventes
  def getTxCommision(): Float = txCommision

  override def getSalaire(): Double = ventes * txCommision + getSalaireFixe()

  override def toString: String =
    f"""Commercial: ${getCode}
       |Salaire fixe: ${getSalaireFixe}
       |Salaire: ${getSalaire}
       |Ventes: ${getVentes}""".stripMargin
}
