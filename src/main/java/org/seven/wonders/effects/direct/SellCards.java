package org.seven.wonders.effects.direct;

import lombok.Data;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.wonders.Wonder;

@Data
public class SellCards extends ValueEffect {

  public static final SellCards BLACK_6 = new SellCards(Color.BLACK, 6);

  public static final SellCards GREY_6 = new SellCards(Color.GREY, 6);

  public static final SellCards BROWN_6 = new SellCards(Color.BROWN, 6);

  public static final SellCards GREEN_6 = new SellCards(Color.GREEN, 6);

  public static final SellCards YELLOW_6 = new SellCards(Color.YELLOW, 6);

  public static final SellCards BLUE_6 = new SellCards(Color.BLUE, 6);

  private Color color;

  private SellCards(Color color, int value) {
    super(value);
    this.color = color;
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
    }
  }

}
