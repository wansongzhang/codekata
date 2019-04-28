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
  public void testCheckParserIllegalPosition() throws PositionException{

    thrown.expect(PositionException.class);
    thrown.expectMessage("121R");
    new Position("121R");


    thrown.expect(PositionException.class);
    thrown.expectMessage("1 S 3");
    new Position("1 S 3");

    thrown.expect(PositionException.class);
    thrown.expectMessage("1 T S");
    new Position("1 T S");
  }
}
