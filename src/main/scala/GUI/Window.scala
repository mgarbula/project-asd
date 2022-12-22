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

    val menuPanel:BorderPanel = new BorderPanel {
      add(new Menu(treePre), BorderPanel.Position.Center)
    }
    add(menuPanel, BorderPanel.Position.North)

    val treePre:Label = new Label("-----------------")
    add(treePre, BorderPanel.Position.Center)

    val directionLabel:Label = new Label("-----------------")
    add(directionLabel, BorderPanel.Position.South)
  }
  centerOnScreen()
  open()
}