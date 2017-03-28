package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.direct.GetShields;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Red extends Card {

  public static final Red STOCKADE = new Red(1, WOOD);

  public static final Red BARRACKS = new Red(1, ORE);

  public static final Red GUARD_TOWER = new Red(1, CLAY);

  public static final Red WALLS = new Red(2, STONE, STONE, STONE);

  public static final Red FORTIFICATIONS = new Red(3, WALLS, STONE, ORE, ORE, ORE);

  public static final Red TRAINING_GROUND = new Red(2, WOOD, ORE, ORE);

  public static final Red CIRCUS = new Red(3, TRAINING_GROUND, STONE, STONE, STONE, ORE);

  public static final Red ARSENAL = new Red(3, TEXTILE, ORE, WOOD, WOOD);

  public static final Red STABLES = new Red(2, Green.APOTHECARY, ORE, CLAY, WOOD);

  public static final Red ARCHERY_RANGE = new Red(2, Green.WORKSHOP, ORE, WOOD, WOOD);

  public static final Red SIEGE_WORKSHOP = new Red(3, Green.LABORATORY, ORE, CLAY, CLAY, CLAY);

  static {
    setNames(Red.class.getDeclaredFields());
  }

  public Red(int valor, Card cadena, Resource... recursos) {
    this(valor, recursos);
    if (cadena != null) {
      getCost().setChain(cadena);
    }
  }

  public Red(int valor, Resource... recursos) {
    super(Color.RED, GetShields.instantiate(valor), new Cost(recursos));
  }

}
