package bridge.verifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputVerifierTest {
    @DisplayName("다리 길이가 정상적으로 검증되는지 확인")
    @ValueSource(strings = {"3", "4", "5", "6", "7", "8", "18", "19", "20"})
    @ParameterizedTest
    void bridgeSize_올바른_범위(String input) {
        InputVerifier.BridgeSize(input);
    }

    @DisplayName("다리 길이가 3보다 작을때 예외 처리")
    @ValueSource(strings = {"2", "1", "0", "-1", "-2", "-3", "-4", "-5", "-112"})
    @ParameterizedTest
    void bridgeSize_기준보다_작은_범위(String input) {
        assertThatThrownBy(() -> InputVerifier.BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 20보다 클때 예외 처리")
    @ValueSource(strings = {"21", "22", "23", "24", "222", "192", "302", "123", "1203"})
    @ParameterizedTest
    void bridgeSize_기준보다_큰_범위(String input) {
        assertThatThrownBy(() -> InputVerifier.BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 숫자가 아닐때 예외 처리")
    @ValueSource(strings = {"aa", "2a", "1sd", "##@", "-=", " ", "", "123as", "test"})
    @ParameterizedTest
    void bridgeSize_숫자가_아닌_입력(String input) {
        assertThatThrownBy(() -> InputVerifier.BridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동할 칸이 정상적으로 검증되는지 확인")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void moving_올바른_값(String input) {
        InputVerifier.moving(input);
    }

    @DisplayName("이동할 칸에 잘못된 값이 입력되면 예외 처리")
    @ValueSource(strings = {"UU", "d", "R", "123", "43C", "CV", "", " ", "앞"})
    @ParameterizedTest
    void moving_잘못된_값(String input) {
        assertThatThrownBy(() -> InputVerifier.moving(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작/종료 여부가 정상적으로 검증되는지 확인")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void gameCommand_올바른_값(String input) {
        InputVerifier.gameCommand(input);
    }

    @DisplayName("재시작/종료 여부가 정상적으로 검증되는지 확인")
    @ValueSource(strings = {"Rr", "q", "DC", "", " ", "12", "테스트"})
    @ParameterizedTest
    void gameCommand_잘못된_값(String input) {
        assertThatThrownBy(() -> InputVerifier.gameCommand(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}