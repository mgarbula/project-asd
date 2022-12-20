package tree

abstract class Tree
object Tree {
  case object Empty extends Tree
  case class Node(elem: Int, l: Tree, r: Tree) extends Tree
}

