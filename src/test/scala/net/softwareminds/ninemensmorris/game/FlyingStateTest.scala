package net.softwareminds.ninemensmorris.game

import org.scalatest.FlatSpec

class FlyingStateTest extends FlatSpec {

  "A FlyingState" should "return LostState if number of pieces on the board is 2" in {
    val playerState = FlyingState.piecesOnTheBoard(2)

    assert(playerState == LostState)
  }

  it should "return FlyingState if number of pieces on the board is 3" in {
    val playerState = FlyingState.piecesOnTheBoard(3)

    assert(playerState == FlyingState)
  }

  it should "return FlyingState if number of pieces on the board is greater than 3" in {
    val playerState = FlyingState.piecesOnTheBoard(4)

    assert(playerState == FlyingState)
  }

  it should "return FlyingState if number of set pieces is 9" in {
    val playerState = FlyingState.piecesSet(9)

    assert(playerState == FlyingState)
  }
}
