package com.kata.marsrover.action;

import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarMAction implements CarAction {

  public CarMAction(){}

  public Position execute(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getXPos() + 1, currentPos.getYPos(), currentPos.getDirection());
      case 'S':
        return new Position(currentPos.getXPos(), currentPos.getYPos() - 1, currentPos.getDirection());
      case 'W':
        return new Position(currentPos.getXPos() - 1, currentPos.getYPos(), currentPos.getDirection());
      case 'N':
        return new Position(currentPos.getXPos(), currentPos.getYPos() + 1, currentPos.getDirection());
      default:
        return currentPos;
    }
  }
}
