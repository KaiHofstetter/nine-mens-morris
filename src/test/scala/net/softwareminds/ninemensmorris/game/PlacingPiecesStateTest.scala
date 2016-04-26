package net.softwareminds.ninemensmorris.game

import org.scalatest.FlatSpec

class PlacingPiecesStateTest extends FlatSpec {

  "A PlacingPiecesState" should "should return MovingPiecesState if number of set pieces is 9" in {
    val playerState = PlacingPiecesState.piecesSet(9)

    assert(playerState == MovingPiecesState)
  }

  it should "return PlacingPiecesState if number of set pieces is less than 9" in {
    val playerState = PlacingPiecesState.piecesSet(8)

    assert(playerState == PlacingPiecesState)
  }

  it should "return PlacingPiecesState if number of pieces on the board is 2" in {
    val playerState = PlacingPiecesState.piecesOnTheBoard(2)

    assert(playerState == PlacingPiecesState)
  }

  it should "return PlacingPiecesState if number of pieces on the board is 3" in {
    val playerState = PlacingPiecesState.piecesOnTheBoard(3)

    assert(playerState == PlacingPiecesState)
  }
}
