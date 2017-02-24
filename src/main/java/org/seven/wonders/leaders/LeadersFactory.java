package org.seven.wonders.leaders;

import static org.seven.wonders.cards.Blue.*;
import static org.seven.wonders.cards.Brown.*;
import static org.seven.wonders.cards.Green.*;
import static org.seven.wonders.cards.Grey.*;
import static org.seven.wonders.cards.Red.*;
import static org.seven.wonders.cards.Yellow.*;

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

  private static final List<Card> LEADERS = Arrays.asList(GLASSWORKS, LOOM, PRESS, LUMBER_YARD, CLAY_POOL, ORE_VEIN,
      STONE_PIT, CLAY_PIT, TIMBER_YARD, EAST_TRADING_POST, WEST_TRADING_POST, MARKETPLACE, ALTAR, THEATRE, BATHS,
      STOCKADE, BARRACKS, GUARD_TOWER, APOTHECARY, WORKSHOP, SCRIPTORIUM, // 3
      LUMBER_YARD, ORE_VEIN, EXCAVATION, TAVERN, PAWNSHOP, GUARD_TOWER, SCRIPTORIUM, // 4
      CLAY_POOL, STONE_PIT, FOREST_CAVE, TAVERN, ALTAR, BARRACKS, APOTHECARY, // 5
      GLASSWORKS, LOOM, PRESS, TREE_FARM, MINE, MARKETPLACE, THEATRE, // 6
      EAST_TRADING_POST, WEST_TRADING_POST, TAVERN, BATHS, PAWNSHOP, STOCKADE, WORKSHOP); // 7

  private static final List<Card> THRONES = Arrays.asList(GLASSWORKS, LOOM, PRESS, BRICKYARD, FOUNDRY, QUARRY, SAWMILL,
      FORUM, CARAVANSERY, VINEYARD, STATUE, AQUEDUCT, COURTHOUSE, TEMPLE, STABLES, WALLS, ARCHERY_RANGE, LABORATORY,
      DISPENSARY, LIBRARY, SCHOOL, // 3
      BRICKYARD, FOUNDRY, QUARRY, SAWMILL, BAZAR, TRAINING_GROUND, DISPENSARY, // 4
      GLASSWORKS, LOOM, PRESS, CARAVANSERY, COURTHOUSE, STABLES, LABORATORY, // 5
      FORUM, CARAVANSERY, VINEYARD, TEMPLE, TRAINING_GROUND, ARCHERY_RANGE, LIBRARY, // 6
      FORUM, BAZAR, STATUE, AQUEDUCT, TRAINING_GROUND, WALLS, SCHOOL); // 7

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
