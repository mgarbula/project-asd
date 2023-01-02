package GUI

import tree.{AVL, BST, Tree}

object Operations {
  val bst = new BST
  val avl = new AVL

  def doOperation(operation: Int, t: Tree, elem: Int, kind: String): Tree = operation match {
    case 1 => { val modifiedT = insert(t, elem, kind)
                println("Po wstawieniu: " + preorder(modifiedT, kind))
                modifiedT }
    case 2 => { val modifiedT = delete(t, elem, kind)
                println("Po usuniecu: " + preorder(modifiedT, kind))
                modifiedT }
  }

  def preorder(t: Tree, kind: String): List[Int] = {
    if (kind.equals("BST"))
      bst.preorder(t)
    else
      avl.preorder(t).map(a => a._1)
  }

  def insert(t: Tree, elem: Int, kind: String): Tree = {
    if (kind.equals("BST"))
      bst.insert(t, elem)
    else
      avl.insert(t, elem)
  }

  def delete(t: Tree, elem: Int, kind: String): Tree = {
    if (kind.equals("BST"))
      bst.delete(t, elem)
    else
      avl.delete(t, elem)
  }
}