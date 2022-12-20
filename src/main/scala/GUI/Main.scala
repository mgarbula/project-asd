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
      add(new AddMenu, BorderPanel.Position.North)
      add(new RemoveMenu, BorderPanel.Position.South)
    }
    add(menuPanel, BorderPanel.Position.East)
  }
  //pack()
  centerOnScreen()
  open()
}

object Main {
  def main(args: Array[String]): Unit = {
    new Window()
  }
}
