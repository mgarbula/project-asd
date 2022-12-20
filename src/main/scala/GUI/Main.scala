package GUI

import scala.swing._

object Main {
  def main(args: Array[String]): Unit = {
    new Frame() {
      visible = true
      size = new Dimension(500, 600)
    }
  }
}
