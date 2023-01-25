package tree

import tree.Tree.{Empty, Node, elem, height, left, right}

class AVL {

  def insert(t: Tree, elem: Int): Tree = t match {
    case Empty => Node(elem, 1, Empty, Empty)
    case Node(a, _, l, r) => {
      var newL = l
      var newR = r
      if (elem <= a) newL = insert(l, elem)
      else newR = insert(r, elem)
      val newTree = Node(a, Math.max(height(newL), height(newR)) + 1, newL, newR)
      rotateInsert(newTree, getBalance(newTree), elem)
    }
  }

  def delete(t: Tree, elem: Int): Tree = t match {
    case Empty => t
    case Node(a, _, _, _) if a == elem => new BST().deleteElem(t)
    case Node(a, h, l, r) if elem < a  => {
      rotateDelete(Node(a, h, rotateDelete(delete(l, elem)), r))
    }
    case Node(a, h, l, r) if elem > a  => {
      rotateDelete(Node(a, h, l, rotateDelete(delete(r, elem))))
    }
  }

  def rotateDelete(t: Tree): Tree = t match {
    case Empty => Empty
    case Node(_, _, _, _) => {
      val newTree = Node (elem (t), Math.max (height (right (t) ), height (left (t) ) ) + 1, left (t), right (t) )
      val balance = getBalance (newTree)
      if (balance > 1 && getBalance (right (newTree) ) >= 0) rotateLeft (newTree)
      else if (balance > 1 && getBalance (right (newTree) ) < 0) rotateRight (Node (Tree.elem (newTree), height (newTree), rotateLeft (left (newTree) ), right (newTree) ) )
      else if (balance < - 1 && getBalance (left (newTree) ) <= 0) rotateRight (newTree)
      else if (balance < - 1 && getBalance (left (newTree) ) > 0) rotateLeft (Node (Tree.elem (newTree), height (newTree), left (newTree), rotateRight (right (newTree) ) ) )
      else newTree
    }
  }

    def rotateInsert(t: Tree, balance: Int, elem: Int): Tree = {
    if (balance > 1 && elem > Tree.elem(right(t))) rotateLeft(t)
    else if (balance < -1 && elem < Tree.elem(left(t))) rotateRight(t)
    else if (balance > 1 && elem < Tree.elem(right(t))) rotateLeft(Node(Tree.elem(t), height(t), left(t), rotateRight(right(t))))
    else if (balance < -1 && elem > Tree.elem(left(t))) rotateRight(Node(Tree.elem(t), height(t), rotateLeft(left(t)), right(t)))
    else t
  }

  def getBalance(t: Tree): Int = t match {
    case Empty => 0
    case Node(a, h, l, r) => height(r) - height(l)
  }

  def search(t: Tree, elem: Int): Boolean = new BST().search(t, elem)

  def preorder(t:Tree): List[(Int, Int)] = t match {
    case Empty => List[(Int, Int)]()
    case Node(a, h, l, r) => List((a, h)) ++ preorder(l) ++ preorder(r)
  }

  def inorder(t: Tree): List[(Int, Int)] = t match {
    case Empty => List[(Int, Int)]()
    case Node(a, h, l, r) => inorder(l) ++ List((a, h)) ++ inorder(r)
  }

  def rotateLeft(t: Tree): Tree = {
    val newRoot = elem(right(t))
    val newLeftChild = Node(elem(t), Math.max(height(left(t)), height(left(right(t)))) + 1, left(t), left(right(t)))
    Node(newRoot, Math.max(height(newLeftChild), height(right(right(t)))) + 1, newLeftChild, right(right(t)))
  }

  def rotateRight(t: Tree): Tree = {
    val newRoot =   elem(left(t))
    val newRightChild = Node(elem(t), Math.max(height(right(t)), height(right(left(t)))) + 1, right(left(t)), right(t))
    Node(newRoot, Math.max(height(newRightChild), height(left(left(t)))) + 1, left(left(t)), newRightChild)
  }
}