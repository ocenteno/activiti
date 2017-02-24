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
  private static Wonder ALEXANDRIA;

  private static Wonder RHODOS;

  private static Wonder HALIKARNASSOS;

  private static Wonder OLYMPIA;

  private static Wonder EPHESOS;

  private static Wonder BABYLON;

  private static Wonder GIZAH;

  // Leaders y goodies (3)
  private static Wonder ROME;

  private static Wonder CATAN;

  private static Wonder BRUSSELS;

  // Cities (2)
  private static Wonder PETRA;

  private static Wonder AGIA_SOPHIA;

  // Wonderpack (4)
  private static Wonder ABU_SIMBEL;

  private static Wonder GREAT_WALL;

  private static Wonder STONEHENGE;

  private static Wonder MANNEKEN_PIS;

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

  public static List<Wonder> randomBasic(int jugadores) {
    return random(jugadores, 0, 7);
  }

  public static List<Wonder> randomLeaders(int jugadores) {
    return random(jugadores, 0, 10);
  }

  public static List<Wonder> randomCities(int jugadores) {
    return random(jugadores, 0, 12);
  }

  public static List<Wonder> randomWonderPack(int jugadores) {
    return random(jugadores, 0, 16);
  }

  public static List<Wonder> randomThrones(int jugadores) {
    return random(jugadores, 16, 32);
  }

  public static List<Wonder> randomKingdoms(int jugadores) {
    return random(jugadores, 16, 35);
  }

  public static List<Wonder> randomAll(int jugadores) {
    return random(jugadores, 0, 35);
  }

  private static List<Wonder> random(int jugadores, int min, int max) {
    List<Wonder> wonders = new ArrayList<Wonder>(jugadores);
    while (wonders.size() < jugadores) {
      Wonder m = generarMaravilla(min, max);
      if (!wonders.contains(m)) {
        m.setCaraActiva(RANDOM.nextBoolean());
        wonders.add(m);
      }
    }
    return wonders;
  }

  private static final Wonder generarMaravilla(int min, int max) {
    return WONDERS[min + RANDOM.nextInt(max - min)];
  }

  private static Random RANDOM = new Random();

  private Expression parameter;

  @Override
  public void execute(DelegateExecution execution) throws Exception {
    Game game = (Game)execution.getVariable("game");
    int numJugadores = (int)this.parameter.getValue(execution);
    game.random(numJugadores);
    execution.setVariable("result", game);
    System.out.println(game.getPlayers());
  }

}
