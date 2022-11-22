package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BridgeValidateTest {

    @DisplayName("다리 길이 입력이 3~20을 벗어나면 오류가 발생한다.")
    @Test
    void 다리_길이_사이즈_테스트(){
        assertThatThrownBy(()-> new InputView().validateOverSize(222))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력에 숫자가 아닌 입력이 들어오면 오류가 발생한다.")
    @Test
    void 다리_길이_숫자여부_테스트(){
        assertThatThrownBy(() -> new InputView().validateIsDigit("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 칸이 U 혹은 D가 아닌 값이 들어오면 오류가 발생한다.")
    @ValueSource(strings = {"123123","Z"})
    @ParameterizedTest
    void 이동할_칸의_값_테스트(String moving){
        assertThatThrownBy(()-> new InputView().validateUpOrDown(moving))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력에 공백이 들어오면 오류가 발생한다.")
    @Test
    void 공백_입력_테스트() {
        assertThatThrownBy(() -> new InputView().validateIsEmpty(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부를 입력 받을 때, Q 혹은 R가 아닌 다른 값이 들어오면 오류가 발생한다.")
    @ValueSource(strings = {"123123","Z","일"})
    @ParameterizedTest
    void 재시작_입력_테스트(String input){
        assertThatThrownBy(()-> new InputView().validateRestartOrQuit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
