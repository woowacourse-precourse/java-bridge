package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class InputViewTest {
    private InputView inputView = new InputView();


    @Test
    void 다리_크기_사용자_입력_검증() {
        assertThat(inputView.readBridgeSize("5")).isEqualTo(5);
    }

    @Test
    void 다리_크기_숫자가_아닌_사용자_입력() {
        assertThatThrownBy(() -> inputView.readBridgeSize("s"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 '숫자'여야 합니다.");
    }

    @Test
    void 다리_크기_범위_밖_숫자_사용자_입력() {
        assertThatThrownBy(() -> inputView.readBridgeSize("22"))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"U:U","D:D"}, delimiter = ':')
    void 이동_사용자_입력_검증(String input,String result) {
        assertThat(inputView.readMoving(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AA","BB","123","A"})
    void 이동_사용자_입력_예외_처리(String input) {
        assertThatThrownBy(() -> inputView.readMoving(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 이동할 칸은 U(위), D(아래)만 선택 가능합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"R:R","Q:Q"}, delimiter = ':')
    void 게임재시작_사용자_입력_검증(String input, String  result) {
        assertThat(inputView.readGameCommand(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"AA","BB","123","A"})
    void 게임시작_사용자_입력_예외_처리(String input) {
        assertThatThrownBy(() -> inputView.readMoving(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessage("[ERROR] 이동할 칸은 U(위), D(아래)만 선택 가능합니다.");
    }


}