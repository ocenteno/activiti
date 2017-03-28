package org.seven.wonders.effects.action;

import lombok.Data;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.ActionEffect;
import org.seven.wonders.wonders.Wonder;

@Data
public class DuplicateCard extends ActionEffect {

  public static final DuplicateCard YELLOW = new DuplicateCard(1, Color.YELLOW);

  public static final DuplicateCard ANY = new DuplicateCard(1, Color.ANY);

  private Color color;

  public DuplicateCard(int times, Color color) {
    super(times);
    this.color = color;
  }

  public static DuplicateCard instantiate(int times, Color color) {
    return new DuplicateCard(times, color);
  }

  @Override
  public void apply(Wonder... wonder) {
  }

}
