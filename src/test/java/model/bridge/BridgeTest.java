package model.bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {
    static List<List<String>> initBridge;
    static List<Bridge> bridges;
    static List<MoveMark> marks;

    @BeforeAll
    static void setUp() {
        initBridge = new ArrayList<>() {{
            add(List.of("U", "D", "D"));
            add(List.of("D", "U", "D"));
        }};

        bridges = new ArrayList<>();
        for (List<String> init : initBridge) {
            bridges.add(new Bridge(init));
        }
    }

    @DisplayName("사용자가 입력한 문자가 다리와 동일한 경우 TRUE 반환")
    @MethodSource("correct")
    @ParameterizedTest(name = "[{index}]    다리가 {0}일 때 {1}칸에 {2} 입력")
    void canMove(Bridge bridge, int stage, MoveMark mark) {
        boolean move = bridge.canMove(stage, mark);
        assertTrue(move);
    }

    @DisplayName("사용자가 입력한 문자가 다리와 다른 경우 FALSE 반환")
    @MethodSource("wrong")
    @ParameterizedTest(name = "[{index}]    다리가 {0}일 때 {1}칸에 {2} 입력")
    void canNotMove(Bridge bridge, int stage, MoveMark mark) {
        boolean move = bridge.canMove(stage, mark);
        assertFalse(move);
    }

    static Stream<Arguments> correct() {
        setCorrectMoveMark();

        return Stream.of(
                Arguments.of(bridges.get(0), 0, marks.get(0)),
                Arguments.of(bridges.get(0), 1, marks.get(1)),
                Arguments.of(bridges.get(0), 2, marks.get(2)),
                Arguments.of(bridges.get(1), 0, marks.get(3)),
                Arguments.of(bridges.get(1), 1, marks.get(4)),
                Arguments.of(bridges.get(1), 2, marks.get(5))
        );
    }

    private static void setCorrectMoveMark() {
        marks = new ArrayList<>();
        for (List<String> init : initBridge) {
            for (String mark : init) {
                marks.add(new MoveMark(mark));
            }
        }
    }

    static Stream<Arguments> wrong() {
        setWrongMovieMark();

        return Stream.of(
                Arguments.of(bridges.get(0), 0, marks.get(0)),
                Arguments.of(bridges.get(0), 1, marks.get(1)),
                Arguments.of(bridges.get(0), 2, marks.get(2)),
                Arguments.of(bridges.get(1), 0, marks.get(3)),
                Arguments.of(bridges.get(1), 1, marks.get(4)),
                Arguments.of(bridges.get(1), 2, marks.get(5))
        );
    }

    private static void setWrongMovieMark() {
        marks = new ArrayList<>();
        for (List<String> init : initBridge) {
            for (String mark : init) {
                addWrongMark(mark);
            }
        }
    }

    private static void addWrongMark(String mark) {
        if (mark.equals("U")) {
            marks.add(new MoveMark("D"));
            return;
        }

        if (mark.equals("D")) {
            marks.add(new MoveMark("U"));
        }
    }
}