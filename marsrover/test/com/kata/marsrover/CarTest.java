package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;



/**
 * Created by sloanzhang on 2019/4/26.
 */
public class CarTest {

  @Test
  public void testStart_00E_WithCMD_M_GetPos_10E() throws ActionException {
    Position destPos = new Position(1, 0, 'E');
    Assert.assertEquals(destPos.toString(),  new Car(0, 0, 'E').executeAction('M').toString());
  }



  @Test
  public void testStart_00E_WithCMD_L_GetPos_00N() throws ActionException {
    Position destPos = new Position(0, 0, 'N');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'E').executeAction('L').toString());
  }

  @Test
  public void testStart_00E_WithCMD_R_GetPos_00S() throws ActionException {
    Position destPos = new Position(0, 0, 'S');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'E').executeAction('R').toString());
  }


  @Test
  public void testStart_00S_WithCMD_L_GetPos_00E() throws ActionException {
    Position destPos = new Position(0, 0, 'E');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'S').executeAction('L').toString());
  }

  @Test
  public void testStart_00S_WithCMD_R_GetPos_00W() throws ActionException {
    Position destPos = new Position(0, 0, 'W');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'S').executeAction('R').toString());
  }

  @Test
  public void testStart_01S_WithCMD_M_GetPos_00S() throws ActionException {
    Position destPos = new Position(0, 0, 'S');
    Assert.assertEquals(destPos.toString(), new Car(0, 1, 'S').executeAction('M').toString());
  }


  @Test
  public void testStart_00W_WithCMD_L_GetPos_00S() throws ActionException {
    Position destPos = new Position(0, 0, 'S');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'W').executeAction('L').toString());
  }


  @Test
  public void testStart_00W_WithCMD_R_GetPos_00N() throws ActionException {
    Position destPos = new Position(0, 0, 'N');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'W').executeAction('R').toString());
  }

  @Test
  public void testStart_10W_WithCMD_M_GetPos_00W() throws ActionException {
    Position destPos = new Position(0, 0, 'W');
    Assert.assertEquals(destPos.toString(), new Car(1, 0, 'W').executeAction('M').toString());
  }


  @Test
  public void testStart_00N_WithCMD_L_GetPos_00W() throws ActionException {
    Position destPos = new Position(0, 0, 'W');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'N').executeAction('L').toString());
  }
  @Test
  public void testStart_00N_WithCMD_R_GetPos_00E() throws ActionException {
    Position destPos = new Position(0, 0, 'E');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'N').executeAction('R').toString());
  }

  @Test
  public void testStart_00N_WithCMD_M_GetPos_01N() throws ActionException {
    Position destPos = new Position(0, 1, 'N');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'N').executeAction('M').toString());
  }



  @Test
  public void testStart_00E_WithCMD_MMM_GetPos_30E() throws ActionException {
    Position destPos = new Position(3, 0, 'E');
    Assert.assertEquals(destPos.toString(), new Car(0, 0, 'E').rover("MMM").toString());
  }

  @Test
  public void testCheckValidCmdStr() throws ActionException {
    Assert.assertTrue(new Car().isValidActionCmdStr("LRMRMRM"));
    Assert.assertFalse(new Car().isValidActionCmdStr("LR MRMRM"));
    Assert.assertFalse(new Car().isValidActionCmdStr("ST"));
  }


  @Test
  public void testStart_11N_WithCMD_LMR_GetPos_01N() throws ActionException {
    Position destPos = new Position(0, 1, 'N');
    Assert.assertEquals(destPos.toString(), new Car(1, 1, 'N').rover("LMR").toString());
  }

  @Test
  public void testStart_11N_WithCMD_LLLL_GetPos_11N() throws ActionException {
    Position destPos = new Position(1, 1, 'N');
    Assert.assertEquals(destPos.toString(), new Car(1, 1, 'N').rover("LLLL").toString());
  }

  @Test
  public void testStart_11N_WithCMD_RRRR_GetPos_11N() throws ActionException {
    Position destPos = new Position(1, 1, 'N');
    Assert.assertEquals(destPos.toString(), new Car(1, 1, 'N').rover("RRRR").toString());
  }

  @Test
  public void testStart_11N_WithCMD_LRRML_GetPos_21N() throws ActionException {
    Position destPos = new Position(2, 1, 'N');
    Assert.assertEquals(destPos.toString(), new Car(1, 1, 'N').rover("LRRML").toString());
  }

  @Test
  public void testCarRoverStartOfOutBoundray() throws MapException, PositionException, ActionException {
    MarsMap marsMap=new MarsMap(5,5);
    String posStr="6 0 N";
    String cmdStr="M";
    Assert.assertEquals("6 0 N RIP",new Car(posStr,marsMap).rover(cmdStr));
  }


  @Test
  public void testCarRoverGetRip() throws MapException, PositionException, ActionException {
    MarsMap marsMap=new MarsMap(5,5);
    String posStr="5 5 N";
    String cmdStr="M";
    Assert.assertEquals("5 5 N RIP", new Car(posStr,marsMap).rover(cmdStr));
  }


  @Test
  public void testCarRoverWithExistRipMapInfoIgnoreAction() throws MapException, PositionException, ActionException {
    MarsMap marsMap=new MarsMap(5,5);
    marsMap.addRipPosition(new RipPosition(new Position(5, 5, 'N'), 'M'));
    String posStr="5 5 N";
    String cmdStr="MLM";
    Assert.assertEquals("4 5 W", new Car(posStr, marsMap).rover(cmdStr));
  }




}
