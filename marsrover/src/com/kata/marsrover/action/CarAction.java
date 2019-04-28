package com.kata.marsrover.action;

import com.kata.marsrover.Position;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public interface CarAction {
  public Position executeFromPos(Position currentPos);
}
