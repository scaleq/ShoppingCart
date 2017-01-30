/**
  * Created by Alex on 27-Jan-17.
  */
import org.scalatest.FunSuite

class ShoppingCartTests  extends FunSuite {

  /* Step 1 */
  test("An empty shopping cart should return 0.0 at checkout") {
    assert(ShoppingCart(Nil).checkout() == 0)
  }

  test("A shopping cart with an apple should return 0.60 at checkout") {
    assert(ShoppingCart(Apple::Nil).checkout() == 0.60)
  }

  test("A shopping cart with an orange should return 0.60 at checkout") {
    assert(ShoppingCart(Orange::Nil).checkout() == 0.25)
  }

  test("A shopping cart with three apples and an orange should return 2.05 at checkout") {
    assert(ShoppingCart(Apple::Apple::Apple::Orange::Nil).checkout() == 2.05)
  }

  /* Step 2 */

  test("A shopping cart with two apples and offer 'Buy one get one free on Apples' should return 0.60 at checkout") {
    assert(ShoppingCart(Apple::Apple::Nil).checkout(BuyOneGetOneFreeAppleDiscount::Nil) == 0.60)
  }

  test("A shopping cart with three apples and offer 'Buy one get one free on Apples' should return 1.20 at checkout") {
    assert(ShoppingCart(Apple::Apple::Apple::Nil).checkout(BuyOneGetOneFreeAppleDiscount::Nil) == 1.20)
  }

  test("A shopping cart with four apples and offer 'Buy one get one free on Apples' should return 1.20 at checkout") {
    assert(ShoppingCart(Apple::Apple::Apple::Apple::Nil).checkout(BuyOneGetOneFreeAppleDiscount::Nil) == 1.20)
  }

  test("A shopping cart with three oranges and offer 'Three for the price of two on Oranges' should return 0.50 at checkout") {
    assert(ShoppingCart(Orange::Orange::Orange::Nil).checkout(ThreeForThePriceOfTwoOrangeDiscount::Nil) == 0.50)
  }

  test("A shopping cart with four oranges and offer 'Three for the price of two on Oranges' should return 0.75 at checkout") {
    assert(ShoppingCart(Orange::Orange::Orange::Orange::Nil).checkout(ThreeForThePriceOfTwoOrangeDiscount::Nil) == 0.75)
  }

  test("A shopping cart with five oranges and offer 'Three for the price of two on Oranges' should return 1.00 at checkout") {
    assert(ShoppingCart(Orange::Orange::Orange::Orange::Orange::Nil).checkout(ThreeForThePriceOfTwoOrangeDiscount::Nil) == 1.00)
  }

  test("A shopping cart with six oranges and offer 'Three for the price of two on Oranges' should return 1.00 at checkout") {
    assert(ShoppingCart(Orange::Orange::Orange::Orange::Orange::Orange::Nil).checkout(ThreeForThePriceOfTwoOrangeDiscount::Nil) == 1.00)
  }

}
