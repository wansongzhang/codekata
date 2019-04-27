package com.kata.marsrover;

import com.kata.marsrover.action.CarActionFactory;
import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.PositionException;

/**
 * Created by sloanzhang on 2019/4/26.
 */
public class Car {

  private MarsMap marsMap;
  private Position startPos, currentPos;

  public Car(int x, int y, char direction) {
    startPos = new Position(x, y, direction);
    currentPos = startPos;
  }

  public Car(String carPosStr, MarsMap marsMap) throws PositionException {
    startPos = new Position(carPosStr);
    currentPos = startPos;
    this.marsMap = marsMap;
  }


  public String rover(String cmdLine) throws ActionException {
    if (checkIsOutOfBoundary(currentPos)) {
      return currentPos.toString() + " RIP";
    }
    char[] actionArray = cmdLine.trim().toCharArray();
    for (char action : actionArray) {
      if (checkRipPosAction(currentPos, action)) continue;
      Position lastPos = currentPos;
      currentPos = executeAction(action);
      if (checkIsOutOfBoundary(currentPos)) {
        markMapRipInfo(lastPos, action);
        return lastPos.toString() + " RIP";
      }
    }
    return currentPos.toString();
  }

  Position executeAction(char action) throws ActionException {
    return CarActionFactory.getCarAction(action).execute(currentPos);
  }

  private boolean checkRipPosAction(Position pos, char action) {
    return marsMap != null && marsMap.isRipPosAction(new RipPosition(pos, action));
  }

  private void markMapRipInfo(Position pos, char lastAction) {
    marsMap.addRipPosition(new RipPosition(pos, lastAction));
  }

  private boolean checkIsOutOfBoundary(Position currentPos) {
    return marsMap != null && !marsMap.isInBoundary(currentPos.getXPos(), currentPos.getYPos());
  }
}
