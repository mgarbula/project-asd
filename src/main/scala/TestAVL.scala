import tree.Tree.{Empty, height, right}
import tree._

object TestAVL {
  def main(args: Array[String]): Unit = {
    var t:Tree = Empty
    val avl:AVL = new AVL

    /*t = avl.insert(t, 4)
    t = avl.insert(t, 2)
    t = avl.insert(t, 8)
    t = avl.insert(t, 9)
    t = avl.insert(t, 6)
    t = avl.insert(t, 10)
    println("t = " + t)*/

    /*t = avl.insert(t, 10)
    t = avl.insert(t, 20)
    t = avl.insert(t, 30)
    t = avl.insert(t, 40)
    t = avl.insert(t, 25)
    t = avl.insert(t, 90)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))*/

    /*t = avl.insert(t, 6)
    t = avl.insert(t, 5)
    t = avl.insert(t, 4)*/

    t = avl.insert(t, 5)
    t = avl.insert(t, 0)
    t = avl.insert(t, 6)
    t = avl.insert(t, -1)
    t = avl.insert(t, 1)
    t = avl.insert(t, 2)
    println("tree " + t)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))

    t = avl.delete(t, -1)
    t = avl.delete(t, 0)
    println("tree " + t)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))

    /*t = avl.insert(t, 5)
    t = avl.insert(t, 0)
    t = avl.insert(t, 8)
    t = avl.insert(t, 9)
    t = avl.insert(t, 7)
    t = avl.insert(t, 6)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))
    t = avl.delete(t, 9)
    t = avl.delete(t, 8)
    println("t " + t)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))*/

    /*t = avl.insert(t, 7)
    t = avl.insert(t, 5)
    t = avl.insert(t, 0)
    t = avl.insert(t, 6)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))*/

    /*t = avl.delete(t, 10)
    println("preorder " + avl.preorder(t))
    println("inorder " + avl.inorder(t))*/

    /*t = avl.insert(t, 6)
    t = avl.insert(t, 7)
    t = avl.insert(t, 8)
    println(avl.preorder(t))
    println(avl.inorder(t))
    t = avl.insert(t, 5)
    t = avl.insert(t, 4)
    println(avl.preorder(t))
    println(avl.inorder(t))*/


    /*println("Preorder stary " + avl.preorder(t))
    println("Inorder stary " + avl.inorder(t))
    t = avl.rotateLeft(t, right(t))
    println("Preorder nowy " + avl.preorder(t))
    println("Inorder nowy " + avl.inorder(t))*/
    /*println(avl.inorder(t))
    println(avl.preorder(t))*/
  }
}

