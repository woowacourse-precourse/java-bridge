package bridge.domain.bridge_game;

import static bridge.domain.constants.MoveCommands.MOVE_DOWN_COMMAND;
import static bridge.domain.constants.MoveCommands.MOVE_UP_COMMAND;
import static bridge.domain.constants.MoveResultsSign.MOVE_FAIL;
import static bridge.domain.constants.MoveResultsSign.MOVE_SUCCESS;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.constants.MoveCommands;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MoveResultsTest {

    private static final String BLANK = " ";
    
    private MoveResults moveResults;

    @BeforeEach
    void setUp() {
        moveResults = new MoveResults();
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 {1}가, downResults에는 공백이 저장된다.")
    @MethodSource("provideArgumentsForAddResultsUp")
    void addResultsUp(MoveCommands moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);

        assertThat(moveResults.upLineResults()).containsOnly(resultSign);
        assertThat(moveResults.downLineResults()).containsOnly(BLANK);
    }

    @ParameterizedTest(name = "{0}, {1}을 입력 받으면 upResult에는 공백이, downResults에는 {1}가 저장된다.")
    @MethodSource("provideArgumentsForAddResultsDown")
    void addResultsDown(MoveCommands moveCommand, String resultSign) {
        moveResults.addResults(moveCommand, resultSign);

        assertThat(moveResults.upLineResults()).containsOnly(BLANK);
        assertThat(moveResults.downLineResults()).containsOnly(resultSign);
    }

    @DisplayName("reset 메서드는 upResult와 downResult를 전부 비운다.")
    @Test
    void reset() {
        moveResults.addResults(MOVE_UP_COMMAND, MOVE_SUCCESS);
        moveResults.reset();

        assertThat(moveResults.upLineResults()).isEmpty();
        assertThat(moveResults.downLineResults()).isEmpty();
    }

    private static Stream<Arguments> provideArgumentsForAddResultsUp() {
        return Stream.of(
                Arguments.of(MOVE_UP_COMMAND, MOVE_SUCCESS),
                Arguments.of(MOVE_UP_COMMAND, MOVE_FAIL)
        );
    }

    private static Stream<Arguments> provideArgumentsForAddResultsDown() {
        return Stream.of(
                Arguments.of(MOVE_DOWN_COMMAND, MOVE_SUCCESS),
                Arguments.of(MOVE_DOWN_COMMAND, MOVE_FAIL)
        );
    }
}