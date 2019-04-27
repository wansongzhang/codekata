package com.kata.marsrover.action;

import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarLAction implements CarAction {

  public CarLAction(){}

  public Position execute(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'N');
      case 'S':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'E');
      case 'W':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'S');
      case 'N':
        return new Position(currentPos.getXPos(), currentPos.getYPos(), 'W');
      default:
        return currentPos;
    }
  }
}
