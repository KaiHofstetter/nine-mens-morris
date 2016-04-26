package net.softwareminds.ninemensmorris.game

import org.scalatest.{FlatSpec, FunSuite}

class LostStateTest extends FlatSpec {

  "A LostState" should "return LostState if number of pieces on the board is 2" in {
    val playerState = LostState.piecesOnTheBoard(2)

    assert(playerState == LostState)
  }

  it should "return LostState if number of set pieces is 9" in {
    val playerState = LostState.piecesSet(9)

    assert(playerState == LostState)
  }
}
