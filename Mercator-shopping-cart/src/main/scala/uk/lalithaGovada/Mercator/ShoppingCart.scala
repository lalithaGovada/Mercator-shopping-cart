package uk.lalithaGovada.Mercator

import uk.lalithaGovada.Mercator.CostEngine._
/*
"ShoppingCart" class responsible for below teask:
1) It loads the CostEngine and each item and its cost.
2) "cost" method have single param to take list of Shoping products
    "totalCost" responsible for Total of all selected items
*/
case class ShoppingCart(costEngines: List[CostEngine] = Nil) {

  private val defaultCostEngines = defaultAppleCost :: defaultOrangeCost :: Nil

  def cost(products: List[ShopProduct]): BigDecimal = {

    def totalCost(cost: BigDecimal, products: List[ShopProduct]): BigDecimal = {

      val combinedCostEngines = costEngines ++ defaultCostEngines
      val combinedCostFn = combinedCostEngines.tail.foldLeft(combinedCostEngines.head.cost)((acc, e) => acc orElse e.cost)
      val costResult = combinedCostFn(cost, products.sortBy(_.toString))

      costResult match {
        case (c, Nil) => c
        case (c, l) => totalCost(c, l)
      }
    }

    totalCost(0, products)
  }
}
