package org.seven.wonders.game;

import java.util.HashSet;
import java.util.Set;

import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.tokens.Cost;

public class Habilities extends Cost {

  private Set<Class<? extends HabilityEffect>> habilities = new HashSet<>();

  public void set(Class<? extends HabilityEffect> clazz) {
    this.habilities.add(clazz);
  }

  public boolean can(Class<? extends HabilityEffect> clazz) {
    return this.habilities.contains(clazz);
  }

}
