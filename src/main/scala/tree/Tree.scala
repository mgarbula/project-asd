package tree

abstract class Tree
object Tree {
  case object Empty extends Tree
  case class Node(elem: Int, height: Int, l: Tree, r: Tree) extends Tree

  def elem(t: Tree): Int = t match {
    case Empty => -1
    case Node(elem, _, _, _) => elem
  }

  def height(t: Tree): Int = t match {
    case Empty => 0
    case Node(_, h, _, _) => h
  }

  def left(t: Tree): Tree = t match {
    case Empty => Empty
    case Node(_, _, l, _) => l
  }

  def right(t: Tree): Tree = t match {
    case Empty => Empty
    case Node(_, _, _, r) => r
  }
}