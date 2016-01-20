package net.softwareminds.ninemensmorris.board

import org.scalatest.FlatSpec

class BoardTest extends FlatSpec {

  "A new Board" should "only have empty points" in {
    val board = new Board();

    assert(board.getPiece(0,0) == null)
    assert(board.getPiece(0,1) == null)
    assert(board.getPiece(0,2) == null)

    assert(board.getPiece(1,0) == null)
    assert(board.getPiece(1,1) == null)
    assert(board.getPiece(1,2) == null)

    assert(board.getPiece(2,0) == null)
    assert(board.getPiece(2,1) == null)
    assert(board.getPiece(2,2) == null)

    assert(board.getPiece(3,0) == null)
    assert(board.getPiece(3,1) == null)
    assert(board.getPiece(3,2) == null)
    assert(board.getPiece(3,3) == null)
    assert(board.getPiece(3,4) == null)
    assert(board.getPiece(3,5) == null)

    assert(board.getPiece(4,0) == null)
    assert(board.getPiece(4,1) == null)
    assert(board.getPiece(4,2) == null)

    assert(board.getPiece(5,0) == null)
    assert(board.getPiece(5,1) == null)
    assert(board.getPiece(5,2) == null)

    assert(board.getPiece(6,0) == null)
    assert(board.getPiece(6,1) == null)
    assert(board.getPiece(6,2) == null)
  }

  it should "set piece at the correct position" in {
    var board = new Board();

    board = board.setPiece(2,1, Piece.Black)

    assert(board.getPiece(2,1) == Piece.Black)
  }

}
