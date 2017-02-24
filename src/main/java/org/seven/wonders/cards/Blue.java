package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Blue extends Card {

  public static final Blue PAWNSHOP = new Blue(3);

  public static final Blue BATHS = new Blue(3, STONE);

  public static final Blue AQUEDUCT = new Blue(5, BATHS, STONE, STONE, STONE);

  public static final Blue ALTAR = new Blue(2);

  public static final Blue TEMPLE = new Blue(3, ALTAR, WOOD, CLAY, GLASS);

  public static final Blue PANTHEON = new Blue(7, TEMPLE, CLAY, CLAY, ORE, PAPYRUS, TEXTILE, GLASS);

  public static final Blue THEATRE = new Blue(2);

  public static final Blue STATUE = new Blue(4, THEATRE, WOOD, ORE, ORE);

  public static final Blue GARDENS = new Blue(5, STATUE, WOOD, CLAY, CLAY);

  public static final Blue TOWN_HALL = new Blue(6, GLASS, ORE, STONE, STONE);

  public static final Blue PALACE = new Blue(8, TEXTILE, PAPYRUS, GLASS, ORE, WOOD, CLAY, STONE);

  public static final Blue COURTHOUSE = new Blue(4, Green.SCRIPTORIUM, CLAY, CLAY, TEXTILE);

  public static final Blue SENATE = new Blue(6, Green.LIBRARY, ORE, WOOD, WOOD, STONE);

  static {
    setNames(Blue.class.getDeclaredFields());
  }

  public Blue(int valor, Card cadena, Resource... recursos) {
    this(valor, recursos);
    if (cadena != null) {
      getCost().setChain(cadena);
    }
  }

  public Blue(int valor, Resource... recursos) {
    super(Color.BLUE, Effect.victoryPoints(valor), new Cost(recursos));
  }

  public Blue(int valor) {
    super(Color.BLUE, Effect.victoryPoints(valor), Cost.FREE);
  }

}
