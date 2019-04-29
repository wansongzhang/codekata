package com.kata.marsrover.action;

import com.kata.marsrover.Coordinate;
import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarMAction implements CarAction {

  public CarMAction(){}

  public Position executeFromPos(Position currentPos){
    char direction = currentPos.getDirection();
    switch (direction) {
      case 'E':
        return new Position(currentPos.getCoordinate().inCreaseX(), currentPos.getDirection());
      case 'S':
        return new Position(currentPos.getCoordinate().deCreaseY(), currentPos.getDirection());
      case 'W':
        return new Position(currentPos.getCoordinate().deCreaseX(), currentPos.getDirection());
      case 'N':
        return new Position(currentPos.getCoordinate().inCreaseY(), currentPos.getDirection());
      default:
        return currentPos;
    }
  }
}
