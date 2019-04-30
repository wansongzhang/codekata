package com.kata.marsrover;


import com.kata.marsrover.exception.PositionException;

/**
 * Created by sloanzhang on 2019/4/26.
 */
public class Position {
  private  char direction;
  private  Coordinate coordinate;
  private  int yPos;

  public Position(Coordinate coordinate,char direction) {
    this.coordinate = coordinate;
    this.direction = direction;
  }

  public Position(String posStr) throws PositionException {
    String[] posArray = getValidPosArray(posStr);
    try {
      this.coordinate=new Coordinate(Integer.parseInt(posArray[0]),Integer.parseInt(posArray[1]));
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



  boolean isValidPositionDirection(char direction){
    return (direction=='E'||direction=='S'||direction=='W'||direction=='N')?true:false;
  }


  public boolean isEquals(Position pos){
    return (coordinate.isEquals(pos.getCoordinate())&&direction==pos.getDirection());
  }

  public String toString() {
    return new StringBuilder().append(coordinate.toString()).append(" ").append(direction).toString();
  }

  public Coordinate getCoordinate() {
    return coordinate;
  }
  public char getDirection() {
    return direction;
  }

}
