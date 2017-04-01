package org.seven.wonders.effects.hability;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

@Data
@RequiredArgsConstructor
public class CanHaveCardTwice extends HabilityEffect {

  public static final CanHaveCardTwice GREY = new CanHaveCardTwice(Color.GREY);

  public static final CanHaveCardTwice BROWN = new CanHaveCardTwice(Color.BROWN);

  public static final CanHaveCardTwice INSTANCE = new CanHaveCardTwice(Color.ANY);

  private final Color color;

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanHaveCardTwice.class);
    }
  }

}
