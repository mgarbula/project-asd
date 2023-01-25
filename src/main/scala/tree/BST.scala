package tree

import tree.Tree._

class BST {
  def insert(t: Tree, elem: Int): Tree = t match {
    case Empty => Node(elem, 0, Empty, Empty)
    case Node(a, h, l, r) => if (elem <= a) Node(a, h, insert(l, elem), r)
                          else Node(a, h, l, insert(r, elem))
  }

  def preorder(t: Tree): List[Int] = t match {
    case Empty => List[Int]()
    case Node(a, _, l, r) => List(a) ++ preorder(l) ++ preorder(r)
  }

  def search(t: Tree, elem: Int): Boolean = t match {
    case Empty => false
    case Node(a, _, l, r) => if (a == elem) true else search(l, elem) || search(r, elem)
  }

  def minElem(t: Tree): Int = t match {
    case Node(a, _, Empty, _) => a
    case Node(a, _, l, _)     => minElem(l)
  }

  def maxElem(t: Tree): Int = t match {
    case Node(a, _, _, Empty) => a
    case Node(_, _, _, r)     => maxElem(r)
  }
  
  def makeElemEmpty(t: Tree, elem: Int): Tree = t match {
    case Empty => Empty
    case Node(a, _, l, r) if a == elem => l
    case Node(a, _, l, r) if true      => Node(a, 0, l, makeElemEmpty(r, elem))
  }

  def deleteElem(t: Tree): Tree = t match {
    case Node(_, _, Empty, Empty)       => Empty
    case Node(_, _, Empty, r)           => Node(minElem(r), 0, Empty, delete(r, minElem(r)))
    case Node(_, _, l, Empty)           => Node(maxElem(l), 0, delete(l, maxElem(l)), Empty)
    case Node(_, _, l, r) => {
      val maxiElem = maxElem(l)
      Node(maxiElem, 0, makeElemEmpty(l, maxiElem), r)
    }
  }

  def delete(t: Tree, elem: Int): Tree = t match {
    case Empty => t
    case Node(a, _, _, _) if a == elem => deleteElem(t)
    case Node(a, _, l, r) if elem < a  => Node(a, 0, delete(l, elem), r)
    case Node(a, _, l, r) if elem > a  => Node(a, 0, l, delete(r, elem))
  }
}
