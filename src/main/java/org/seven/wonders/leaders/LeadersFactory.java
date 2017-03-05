package org.seven.wonders.leaders;

import static org.seven.wonders.leaders.ThronesLeader.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import lombok.Data;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.cards.Card;
import org.seven.wonders.game.Game;

@Data
public final class LeadersFactory implements JavaDelegate {

  private static final List<Leader> LEADERS = Arrays.asList(); // 7

  private static final List<Leader> THRONES = Arrays.asList(GILLY, CRASTER, HODOR, BRANDON_STARK, MEERA_REED,
      JOJEN_REED, BENJEN_STARK, MAG_THE_MIGHTY, RATTLESHIRT, XARO_XHOAN_DAXOS, KRAZNYS_MO_NAKLOZ, MISSANDEI,
      TYENE_SAND, NYMERIA_SAND, OBARA_SAND, QYBURN, SAMWELL_TARLEY, MAESTER_LUWIN, JANOS_SLYNT, TORMUND_GIANTSBANE,
      DAVOS_SEAWORTH, SALLADHOR_SAAN, LITTLEFINGER, ROBB_STARK, JAIME_LANNISTER, THE_MOUNTAIN, LORAS_TYREL,
      TRYSTANE_MARTELL, ARYA_STARK, PYAT_PREE, AERON_GREYJOY, EURON_GERYJOY);

  public static List<Card> getLeaders(int jugadores, boolean thrones) {
    List<Card> mazo = new ArrayList<>(jugadores);
    if (thrones) {
      Collections.shuffle(THRONES);
      mazo.addAll(THRONES.subList(0, jugadores * 4));
    } else {
      Collections.shuffle(LEADERS);
      mazo.addAll(LEADERS.subList(0, jugadores * 4));
    }
    return mazo;
  }

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Game game = (Game)execution.getVariable("game");
    execution.setVariable("cards", getLeaders(game.totalPlayers(), game.isThrones()));
  }

}
