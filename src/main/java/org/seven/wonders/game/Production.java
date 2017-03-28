package org.seven.wonders.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;

import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Production extends Cost {

  @Getter
  private List<Resource[]> or = new ArrayList<>();

  public void add(int value) {
    this.coins += value;
  }

  public int pay(int value) {
    int diff = this.coins - value;
    this.coins -= Math.min(value, this.coins);
    return Math.max(0, diff);
  }

  public void add(Resource... recursos) {
    List<Resource> resources = Arrays.asList(recursos);
    this.stones += Collections.frequency(resources, Resource.STONE);
    this.woods += Collections.frequency(resources, Resource.WOOD);
    this.ores += Collections.frequency(resources, Resource.ORE);
    this.clays += Collections.frequency(resources, Resource.CLAY);
    this.textiles += Collections.frequency(resources, Resource.TEXTILE);
    this.papyruses += Collections.frequency(resources, Resource.PAPYRUS);
    this.glasses += Collections.frequency(resources, Resource.GLASS);
  }

  public void addOr(Resource... value) {
    this.or.add(value);
  }

  public Production(Resource... recursos) {
    super(recursos);
  }

  public Production(int monedas, Resource... resources) {
    super(monedas, resources);
  }

}
