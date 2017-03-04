package org.seven.wonders.game;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

import org.seven.wonders.effects.Condition.Scope;
import org.seven.wonders.tokens.Resource;

@Data
public class Price implements Serializable {

  // 0-3: WOOD,CLAY,STONE,ORE,
  // 4-6: TEXTILE,GLASS,PAPYRUS,
  // 7: DISCOUNT
  private int[][] internalPrices = new int[8][4];

  private Set<Scope> internalScopes = new HashSet<>();

  public void setBuy(Scope scope, int price) {
    this.internalScopes.add(scope);
    for (int i = 0; i < 7; i++) {
      this.internalPrices[i][position(scope)] = price;
    }
  }

  private int position(Scope scope) {
    switch (scope) {
      case BANK:
        return 0;
      case LEFT:
        return 1;
      case RIGHT:
        return 2;
      case OTHERS:
        return 3;
      default:
        return -1;
    }
  }

  public int get(Resource resource, Scope scope) {
    return this.internalPrices[resource.ordinal()][position(scope)];
  }

  public int getDiscount(Scope scope) {
    return this.internalPrices[7][position(scope)];
  }

}
