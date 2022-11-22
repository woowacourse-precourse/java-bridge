package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class InputViewTest {

    @DisplayName("다리의 길이를 3~20에서 벗어난 숫자를 입력한 경우 예외처리")
    @Test
    void checkBridgeSizeOutRange(){
        assertThatThrownBy(() -> InputView.errorBridgeSizeOverRange("21"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputView.errorBridgeSizeOverRange("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이를 숫자가 아닌 것을 입력시 예외처리")
    @Test
    void checkBridgInputNotNumber(){
        assertThatThrownBy(() -> InputView.errorBridgeSizeOverRange("a"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> InputView.errorBridgeSizeOverRange("!!"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸을 U,D가 아닌 것을 입력시 예외처리")
    @Test
    void checkMoveInputNotUOrD(){
        assertThatThrownBy(() -> InputView.errorInputNotUOrD("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 또는 종료시 Q,R이 아닌 것을 입력시 예외처리")
    @Test
    void checkRetryInputNotROrQ(){
        assertThatThrownBy(() -> InputView.errorInputNotUOrD("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}