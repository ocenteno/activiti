package org.seven.wonders.effects.direct;

import org.seven.wonders.effects.ValueEffect;
import org.seven.wonders.wonders.Wonder;

public class GetShields extends ValueEffect {

  private static final int FACTOR = 10;

  private GetShields(int value) {
    super(value);
  }

  public static GetShields instantiate(int shields, int half) {
    return new GetShields(FACTOR * shields + half);
  }

  public static GetShields instantiate(int shields) {
    return instantiate(shields, 0);
  }

  @Override
  public void apply(Wonder... others) {
    for (Wonder wonder : others) {
      int value = (int)getValue();
      wonder.addShields(value / FACTOR);
      wonder.addHalfShields(value % FACTOR);
    }
  }

}
