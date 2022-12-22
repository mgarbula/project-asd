package tree

import GUI.DirectionLabel
import tree.Tree._

class BST {
  def insert(t: Tree, elem: Int, directionLabel: DirectionLabel): Tree = t match {
    case Empty => directionLabel.printDirection(elem, _, 'm'); Node(elem, Empty, Empty)
    case Node(a, l, r) => if (elem <= a) {
                            directionLabel.printDirection(elem, a, 'l')
                            println(a)
                            Node(a, insert(l, elem, directionLabel), r)
                          } else {
                            directionLabel.printDirection(elem, a, 'r')
                            Node(a, l, insert(r, elem, directionLabel))
                          }
  }

  def preorder(t: Tree): List[Int] = t match {
    case Empty => List[Int]()
    case Node(a, l, r) => List(a) ++ preorder(l) ++ preorder(r)
  }

  def search(t: Tree, elem: Int): Boolean = t match {
    case Empty => false
    case Node(a, l, r) => if (a == elem) true else search(l, elem) || search(r, elem)
  }

  def minElem(t: Tree): Int = t match {
    case Node(a, Empty, _) => a
    case Node(a, l, _)     => minElem(l)
  }

  def maxElem(t: Tree): Int = t match {
    case Node(a, _, Empty) => a
    case Node(a, _, r)     => maxElem(r)
  }

  def minTree(t: Tree): Tree = t match {
    case Node(a, Empty, r)               => r
    case Node(a, Node(b, Empty, r1), r2) => Node(a, r1, r2)
    case Node(_, Node(b, l, r1), r2)     => minTree(Node(b, l, r1))
  }

  def maxTree(t: Tree): Tree = t match {
    case Node(a, l, Empty)               => l
    case Node(a, l1, Node(b, l2, Empty)) => Node(a, l1, Empty)
    case Node(_, l1, Node(b, l2, r))     => maxTree(Node(b, l2, r))
  }

  def makeElemEmpty(t: Tree, elem: Int): Tree = t match {
    case Node(a, l, r) if a == elem => l
    case Node(a, l, r) if true      => Node(a, l, makeElemEmpty(r, elem))
  }

  def deleteElem(t: Tree): Tree = t match {
    case Node(_, Empty, Empty)       => Empty
    case Node(_, Empty, r)           => Node(minElem(r), Empty, minTree(r))
    case Node(_, l, Empty)           => Node(maxElem(l), maxTree(l), Empty)
    case Node(_, l, r) => {
      val maxiElem = maxElem(l)
      Node(maxiElem, makeElemEmpty(l, maxiElem), r)
    }
  }

  def delete(t: Tree, elem: Int): Tree = t match {
    case Empty => t
    case Node(a, l, r) if a == elem => deleteElem(t)
    case Node(a, l, r) if elem < a  => Node(a, delete(l, elem), r)
    case Node(a, l, r) if elem > a  => Node(a, l, delete(r, elem))
  }
}
