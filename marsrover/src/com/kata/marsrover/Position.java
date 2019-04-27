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
    String[] posArray = getPosArray(posStr);
    if (!isValidPosArray(posArray)) throw new PositionException(posStr);
    try {
      this.xPos = Integer.parseInt(posArray[0]);
      this.yPos = Integer.parseInt(posArray[1]);
      this.direction = posArray[2].charAt(0);
    } catch (Exception e) {
      throw new PositionException(posStr);
    }
  }

  boolean isValidPosArray(String[] posArray) throws PositionException {
    if (posArray == null || posArray.length != 3) return false;
    if (!Position.isValidPositionDirection(posArray[2].charAt(0))) return false;
    return true;
  }

  private String[] getPosArray(String posStr) {
    String[] posArray = posStr.trim().split("\\s+");
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

  public static boolean isValidPositionDirection(char direction){
    return (direction=='E'||direction=='S'||direction=='W'||direction=='N')?true:false;
  }


  public boolean equals(Position pos){
    return (xPos==pos.getXPos()&&yPos==pos.getYPos()&&direction==pos.getDirection());
  }

  public String toString() {
    return new StringBuilder().append(xPos).append(" ").append(yPos).append(" ").append(direction).toString();
  }
}
