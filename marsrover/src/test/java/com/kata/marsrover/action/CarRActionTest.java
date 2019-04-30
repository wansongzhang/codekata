package com.kata.marsrover.action;

import com.kata.marsrover.Coordinate;
import com.kata.marsrover.Position;
import com.kata.marsrover.exception.PositionException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by sloanzhang on 2019/4/27.
 */
public class CarRActionTest {

  @ParameterizedTest
  @DisplayName("测试R指令从不同位置出发均可获得正确的位置结果")
  @ArgumentsSource(CustomArgumentsGenerator.class)
  void expectedCarRActionExecute(String startPosStr, String result) throws PositionException {
    Position srcPos = new Position(startPosStr);
    assertEquals(result, new CarRAction().executeFromPos(srcPos).toString());
  }

  static class CustomArgumentsGenerator implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
      return Stream.of(
              Arguments.of("0 0 E", "0 0 S"),
              Arguments.of("0 0 S", "0 0 W"),
              Arguments.of("0 0 W", "0 0 N"),
              Arguments.of("0 0 N", "0 0 E")
      );
    }
  }

  @Test
  @DisplayName("测试R指令从一个错误Direction出发的情况返回原始位置")
  public void testStartIllegalDirection() throws PositionException {
    assertEquals("0 0 X", new CarRAction().executeFromPos(new Position(new Coordinate(0, 0), 'X')).toString());
  }



}
