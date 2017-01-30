/**
  * Created by Alex on 30-Jan-17.
  */
trait Discount extends (ShoppingCart => BigDecimal)

object BuyOneGetOneFreeAppleDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart) = {
    val appleItems = shoppingCart.items.collect { case item@Apple => item }
    (appleItems.length / 2) * Apple.price
  }
}

object ThreeForThePriceOfTwoOrangeDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart) = {
    val orangeItems = shoppingCart.items.collect { case item @ Orange => item }
    (orangeItems.length / 3) * Orange.price
  }
}

