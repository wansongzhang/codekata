package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class MarsRoverTest {


  @Test
  public void testSendOneCar() throws MapException, PositionException, ActionException {
    MarsRover marsRover = new MarsRover();
    marsRover.readMapInfo("5 5");
    String posStr = "5 5 N";
    String cmdStr = "M";
    String result = marsRover.sendCar(posStr, cmdStr);
    Assert.assertEquals("5 5 N RIP", result);
  }


  @Test
  public void testSendMoreCar() throws MapException, PositionException, ActionException {
    MarsRover marsRover = new MarsRover();
    marsRover.readMapInfo("5 5");
    String posStr = "5 5 N";
    String cmdStr = "M";
    String result = marsRover.sendCar(posStr, cmdStr);
    Assert.assertEquals("5 5 N RIP", result);

    cmdStr = "M";
    result = marsRover.sendCar(posStr, cmdStr);
    Assert.assertEquals("5 5 N", result);

    cmdStr = "MLLM";
    result = marsRover.sendCar(posStr, cmdStr);
    Assert.assertEquals("5 4 S", result);

    cmdStr = "RMM";
    result = marsRover.sendCar(posStr, cmdStr);
    Assert.assertEquals("5 5 E RIP", result);

  }


}
