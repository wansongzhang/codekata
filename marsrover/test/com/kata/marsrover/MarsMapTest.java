package com.kata.marsrover;

import com.kata.marsrover.exception.MapException;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sloanzhang on 2019/4/27.
 */
public class MarsMapTest {

  @Test
  public void testMarsReadMapInput() throws MapException {
    MarsMap map = new MarsMap("5  6");
    Assert.assertEquals(5, map.getXBoundary());
    Assert.assertEquals(6, map.getYBoundary());
    try {
      new MarsRover().readMapInfo("5 x 5");
      Assert.assertFalse(true);
    } catch (MapException e) {
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testCheck11_isInBoundary_map_55() {
    MarsMap map=new MarsMap(5,5);
    Assert.assertEquals(true, map.isInBoundary(1, 1));
  }

  @Test
  public void testCheck61_isOutBoundary_map_55() {
    MarsMap map=new MarsMap(5,5);
    Assert.assertEquals(false, map.isInBoundary(6, 1));
  }

  @Test
  public void testCheckRipPosition() {
    MarsMap map=new MarsMap(5,5);
    RipPosition ripPos=new RipPosition(new Position(5,5,'N'),'M');
    map.addRipPosition(ripPos);
    Assert.assertEquals(true, map.isRipPosAction(ripPos));
  }

}
