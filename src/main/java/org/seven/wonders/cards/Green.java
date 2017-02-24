package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;
import org.seven.wonders.tokens.Science;

public class Green extends Card {

  public static final Card APOTHECARY = new Green(Science.COMPASS, TEXTILE);

  public static final Card DISPENSARY = new Green(Science.COMPASS, APOTHECARY, ORE, ORE, GLASS);

  public static final Card LODGE = new Green(Science.COMPASS, DISPENSARY, CLAY, CLAY, TEXTILE, PAPYRUS);

  public static final Card WORKSHOP = new Green(Science.GEAR, GLASS);

  public static final Card LABORATORY = new Green(Science.GEAR, WORKSHOP, CLAY, CLAY, PAPYRUS);

  public static final Card OBSERVATORY = new Green(Science.GEAR, LABORATORY, ORE, ORE, GLASS, TEXTILE);

  public static final Card SCRIPTORIUM = new Green(Science.TABLET, PAPYRUS);

  public static final Card LIBRARY = new Green(Science.TABLET, SCRIPTORIUM, STONE, STONE, TEXTILE);

  public static final Card UNIVERSITY = new Green(Science.TABLET, LIBRARY, WOOD, WOOD, PAPYRUS, GLASS);

  public static final Card SCHOOL = new Green(Science.TABLET, STONE, PAPYRUS);

  public static final Card ACADEMY = new Green(Science.COMPASS, SCHOOL, STONE, STONE, STONE, GLASS);

  public static final Card STUDY = new Green(Science.GEAR, SCHOOL, STONE, PAPYRUS, TEXTILE);

  static {
    setNames(Green.class.getDeclaredFields());
  }

  public Green(Science valor, Card cadena, Resource... recursos) {
    this(valor, recursos);
    if (cadena != null) {
      getCost().setChain(cadena);
    }
  }

  public Green(Science valor, Resource... recursos) {
    super(Color.GREEN, Effect.science(valor), new Cost(recursos));
  }

}
