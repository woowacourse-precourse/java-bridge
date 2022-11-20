package bridge.game;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoveTest {

    @DisplayName("목적지 조회 기능 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void getDestination(String destination) {
        Move move = new Move(destination, true);
        String moveDestination = move.getDestination();
        assertThat(moveDestination).isEqualTo(destination);
    }

    @DisplayName("성공 여부 조회 기능 테스트")
    @ValueSource(booleans = {true, false})
    @ParameterizedTest
    void isSuccess(boolean result) {
        Move move = new Move("U", result);
        boolean moveResult = move.isSuccess();
        assertThat(moveResult).isEqualTo(result);
    }
}