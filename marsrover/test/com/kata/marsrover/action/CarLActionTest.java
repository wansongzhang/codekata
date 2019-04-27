package com.kata.marsrover.action;

import com.kata.marsrover.Position;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarLActionTest {
  @Test
  public void testStart_00E_Get_00N()  {
    Position destPos = new Position(0, 0, 'N');
    Position srcPos = new Position(0, 0, 'E');
    Assert.assertEquals(destPos.toString(), new CarLAction().execute(srcPos).toString());
  }

  @Test
  public void testStart_00S_Get_00E()  {
    Position destPos = new Position(0, 0, 'E');
    Position srcPos = new Position(0, 0, 'S');
    Assert.assertEquals(destPos.toString(), new CarLAction().execute(srcPos).toString());
  }

  @Test
  public void testStart_00W_Get_00S()  {
    Position destPos = new Position(0, 0, 'S');
    Position srcPos = new Position(0, 0, 'W');
    Assert.assertEquals(destPos.toString(), new CarLAction().execute(srcPos).toString());
  }

  @Test
  public void testStart_00N_Get_00W(){
    Position destPos = new Position(0, 0, 'W');
    Position srcPos = new Position(0, 0, 'N');
    Assert.assertEquals(destPos.toString(), new CarLAction().execute(srcPos).toString());
  }

  @Test
  public void testStartIllegalDirection_GetDefault() {
    Position srcPos = new Position(0, 0, 'T');
    Assert.assertEquals(srcPos.toString(), new CarLAction().execute(srcPos).toString());
  }



}
