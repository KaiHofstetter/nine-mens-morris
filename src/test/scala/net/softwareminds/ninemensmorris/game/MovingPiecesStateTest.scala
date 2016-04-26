package net.softwareminds.ninemensmorris.game

import org.scalatest.FlatSpec

class MovingPiecesStateTest extends FlatSpec {

  "A MovingPiecesState" should "return LostState if number of pieces on the board is 2" in {
    val playerState = MovingPiecesState.piecesOnTheBoard(2)

    assert(playerState == LostState)
  }

  it should "return FlyingState if number of pieces on the board is 3" in {
    val playerState = MovingPiecesState.piecesOnTheBoard(3)

    assert(playerState == FlyingState)
  }

  it should "return MovingPiecesState if number of pieces on the board is 4" in {
    val playerState = MovingPiecesState.piecesOnTheBoard(4)

    assert(playerState == MovingPiecesState)
  }

  it should "return MovingPiecesState if number of set pieces is 9" in {
    val playerState = MovingPiecesState.piecesSet(9)

    assert(playerState == MovingPiecesState)
  }
}
