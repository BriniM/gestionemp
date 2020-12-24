package io.brinim.gestionemp

object Gestion {
  private var employes: List[Employe] = List()

  def ajouterEmploye(code: Int, salaire: Double, idType: Int): Unit = {
    TypeEmploye(idType) match {
      case TypeEmploye.Commercant =>
        val ventes = Menu.question("Donner ventes: ", """[0-9]+\.{0,1}[0-9]*""")
        employes = new Commercant(code, salaire, ventes.toDouble) :: employes
      case TypeEmploye.Administratif => {
        val hrSupp = Menu.question("Donner heures supplémentaires: ", """[0-9]+\.{0,1}[0-9]*""")
        employes = new Administratif(code, salaire, hrSupp.toDouble) :: employes
      }
      case _ => println("Type Employé inconnu ou n'est pas encore implémenté.")
    }
  }

  def rechercherEmploye(code: Int): Option[Employe] = {
    employes.find(e => e.getCode == code)
  }

  def salairePlusHaut(): Double = {
    if (employes.isEmpty) 0 else employes.map(e => e.getSalaire()).max
  }

  def masseSalariale(): Double = {
    if (employes.isEmpty) 0 else employes.map(e => e.getSalaire()).sum
  }

  def nbCommerciaux(): Int = if (employes.isEmpty) 0 else employes.count(e => e.isInstanceOf[Commercant])

  def commercantAvecMaxCA(): Commercant = {
    if (nbCommerciaux() == 0)
      throw new Exception("Pas de commercants")
    else employes.filter(e => e.isInstanceOf[Commercant])
      .maxBy(e => e.asInstanceOf[Commercant].getVentes()).asInstanceOf[Commercant]
  }
}
