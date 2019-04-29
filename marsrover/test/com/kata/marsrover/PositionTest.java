package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.PositionException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * Created by sloanzhang on 2019/4/27.
 */
public class PositionTest {

  @Rule
  public ExpectedException thrown = ExpectedException.none();
  @Test
  public void testCheckParserRightPosition() throws PositionException {
    Assert.assertEquals(new Position(1, 1, 'S').toString(), new Position("1 1 S").toString());
  }

  @Test
  public void testCheckParserRightPositionWithMoreSpace() throws PositionException {
    Assert.assertEquals(new Position(1, 1, 'S').toString(), new Position("1   1  S").toString());
  }

  @Test
  public void testCheckParserIllegalPositionX() throws PositionException{
    expectedParserIllegalPosition("X 1 S");
  }

  @Test
  public void testCheckParserIllegalPositionY() throws PositionException{
    expectedParserIllegalPosition("1 Y S");
  }

  @Test
  public void testCheckParserIllegalPositionDirection() throws PositionException {
    expectedParserIllegalPosition("1 2 R");
  }

  @Test
  public void testCheckParserIllegalPosition() throws PositionException {
    expectedParserIllegalPosition("1 2 3 R");
  }

  private void expectedParserIllegalPosition(String posStr) throws PositionException {
    thrown.expect(PositionException.class);
    thrown.expectMessage(posStr);
    new Position(posStr);
  }
}
