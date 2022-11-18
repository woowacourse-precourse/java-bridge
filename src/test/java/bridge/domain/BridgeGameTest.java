package bridge.domain;

import bridge.exception.InputException;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("이동할 칸 선택시 U, D가 아닌 다른 문자를 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "u", "d"})
    void readMoving(String direction) {
        assertThatThrownBy(() -> InputException.isValidMovementDirection(direction))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 수 있는 칸인지 판단할 수 있다.")
    @ParameterizedTest
    @CsvSource({"0,U", "1,U", "2,D"})
    void judgeMovementDirection(int index, String direction) {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        assertThat(bridge.isPossibleMove(index, direction)).isTrue();
    }
}
