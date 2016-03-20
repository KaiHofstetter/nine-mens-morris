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
      | | | | | | |
      0 1 2 3 4 5 6
 */

case class Coordinate(xPos: Int, yPos: Int)

object Board {
  private val neighbors = Map(
    Coordinate(0, 0) -> Set(Coordinate(3, 0), Coordinate(0, 3)),
    Coordinate(3, 0) -> Set(Coordinate(0, 0), Coordinate(3, 1), Coordinate(6, 0)),
    Coordinate(6, 0) -> Set(Coordinate(3, 0), Coordinate(6, 3)),

    Coordinate(1, 1) -> Set(Coordinate(3, 1), Coordinate(1, 3)),
    Coordinate(3, 1) -> Set(Coordinate(1, 1), Coordinate(3, 0), Coordinate(3, 2), Coordinate(5, 1)),
    Coordinate(5, 1) -> Set(Coordinate(3, 1), Coordinate(5, 3)),

    Coordinate(2, 2) -> Set(Coordinate(2, 3), Coordinate(3, 2)),
    Coordinate(3, 2) -> Set(Coordinate(2, 2), Coordinate(3, 1), Coordinate(4, 2)),
    Coordinate(4, 2) -> Set(Coordinate(3, 2), Coordinate(4, 3)),

    Coordinate(0, 3) -> Set(Coordinate(0, 0), Coordinate(0, 6), Coordinate(1, 3)),
    Coordinate(1, 3) -> Set(Coordinate(0, 3), Coordinate(1, 1), Coordinate(1, 5), Coordinate(2, 3)),
    Coordinate(2, 3) -> Set(Coordinate(1, 3), Coordinate(2, 2), Coordinate(2, 4)),

    Coordinate(4, 3) -> Set(Coordinate(4, 2), Coordinate(4, 4), Coordinate(5, 3)),
    Coordinate(5, 3) -> Set(Coordinate(4, 3), Coordinate(5, 1), Coordinate(5, 5), Coordinate(6, 3)),
    Coordinate(6, 3) -> Set(Coordinate(5, 3), Coordinate(6, 0), Coordinate(6, 6)),

    Coordinate(2, 4) -> Set(Coordinate(2, 3), Coordinate(3, 4)),
    Coordinate(3, 4) -> Set(Coordinate(2, 4), Coordinate(3, 5), Coordinate(4, 4)),
    Coordinate(4, 4) -> Set(Coordinate(3, 4), Coordinate(4, 3)),

    Coordinate(1, 5) -> Set(Coordinate(1, 3), Coordinate(3, 5)),
    Coordinate(3, 5) -> Set(Coordinate(1, 5), Coordinate(3, 4), Coordinate(3, 6), Coordinate(5, 5)),
    Coordinate(5, 5) -> Set(Coordinate(3, 5), Coordinate(5, 3)),

    Coordinate(0, 6) -> Set(Coordinate(0, 3), Coordinate(3, 6)),
    Coordinate(3, 6) -> Set(Coordinate(0, 6), Coordinate(3, 5), Coordinate(6, 6)),
    Coordinate(6, 6) -> Set(Coordinate(3, 6), Coordinate(6, 3))
  )

  def getNeighbors(xPos: Int, yPos: Int): Set[Coordinate] = {
    neighbors(Coordinate(xPos, yPos))
  }
}

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
