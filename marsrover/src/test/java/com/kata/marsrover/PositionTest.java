package com.kata.marsrover;

import com.kata.marsrover.action.CarLAction;
import com.kata.marsrover.action.CarLActionTest;
import com.kata.marsrover.exception.PositionException;
import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
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
public class PositionTest {

    static class CustomArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("1 1 S", new Position(new Coordinate(1, 1), 'S')),
                    Arguments.of("1     1 N", new Position(new Coordinate(1, 1), 'N')),
                    Arguments.of("1     1 S  ", new Position(new Coordinate(1, 1), 'S'))
            );
        }
    }

    @ParameterizedTest
    @DisplayName("测试解析不同的字符串作为位置正确输入")
    @ArgumentsSource(CustomArgumentsGenerator.class)
    void expectedPositionParser(String startPosStr, Position destPos) throws PositionException {
        assertEquals(destPos.toString(), new Position(startPosStr).toString());
    }




    static class ErrorPosArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("X 1 S"),
                    Arguments.of("1 Y S"),
                    Arguments.of("1 2 R"),
                    Arguments.of("1 2 3 R")
            );
        }
    }

    @ParameterizedTest
    @DisplayName("测试解析异常的字符串会扔出PositionException异常")
    @ArgumentsSource(ErrorPosArgumentsGenerator.class)
    void expectedParserIllegalPosition(String posStr) throws PositionException {
        Assertions.assertThrows(PositionException.class, () -> {
            new Position(posStr);
        }, posStr);
    }
}
