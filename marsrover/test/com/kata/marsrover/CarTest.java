package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
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
