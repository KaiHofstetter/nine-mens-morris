package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece.Black
import org.scalatest.FlatSpec

class BoardRuleCheckerTest extends FlatSpec {

  "A BoardRuleChecker" should "throw PointOccupiedException if the position passed to setPiece is already occupied" in {
    val board = new Board().setPiece(2, 2, Black)

    intercept[PointOccupiedException] {
      BoardRuleChecker.checkSetPiece(board, 2, 2, Black)
    }
  }

  it should "throw MaxNumberOfPiecesException if the board already has the max number of pieces of the same " +
    "color" in {
    val board = new Board().setPiece(0, 0, Black)
      .setPiece(0, 3, Black)
      .setPiece(0, 6, Black)
      .setPiece(1, 1, Black)
      .setPiece(1, 3, Black)
      .setPiece(1, 5, Black)
      .setPiece(2, 2, Black)
      .setPiece(2, 3, Black)
      .setPiece(2, 4, Black)

    intercept[MaxNumberOfPiecesException] {
      BoardRuleChecker.checkSetPiece(board, 3, 0, Black)
    }
  }

  it should "throw PointEmptyException if the source position passed to movePiece is empty" in {
    val board = new Board().setPiece(2, 2, Black)

    intercept[PointEmptyException] {
      BoardRuleChecker.checkMovePiece(board, 2, 1, 2, 3)
    }
  }

  it should "throw PointOccupiedException if the target position passed to movePiece is already occupied" in {
    val board = new Board().setPiece(2, 2, Black)
      .setPiece(2, 3, Black)

    intercept[PointOccupiedException] {
      BoardRuleChecker.checkMovePiece(board, 2, 2, 2, 3)
    }
  }

  it should "throw NotAdjacentPositionException if the source position is not an adjacent position of the target " +
    "position" in {
    val board = new Board().setPiece(3, 2, Black)

    intercept[NotAdjacentPositionException] {
      BoardRuleChecker.checkMovePiece(board, 3, 2, 3, 3)
    }
  }


}


