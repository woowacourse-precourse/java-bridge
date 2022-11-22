package bridge.domain;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MoverTest {

    private Mover mover;
    private final List<String> arr = new ArrayList<>(List.of("U", "D", "U"));


    @BeforeEach
    void setup() {
        mover = Mover.from(Bridge.from(arr));
    }

    @DisplayName("정답을 맞춘경우, 맞추지 못한 경우 그에 맞는 결과를 반환한다.")
    @MethodSource("provideInputForMove")
    @ParameterizedTest
    void returnGameResultGivenMoveCommand(boolean isMatch, ViewStatus status) {
        GameResult result = mover.resultOfMove(isMatch);

        assertThat(result.getNextViewStatus()).isEqualTo(status);
    }

    @DisplayName("모든 정답을 맞춘 경우 그에 맞는 결과를 반환한다.")
    @Test
    void returnWinStatusWhenGiveCorrectMoveCommand() {
        GameResult result = moveUntilWin(mover);

        List<String> partialBridge = result.getResult();

        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.WIN);
        assertThat(partialBridge.size()).isEqualTo(3);
    }

    private GameResult moveUntilWin(Mover mover) {
        boolean isMatch = true;
        for (String position : arr) {
            isMatch = mover.move(position);
        }
        return mover.resultOfMove(isMatch);
    }

    private static Stream<Arguments> provideInputForMove() { // argument source method
        return Stream.of(
                Arguments.of(true, ViewStatus.DETERMINE_MOVE),
                Arguments.of(false, ViewStatus.DETERMINE_RETRY)
        );
    }
}