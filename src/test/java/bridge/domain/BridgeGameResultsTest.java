package bridge.domain;

import bridge.constant.MoveCommand;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static bridge.constant.MoveCommand.*;
import static bridge.constant.MoveSign.*;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameResultsTest {

    private static final String BLANK = " ";

    private BridgeGameResults bridgeGameResults;

    @BeforeEach
    void setUp() {
        bridgeGameResults = new BridgeGameResults();
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 공백이, downResults에는 {1}가 저장된다.")
    @MethodSource("provideArgumentsForAddResultsDown")
    void addResultsDown(MoveCommand moveCommand, String resultSign) {
        bridgeGameResults.addResults(moveCommand, resultSign);

        assertThat(bridgeGameResults.upLineResults()).containsOnly(BLANK);
        assertThat(bridgeGameResults.downLineResults()).containsOnly(resultSign);
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 {1}가, downResults에는 공백이 저장된다.")
    @MethodSource("provideArgumentsForAddResultsUp")
    void addResultsUp(MoveCommand moveCommand, String resultSign) {
        bridgeGameResults.addResults(moveCommand, resultSign);

        assertThat(bridgeGameResults.upLineResults()).containsOnly(resultSign);
        assertThat(bridgeGameResults.downLineResults()).containsOnly(BLANK);
    }

    @DisplayName("reset 메서드는 upResult와 downResult를 전부 비운다.")
    @Test
    void reset() {
        bridgeGameResults.addResults(MOVE_UP_VALUE, MOVE_SUCCESS.getMessage());
        bridgeGameResults.reset();

        assertThat(bridgeGameResults.upLineResults()).isEmpty();
        assertThat(bridgeGameResults.downLineResults()).isEmpty();
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