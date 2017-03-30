package org.seven.wonders.wonders;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import lombok.Data;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.seven.wonders.game.Game;

@Data
public final class WondersFactory implements JavaDelegate {

  // Básicos (7)
  private static Wonder ALEXANDRIA = Alexandria.WONDER;

  private static Wonder RHODOS = Rhodos.WONDER;

  private static Wonder HALIKARNASSOS = Halikarnassos.WONDER;

  private static Wonder OLYMPIA = Olympia.WONDER;

  private static Wonder EPHESOS = Ephesos.WONDER;

  private static Wonder BABYLON = Babylon.WONDER;

  private static Wonder GIZAH = Gizah.WONDER;

  // Leaders y goodies (3)
  private static Wonder ROME = Rome.WONDER;

  private static Wonder CATAN = Catan.WONDER;

  private static Wonder BRUSSELS = Brussels.WONDER;

  // Cities (2)
  private static Wonder PETRA = Petra.WONDER;

  private static Wonder AGIA_SOPHIA = AgiaSophia.WONDER;

  // Wonderpack (4)
  private static Wonder ABU_SIMBEL = AbuSimbel.WONDER;

  private static Wonder GREAT_WALL = GreatWall.WONDER;

  private static Wonder STONEHENGE = Stonehenge.WONDER;

  private static Wonder MANNEKEN_PIS = MannnekenPis.WONDER;

  // Thrones (16)
  private static final Wonder THE_WALL = TheWall.WONDER;

  private static final Wonder WINTERFELL = Winterfell.WONDER;

  private static final Wonder PYKE = Pyke.WONDER;

  private static final Wonder THE_TWINS = TheTwins.WONDER;

  private static final Wonder RIVERRUN = Riverrun.WONDER;

  private static final Wonder THE_EYRE = TheEyre.WONDER;

  private static final Wonder HARRENHAL = Harrenhal.WONDER;

  private static final Wonder CASTERLY_ROCK = CasterlyRock.WONDER;

  private static final Wonder KINGS_LANDING = KingsLanding.WONDER;

  private static final Wonder STORMS_END = StormsEnd.WONDER;

  private static final Wonder DRAGON_STONE = Dragonstone.WONDER;

  private static final Wonder HIGHGARDEN = Highgarden.WONDER;

  private static final Wonder SUNSPEAR = Sunspear.WONDER;

  private static final Wonder BRAAVOS = Braavos.WONDER;

  private static final Wonder QARTH = Qarth.WONDER;

  private static final Wonder MEREEN = Mereen.WONDER;

  // Kingdoms (3)
  private static final Wonder WEIRWOOD = Weirwood.WONDER;

  private static final Wonder DREADFORT = Dreadfort.WONDER;

  private static final Wonder FIST_OF_THE_FIRST_MEN = FistOfTheFirstMen.WONDER;

  private static final Wonder[] WONDERS = new Wonder[] { ALEXANDRIA, RHODOS, HALIKARNASSOS, OLYMPIA, EPHESOS, BABYLON,
    GIZAH, ROME, PETRA, AGIA_SOPHIA, ABU_SIMBEL, GREAT_WALL, STONEHENGE, MANNEKEN_PIS, CATAN, BRUSSELS, THE_WALL,
    WINTERFELL, PYKE, THE_TWINS, RIVERRUN, THE_EYRE, HARRENHAL, CASTERLY_ROCK, KINGS_LANDING, STORMS_END,
      DRAGON_STONE, HIGHGARDEN, SUNSPEAR, BRAAVOS, QARTH, MEREEN, WEIRWOOD, FIST_OF_THE_FIRST_MEN, DREADFORT };

  public static List<Wonder> randomBasic(int players) {
    return random(players, 0, 7);
  }

  public static List<Wonder> randomLeaders(int players) {
    return random(players, 0, 10);
  }

  public static List<Wonder> randomCities(int players) {
    return random(players, 0, 12);
  }

  public static List<Wonder> randomWonderPack(int players) {
    return random(players, 0, 16);
  }

  public static List<Wonder> randomThrones(int players) {
    return random(players, 16, 32);
  }

  public static List<Wonder> randomKingdoms(int players) {
    return random(players, 16, 35);
  }

  public static List<Wonder> randomAll(int players) {
    return random(players, 0, 35);
  }

  private static List<Wonder> random(int players, int min, int max) {
    List<Wonder> wonders = new ArrayList<Wonder>(players);
    while (wonders.size() < players) {
      Wonder m = randomizeWonder(min, max);
      if (!wonders.contains(m)) {
        m.setCaraActiva(RANDOM.nextBoolean());
        wonders.add(m);
      }
    }
    return wonders;
  }

  private static final Wonder randomizeWonder(int min, int max) {
    return WONDERS[min + RANDOM.nextInt(max - min)];
  }

  private static Random RANDOM = new Random();

  private Expression parameter;

  @Override
  public void execute(DelegateExecution execution) {
    Game game = (Game)execution.getVariable("game");
    int numJugadores = (int)this.parameter.getValue(execution);
    game.random(numJugadores);
    execution.setVariable("result", game);
    System.out.println(game.getPlayers());
  }

}
