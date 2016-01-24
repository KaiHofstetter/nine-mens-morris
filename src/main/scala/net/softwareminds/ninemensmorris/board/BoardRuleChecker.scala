package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece._

class BoardRuleException(message: String = null) extends IllegalArgumentException(message)

class PointOccupiedException(message: String = null) extends BoardRuleException(message)

object BoardRuleChecker {
  def checkSetPiece(board: Board, xPos: Int, yPos: Int, piece: Piece): Unit = {
    assertPointIsEmpty(board, xPos, yPos)
  }

  private def assertPointIsEmpty(board: Board, xPos: Int, yPos: Int): Unit = {
    if (board.getPiece(xPos, yPos) != null) {
      throw new PointOccupiedException("Point at x position " + xPos + " and y position " + yPos + " is " +
        "already occupied!")
    }
  }
}
