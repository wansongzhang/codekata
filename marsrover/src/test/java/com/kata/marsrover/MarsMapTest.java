package com.kata.marsrover;

import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by sloanzhang on 2019/4/27.
 */
public class MarsMapTest {


  @Test
  public void testMarsReadMapInput() throws MapException {
    MarsMap map = new MarsMap("5  6");
    assertEquals(5, map.getXBoundary());
    assertEquals(6, map.getYBoundary());
    Assertions.assertThrows(MapException.class, () -> {
      new MarsRover().readMapInfo("5 x 5");
    },"5 x 5");

  }

  @Test
  public void testCheck11_isInBoundary_map_55() {
    MarsMap map=new MarsMap(5,5);
    assertEquals(true, map.isInBoundary(new Coordinate(1, 1)));
  }

  @Test
  public void testCheck61_isOutBoundary_map_55() {
    MarsMap map=new MarsMap(5,5);
    assertEquals(false, map.isInBoundary(new Coordinate(6, 1)));
  }

  @Test
  public void testCheckRipPosition() throws PositionException {
    MarsMap map=new MarsMap(5,5);
    RipPosition ripPos=new RipPosition(new Position("5 5 N"),'M');
    map.addRipPosition(ripPos);
    assertEquals(true, map.isRipPosition(ripPos));
  }

}
