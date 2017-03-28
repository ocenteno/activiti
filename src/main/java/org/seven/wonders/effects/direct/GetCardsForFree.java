package org.seven.wonders.effects.direct;

import lombok.Data;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.effects.hability.CanDuplicateCard;
import org.seven.wonders.wonders.Wonder;

@Data
public class GetCardsForFree extends ValueEffect {

  private Color color;

  private GetCardsForFree(int value, Color color) {
    super(value);
    this.color = color;
  }

  public static GetCardsForFree instantiate(int value, Color color) {
    return new GetCardsForFree(value, color);
  }

  @Override
  public void apply(Wonder... wonders) {
    for (Wonder wonder : wonders) {
      wonder.enable(CanDuplicateCard.class);
    }
  }

}
