package GUI

import scala.swing.Label

class DirectionLabel(txt: String) extends Label {
  text = txt

  def printDirection(elem: Int, a: Int, direction: Char): Unit = direction match {
    case 'l' => text = "" + elem + " mniejszy od " + a + " - idę w lewo"; println("HALOO LEWO"); //Thread.sleep(1000)
    case 'r' => text = "" + elem + " większy od " + a + " - idę w prawo"; println("HALOO PRAWO"); //Thread.sleep(1000)
    case 'm' => text = "" + elem + " jest na swoim miejscu"; println("HALOOO"); //Thread.sleep(1000)
  }

}
