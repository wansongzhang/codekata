package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
import com.kata.marsrover.exception.RipException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * Created by sloanzhang on 2019/4/26.
 */
public class CarTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Test
  public void testCheckGetIllegalAction() throws ActionException, RipException {
    thrown.expect(ActionException.class);
    thrown.expectMessage("X");
    new Car(0,0,'E').executeOneAction('X');
  }

  @Test
  public void testStart_11N_WithCMD_LMR_GetPos_01N() throws ActionException, PositionException {
    expectedCarRoverCmd("1 1 N", "LMR", "0 1 N");
  }


  @Test
  public void testStart_11N_WithCMD_LLLL_GetPos_11N() throws ActionException, PositionException {
    expectedCarRoverCmd("1 1 N", "LLLL","1 1 N");
  }

  @Test
  public void testStart_11N_WithCMD_RRRR_GetPos_11N() throws ActionException, PositionException {
    expectedCarRoverCmd("1 1 N", "RRRR", "1 1 N");
  }

  @Test
  public void testStart_11N_WithCMD_LRRML_GetPos_21N() throws ActionException, PositionException {
    expectedCarRoverCmd("1 1 N", "LRRML", "2 1 N");
  }

  @Test
  public void testCarRoverStartOfOutBoundray() throws MapException, PositionException, ActionException {
    String posStr="6 0 N";
    thrown.expect(PositionException.class);
    thrown.expectMessage(posStr);
    new Car(posStr, new MarsMap(5,5)).rover("M");
  }

  @Test
  public void testCarRoverGetRip() throws MapException, PositionException, ActionException {
    expectedCarRoverCmdWithMap(new MarsMap(5,5), "5 5 N", "M", "5 5 N RIP");
  }

  @Test
  public void testCarRoverWithExistRipMapInfoIgnoreAction() throws MapException, PositionException, ActionException {
    MarsMap marsMap=new MarsMap(5,5);
    marsMap.addRipPosition(new RipPosition(new Position("5 5 N"), 'M'));
    expectedCarRoverCmdWithMap(marsMap,"5 5 N","MLM","4 5 W");
  }

  private void expectedCarRoverCmd(String startPosStr,String cmd,String destPosStr) throws ActionException, PositionException {
    Assert.assertEquals(new Position(destPosStr).toString(), new Car(startPosStr,null).rover(cmd).toString());
  }

  private void expectedCarRoverCmdWithMap(MarsMap map,String startPosStr,String cmd,String result) throws ActionException, PositionException {
    Assert.assertEquals(result, new Car(startPosStr,map).rover(cmd).toString());
  }

}
