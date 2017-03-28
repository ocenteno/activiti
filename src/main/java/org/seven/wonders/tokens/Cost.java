package org.seven.wonders.tokens;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

import org.seven.wonders.cards.Card;

@Getter
public class Cost implements Serializable {

  public static final Cost FREE = new Cost();

  public static final Cost COIN = new Cost(1);

  public static final Cost CARD = new Cost(-1);

  private transient List<Resource> resources;

  protected int coins;

  protected int stones;

  protected int clays;

  protected int woods;

  protected int ores;

  protected int textiles;

  protected int papyruses;

  protected int glasses;

  @Setter
  private Card chain;

  public Cost(Resource... recursos) {
    this(0, recursos);
  }

  public Cost(int monedas, Resource... resources) {
    this.coins = monedas;
    this.resources = Arrays.asList(resources);
    this.stones = Collections.frequency(this.resources, Resource.STONE);
    this.woods = Collections.frequency(this.resources, Resource.WOOD);
    this.ores = Collections.frequency(this.resources, Resource.ORE);
    this.clays = Collections.frequency(this.resources, Resource.CLAY);
    this.textiles = Collections.frequency(this.resources, Resource.TEXTILE);
    this.papyruses = Collections.frequency(this.resources, Resource.PAPYRUS);
    this.glasses = Collections.frequency(this.resources, Resource.GLASS);
  }

}
