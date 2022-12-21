package GUI

import GUI.Operations.doOperation
import tree.Tree
import tree.Tree.Empty

import scala.swing.{BorderPanel, Button, FlowPanel, Label, TextArea}
import scala.swing.event.ButtonClicked

class Menu extends BorderPanel {
  var tree:Tree = Empty

  val addOption:OptionPanel = new OptionPanel {
    override val operation = 1
    override val btn: Button = new Button("Dodaj") {
      reactions += {
        case ButtonClicked(_) => tree = doOperation(operation, tree, txt.text.toInt); txt.text = ""
      }
    }

    contents += new Label("Dodaj element")
    contents += txt
    contents += btn
  }

  val removeOption:OptionPanel = new OptionPanel {
    override val operation = 2
    override val btn: Button = new Button("Usun") {
      reactions += {
        case ButtonClicked(_) => tree = doOperation(operation, tree, txt.text.toInt); txt.text = ""
      }
    }

    contents += new Label("Usun element")
    contents += txt
    contents += btn
  }

  add(addOption, BorderPanel.Position.North)
  add(removeOption, BorderPanel.Position.South)
}

trait OptionPanel extends FlowPanel {
  val txt:TextArea = new TextArea(1, 20)
  val btn:Button
  val operation:Int
}