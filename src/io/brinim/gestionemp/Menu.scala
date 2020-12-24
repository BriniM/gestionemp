package io.brinim.gestionemp

import scala.annotation.tailrec
import scala.collection.mutable
import scala.io.StdIn

object Menu {
  val dictionnaireCommandes: mutable.HashMap[String, () => Unit] = mutable.HashMap()

  def question(question: String, regexpString: String): String = {
    print(question)
    val input = StdIn.readLine()

    if(input.matches(regexpString))
      input
    else
      throw new Exception("Veuillez vérifier votre input.")
  }

  def question(question: String, enum: Enumeration): Int = {
    println(f"Types possibles: [${enum.values.mkString(", ")}]")
    print(question)

    val input = StdIn.readLine()

    if(enum.values.exists(p => p.toString.equalsIgnoreCase(input)))
      return enum.values.find(p => p.toString.equalsIgnoreCase(input)).get.id
    throw new Exception("Le type que vous avez saisi est inconnu.")
  }

  def ajouterCommande(cmd: String, handler: () => Unit): Unit = {
    if (dictionnaireCommandes.contains(cmd))
      throw new Exception("La commande existe déja.")
    dictionnaireCommandes += cmd -> handler
  }

  @tailrec
  def loop(): Unit = {
    println(f"Commandes possibles: [${dictionnaireCommandes.keySet.mkString(", ")}]")
    print("Donner commande: ")
    val input = StdIn.readLine()

    if (dictionnaireCommandes.keysIterator.exists(c => c.equalsIgnoreCase(input))) {
      try {
        dictionnaireCommandes(input.toLowerCase)()
      } catch { case e: Exception => println(e) }
    }
    loop()
  }

  def loopAsync(): Unit = {
    new Thread{ override def run() { loop() } }.start()
  }
}
