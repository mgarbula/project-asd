package GUI

import GUI.Operations.{doOperation}
import tree.Tree
import tree.Tree.Empty

import javax.swing.SwingUtilities
import scala.swing.{BorderPanel, Button, FlowPanel, Label, TextArea}
import scala.swing.event.ButtonClicked

class Menu(treePrinter: TreePrinter, directionLabel: DirectionLabel) extends BorderPanel {
  val BST = "BST"
  val AVL = "AVL"
  var kind:String = BST
  var kindToChoose:String = AVL
  var tree:Tree = Empty

  val addOption:OptionPanel = new OptionPanel {
    override val operation = 1
    override val btn: Button = new Button("Dodaj") {
      reactions += {
        case ButtonClicked(_) =>
          SwingUtilities.invokeLater(() => {
            val myThread = new MyThread(directionLabel, txt.text.toInt, tree, btn)
            myThread.start()
            tree = doOperation(operation, tree, txt.text.toInt, kind)
            txt.text = ""
            treePrinter.printTree(tree)
          })

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
        case ButtonClicked(_) =>
          tree = doOperation(operation, tree, txt.text.toInt, kind)
          txt.text = ""
          treePrinter.printTree(tree)
      }
    }

    contents += new Label("Usun element")
    contents += txt
    contents += btn
  }

  val kindPanel:BorderPanel = new BorderPanel {
    val kindLabel = new Label("Aktualny typ drzewa: " + kind)
    add(kindLabel, BorderPanel.Position.North)

    val kindButton:Button = new Button("Zmien typ") {
      reactions += {
        case ButtonClicked(_) =>
          tree = Empty
          treePrinter.printTree(tree)
          kindLabel.text = "Aktualny typ drzewa: " + kindToChoose
          val help = kindToChoose
          kindToChoose = new String(kind)
          kind = new String(help)
      }
    }
    add(kindButton, BorderPanel.Position.Center)
  }

  val optionsPanel = new BorderPanel {
    add(addOption, BorderPanel.Position.North)
    add(removeOption, BorderPanel.Position.South)
  }
  add(optionsPanel, BorderPanel.Position.Center)
  add(kindPanel, BorderPanel.Position.East)
}

trait OptionPanel extends FlowPanel {
  val txt:TextArea = new TextArea(1, 10)
  val btn:Button
  val operation:Int
}