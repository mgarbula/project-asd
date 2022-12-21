package GUI

import scala.swing.MainFrame
import scala.swing.Dimension
import scala.swing.Label
import scala.swing.BorderPanel

class Window extends MainFrame {
  title = "Tree"
  size = new Dimension(600, 600)
  contents = new BorderPanel {
    add(new Label("Tu będzie drzewo"), BorderPanel.Position.Center)
    val menuPanel:BorderPanel = new BorderPanel {
      add(new Menu, BorderPanel.Position.Center)
    }
    add(menuPanel, BorderPanel.Position.East)
  }
  centerOnScreen()
  open()
}