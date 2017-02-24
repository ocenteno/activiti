package org.seven.wonders.leaders;

import lombok.Data;

import org.seven.wonders.effects.Effect;

@Data
public class ThronesLeader extends Leader {

  public ThronesLeader(Effect efecto, int monedas) {
    super(efecto, monedas);
  }

}
