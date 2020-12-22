package io.brinim.gestionemp

object Gestion {
  private var employes = List[Employe]()

  def ajouterEmploye(e: Employe): Unit = {
    employes = e +: employes
  }

  def rechercherEmploye(code: Int):Option[Employe] = {
    employes.find(e => e.getCode == code)
  }

  def salairePlusHaut(): Double = {
    if (employes.isEmpty)
      0
    employes.map(e => e.getSalaireFixe()).max
  }

  def masseSalariale(): Double = {
    if (employes.isEmpty)
      0
    employes.map(e => e.getSalaireFixe()).sum
  }

  def nbCommerciaux(): Int = if(employes.isEmpty) 0 else employes.count(e => e.isInstanceOf[Commercant])
  def commercantAvecMaxCA(): Commercant = {
    if (employes.isEmpty)
      0
    employes.takeWhile(e => e.isInstanceOf[Commercant])
      .maxBy(e => e.asInstanceOf[Commercant].getVentes()).asInstanceOf[Commercant]
  }
}
