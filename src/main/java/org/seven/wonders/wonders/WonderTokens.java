package org.seven.wonders.wonders;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Science;
import org.seven.wonders.tokens.Token;

@Data
public class WonderTokens implements Serializable {

  public int directVPs;

  public int shields;

  public int halfShields;

  public final List<Science> science = new ArrayList<>();

  public final List<Science[]> orScience = new ArrayList<>();

  public final List<Effect> actions = new ArrayList<>();

  public final List<Effect> when = new ArrayList<>();

  public final List<Effect> vps = new ArrayList<>();

  public final List<Token> tokens = new ArrayList<>();

}
