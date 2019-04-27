package com.kata.marsrover;

import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by sloanzhang on 2019/4/27.
 */
public class PositionTest {

  @Test
  public void testCheckParserRightPosition() throws PositionException {
    Assert.assertEquals(new Position(1, 1, 'S').toString(), new Position("1 1 S").toString());
  }

  @Test
  public void testCheckParserRightPositionWithMoreSpace() throws PositionException {
    Assert.assertEquals(new Position(1, 1, 'S').toString(), new Position("1   1  S").toString());
  }

  @Test
  public void testCheckParserIllegalPosition() {
    try {
      new Position("121R");
      Assert.assertFalse(true);
    } catch (PositionException e) {
      Assert.assertEquals("121R", e.getMessage());
    }

    try {
      new Position("1 S 3");
      Assert.assertFalse(true);
    } catch (PositionException e) {
      Assert.assertEquals("1 S 3", e.getMessage());
    }

    try {
      new Position("1 T S");
      Assert.assertFalse(true);
    } catch (PositionException e) {
      Assert.assertEquals("1 T S", e.getMessage());
    }
  }
}
