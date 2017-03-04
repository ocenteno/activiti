package org.seven.wonders.services;

import static org.seven.wonders.tokens.Resource.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Data;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.game.Game;
import org.seven.wonders.game.Payment;
import org.seven.wonders.game.Player;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

@Data
public class CheckCanBuy implements JavaDelegate {

  private Expression costLeft;

  private Expression player;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    // 1) GET PROCESS VARIABLES
    Player currentPlayer = (Player)this.player.getValue(execution);
    Game game = (Game)execution.getVariable("game");
    // Cost cost = (Cost)this.costLeft.getValue(execution);
    // 2) INITIALIZE INTERNAL VARIABLES
    Object value = this.costLeft.getValue(execution);
    int[] need = (value instanceof Cost) ? getNeeds((Cost)value) : (int[])value;
    boolean canBuy = true;
    Payment payByScope = new Payment();
    Resource[] keys = new Resource[] { WOOD, ORE, CLAY, STONE, TEXTILE, GLASS, PAPYRUS };
    Map<Scope, int[][]> resourcesByScope = getResourcesByScope(game, currentPlayer);
    // FOR EACH RESOURCE
    for (int i = 0; i < keys.length && canBuy; i++) {
      if (need[i] > 0) {
        // GET WHERE TO BUY IT CHEAPER
        List<Scope> scopes = currentPlayer.getWonder().getScopesByPriceForResource(keys[i]);
        // FOR EACH SCOPE GET RESOURCES PRODUCED
        for (Scope scope : scopes) {
          int[][] resources = resourcesByScope.get(scope);
          if (resources != null) {
            for (int j = 0; j < resources.length && need[i] > 0; j++) {
              // COMPUTE THE AMOUNT THAT CAN BE BOUGHT & THE COST
              int buy = resources[j][i] > need[i] ? need[i] : resources[j][i];
              payByScope.add(currentPlayer.getWonder().getCostOf(keys[i], scope, buy), scope);
              need[i] -= buy;
            }
          }
        }
        // IF THERE ARE NEEDS LEFT, IT´S NOT POSSIBLE TO BUY IT
        canBuy &= !(need[i] > 0);
      }
    }
    // CHECK IF THERE ARE DISCOUNTS
    for (Scope scope : currentPlayer.getWonder().getAvailableScopes()) {
      payByScope.add(currentPlayer.getWonder().getDiscount(scope), scope);
    }
    // IN THE END I CAN BUY IF I HAVE ENOUGH COINS
    canBuy &= payByScope.getTotal() <= currentPlayer.getWonder().getProduces().getCoins();
    execution.setVariable("canBuy", canBuy);
  }

  private Map<Scope, int[][]> getResourcesByScope(Game game, Player currentPlayer) {
    Map<Scope, List<Player>> playersByScope = game.getPlayersByScope(currentPlayer);
    Map<Scope, int[][]> resourcesByScope = getResources(playersByScope);
    return resourcesByScope;
  }

  private int[] getNeeds(Cost c) {
    return new int[] { c.getWoods(), c.getOres(), c.getClays(), c.getStones(), c.getTextiles(), c.getGlasses(),
        c.getPapyruses() };
  }

  private Map<Scope, int[][]> getResources(Map<Scope, List<Player>> players) {
    Map<Scope, int[][]> result = new HashMap<Scope, int[][]>(4);
    for (Scope scope : players.keySet()) {
      result.put(scope, getResources(players.get(scope)));
    }
    return result;
  }

  private int[][] getResources(List<Player> players) {
    int[][] resources = new int[players.size()][];
    for (int i = 0; i < players.size(); i++) {
      resources[i] = getResources(players.get(i));
    }
    return resources;
  }

  private int[] getResources(Player p) {
    return new int[] { p.getWonder().getProduces().getWoods(), p.getWonder().getProduces().getOres(),
        p.getWonder().getProduces().getClays(), p.getWonder().getProduces().getStones(),
        p.getWonder().getProduces().getTextiles(), p.getWonder().getProduces().getGlasses(),
        p.getWonder().getProduces().getPapyruses() };
  }

}
