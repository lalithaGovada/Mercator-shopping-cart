package uk.lalithaGovada.Mercator

import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers
import uk.lalithaGovada.Mercator.CostEngine._
/*
Step 2: Simple offers Logic 
~~~~~~~~~~~~~~~~~~~~~~~~~~~
MercatorCostEngineTest have 
"AppleCostEngine" method responsible to define Apple cost as 60p for each.if Apple not in Cost than Nill will be returns
"discountedAppleCost" method responsible to give offer "buy one, get one free on Apples"

"OrangeCostEngine" method defines each Orange cost as 0.25p, if Orange not in Cost than Nill will be returns
"discountedOrangeCost" 3 for the price of 2- business logic is defined hear
*/
class MercatorCostEngineTest extends AnyFreeSpec with Matchers {

  private val zero = BigDecimal(0)

  "AppleCostEngine" - {
    "defaultAppleCost" - {
      "should calculate cost based on individual cost (60p) of apple" in {
        defaultAppleCost.cost( zero -> (Apple :: Nil)) shouldBe 0.60 -> Nil
      }
    }
    "discountedAppleCost" - {
      "should calculate cost applying discount rule: buy one, get one free" in {
        discountedAppleCost.cost(zero -> (Apple :: Apple :: Nil)) shouldBe 0.60 -> Nil
      }
    }
  }
  "OrangeCostEngine" - {
    "defaultOrangeCost" - {
      "should calculate total cost pbased on individual cost (25p) of orange" in {
        defaultOrangeCost.cost(zero -> (Orange :: Nil)) shouldBe 0.25 -> Nil
      }
    }
    "discountedOrangeCost" - {
      "should calculate cost applying discount rule: 3 for the price of 2" in {
        discountedOrangeCost.cost(zero -> (Orange :: Orange :: Orange :: Nil)) shouldBe 0.50 -> Nil
      }
    }
  }
}
