package com.kata.marsrover.action;

import com.kata.marsrover.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarMActionTest {
  @Test
  public void testStart_00E_Get_10E()  {
    Position destPos = new Position(1, 0, 'E');
    Position srcPos = new Position(0, 0, 'E');
    Assert.assertEquals(destPos.toString(), new CarMAction().executeFromPos(srcPos).toString());
  }

  @Test
  public void testStart_01S_Get_00S()  {
    Position destPos = new Position(0, 0, 'S');
    Position srcPos = new Position(0, 1, 'S');
    Assert.assertEquals(destPos.toString(), new CarMAction().executeFromPos(srcPos).toString());
  }

  @Test
  public void testStart_10W_Get_00W()  {
    Position destPos = new Position(0, 0, 'W');
    Position srcPos = new Position(1, 0, 'W');
    Assert.assertEquals(destPos.toString(), new CarMAction().executeFromPos(srcPos).toString());
  }

  @Test
  public void testStart_00N_Get_01N(){
    Position destPos = new Position(0, 1, 'N');
    Position srcPos = new Position(0, 0, 'N');
    Assert.assertEquals(destPos.toString(), new CarMAction().executeFromPos(srcPos).toString());
  }

  @Test
  public void testStartIllegalDirection_GetDefault() {
    Position srcPos = new Position(0, 0, 'T');
    Assert.assertEquals(srcPos.toString(), new CarMAction().executeFromPos(srcPos).toString());
  }



}
