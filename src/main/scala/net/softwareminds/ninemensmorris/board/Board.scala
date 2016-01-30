package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Board.EmptyBoard
import net.softwareminds.ninemensmorris.board.Piece.Piece

import scala.collection.immutable.VectorIterator

/*
  Board layout/coordinates

     0     1     2
  0 *-----*-----*
    |  0  |1   2|
  1 | *---*---* |
    | |  0|1 2| |
  2 | | *-*-* | |
    |0|1|2  |0|1|2
  3 *-*-*   *-*-*
    | | |0 1|2| |
  4 | | *-*-* | |
    | |0  |1  |2|
  5 | *---*---* |
    |0    |1    |2
  6 *-----*-----*

 */

object Board {
  val EmptyBoard = Vector(Vector(null, null, null),
    Vector(null, null, null),
    Vector(null, null, null),
    Vector(null, null, null, null, null, null),
    Vector(null, null, null),
    Vector(null, null, null),
    Vector(null, null, null))
}

class Board(val points: Vector[Vector[Piece]] = EmptyBoard) {

  def setPiece(xPos: Int, yPos: Int, piece: Piece): Board = {
    val updatedPoints = points.updated(xPos, points.apply(xPos).updated(yPos, piece))

    new Board(updatedPoints)
  }

  def getPiece(xPos: Int, yPos: Int): Piece = {
    points.apply(xPos).apply(yPos)
  }

  def movePiece(startXPos: Int, startYPos: Int, targetXPos: Int, targetYPos: Int): Board = {
    val pieceAtStartPos = points.apply(startXPos).apply(startYPos)
    val updateBoard = setPiece(startXPos, startYPos, null)

    updateBoard.setPiece(targetXPos, targetYPos, pieceAtStartPos)
  }

  def iterator: Iterator[Piece] = {
    points.flatten.iterator
  }
}
