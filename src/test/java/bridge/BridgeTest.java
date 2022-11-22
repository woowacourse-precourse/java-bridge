package bridge;

import bridge.view.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {
    @DisplayName("입력된 다리 크기가 3이상 20이하가 아닌경우 예외 발생")
    @ValueSource(strings = {"-1123213151", "-1", "0","1","2","129740124"})
    @ParameterizedTest
    void readBridgeSizeWithWrongSizeInput(String size) {
        assertThatThrownBy(() -> Validation.validSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력된 다리 크기가 숫자가 아닌 경우 예외 발생")
    @ValueSource(strings = {" ","d","[","Eleven","sadsadwq"})
    @ParameterizedTest
    void readBridgeSizeWithWrongTypeInput(String size) {
        assertThatThrownBy(() -> Validation.validSize(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("입력된 방향이 U,D가 아닌 경우 예외 발생")
    @ValueSource(strings = {" ","0","d","[","Up","Down","위","아래 ㄱㄱ"})
    @ParameterizedTest
    void readMovingWithWrongInput(String moving) {
        assertThatThrownBy(() -> Validation.validMoving(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력은 U,D 만 가능합니다.");
    }


    @DisplayName("재시도 여부 입력이 R,Q가 아닌 경우 예외 발생")
    @ValueSource(strings = {" ","0","d","[","No more","더 할래요","하기싫습니다"})
    @ParameterizedTest
    void readGameCommandWithWrongInput(String retryIntention) {
        assertThatThrownBy(() -> Validation.validCommand(retryIntention))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 입력은 R,Q 만 가능합니다.");
    }
}