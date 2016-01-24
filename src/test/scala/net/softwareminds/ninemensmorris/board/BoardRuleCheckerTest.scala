package net.softwareminds.ninemensmorris.board

import org.scalatest.FlatSpec

class BoardRuleCheckerTest extends FlatSpec {

  "A BoardRuleChecker" should "throw PointOccupiedException if the position passed to setPiece is already occupied" in {
    val board = new Board().setPiece(2, 1, Piece.Black)

    intercept[PointOccupiedException] {
      BoardRuleChecker.checkSetPiece(board, 2, 1, Piece.Black)
    }
  }

}
