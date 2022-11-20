package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputTest {
    private static final String ERROR_MESSAGE = "[ERROR]";
    @Test
    @DisplayName("다리 길이를 빈 값을 입력시 에러 발생")
    void 다리길이_빈값_테스트(){
        assertThatThrownBy(() -> {
            new InputView().readBridgeSize("");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    @Test
    @DisplayName("다리 길이를 숫자가 아닌 값을 입력시 에러 발생")
    void 다리길이_숫자_테스트() {
        assertThatThrownBy(() -> {
            new InputView().readBridgeSize("U");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    @Test
    @DisplayName("게임 시 규칙에 맞지 않은 값을 입력시 에러 발생")
    void 게임_숫자_테스트(){
        assertThatThrownBy(() -> {
            new InputView().readMoving("0");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    @Test
    @DisplayName("게임 시 빈 값을 입력시 에러 발생")
    void 게임_빈값_테스트(){
        assertThatThrownBy(() -> {
            new InputView().readMoving("");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
    @Test
    @DisplayName("재시작 시 규칙에 맞지 않은 값을 입력시 에러 발생")
    void 재시작_빈값_테스트(){
        assertThatThrownBy(() -> {
            new InputView().readGameCommand("U");
        }).hasMessageContaining(ERROR_MESSAGE);
    }
}
