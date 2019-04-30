package com.kata.marsrover;

public class Coordinate {
  private final int x;
  private final int y;

  public Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public boolean isEquals(Coordinate coordinate) {
    return (x==coordinate.x&&y==coordinate.y)?true:false;
  }

  public Coordinate inCreaseX(){
    return new Coordinate(x+1,y);
  }

  public Coordinate deCreaseX(){
    return new Coordinate(x-1,y);
  }


  public Coordinate inCreaseY(){
    return new Coordinate(x,y+1);
  }

  public Coordinate deCreaseY(){
    return new Coordinate(x,y-1);
  }

  public String toString(){
    return x+" "+y;
  }
}
