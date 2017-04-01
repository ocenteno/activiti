package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.Effect;
import org.seven.wonders.effects.deferred.CopyCardEnd;
import org.seven.wonders.effects.deferred.DeferredVPs;
import org.seven.wonders.effects.direct.GetShields;
import org.seven.wonders.effects.direct.GetVPs;
import org.seven.wonders.effects.hability.CanBuyCheaper;
import org.seven.wonders.effects.hability.CanDuplicateResource;
import org.seven.wonders.effects.hability.CanGenerateResource;
import org.seven.wonders.effects.mixed.ForMeAndSides;
import org.seven.wonders.effects.mixed.CoinsVPsIf;
import org.seven.wonders.effects.mixed.DebtVPs;
import org.seven.wonders.effects.mixed.DebtVPsIf;
import org.seven.wonders.effects.mixed.DiplomacyVPs;
import org.seven.wonders.effects.mixed.WonderForFreeVPs;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Black extends Card {

  // AGE I
  public static final Black HIDEOUT = new Black(DebtVPs.instantiate(1, 2));

  public static final Black GAMBLING_DEN = new Black(ForMeAndSides.instantiate(6, 1));

  public static final Black RESIDENCE = new Black(DiplomacyVPs.instantiate(1));

  public static final Black CLANDESTINE_DOCK_EAST = new Black(CanBuyCheaper.PAY_RIGHT_1_LESS, Cost.COIN);

  public static final Black CLANDESTINE_DOCK_WEST = new Black(CanBuyCheaper.PAY_LEFT_1_LESS, Cost.COIN);

  public static final Black GATES_OF_THE_CITY = new Black(GetVPs.instantiate(4), 1, WOOD);

  public static final Black PIGEON_LOFT = new Black(CopyCardEnd.GREEN, 1, ORE);

  public static final Black SECRET_WAREHOUSE = new Black(CanDuplicateResource.INSTANCE, 2);

  public static final Black MILITIA = new Black(GetShields.instantiate(2), 3);

  // AGE II
  public static final Black SEPULCHER = new Black(DebtVPsIf.instantiate(1, 4, Condition.ALL_VICTORIES), //
      STONE, GLASS, TEXTILE);

  public static final Black ARCHITECT_CABINET = new Black(WonderForFreeVPs.instantiate(2), 1, PAPYRUS);

  public static final Black LAIR = new Black(DebtVPs.instantiate(2, 3), WOOD, GLASS);

  public static final Black GAMBLING_HOUSE = new Black(ForMeAndSides.instantiate(9, 2), Cost.COIN);

  public static final Black CONSULATE = new Black(DiplomacyVPs.instantiate(2), CLAY, PAPYRUS);

  public static final Black TABULARIUM = new Black(GetVPs.instantiate(6), 2, ORE, WOOD, TEXTILE);

  public static final Black SPY_RING = new Black(CopyCardEnd.GREEN, 2, STONE, CLAY);

  public static final Black BLACK_MARKET = new Black(CanGenerateResource.INSTANCE, ORE, TEXTILE);

  public static final Black MERCENARIES = new Black(GetShields.instantiate(3), 4, PAPYRUS);

  // AGE III
  public static final Black CENOTAPH = new Black(DebtVPsIf.instantiate(1, 5, Condition.ALL_VICTORIES), //
      CLAY, CLAY, STONE, TEXTILE, GLASS);

  public static final Black SLAVE_MARKET = new Black(CoinsVPsIf.instantiate(1, 1, Condition.MY_VICTORIES), //
      ORE, ORE, WOOD, WOOD);

  public static final Black BROTHERHOOD = new Black(DebtVPs.instantiate(3, 4), WOOD, WOOD, ORE, TEXTILE);

  public static final Black SECRET_SOCIETY = new Black(CoinsVPsIf.instantiate(1, 1, Condition.MY_BLACKS), //
      STONE, PAPYRUS);

  public static final Black EMBASSY = new Black(DiplomacyVPs.instantiate(3), STONE, TEXTILE, PAPYRUS);

  public static final Black CAPITOL = new Black(GetVPs.instantiate(8), 2, CLAY, CLAY, STONE, STONE, GLASS, PAPYRUS);

  public static final Black TORTURE_CHAMBER = new Black(CopyCardEnd.GREEN, 3, ORE, ORE, GLASS);

  public static final Black BUILDERS_UNION = new Black(DebtVPsIf.instantiate(1, 4, Condition.OTHER_WONDERS), //
      CLAY, WOOD, PAPYRUS, GLASS);

  public static final Black CONTINGENT = new Black(GetShields.instantiate(5), 5, TEXTILE);

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
    this(DeferredVPs.instantiate(valor, condicion), new Cost(recursos));
  }

}
