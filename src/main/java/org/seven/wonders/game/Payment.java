package org.seven.wonders.game;

import java.util.HashMap;
import java.util.Map;

import org.seven.wonders.effects.Condition.Scope;

public class Payment {

  private Map<Scope, Integer> internalPayment = new HashMap<>();

  private int total;

  public void add(int value, Scope scope) {
    int current = this.internalPayment.containsKey(scope) ? this.internalPayment.get(scope) : 0;
    current += value;
    this.internalPayment.put(scope, current);
    this.total += value;
  }

  public int getTotal() {
    return this.total;
  }

}
