package org.seven.wonders.cards;

import static org.seven.wonders.cards.Black.*;
import static org.seven.wonders.cards.Blue.*;
import static org.seven.wonders.cards.Brown.*;
import static org.seven.wonders.cards.Green.*;
import static org.seven.wonders.cards.Grey.*;
import static org.seven.wonders.cards.Guild.*;
import static org.seven.wonders.cards.Red.*;
import static org.seven.wonders.cards.Yellow.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class CardsFactory {

  private static final List<Card> ERA_I = Arrays.asList(GLASSWORKS, LOOM, PRESS, LUMBER_YARD, CLAY_POOL, ORE_VEIN,
      STONE_PIT, CLAY_PIT, TIMBER_YARD, EAST_TRADING_POST, WEST_TRADING_POST, MARKETPLACE, ALTAR, THEATRE, BATHS,
      STOCKADE, BARRACKS, GUARD_TOWER, APOTHECARY, WORKSHOP, SCRIPTORIUM, // 3
      LUMBER_YARD, ORE_VEIN, EXCAVATION, TAVERN, PAWNSHOP, GUARD_TOWER, SCRIPTORIUM, // 4
      CLAY_POOL, STONE_PIT, FOREST_CAVE, TAVERN, ALTAR, BARRACKS, APOTHECARY, // 5
      GLASSWORKS, LOOM, PRESS, TREE_FARM, MINE, MARKETPLACE, THEATRE, // 6
      EAST_TRADING_POST, WEST_TRADING_POST, TAVERN, BATHS, PAWNSHOP, STOCKADE, WORKSHOP); // 7

  private static final List<Card> ERA_II = Arrays.asList(GLASSWORKS, LOOM, PRESS, BRICKYARD, FOUNDRY, QUARRY, SAWMILL,
      FORUM, CARAVANSERY, VINEYARD, STATUE, AQUEDUCT, COURTHOUSE, TEMPLE, STABLES, WALLS, ARCHERY_RANGE, LABORATORY,
      DISPENSARY, LIBRARY, SCHOOL, // 3
      BRICKYARD, FOUNDRY, QUARRY, SAWMILL, BAZAR, TRAINING_GROUND, DISPENSARY, // 4
      GLASSWORKS, LOOM, PRESS, CARAVANSERY, COURTHOUSE, STABLES, LABORATORY, // 5
      FORUM, CARAVANSERY, VINEYARD, TEMPLE, TRAINING_GROUND, ARCHERY_RANGE, LIBRARY, // 6
      FORUM, BAZAR, STATUE, AQUEDUCT, TRAINING_GROUND, WALLS, SCHOOL); // 7

  private static final List<Card> ERA_III = Arrays.asList(LIGHTHOUSE, HAVEN, ARENA, PALACE, TEMPLE, SENATE, TOWN_HALL,
      GARDENS, ARSENAL, FORTIFICATIONS, SIEGE_WORKSHOP, OBSERVATORY, LODGE, ACADEMY, UNIVERSITY, STUDY, // 3
      HAVEN, CHAMBER_OF_COMMERCE, GARDENS, ARSENAL, CIRCUS, UNIVERSITY, // 4
      ARENA, SENATE, TOWN_HALL, CIRCUS, SIEGE_WORKSHOP, STUDY, // 5
      LIGHTHOUSE, CHAMBER_OF_COMMERCE, TEMPLE, TOWN_HALL, CIRCUS, LODGE, // 6
      ARENA, PALACE, ARSENAL, FORTIFICATIONS, OBSERVATORY, ACADEMY); // 7

  private static final List<Card> CITIES_ERA_I = Arrays.asList((Card)HIDEOUT, GAMBLING_DEN, RESIDENCE,
      CLANDESTINE_DOCK_EAST, CLANDESTINE_DOCK_WEST, GATES_OF_THE_CITY, PIGEON_LOFT, MILITIA, SECRET_WAREHOUSE);

  private static final List<Card> CITIES_ERA_II = Arrays.asList((Card)MERCENARIES, BLACK_MARKET, SPY_RING, TABULARIUM,
      CONSULATE, GAMBLING_HOUSE, LAIR, ARCHITECT_CABINET, SEPULCHER);

  private static final List<Card> CITIES_ERA_III = Arrays.asList((Card)BUILDERS_UNION, CENOTAPH, SECRET_SOCIETY,
      SLAVE_MARKET, BROTHERHOOD, EMBASSY, CAPITOL, TORTURE_CHAMBER, CONTINGENT);

  private static final List<Card> GREMIOS = Arrays.asList(
      (Card)GUILD_OF_SHADOWS, // cities
      COURTESANS_GUILD, COUNTERFEITERS_GUILD, SCIENTISTS_GUILD, MARAUDERS_GUILD, GAMERS_GUILD, EMPERORS_GUILD,
      MOURNERS_GUILD, STRATEGISTS_GUILD, SPIES_GUILD, TRADERS_GUILD, MAGISTRATES_GUILD, ARCHITECTS_GUILD,
      WORKERS_GUILD, CRAFTSMEN_GUILD, PHILOSOPHERS_GUILD, DIPLOMATS_GUILD, SHIPOWNERS_GUILD, BUILDERS_GUILD);// normal

  private CardsFactory() {
  }

  public static List<Card> getCards(int age, int jugadores, boolean cities) {
    if (age == 1) {
      return getCardsAgeI(jugadores, cities);
    }
    if (age == 2) {
      return getCardsAgeIII(jugadores, cities);
    }
    if (age == 3) {
      return getCardsAgeIII(jugadores, cities);
    }
    return null;
  }

  public static List<Card> getCardsAgeI(int jugadores, boolean cities) {
    return mazo(jugadores, cities, ERA_I, CITIES_ERA_I);
  }

  public static List<Card> getCardsAgeII(int jugadores, boolean cities) {
    return mazo(jugadores, cities, ERA_II, CITIES_ERA_II);
  }

  public static List<Card> getCardsAgeIII(int jugadores, boolean cities) {
    List<Card> mazo = mazo(jugadores, cities, ERA_III, CITIES_ERA_III);
    if (!cities) {
      GREMIOS.remove(0);
    }
    Collections.shuffle(GREMIOS);
    int n = jugadores < 8 ? jugadores + 2 : jugadores + 1;
    mazo.addAll(GREMIOS.subList(0, n));
    return mazo;
  }

  private static List<Card> mazo(int jugadores, boolean cities, final List<Card> cartasEra,
      final List<Card> cartasCities) {
    if (jugadores == 8) {
      jugadores = 7;
      cities = true;
    }
    List<Card> mazo = new ArrayList<>(jugadores * (cities ? 8 : 7));
    mazo.addAll(cartasEra.subList(0, jugadores * 7));
    if (cities) {
      Collections.shuffle(cartasCities);
      mazo.addAll(cartasCities.subList(0, jugadores));
    }
    return mazo;
  }

}
