package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RoundTest {
    private Round round;

    @BeforeEach
    void beforeEach() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        round = new Round(bridge);
    }

    @DisplayName("첫 번째 칸에서 이동 가능한 칸을 판단한다.")
    @ParameterizedTest
    @CsvSource({"U, O", "D, X"})
    void canMovable(String selectedSpace, Movable result) {
        Movable movable = round.canMovable(selectedSpace);

        Assertions.assertThat(movable).isEqualTo(result);
    }

    @DisplayName("다음 라운드로 넘어가서 이동한 칸이 이동 가능한 칸인지 판단한다.")
    @ParameterizedTest
    @CsvSource({"U, false", "D, true"})
    void isSuccessSelectingRightSpace(String selectedSpace, boolean result) {
        round.next();
        round.canMovable(selectedSpace);

        boolean isRightSpace = round.isSuccessSelectingRightSpace();

        Assertions.assertThat(isRightSpace).isEqualTo(result);
    }

    @DisplayName("마지막 라운드를 성공했는지 판단한다.")
    @ParameterizedTest
    @CsvSource({"U, true", "D, false"})
    void isSuccessLastRound(String selectedSpace, boolean result) {
        round.next();
        round.next();
        round.canMovable(selectedSpace);
        round.next();

        boolean successLastRound = round.isSuccessLastRound();

        Assertions.assertThat(successLastRound).isEqualTo(result);
    }
}