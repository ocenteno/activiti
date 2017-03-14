package org.seven.wonders.services

import static org.seven.wonders.tokens.Resource.*

import org.seven.wonders.cards.Card
import org.seven.wonders.game.Game
import org.seven.wonders.game.Payment
import org.seven.wonders.game.Player

public class CheckCanBuild {

  def static resources = [WOOD, ORE, CLAY, STONE, TEXTILE, GLASS, PAPYRUS]

  public static boolean run(Game game, Player current, Card card) {
    def cost = card.cost
    def prod = current.wonder.produces
    def need = [cost.coins, cost.woods, cost.ores, cost.clays, cost.stones, cost.textiles, cost.glasses, cost.papyruses]
    def have = [prod.coins, prod.woods, prod.ores, prod.clays, prod.stones, prod.textiles, prod.glasses, prod.papyruses]

    /*
     * 1. CAN BE BUILT WITH OWN PRODUCED RESOURCES
     */
    def remain = need.withIndex().collect{ it, i ->
      Math.max(0, it - have[i])
    }
    if(remain.clone().unique() == [0]) return true
    // save coins left in case it´s needed to buy
    remain = remain.reverse()
    def noCoins = remain.pop() > 0
    remain = remain.reverse()

    /*
     * 2. CAN BE BUILT WITH PRODUCED OR RESOURCES
     */
    def options = computeOrOptions(prod.or.combinations())
    options.each{ opt ->
      remain = remain.withIndex().collect{ it,i -> Math.max(0, it - opt[i]) }
      if(remain.clone().unique() == [0]) return true
    }
    if(noCoins) return false

    /*
     * 3. CHECK IF RESOURCES CAN BE BOUGHT TAKING DISCOUNTS INTO ACCOUNT
     */
    return evaluateBuyingToNeighbours(game, current, remain)
  }

  private static def computeOrOptions(combinations) {
    def maps = [:]
    resources.each{
      maps << [(it):new int[combinations.size()]]
    }
    combinations.eachWithIndex{ res, i ->
      res.each{
        maps[it][i] ++
      }
    }
    def options = maps.collect{it.value}.transpose()
    return options
  }

  private static boolean evaluateBuyingToNeighbours(Game game, Player current, Collection remain) {
    Payment payByScope = new Payment()
    def canBuy = evaluateCostOfResources(game, current, remain, payByScope)
    if(!canBuy) return false
    current.wonder.getAvailableScopes().each{ scope ->
      payByScope.add(current.getWonder().getDiscount(scope), scope)
    }
    canBuy &= payByScope.total <= current.wonder.produces.coins
    return canBuy
  }

  private static boolean evaluateCostOfResources(Game game, Player current, Collection remain, Payment payByScope) {
    def canBuy = true
    def resourcesByScope = getResourcesByScope(game, current)
    // evaluate each resource to see if it can be bought
    resources.eachWithIndex { res, i ->
      if(!canBuy) return false // if not buyable break all
      if (remain[i] > 0) {
        // get where to buy current resource cheaper
        def scopes = current.wonder.getScopesByPriceForResource(res)
        scopes.each {
          def optionsToBuy = resourcesByScope[it]
          if (optionsToBuy != null) {
            optionsToBuy.eachWithIndex{opt,j ->
              if(remain[i] > 0){
                // compute the amount that can be bought and its cost
                int buy = opt[i] > remain[i] ? remain[i] : opt[i]
                payByScope.add(current.wonder.getCostOf(res, it, buy), it)
                remain[i] -= buy
              }
            }
          }
        }
        // if there are needs left it´s not possible to buy the resource
        canBuy &= !(remain[i] > 0)
      }
    }
    return canBuy
  }

  def static getResourcesByScope(game, currentPlayer){
    def players = game.getPlayersByScope(currentPlayer)
    def result = [:]
    players.keySet().each { scope ->
      result << [(scope): getResources(players[scope])]
    }
    return result
  }

  def static getResources(players){
    def resources = [players.size()][]
    players.eachWithIndex { it, i ->
      def prod = it.wonder.produces
      resources[i] = [prod.woods, prod.ores, prod.clays, prod.stones, prod.textiles, prod.glasses, prod.papyruses]
    }
    return resources
  }

  def static getPlayerResources(player){
    def prod = player.wonder.produces
    return [prod.woods, prod.ores, prod.clays, prod.stones, prod.textiles, prod.glasses, prod.papyruses]
  }

}
