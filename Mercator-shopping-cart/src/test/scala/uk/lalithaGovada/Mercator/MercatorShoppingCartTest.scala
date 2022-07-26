package uk.lalithaGovada.Mercator

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import uk.lalithaGovada.Mercator.CostEngine._
/*

Step 1: Shopping cart
● You are building a checkout system for a shop which only sells apples and
oranges.
● Apples cost 60p and oranges cost 25p.
● Build a checkout system which takes a list of items scanned at the till and outputs
the total cost
● For example: [ Apple, Apple, Orange, Apple ] => £2.05 
● Make reasonable assumptions about the inputs to your solution; for example, many
candidates take a list of strings as input

"MercatorShoppingCartTest" is responsible for above task
"uk.lalithaGovada.Mercator.ShoppingCart" class responsible to take list of items scanned and calculate total cost

*/
class MercatorShoppingCartTest extends AnyFreeSpec with Matchers {
  "ShoppingCart" - {
    "given collection of products" - {
      "should calculate the total cost the products correctly (each apple cost 60p and each orange cost 25p)" in {
        ShoppingCart()
          .cost(Apple :: Apple :: Orange :: Apple :: Nil) shouldBe 2.05
      }
    }
    "given collection of products and discounts" - {
      "should apply correct discount to Apples" in {
        ShoppingCart(discountedAppleCost :: Nil)
          .cost(Apple :: Apple :: Apple :: Apple :: Apple :: Nil) shouldBe 1.8
      }
      "should apply correct discount to Oranges" in {
        ShoppingCart(discountedOrangeCost :: Nil)
          .cost(Orange :: Orange :: Orange :: Orange :: Nil) shouldBe 0.75
      }
      "should apply correct discount to both Apples and Oranges" in {
        ShoppingCart(discountedAppleCost :: discountedOrangeCost :: Nil)
          .cost(Apple :: Apple :: Apple :: Orange :: Orange :: Orange :: Apple :: Apple :: Apple :: Orange :: Orange :: Nil) shouldBe 2.8
      }
    }
  }
}
