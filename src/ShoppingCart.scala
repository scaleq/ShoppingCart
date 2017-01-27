/**
  * Created by Alex on 27-Jan-17.
  */

trait ShoppingCartItem
case class Apple() extends ShoppingCartItem
case class Orange() extends ShoppingCartItem

object ShoppingCart {
  def checkout(items: List[ShoppingCartItem]) : Double = items.map {
    case Apple() => 0.60
    case Orange() => 0.25
  }.sum
}
