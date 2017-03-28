package org.seven.wonders.effects.hability;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.HabilityEffect;
import org.seven.wonders.wonders.Wonder;

@Data
@RequiredArgsConstructor
public class CanDuplicateCard extends HabilityEffect {

  public static final CanDuplicateCard GREY = new CanDuplicateCard(Color.GREY);

  public static final CanDuplicateCard BROWN = new CanDuplicateCard(Color.BROWN);

  public static final CanDuplicateCard INSTANCE = new CanDuplicateCard(Color.ANY);

  private final Color color;

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      wonder.enable(CanDuplicateCard.class);
    }
  }

}
