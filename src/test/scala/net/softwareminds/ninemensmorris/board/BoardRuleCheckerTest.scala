package net.softwareminds.ninemensmorris.board

import org.scalatest.FlatSpec

class BoardRuleCheckerTest extends FlatSpec {

  "A BoardRuleChecker" should "throw PointOccupiedException if the position passed to setPiece is already occupied" in {
    val board = new Board().setPiece(2, 1, Piece.Black)

    intercept[PointOccupiedException] {
      BoardRuleChecker.checkSetPiece(board, 2, 1, Piece.Black)
    }
  }

  it should "throw MaxNumberOfPiecesException if the board already has the max number of pieces of the same " +
    "color" in {
    val board = new Board().setPiece(0, 0, Piece.Black)
      .setPiece(0, 1, Piece.Black)
      .setPiece(0, 2, Piece.Black)
      .setPiece(1, 0, Piece.Black)
      .setPiece(1, 1, Piece.Black)
      .setPiece(1, 2, Piece.Black)
      .setPiece(2, 0, Piece.Black)
      .setPiece(2, 1, Piece.Black)
      .setPiece(2, 2, Piece.Black)

    intercept[MaxNumberOfPiecesException] {
      BoardRuleChecker.checkSetPiece(board, 3, 0, Piece.Black)
    }
  }

  it should "throw PointEmptyException if the source position passed to movePiece is empty" in {
    val board = new Board().setPiece(2, 2, Piece.Black)

    intercept[PointEmptyException] {
      BoardRuleChecker.checkMovePiece(board, 2, 1, 2, 2)
    }
  }

  it should "throw PointOccupiedException if the target position passed to movePiece is already occupied" in {
    val board = new Board().setPiece(2, 1, Piece.Black)
      .setPiece(2, 2, Piece.Black)

    intercept[PointOccupiedException] {
      BoardRuleChecker.checkMovePiece(board, 2, 1, 2, 2)
    }
  }

}


