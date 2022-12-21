package GUI

import tree.{BST, Tree}

object Operations {
  val bst = new BST

  def doOperation(operation: Int, t: Tree, elem: Int): Tree = operation match {
    case 1 => { val modifiedT = insert(t, elem)
                println("Po wstawieniu: " + preorder(modifiedT))
                modifiedT }
    case 2 => { val modifiedT = delete(t, elem)
                println("Po usuniecu: " + preorder(modifiedT))
                modifiedT }
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