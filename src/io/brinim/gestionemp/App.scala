package io.brinim.gestionemp

import scala.annotation.tailrec
import scala.io.StdIn

object App {
  @tailrec
  def main(args: Array[String]): Unit = {
    println(
      """[ajouter
        | rechercher
        | salaire plus haut
        | massa salariale
        | nombre commerciaux
        | commercant ayant ca max]""".stripMargin)
    print("Donner commande: ")
    val input = StdIn.readLine.toLowerCase
    input match {
      case "ajouter" => {
        print("Donner le type: [Commercant | Administratif]: ")
        val emp = StdIn.readLine
        if (emp.equalsIgnoreCase("commercant")) {
          print("Donner code unique: ")
          val code = StdIn.readInt()

          print("Donner salaire fixe: ")
          val salaire = StdIn.readDouble()

          print("Donner ventes: ")
          val ventes = StdIn.readInt()

          Gestion.ajouterEmploye(new Commercant(code, salaire, ventes))
        }
        else if (emp.equalsIgnoreCase("administratif")) {
          print("Donner code unique: ")
          val code = StdIn.readInt()

          print("Donner salaire fixe: ")
          val salaire = StdIn.readDouble()

          print("Donner ventes: ")
          val ventes = StdIn.readInt()

          Gestion.ajouterEmploye(new Commercant(code, salaire, ventes))
        }
        else println("Type employe inconnu")
      }
      case "rechercher" => {
        println("Donner code: ")
        val code = StdIn.readInt

        println(Gestion.rechercherEmploye(code).getOrElse("Pas d'employé avec ce code"))
      }
      case "salaire plus haut" => {
        println(f"Salaire plus haut: ${Gestion.salairePlusHaut}")
      }
      case "masse salariale" => {
        println(f"La masse salariale: ${Gestion.masseSalariale}")
      }
      case "nombre commerciaux" => {
        println(f"Le nombre de commercants est: ${Gestion.nbCommerciaux()}")
      }
      case "commercant ayant ca max" => {
        println(f"Le commercant ayant max de CA est: ${Gestion.commercantAvecMaxCA}")
      }
      case _ => println("Commande inconnu, veuillez réssayer.")
    }

    main(Array[String]())
  }
}
