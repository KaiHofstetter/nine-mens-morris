package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece._

class BoardRuleException(message: String = null) extends IllegalArgumentException(message)

class PointOccupiedException(message: String = null) extends BoardRuleException(message)

class MaxNumberOfPiecesException(message: String = null) extends IllegalArgumentException(message)

object BoardRuleChecker {

  val MaxNumOfPieces = 9

  def checkSetPiece(board: Board, xPos: Int, yPos: Int, piece: Piece): Unit = {
    assertPointIsNotOccupied(board, xPos, yPos)
    assertMaxNumberOfPiece(board, piece)
  }

  private def assertPointIsNotOccupied(board: Board, xPos: Int, yPos: Int): Unit = {
    if (board.getPiece(xPos, yPos) != null) {
      throw new PointOccupiedException("Point at x position " + xPos + " and y position " + yPos + " is " +
        "already occupied!")
    }
  }

  private def assertMaxNumberOfPiece(board: Board, piece: Piece): Unit = {
    val numOfPieces = board.iterator.count(p => p == piece)

    if (numOfPieces == MaxNumOfPieces) {
      throw new MaxNumberOfPiecesException("Board already has the maximum number of " + piece + " pieces")
    }
  }
}
