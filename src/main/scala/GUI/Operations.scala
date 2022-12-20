package GUI

import tree.{BST, Tree}

object Operations {
  val bst = new BST

  def whatToDo(t: Tree): Unit = {
    println("Co chcesz zrobic?")
    println("1. Dodaj element")
    println("2. Usun element")
    println("3. Koniec")
    println("Podaj numer operacji")
    val input = scala.io.StdIn.readLine()
    println("Podaj element")
    val elem = scala.io.StdIn.readLine()
    doOperation(input.toInt, t, elem.toInt)
  }

  def doOperation(operation: Int, t: Tree, elem: Int): Unit = operation match {
    case 1 => { val modifiedT = insert(t, elem)
                println("Po wstawieniu: " + preorder(modifiedT))
                whatToDo(modifiedT) }
    case 2 => { val modifiedT = delete(t, elem)
                println("Po usuniecu: " + preorder(modifiedT))
                whatToDo(modifiedT) }
    case 3 => println("Koniec")
  }

  def preorder(t: Tree): List[Int] = {
    bst.preorder(t)
  }

  def insert(t: Tree, elem: Int): Tree = {
    bst.insert(t, elem)
  }

  def delete(t: Tree, elem: Int): Tree = {
    bst.delete(t, elem)
  }
}