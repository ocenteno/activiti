package org.seven.wonders.test

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.seven.wonders.leaders.Leader
import org.seven.wonders.leaders.LeadersFactory
import org.seven.wonders.services.PlayLeader

public class TestPlayLeader extends TestChooseCard {

  @InjectMocks
  private PlayLeader playLeader = new PlayLeader()

  @Before
  @Override
  public void startProcess() {
    super.startProcess()
    List<Leader> leaders = LeadersFactory.getLeaders(3, true)
    for (Leader leader : leaders) {
      this.currentGame.nextPlayer().getLeaders().add(leader)
    }
  }

  @Test
  public void testPlayAnyLeader() {
    this.currentPlayer.giveCoins(6)
    this.playLeader.execute(this.execution)

    // Leaders chosen
    assertNotNull(this.currentPlayer.getLeaders())
    assertEquals(3, this.currentPlayer.getLeaders().size())
    assertEquals(0, this.currentPlayer.getHand().size())
  }
}
