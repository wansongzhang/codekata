package com.kata.marsrover.action;

import com.kata.marsrover.Coordinate;
import com.kata.marsrover.Position;
import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarMActionTest {
  @Test
  public void testStart_00E_Get_10E() throws PositionException {
    expectedCarMActionExecute("0 0 E", "1 0 E");
  }

  @Test
  public void testStart_01S_Get_00S() throws PositionException {
    expectedCarMActionExecute("0 1 S", "0 0 S");
  }

  @Test
  public void testStart_10W_Get_00W() throws PositionException {
    expectedCarMActionExecute("1 0 W", "0 0 W");
  }

  @Test
  public void testStart_00N_Get_01N()throws PositionException {
    expectedCarMActionExecute("0 0 N", "0 1 N");
  }


  @Test
  public void testStartIllegalDirection() throws PositionException {
    Assert.assertEquals("0 0 X", new CarMAction().executeFromPos(new Position(new Coordinate(0, 0), 'X')).toString());
  }

  private void expectedCarMActionExecute(String startPosStr, String result) throws PositionException {
    Position srcPos = new Position(startPosStr);
    Assert.assertEquals(result, new CarMAction().executeFromPos(srcPos).toString());
  }

}
