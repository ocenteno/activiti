package org.seven.wonders.cards;

import static org.seven.wonders.tokens.Resource.*;

import org.seven.wonders.effects.Effect;
import org.seven.wonders.tokens.Cost;
import org.seven.wonders.tokens.Resource;

public class Brown extends Card {

  public static final Brown LUMBER_YARD = new Brown(WOOD);

  public static final Brown STONE_PIT = new Brown(STONE);

  public static final Brown CLAY_POOL = new Brown(CLAY);

  public static final Brown ORE_VEIN = new Brown(ORE);

  public static final Brown SAWMILL = new Brown(Cost.COIN, WOOD, WOOD);

  public static final Brown QUARRY = new Brown(Cost.COIN, STONE, STONE);

  public static final Brown BRICKYARD = new Brown(Cost.COIN, CLAY, CLAY);

  public static final Brown FOUNDRY = new Brown(Cost.COIN, ORE, ORE);

  public static final Brown TREE_FARM = new Brown(Cost.COIN, WOOD, CLAY);

  public static final Brown EXCAVATION = new Brown(Cost.COIN, STONE, CLAY);

  public static final Brown CLAY_PIT = new Brown(Cost.COIN, CLAY, ORE);

  public static final Brown TIMBER_YARD = new Brown(Cost.COIN, STONE, WOOD);

  public static final Brown FOREST_CAVE = new Brown(Cost.COIN, WOOD, ORE);

  public static final Brown MINE = new Brown(Cost.COIN, ORE, STONE);

  static {
    setNames(Brown.class.getDeclaredFields());
  }

  public Brown(Resource recurso) {
    this(Cost.FREE, recurso);
  }

  public Brown(Cost coste, Resource recurso) {
    super(Color.BROWN, Effect.resources(recurso), coste);
  }

  private Brown(Cost coste, Resource... recursos) {
    super(Color.BROWN, Effect.equalOrDifferentResources(recursos), coste);
  }

}
