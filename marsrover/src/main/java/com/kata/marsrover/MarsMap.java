package com.kata.marsrover;


import com.kata.marsrover.exception.MapException;

import java.util.ArrayList;

/**
 * Created by sloanzhang on 2019/4/26.
 */
public class MarsMap {
  private int xBoundary = 0;
  private int yBoundary = 0;
  private ArrayList<RipPosition> ripPositionList;

  public MarsMap(int x, int y) {
    this.xBoundary = x;
    this.yBoundary = y;
    ripPositionList = new ArrayList<RipPosition>();
  }

  public MarsMap(String mapStr) throws MapException {
    String[] array = mapStr.trim().split("\\s+");
    try {
      this.xBoundary = Integer.parseInt(array[0]);
      this.yBoundary = Integer.parseInt(array[1]);
      ripPositionList = new ArrayList<RipPosition>();
    } catch (Exception e) {
      throw new MapException(mapStr);
    }
  }

  public boolean isInBoundary(Coordinate coordinate) {
    return (coordinate.getX() >= 0 && coordinate.getX() <= xBoundary && coordinate.getY() >= 0 && coordinate.getY() <= yBoundary);
  }

  public int getXBoundary() {
    return xBoundary;
  }

  public int getYBoundary() {
    return yBoundary;
  }

  public void addRipPosition(RipPosition ripPosition) {
    ripPositionList.add(ripPosition);
  }

  public boolean isRipPosition(RipPosition ripPosition) {
    for (RipPosition ripPos : ripPositionList) {
      if (ripPos.isEquals(ripPosition))
        return true;
    }
    return false;
  }
}
