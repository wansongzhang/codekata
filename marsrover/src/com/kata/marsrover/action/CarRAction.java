package com.kata.marsrover.action;

import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarRAction implements CarAction {

  public CarRAction(){}

  public Position execute(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'S');
      case 'S':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'W');
      case 'W':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'N');
      case 'N':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'E');
      default:
        return currentPos;
    }
  }
}
