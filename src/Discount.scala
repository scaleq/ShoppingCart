/**
  * Created by Alex on 30-Jan-17.
  */
trait Discount extends (ShoppingCart => BigDecimal)

object BuyOneGetOneFreeAppleDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart) : BigDecimal = {
    val appleItems = shoppingCart.items.collect { case item@Apple => item }
    (appleItems.length / 2) * Apple.price
  }
}

object ThreeForThePriceOfTwoOrangeDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart) : BigDecimal = {
    val orangeItems = shoppingCart.items.collect { case item @ Orange => item }
    (orangeItems.length / 3) * Orange.price
  }
}

object BuyOneGetOneFreeAppleAndBananaDiscount extends Discount {
  def apply(shoppingCart: ShoppingCart): BigDecimal = {

    val appleAndBananaPrices = shoppingCart.items.collect {
      case item@Apple => item.price
      case item@Banana => item.price
    }

    appleAndBananaPrices.sorted.take(appleAndBananaPrices.length / 2).sum
  }
}

  object ThreeForThePriceOfTwoMelonDiscount extends Discount {
    def apply(shoppingCart: ShoppingCart): BigDecimal = {
      val orangeItems = shoppingCart.items.collect { case item@Melon => item }
      (orangeItems.length / 3) * Melon.price
    }
  }

