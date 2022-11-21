package bridge;

import bridge.exception.BridgeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    BridgeException bridgeException = new BridgeException();


    @DisplayName("다리 길이의 입력값이 3-20 사이가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "21", "22"})
    void createBridgeByNotInRange(String size) {
        assertThatThrownBy(() -> bridgeException.validateBridgeSizeLange(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }


    @DisplayName("이동할 칸의 입력값이 대문자 U나 대문자 D가 아니면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"d", "u", "s", "1", " ", ""})
    void checkMovingByNotRequired(String moving) {
        assertThatThrownBy(() -> bridgeException.validateMove(moving))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이동할 칸은 대문자 U와 대문자 D만 입력 가능합니다.");
    }


    @DisplayName("게임 재시작시 입력값이 대문자 R이나 대문자 Q이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", "1", " ", ""})
    void checkRestartByNotRequired(String restart) {
        assertThatThrownBy(() -> bridgeException.validateRestart(restart))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] R(재시작)과 Q(종료) 중 하나의 문자만 입력가능 합니다.");
    }
}
