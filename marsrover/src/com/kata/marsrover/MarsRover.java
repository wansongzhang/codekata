package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class MarsRover {
  private MarsMap marsMap;

  public void readMapInfo(String mapStr) throws MapException {
    this.marsMap=new MarsMap(mapStr);
  }

  public String sendCar(String posStr, String cmdStr) throws PositionException, ActionException {
    return new Car(posStr,marsMap).rover(cmdStr);
  }
}
