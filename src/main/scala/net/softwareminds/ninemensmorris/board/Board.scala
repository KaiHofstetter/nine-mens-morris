package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece.Piece

/*
  Board layout/coordinates

      0 1 2 3 4 5 6
      | | | | | | |
  0 - *-----*-----*
      |     |     |
  1 - | *---*---* |
      | |   |   | |
  2 - | | *-*-* | |
      | | |   | | |
  3 - *-*-*   *-*-*
      | | |   | | |
  4 - | | *-*-* | |
      | |   |   | |
  5 - | *---*---* |
      |     |     |
  6 - *-----*-----*

 */

case class Coordinate(xPos: Int, yPos: Int)

class Board(val points: Map[Coordinate, Piece] = Map()) {

  def setPiece(xPos: Int, yPos: Int, piece: Piece): Board = {
    val updatedPoints = points + (Coordinate(xPos, yPos) -> piece)

    new Board(updatedPoints)
  }

  def getPiece(xPos: Int, yPos: Int): Option[Piece] = {
    points.get(Coordinate(xPos, yPos))
  }

  def movePiece(startXPos: Int, startYPos: Int, targetXPos: Int, targetYPos: Int): Board = {
    val pieceAtStartPos = getPiece(startXPos, startYPos)
    val updateBoard = new Board(points - Coordinate(startXPos, startYPos))

    updateBoard.setPiece(targetXPos, targetYPos, pieceAtStartPos.get)
  }

  def iterator: Iterator[Piece] = {
    points.values.iterator
  }
}
