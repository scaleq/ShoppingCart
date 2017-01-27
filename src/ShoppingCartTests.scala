/**
  * Created by Alex on 27-Jan-17.
  */
import org.scalatest.FunSuite

class ShoppingCartTests  extends FunSuite {

  test("An empty shopping cart should return 0.0 at checkout") {
    assert(ShoppingCart.checkout(Nil) == 0)
  }

  test("A shopping cart with an apple should return 0.60 at checkout") {
    assert(ShoppingCart.checkout(Apple()::Nil) == 0.60)
  }

  test("A shopping cart with an orange should return 0.60 at checkout") {
    assert(ShoppingCart.checkout(Orange()::Nil) == 0.25)
  }

  test("Three apples and an orange should return 2.05 at checkout") {
    assert(ShoppingCart.checkout(Apple()::Apple()::Apple()::Orange()::Nil) == 2.05)
  }
}
