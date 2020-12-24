package io.brinim.gestionemp

object App {
  def main(args: Array[String]): Unit = {
    Menu.ajouterCommande("ajouter", () => {
      val code = Menu.question("Donner code employé: ", "^[0-9]+$")
      val salaire = Menu.question("Donner salaire employé: ", """[0-9]+\.{0,1}[0-9]*""")
      val typeEmp = Menu.question("Donner type employé: ", TypeEmploye)

      Gestion.ajouterEmploye(code.toInt, salaire.toDouble, typeEmp)
    })

    Menu.ajouterCommande("rechercher", () => {
      val code = Menu.question("Donner code: ", "^[0-9]+$")
      println(Gestion.rechercherEmploye(code.toInt).getOrElse("Pas d'employé avec ce code"))
    })

    Menu.ajouterCommande("salaire plus haut", () => {
      println(f"Salaire plus haut: ${Gestion.salairePlusHaut()}")
    })

    Menu.ajouterCommande("masse salariale", () => {
      println(f"La masse salariale: ${Gestion.masseSalariale()}")
    })

    Menu.ajouterCommande("nombre commercants", () => {
      println(f"Le nombre de commercants est: ${Gestion.nbCommerciaux()}")
    })

    Menu.ajouterCommande("commercant ayant ca max", () => {
      println(f"Le commercant ayant max de CA est: ${Gestion.commercantAvecMaxCA()}")
    })

    Menu.ajouterCommande("exit", () => System.exit(0))

    Menu.loopAsync()
    /* Possibilité de lancer un serveur HTTP ici... etc */
  }
}
