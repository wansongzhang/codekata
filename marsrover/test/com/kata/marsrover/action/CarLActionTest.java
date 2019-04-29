package com.kata.marsrover.action;

import com.kata.marsrover.Position;
import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarLActionTest {
  @Test
  public void testStart_00E_Get_00N() throws PositionException {
    expectedCarLActionExecute("0 0 E", "0 0 N");
  }

  @Test
  public void testStart_00S_Get_00E() throws PositionException {
    expectedCarLActionExecute("0 0 S", "0 0 E");
  }

  @Test
  public void testStart_00W_Get_00S() throws PositionException {
    expectedCarLActionExecute("0 0 W", "0 0 S");
  }

  @Test
  public void testStart_00N_Get_00W() throws PositionException {
    expectedCarLActionExecute("0 0 N", "0 0 W");
  }


  @Test
  public void testStartIllegalDirection() throws PositionException {
    Assert.assertEquals("0 0 X", new CarLAction().executeFromPos(new Position(0, 0, 'X')).toString());
  }

  private void expectedCarLActionExecute(String startPosStr, String result) throws PositionException {
    Position srcPos = new Position(startPosStr);
    Assert.assertEquals(result, new CarLAction().executeFromPos(srcPos).toString());
  }

}
