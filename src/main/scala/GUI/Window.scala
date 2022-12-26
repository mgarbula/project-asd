package GUI

import scala.swing.{BorderPanel, Dimension, Label, MainFrame, TextArea}

class Window extends MainFrame {
  val mySize = new Dimension(400, 400)
  title = "Tree"
  size = mySize
  contents = new BorderPanel {
    minimumSize = mySize
    maximumSize = mySize
    preferredSize = mySize

    //val treePre:TextArea = new TextArea("                               8\t\n                               / \\\n                              /   \\\n                             /     \\\n                            /       \\\n                           7        14\n                          / \\       / \\\n                         /   \\     /   \\\n                        3     5   10\n                       / \\   / \\  /\n                      1   2 4   6 ")
    //val treePrinter:TreePrinter = new TreePrinter()
    val treePrinter:TreePrinter = new TreePrinter

    add(treePrinter, BorderPanel.Position.Center)

    val directionLabel:DirectionLabel = new DirectionLabel("-----------------")
    add(directionLabel, BorderPanel.Position.South)

    val menuPanel:BorderPanel = new BorderPanel {
      add(new Menu(treePrinter, directionLabel), BorderPanel.Position.Center)
    }
    add(menuPanel, BorderPanel.Position.North)
  }
  centerOnScreen()
  open()
}