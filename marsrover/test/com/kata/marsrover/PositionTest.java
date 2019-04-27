package com.kata.marsrover;

import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

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
      new Position("1 S");
      Assert.assertFalse(true);
    } catch (PositionException e) {
      Assert.assertEquals("1 S", e.getMessage());
    }

    try {
      new Position("1 2 T");
      Assert.assertFalse(true);
    } catch (PositionException e) {
      Assert.assertEquals("1 2 T", e.getMessage());
    }
  }
}
