package net.softwareminds.ninemensmorris.board

import net.softwareminds.ninemensmorris.board.Piece.{White, Black}
import org.scalatest.FlatSpec

class BoardTest extends FlatSpec {

  "A new Board" should "only have empty points" in {
    val board = new Board()

    assert(board.getPiece(0, 0).isEmpty)
    assert(board.getPiece(0, 3).isEmpty)
    assert(board.getPiece(0, 6).isEmpty)

    assert(board.getPiece(1, 1).isEmpty)
    assert(board.getPiece(1, 3).isEmpty)
    assert(board.getPiece(1, 5).isEmpty)

    assert(board.getPiece(2, 2).isEmpty)
    assert(board.getPiece(2, 3).isEmpty)
    assert(board.getPiece(2, 4).isEmpty)

    assert(board.getPiece(3, 0).isEmpty)
    assert(board.getPiece(3, 1).isEmpty)
    assert(board.getPiece(3, 2).isEmpty)
    assert(board.getPiece(3, 4).isEmpty)
    assert(board.getPiece(3, 5).isEmpty)
    assert(board.getPiece(3, 6).isEmpty)

    assert(board.getPiece(4, 1).isEmpty)
    assert(board.getPiece(4, 3).isEmpty)
    assert(board.getPiece(4, 5).isEmpty)

    assert(board.getPiece(5, 1).isEmpty)
    assert(board.getPiece(5, 3).isEmpty)
    assert(board.getPiece(5, 5).isEmpty)

    assert(board.getPiece(6, 0).isEmpty)
    assert(board.getPiece(6, 3).isEmpty)
    assert(board.getPiece(6, 6).isEmpty)
  }

  it should "set piece at the correct position" in {
    var board = new Board()

    board = board.setPiece(3, 1, Black)

    assert(board.getPiece(0, 0).isEmpty)
    assert(board.getPiece(0, 3).isEmpty)
    assert(board.getPiece(0, 6).isEmpty)

    assert(board.getPiece(1, 1).isEmpty)
    assert(board.getPiece(1, 3).isEmpty)
    assert(board.getPiece(1, 5).isEmpty)

    assert(board.getPiece(2, 2).isEmpty)
    assert(board.getPiece(2, 3).isEmpty)
    assert(board.getPiece(2, 4).isEmpty)

    assert(board.getPiece(3, 0).isEmpty)
    assert(board.getPiece(3, 1).contains(Black))
    assert(board.getPiece(3, 2).isEmpty)
    assert(board.getPiece(3, 4).isEmpty)
    assert(board.getPiece(3, 5).isEmpty)
    assert(board.getPiece(3, 6).isEmpty)

    assert(board.getPiece(4, 1).isEmpty)
    assert(board.getPiece(4, 3).isEmpty)
    assert(board.getPiece(4, 5).isEmpty)

    assert(board.getPiece(5, 1).isEmpty)
    assert(board.getPiece(5, 3).isEmpty)
    assert(board.getPiece(5, 5).isEmpty)

    assert(board.getPiece(6, 0).isEmpty)
    assert(board.getPiece(6, 3).isEmpty)
    assert(board.getPiece(6, 6).isEmpty)
  }

  it should "move piece to the correct position" in {
    var board = new Board()

    board = board.setPiece(3, 0, White)
    board = board.movePiece(3, 0, 3, 1)

    assert(board.getPiece(0, 0).isEmpty)
    assert(board.getPiece(0, 3).isEmpty)
    assert(board.getPiece(0, 6).isEmpty)

    assert(board.getPiece(1, 1).isEmpty)
    assert(board.getPiece(1, 3).isEmpty)
    assert(board.getPiece(1, 5).isEmpty)

    assert(board.getPiece(2, 2).isEmpty)
    assert(board.getPiece(2, 3).isEmpty)
    assert(board.getPiece(2, 4).isEmpty)

    assert(board.getPiece(3, 0).isEmpty)
    assert(board.getPiece(3, 1).contains(White))
    assert(board.getPiece(3, 2).isEmpty)
    assert(board.getPiece(3, 4).isEmpty)
    assert(board.getPiece(3, 5).isEmpty)
    assert(board.getPiece(3, 6).isEmpty)

    assert(board.getPiece(4, 1).isEmpty)
    assert(board.getPiece(4, 3).isEmpty)
    assert(board.getPiece(4, 5).isEmpty)

    assert(board.getPiece(5, 1).isEmpty)
    assert(board.getPiece(5, 3).isEmpty)
    assert(board.getPiece(5, 5).isEmpty)

    assert(board.getPiece(6, 0).isEmpty)
    assert(board.getPiece(6, 3).isEmpty)
    assert(board.getPiece(6, 6).isEmpty)
  }

}
