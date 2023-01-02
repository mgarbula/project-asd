package GUI

import scala.swing.{BorderPanel, Dimension, MainFrame}

class Window extends MainFrame {
  val mySize = new Dimension(420, 420)
  title = "Tree"
  size = mySize
  contents = new BorderPanel {
    minimumSize = mySize
    maximumSize = mySize
    preferredSize = mySize

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