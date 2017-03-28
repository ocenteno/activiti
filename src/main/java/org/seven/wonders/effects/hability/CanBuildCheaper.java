package org.seven.wonders.effects.hability;

import lombok.Data;

import org.seven.wonders.cards.Card.Color;
import org.seven.wonders.effects.Condition;
import org.seven.wonders.effects.ConditionedEffect;
import org.seven.wonders.wonders.Wonder;

@Data
public class CanBuildCheaper extends ConditionedEffect {

  private Color color;

  private CanBuildCheaper(int value, Condition condition, Color color) {
    super(value, condition);
    this.color = color;
  }

  public static CanBuildCheaper instantiate(int value, Condition condition, Color color) {
    return new CanBuildCheaper(value, condition, color);
  }

  @Override
  public void apply(Wonder... wonders) {
    for (Wonder wonder : wonders) {
      wonder.enable(CanDuplicateCard.class);
    }
  }

}
