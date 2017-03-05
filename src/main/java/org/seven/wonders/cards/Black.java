package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.CommercialEffect;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.DoubleEffect;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Black extends Card {

  // AGE I
  public static final Black HIDEOUT = new Black(DoubleEffect.debtVPs(1, 2));

  public static final Black GAMBLING_DEN = new Black(DoubleEffect.coinsSides(6, 1));

  public static final Black RESIDENCE = new Black(DoubleEffect.peaceVPs(1));

  public static final Black CLANDESTINE_DOCK_EAST = new Black(CommercialEffect.reducePrice(Condition.PAY_RIGHT, 1),
      Cost.COIN);

  public static final Black CLANDESTINE_DOCK_WEST = new Black(CommercialEffect.reducePrice(Condition.PAY_LEFT, 1),
      Cost.COIN);

  public static final Black GATES_OF_THE_CITY = new Black(Effect.victoryPoints(4), 1, WOOD);

  public static final Black PIGEON_LOFT = new Black(Effect.copyCard(Color.GREEN), 1, ORE);

  public static final Black SECRET_WAREHOUSE = new Black(Effect.copyResource(), 2);

  public static final Black MILITIA = new Black(Effect.shields(2), 3);

  // AGE II
  public static final Black SEPULCHER = new Black(DoubleEffect.conditionedDebtVPs(1, 4, Condition.ALL_VICTORIES),
      STONE, GLASS, TEXTILE);

  public static final Black ARCHITECT_CABINET = new Black(DoubleEffect.freeWonderVPs(2), 1, PAPYRUS);

  public static final Black LAIR = new Black(DoubleEffect.debtVPs(2, 3), WOOD, GLASS);

  public static final Black GAMBLING_HOUSE = new Black(DoubleEffect.coinsSides(9, 2), Cost.COIN);

  public static final Black CONSULATE = new Black(DoubleEffect.peaceVPs(2), CLAY, PAPYRUS);

  public static final Black TABULARIUM = new Black(Effect.victoryPoints(6), 2, ORE, WOOD, TEXTILE);

  public static final Black SPY_RING = new Black(Effect.copyCard(Color.GREEN), 2, STONE, CLAY);

  public static final Black BLACK_MARKET = new Black(Effect.resources(ANY), ORE, TEXTILE);

  public static final Black MERCENARIES = new Black(Effect.shields(3), 4, PAPYRUS);

  // AGE III
  public static final Black CENOTAPH = new Black(DoubleEffect.conditionedDebtVPs(1, 5, Condition.ALL_VICTORIES), CLAY,
      CLAY, STONE, TEXTILE, GLASS);

  public static final Black SLAVE_MARKET = new Black(DoubleEffect.contidionedCoinsVPs(1, 1, Condition.MY_VICTORIES),
      ORE, ORE, WOOD, WOOD);

  public static final Black BROTHERHOOD = new Black(DoubleEffect.debtVPs(3, 4), WOOD, WOOD, ORE, TEXTILE);

  public static final Black SECRET_SOCIETY = new Black(DoubleEffect.contidionedCoinsVPs(1, 1, Condition.MY_BLACK),
      STONE, PAPYRUS);

  public static final Black EMBASSY = new Black(DoubleEffect.peaceVPs(3), STONE, TEXTILE, PAPYRUS);

  public static final Black CAPITOL = new Black(Effect.victoryPoints(8), 2, CLAY, CLAY, STONE, STONE, GLASS, PAPYRUS);

  public static final Black TORTURE_CHAMBER = new Black(Effect.copyCard(Color.GREEN), 3, ORE, ORE, GLASS);

  public static final Black BUILDERS_UNION = new Black(DoubleEffect.conditionedDebtVPs(1, 4, Condition.OTHER_WONDERS),
      CLAY, WOOD, PAPYRUS, GLASS);

  public static final Black CONTINGENT = new Black(Effect.shields(5), 5, TEXTILE);

  static {
    setNames(Black.class.getDeclaredFields());
  }

  public Black(Effect efecto) {
    this(efecto, Cost.FREE);
  }

  public Black(Effect efecto, Resource... recursos) {
    this(efecto, new Cost(recursos));
  }

  public Black(Effect efecto, Cost cost) {
    super(Color.BLACK, efecto, cost);
  }

  public Black(Effect efecto, int coins, Resource... recursos) {
    this(efecto, new Cost(coins, recursos));
  }

  public Black(Condition condicion, int valor, Resource... recursos) {
    this(Effect.conditionedVPs(valor, condicion), new Cost(recursos));
  }

}
