package GUI

import tree.Tree
import tree.Tree.{Empty, Node}

import scala.swing.{Button, Label}

class MyThread(directionLabel: DirectionLabel, elem: Int, tree: Tree, btn: Button) extends Thread {
  override def run(): Unit = directionLabel.setText(elem, tree, btn)
}

class DirectionLabel(txt: String) extends Label {
  text = txt

  def printDirection(elem: Int, a: Int, direction: Char): Unit = direction match {
    case 'l' => text = "" + elem + " mniejszy od " + a + " - idę w lewo"
    case 'r' => text = "" + elem + " większy od " + a + " - idę w prawo"
    case 'm' => text = "" + elem + " jest na swoim miejscu"
  }

  def setText(elem: Int, tree: Tree, btn: Button): Unit = tree match {
    case Empty => {
      printDirection(elem, -1, 'm')
      btn.enabled = true
    }
    case Node(a, l, r) => btn.enabled = false; if (elem <= a) {
      printAndSleep(elem, a, 'l', l, btn)
    } else {
      printAndSleep(elem, a, 'r', r, btn)
    }
  }

  def printAndSleep(elem: Int, a: Int, direction: Char, tree: Tree, btn: Button): Unit = {
    printDirection(elem, a, direction)
    Thread.sleep(1000)
    setText(elem, tree, btn)
  }
}
