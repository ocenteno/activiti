package org.seven.wonders.effects;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public abstract class ValueEffect extends DirectEffect {

  private final Object value;

}
