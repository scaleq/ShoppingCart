/**
  * Created by Alex on 27-Jan-17.
  */

sealed trait ShoppingCartItem{
  val price: BigDecimal
}
case object Apple extends ShoppingCartItem {
  val price = BigDecimal(0.60)
}
case object Orange extends ShoppingCartItem{
  val price = BigDecimal(0.25)
}
case object Banana extends ShoppingCartItem{
  val price = BigDecimal(0.20)
}
case object Melon extends ShoppingCartItem{
  val price = BigDecimal(1.00)
}

case class ShoppingCart(items: List[ShoppingCartItem]) {
    def checkout(discounts : List[Discount] = Nil) : BigDecimal = {
      val totalCost = items.map{ _.price }.sum
      val totalDiscount = discounts.map { _(this) }.sum

      totalCost - totalDiscount
  }

  def AddItem(item: ShoppingCartItem) = ShoppingCart(item::items)
}