package com.kata.marsrover.action;

import com.kata.marsrover.Position;
import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.PositionException;
import com.kata.marsrover.exception.RipException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarRActionTest {
  @Test
  public void testStart_00E_Get_00S() throws PositionException {
    expectedCarRActionExecute("0 0 E", "0 0 S");
  }

  @Test
  public void testStart_00S_Get_00W() throws PositionException {
    expectedCarRActionExecute("0 0 S", "0 0 W");
  }

  @Test
  public void testStart_00W_Get_00N() throws PositionException {
    expectedCarRActionExecute("0 0 W", "0 0 N");
  }

  @Test
  public void testStart_00N_Get_00E() throws PositionException {
    expectedCarRActionExecute("0 0 N", "0 0 E");
  }

  @Rule
  public ExpectedException thrown = ExpectedException.none();


  @Test
  public void testStartIllegalDirection() throws PositionException {
    Assert.assertEquals("0 0 X", new CarRAction().executeFromPos(new Position(0, 0, 'X')).toString());
  }

  private void expectedCarRActionExecute(String startPosStr, String result) throws PositionException {
    Position srcPos = new Position(startPosStr);
    Assert.assertEquals(result, new CarRAction().executeFromPos(srcPos).toString());
  }

}
