package net.softwareminds.ninemensmorris.game

trait PlayerState {
  def piecesSet(numOfSetPieces: Int): PlayerState = this
  def piecesOnTheBoard(numOfPieces: Int): PlayerState = this
}

object PlacingPiecesState extends PlayerState {
  override def piecesSet(numOfSetPieces: Int): PlayerState = {
    numOfSetPieces match {
      case 9 => MovingPiecesState
      case _ => this
    }
  }
}

object MovingPiecesState extends PlayerState {
  override def piecesOnTheBoard(numOfPieces: Int): PlayerState = {
    numOfPieces match {
      case 3 => FlyingState
      case 2 => LostState
      case _ => this
    }
  }
}

object FlyingState extends PlayerState {
  override def piecesOnTheBoard(numOfPieces: Int): PlayerState = {
    numOfPieces match {
      case 2 => LostState
      case _ => this
    }
  }
}

object LostState extends PlayerState {
}
