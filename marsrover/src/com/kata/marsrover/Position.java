package com.kata.marsrover;

import com.kata.marsrover.exception.PositionException;

/**
 * Created by sloanzhang on 2019/4/26.
 */
public class Position {
  private  char direction;
  private  int xPos;
  private  int yPos;

  public Position(int x, int y, char direction) {
    this.xPos = x;
    this.yPos = y;
    this.direction = direction;
  }

  public Position(String posStr) throws PositionException {
    String[] posArray = getValidPosArray(posStr);
    try {
      this.xPos = Integer.parseInt(posArray[0]);
      this.yPos = Integer.parseInt(posArray[1]);
      this.direction = posArray[2].charAt(0);
    } catch (NumberFormatException e) {
      throw new PositionException(posStr);
    }
  }

  String[] getValidPosArray(String posStr) throws PositionException {
    String[] posArray=posStr.trim().split("\\s+");
    if (posArray == null || posArray.length != 3) throw new PositionException(posStr);
    if (!isValidPositionDirection(posArray[2].charAt(0))) throw new PositionException(posStr);
    return posArray;
  }

  public char getDirection() {
    return direction;
  }

  public int getXPos() {
    return xPos;
  }

  public int getYPos() {
    return yPos;
  }

  boolean isValidPositionDirection(char direction){
    return (direction=='E'||direction=='S'||direction=='W'||direction=='N')?true:false;
  }


  public boolean isEquals(Position pos){
    return (xPos==pos.getXPos()&&yPos==pos.getYPos()&&direction==pos.getDirection());
  }

  public String toString() {
    return new StringBuilder().append(xPos).append(" ").append(yPos).append(" ").append(direction).toString();
  }
}
