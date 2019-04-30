package com.kata.marsrover;

import com.kata.marsrover.exception.ActionException;
import com.kata.marsrover.exception.MapException;
import com.kata.marsrover.exception.PositionException;
import com.kata.marsrover.exception.RipException;
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
 * Created by sloanzhang on 2019/4/26.
 */
public class CarTest {

    static class CustomActionArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("1 1 N", "LMR", "0 1 N"),
                    Arguments.of("1 1 N", "LLLL", "1 1 N"),
                    Arguments.of("1 1 N", "RRRR", "1 1 N"),
                    Arguments.of("1 1 N", "LRRML", "2 1 N")
            );
        }
    }

    @ParameterizedTest
    @DisplayName("测试火星车会根据多个指令运行出正确结果")
    @ArgumentsSource(CustomActionArgumentsGenerator.class)
    void expectedCarRoverCmd(String startPosStr, String cmd, String destPosStr) throws PositionException, ActionException {
        assertEquals(new Position(destPosStr).toString(), new Car(startPosStr, null).rover(cmd).toString());
    }


    static class ErrorActionArgumentsGenerator implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of("5 5", "0 0 E", "X", ActionException.class, "X"),
                    Arguments.of("5 5", "6 0 N", "M", PositionException.class, "6 0 N")
            );
        }
    }

    @ParameterizedTest
    @DisplayName("测试火星车根据错误输入检查出异常")
    @ArgumentsSource(ErrorActionArgumentsGenerator.class)
    void expectedCarRoverCmdException(String mapStr, String startPosStr, String cmd, Class c, String msg) throws PositionException, ActionException {
        Assertions.assertThrows(c, () -> {
            new Car(startPosStr, new MarsMap(mapStr)).rover(cmd);
        }, msg);
    }


    @Test
    void testCarRoverGetRip() throws MapException, PositionException, ActionException {
        expectedCarRoverCmdWithMap(new MarsMap(5, 5), "5 5 N", "M", "5 5 N RIP");
    }

    @Test
    void testCarRoverWithExistRipMapInfoIgnoreAction() throws MapException, PositionException, ActionException {
        MarsMap marsMap = new MarsMap(5, 5);
        marsMap.addRipPosition(new RipPosition(new Position("5 5 N"), 'M'));
        expectedCarRoverCmdWithMap(marsMap, "5 5 N", "MLM", "4 5 W");
    }


    void expectedCarRoverCmdWithMap(MarsMap map, String startPosStr, String cmd, String result) throws ActionException, PositionException {
        assertEquals(result, new Car(startPosStr, map).rover(cmd).toString());
    }

}
