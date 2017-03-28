package org.seven.wonders.effects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class ActionEffect implements Effect {

  private final Type type = Type.ACTION;

  private int times;

  @Override
  public Object getValue() {
    return null;
  }

}
