package com.kata.marsrover.action;


import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarLAction implements CarAction {

  public CarLAction(){}

  public Position executeFromPos(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getCoordinate(), 'N');
      case 'S':
        return new Position(currentPos.getCoordinate(), 'E');
      case 'W':
        return new Position(currentPos.getCoordinate(), 'S');
      case 'N':
        return new Position(currentPos.getCoordinate(), 'W');
      default:
        return currentPos;
    }
  }
}
