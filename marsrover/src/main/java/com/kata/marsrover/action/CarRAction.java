package com.kata.marsrover.action;

import com.kata.marsrover.Position;
import com.kata.marsrover.action.CarAction;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarRAction implements CarAction {

  public CarRAction(){}

  public Position executeFromPos(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getCoordinate(), 'S');
      case 'S':
        return new Position(currentPos.getCoordinate(), 'W');
      case 'W':
        return new Position(currentPos.getCoordinate(), 'N');
      case 'N':
        return new Position(currentPos.getCoordinate(), 'E');
      default:
        return currentPos;
    }
  }
}
