package com.kata.marsrover;

import com.kata.marsrover.action.*;
import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.PositionException;
import com.kata.marsrover.exception.RipException;

/**
 * Created by sloanzhang on 2019/4/26.
 */
public class Car {

  private MarsMap marsMap;
  private Position startPos, currentPos;

  public Car(int x, int y, char direction) {
    startPos = new Position(new Coordinate(x, y),direction);
    currentPos = startPos;
  }

  public Car(String carPosStr, MarsMap marsMap) throws PositionException {
    startPos = new Position(carPosStr);
    currentPos = startPos;
    this.marsMap = marsMap;
  }


  public String rover(String cmdLine) throws ActionException, PositionException {
    if (checkIsOutOfBoundary(startPos)) throw new PositionException(startPos.toString());
    char[] actionArray = parserActionArray(cmdLine);
    try {
      return executeMoreAction(actionArray).toString();
    } catch (RipException ripException) {
      return ripException.getMessage();
    }
  }

  private Position executeMoreAction(char[] actionArray) throws ActionException, RipException {
    for (char action : actionArray) {
      if (checkRipPosition(currentPos, action)) continue;
      currentPos = executeOneAction(action);
    }
    return currentPos;
  }

  Position executeOneAction(char action) throws ActionException, RipException {
    Position lastPos = currentPos;
    currentPos = getCarAction(action).executeFromPos(currentPos);
    if (checkIsOutOfBoundary(currentPos)) {
      markMapRipInfo(lastPos, action);
      throw new RipException(generateRipInfo(lastPos));
    }
    return currentPos;
  }


  private char[] parserActionArray(String cmdLine) {
    return cmdLine.trim().toCharArray();
  }

  private String generateRipInfo(Position pos) {
    return pos.toString() + " RIP";
  }

  private CarAction getCarAction(char action) throws ActionException {
    switch (action) {
      case 'M':
        return new CarMAction();
      case 'L':
        return new CarLAction();
      case 'R':
        return new CarRAction();
      default:
        throw new ActionException("unknown action "+action);
    }
  }

  private boolean checkRipPosition(Position pos, char action) {
    return marsMap != null && marsMap.isRipPosition(new RipPosition(pos, action));
  }

  private void markMapRipInfo(Position pos, char lastAction) {
    marsMap.addRipPosition(new RipPosition(pos, lastAction));
  }

  private boolean checkIsOutOfBoundary(Position currentPos) {
    return marsMap != null && !marsMap.isInBoundary(currentPos.getCoordinate());
  }
}
