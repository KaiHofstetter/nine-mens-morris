package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Board.emptyBoard
import net.softwareminds.ninemensmorris.board.Piece.Piece

/*
  Board layout/coordinates

     1     2     3
  1 *-----*-----*
    |  1  |2   3|
  2 | *---*---* |
    | |  1|2 3| |
  3 | | *-*-* | |
    |1|2|3  |1|2|3
  4 *-*-*   *-*-*
    | | |1 2|3| |
  5 | | *-*-* | |
    | |1  |2  |3|
  6 | *---*---* |
    |1    |2    |3
  7 *-----*-----*

 */

object Board {
  val emptyBoard = Vector(Vector(null, null, null),
                          Vector(null, null, null),
                          Vector(null, null, null),
                          Vector(null, null, null, null, null, null),
                          Vector(null, null, null),
                          Vector(null, null, null),
                          Vector(null, null, null))
}

class Board(val points: Vector[Vector[Piece]] = emptyBoard) {

  def setPiece(xPos: Int, yPos: Int, piece: Piece): Board = {
    val updatedPoints: Vector[Vector[Piece]] = points.updated(xPos, points.apply(xPos).updated(yPos, piece))

    new Board(updatedPoints)
  }

  def getPiece(xPos: Int, yPos: Int): Piece = {
    points.apply(xPos).apply(yPos)
  }

}
