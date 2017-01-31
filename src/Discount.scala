/**
  * Created by Alex on 30-Jan-17.
  */

import scala.reflect.ClassTag

trait Discount extends (ShoppingCart => BigDecimal)

class GeneralDiscount[T <: ShoppingCartItem : ClassTag](itemsInDiscount: Int) extends  Discount {
  def apply(shoppingCart: ShoppingCart) : BigDecimal = {
    val prices = shoppingCart.items.collect { case item : T => item.price }
    prices.take(prices.length / itemsInDiscount).sum
  }
}

object BuyOneGetOneFreeAppleDiscount extends GeneralDiscount[Apple.type](itemsInDiscount = 2)
object ThreeForThePriceOfTwoOrangeDiscount extends GeneralDiscount[Orange.type](itemsInDiscount = 3)
object ThreeForThePriceOfTwoMelonDiscount extends GeneralDiscount[Melon.type](itemsInDiscount = 3)

object BuyOneGetOneFreeAppleAndBananaDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart): BigDecimal = {

    val appleAndBananaPrices = shoppingCart.items.collect {
      case item@Apple => item.price
      case item@Banana => item.price
    }

    appleAndBananaPrices.sorted.take(appleAndBananaPrices.length / 2).sum
  }
}

