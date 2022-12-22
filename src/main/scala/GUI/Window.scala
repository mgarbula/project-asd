package GUI

import scala.swing.MainFrame
import scala.swing.Dimension
import scala.swing.Label
import scala.swing.BorderPanel

class Window extends MainFrame {
  val mySize = new Dimension(600, 600)
  title = "Tree"
  size = mySize
  contents = new BorderPanel {
    minimumSize = mySize
    maximumSize = mySize
    preferredSize = mySize

    val treePre:Label = new Label("-----------------")
    add(treePre, BorderPanel.Position.Center)

    val directionLabel:DirectionLabel = new DirectionLabel("-----------------")
    add(directionLabel, BorderPanel.Position.South)

    val menuPanel:BorderPanel = new BorderPanel {
      add(new Menu(treePre, directionLabel), BorderPanel.Position.Center)
    }
    add(menuPanel, BorderPanel.Position.North)
  }
  centerOnScreen()
  open()
}