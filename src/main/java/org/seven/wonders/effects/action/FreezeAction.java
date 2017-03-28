package org.seven.wonders.effects.action;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.seven.wonders.effects.ActionEffect;
import org.seven.wonders.wonders.Wonder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreezeAction extends ActionEffect {

  private int times;

  public static FreezeAction instantiate(int times) {
    return new FreezeAction(times);
  }

  @Override
  public void apply(Wonder... wonder) {
  }

}
