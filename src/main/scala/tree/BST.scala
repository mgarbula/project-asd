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
    case Empty => -1
    case Node(a, _, _, Empty) => a
    case Node(_, _, _, r)     => maxElem(r)
  }

  def minTree(t: Tree): Tree = t match {
    case Node(_, _, Empty, r)               => r
    case Node(a, h, Node(b, _, Empty, r1), r2) => Node(a, h, r1, r2)
    case Node(_, _, Node(b, h, l, r1), r2)     => minTree(Node(b, h, l, r1))
  }

  def maxTree(t: Tree): Tree = t match {
    case Node(a, _, l, Empty)               => l
    case Node(a, h, l1, Node(b, _, l2, Empty)) => Node(a, h, l1, Empty)
    case Node(_, _, l1, Node(b, h, l2, r))     => maxTree(Node(b, h, l2, r))
  }

  def makeElemEmpty(t: Tree, elem: Int): Tree = t match {
    case Empty => Empty
    case Node(a, _, l, r) if a == elem => l
    case Node(a, _, l, r) if true      => Node(a, 0, l, makeElemEmpty(r, elem))
  }

  def deleteElem(t: Tree): Tree = t match {
    case Node(_, _, Empty, Empty)       => Empty
    case Node(_, _, Empty, r)           => Node(minElem(r), 0, Empty, minTree(r))
    case Node(_, _, l, Empty)           => Node(maxElem(l), 0, maxTree(l), Empty)
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
