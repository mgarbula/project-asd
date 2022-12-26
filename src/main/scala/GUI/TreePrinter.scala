package GUI

import tree.Tree
import tree.Tree.{Empty, Node, elem, left, right}

import scala.swing.TextArea

class TreePrinter extends TextArea {
  //var spacesInFront = 40
  tabSize = 1

  def printTree(tree: Tree): Unit = {
    //text = "\t\t\t\t\t\t\t\t\t\t"
    //printSpaces(spacesInFront)
    //text = ""
    println("================================")
    //spacesInFront = 15
    makeTree(List(tree), 1, treeSize(tree))
  }

  private def makeTree(tree: List[Tree], currentLevel: Int, levels: Int): Unit = {
    if (tree.isEmpty || isAllElementEmpty(tree)) {
      return
    }
    val floor = levels - currentLevel
    val slashes = Math.pow(2, Math.max (floor - 1, 0) ).toInt
    val spacesInFront = (Math.pow(2, floor) - 1).toInt
    val betweenSpaces = (Math.pow(2, floor + 1) - 1).toInt
    //val betweenSlashes = (Math.pow(2, floor + 1) - 1).toInt
    //println("betweenSpaces = " + betweenSpaces)

    printSpaces(spacesInFront)
    val newTrees = tree.flatMap(t => List(left(t), right(t)))
    tree.foreach(t => printElem(t, betweenSpaces))
    //text += "\n"
    println("")

    printSlashes(slashes, tree, spacesInFront)
    //spacesInFront -= 1
    makeTree(newTrees, currentLevel + 1, levels)
  }

  private def isAllElementEmpty(value: List[Tree]): Boolean = {
    def isEmpty(tree: Tree): Boolean = tree match {
      case Empty => true
      case _ => false
    }
    value.map(t => isEmpty(t)).forall(t => t)
  }


  private def printElem(t: Tree, spaces: Int): Unit = t match {
    case Empty => /*text += " ";*/ println(""); printSpaces(spaces)
    case Node(a, _, _) => /*text += a;*/ print(a); printSpaces(spaces)
  }

  private def printSlashes(slashes: Int, tree: List[Tree], firstSpaces: Int): Unit = {
    def printSlashes(t: Tree, i: Int): Unit = t match {
      case Empty => printSpaces(slashes + slashes + i + 1)
      case Node(_, l, r) => {
        leftSlash(l)
        printSpaces(i + i -1)
        rightSlash(r)
        printSpaces(slashes + slashes - 1)
      }
    }

    for (i <- 1 to slashes) {
      for (j <- 0 to tree.size - 1) {
        printSpaces(firstSpaces - i)
        printSlashes(tree(j), i)
      }
      //text += "\n"
      println("")
    }
    //spacesInFront -= 2
  }

  private def leftSlash(t: Tree): Unit = t match {
    case Empty => print(" ") //text += " "
    case _ => print("/") //text += "/"
  }

  private def rightSlash(t: Tree): Unit = t match {
    case Empty => print(" "); //text += " "
    case _ => print("\\") //text += "\\"
  }


  private def printSpaces(spaces: Int): Unit = spaces match {
    case -1 => print("") //text += ""
    case 0 => print("") //text += ""
    case _ => /*text += " ";*/ print(" "); printSpaces(spaces - 1)
  }

  private def treeSize(tree: Tree): Int = tree match {
    case Empty => 0
    case Node(_, Empty, Empty) => 1
    case Node(_, l, r) => 1 + Math.max(treeSize(l), treeSize(r))
  }

}