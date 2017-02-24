package org.seven.wonders.cards;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Grey extends Card {

  public static final Grey LOOM = new Grey(Resource.TEXTILE);

  public static final Grey GLASSWORKS = new Grey(Resource.GLASS);

  public static final Grey PRESS = new Grey(Resource.PAPYRUS);

  static {
    setNames(Grey.class.getDeclaredFields());
  }

  public Grey(Resource recurso) {
    super(Color.GREY, Effect.resource(recurso), Cost.FREE);
  }

}
