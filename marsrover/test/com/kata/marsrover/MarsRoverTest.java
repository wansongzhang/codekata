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
    String result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals("5 5 N RIP", result);
  }


  @Test
  public void testSendMoreCar() throws MapException, PositionException, ActionException {
    MarsRover marsRover = new MarsRover();
    marsRover.readMapInfo("5 5");
    String posStr = "5 5 N";
    String cmdStr = "M";
    String result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals("5 5 N RIP", result);

    cmdStr = "M";
    result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals("5 5 N", result);

    cmdStr = "MLLM";
    result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals("5 4 S", result);

    cmdStr = "RMM";
    result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals("5 5 E RIP", result);
  }

  @Test
  public void testAll() throws ActionException, PositionException, MapException {
    String inputString="5 5 \n 1 2 N \n LMLMLMLMM \n 3 3 E \n MMM";
    String actualResult=new MarsRover().readInput(inputString);
    String expectResult="1 3 N\r\n5 3 E RIP\r\n";
    Assert.assertEquals(expectResult,actualResult);
  }



}
