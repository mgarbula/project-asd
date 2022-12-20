package GUI

import scala.swing.FlowPanel
import scala.swing.TextArea
import scala.swing.Button
import scala.swing.Label

trait Menu extends FlowPanel {
  val txt:TextArea = new TextArea(1, 20)
  val btn:Button
}

class AddMenu extends Menu {
  override val btn: Button = new Button("Dodaj")

  contents += new Label("Dodaj element")
  contents += txt
  contents += btn
}

class RemoveMenu extends Menu {
  override val btn: Button = new Button("Usun")

  contents += new Label("Usun element")
  contents += txt
  contents += btn
}
