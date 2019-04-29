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
    expectedCarRover(new MarsMap("5 5"),"5 5 N","M","5 5 N RIP");
  }

  @Test
  public void testSendMoreCar() throws MapException, PositionException, ActionException {
    MarsMap map = new MarsMap("5 5");
    expectedCarRover(map, "5 5 N", "M", "5 5 N RIP");
    expectedCarRover(map,"5 5 N","MLLM","5 4 S");
    expectedCarRover(map, "5 5 N", "RMM", "5 5 E RIP");
  }

  @Test
  public void testReceiveCmd() throws ActionException, PositionException, MapException {
    String inputString="5 5 \n 1 2 N \n LMLMLMLMM \n 3 3 E \n MMM";
    String actualResult=new MarsRover().receiveCmd(inputString);
    String expectResult="1 3 N\r\n5 3 E RIP\r\n";
    Assert.assertEquals(expectResult,actualResult);
  }

  private void expectedCarRover(MarsMap marsMap,String posStr,String cmdStr,String expectedStr) throws MapException, PositionException, ActionException {
    MarsRover marsRover = new MarsRover();
    marsRover.setMarsMap(marsMap);
    String result = marsRover.sendCarWaitResult(posStr, cmdStr);
    Assert.assertEquals(expectedStr, result);
  }


}
