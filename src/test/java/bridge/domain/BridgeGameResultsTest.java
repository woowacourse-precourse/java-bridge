package bridge.domain;

import bridge.constant.MoveCommand;
import bridge.constant.MoveSign;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.constant.MoveCommand.MOVE_DOWN_VALUE;
import static bridge.constant.MoveCommand.MOVE_UP_VALUE;
import static bridge.constant.MoveSign.MOVE_FAIL;
import static bridge.constant.MoveSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameResultsTest {

    private static final String BLANK = " ";

    private BridgeGameResults moveResults;

    @BeforeEach
    void setUp() {
        moveResults = new BridgeGameResults();
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 {1}가, downResults에는 공백이 저장된다.")
    @MethodSource("provideArgumentsForAddResultsUp")
    void addResultsUp(MoveCommand moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);

        assertThat(moveResults.upLineResults()).containsOnly(resultSign);
        assertThat(moveResults.downLineResults()).containsOnly(BLANK);
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 공백이, downResults에는 {1}가 저장된다.")
    @MethodSource("provideArgumentsForAddResultsDown")
    void addResultsDown(MoveCommand moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);

        assertThat(moveResults.upLineResults()).containsOnly(BLANK);
        assertThat(moveResults.downLineResults()).containsOnly(resultSign);
    }

    @DisplayName("reset 메서드는 upResult와 downResult를 전부 비운다.")
    @Test
    void reset() {
        moveResults.addResults(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage());
        moveResults.reset();

        assertThat(moveResults.upLineResults()).isEmpty();
        assertThat(moveResults.downLineResults()).isEmpty();
    }

    private static Stream<Arguments> provideArgumentsForAddResultsUp() {
        return Stream.of(
                Arguments.of(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage()),
                Arguments.of(MOVE_UP_VALUE, MOVE_FAIL.getMessage())
        );
    }

    private static Stream<Arguments> provideArgumentsForAddResultsDown() {
        return Stream.of(
                Arguments.of(MOVE_DOWN_VALUE, MOVE_SUCCESS.getMessage()),
                Arguments.of(MOVE_DOWN_VALUE, MOVE_FAIL.getMessage())
        );
    }

}