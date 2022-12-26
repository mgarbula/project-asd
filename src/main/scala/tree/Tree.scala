package tree

abstract class Tree
object Tree {
  case object Empty extends Tree
  case class Node(elem: Int, l: Tree, r: Tree) extends Tree

  def elem(t: Tree): Int = t match {
    case Node(elem, _, _) => elem
  }

  def left(t: Tree): Tree = t match {
    case Empty => Empty
    case Node(_, l, _) => l
  }

  def right(t: Tree): Tree = t match {
    case Empty => Empty
    case Node(_, _, r) => r
  }
}

