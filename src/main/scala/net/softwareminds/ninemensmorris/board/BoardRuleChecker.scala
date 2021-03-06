package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece._

import scala.math.abs

class BoardRuleException(message: String = null) extends IllegalArgumentException(message)

class PointOccupiedException(message: String = null) extends BoardRuleException(message)

class PointEmptyException(message: String = null) extends BoardRuleException(message)

class MaxNumberOfPiecesException(message: String = null) extends BoardRuleException(message)

class NotAdjacentPositionException(message: String = null) extends BoardRuleException(message)

object BoardRuleChecker {

  val MaxNumOfPieces = 9

  def checkSetPiece(board: Board, xPos: Int, yPos: Int, piece: Piece): Unit = {
    assertPointIsNotOccupied(board, xPos, yPos)
    assertMaxNumberOfPiece(board, piece)
  }

  def checkMovePiece(board: Board, startXPos: Int, startYPos: Int, targetXPos: Int, targetYPos: Int): Unit = {
    assertPointIsNotEmpty(board, startXPos, startYPos)
    assertPointIsNotOccupied(board, targetXPos, targetYPos)
    assertMovingToAdjacentPosition(startXPos, startYPos, targetXPos, targetYPos)
  }

  private def assertPointIsNotEmpty(board: Board, xPos: Int, yPos: Int): Unit = {
    if (board.getPiece(xPos, yPos).isEmpty) {
      throw new PointEmptyException("Point at x position " + xPos + " and y position " + yPos + " is " +
        "empty!")
    }
  }

  private def assertPointIsNotOccupied(board: Board, xPos: Int, yPos: Int): Unit = {
    if (board.getPiece(xPos, yPos).isDefined) {
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

  private def assertMovingToAdjacentPosition(startXPos: Int, startYPos: Int, targetXPos: Int,
                                             targetYPos: Int): Unit = {
    val neighbors = Board.getNeighbors(startXPos, startYPos)

    if (!neighbors.contains(Coordinate(targetXPos, targetYPos))) {
      throw new NotAdjacentPositionException("Point at x position " + startXPos + " and y position " + startYPos +
      " is not an adjacent position of x position " + targetXPos + " and y position " + targetYPos )
    }
  }
}
