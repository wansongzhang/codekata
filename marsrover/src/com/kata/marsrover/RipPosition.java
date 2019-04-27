package com.kata.marsrover;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class RipPosition extends Position {
  private final char lastAction;

  public RipPosition(Position lastPos, char lastAction) {
    super(lastPos.getXPos(),lastPos.getYPos(),lastPos.getDirection());
    this.lastAction=lastAction;
  }

  public boolean equals(RipPosition ripPos){
    return (super.equals(ripPos)&&lastAction==ripPos.lastAction);
  }
}
