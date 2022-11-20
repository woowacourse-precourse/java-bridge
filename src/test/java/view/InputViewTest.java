package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @DisplayName("다리 길이가 정상인 경우 입력받는데 성공한다.")
    @Test
    void 다리_길이가_정상인_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("10".getBytes()));

        // when
        int bridgeSize = inputView.readBridgeSize();

        // then
        assertThat(bridgeSize).isEqualTo(10);
    }

    @DisplayName("다리 길이에 문자가 포함된 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"1l", " ", "1 ", "j"})
    @ParameterizedTest
    void 다리_길이에_문자가_포함된_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("1l".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("다리 길이가 유효한 범위를 벗어나는 경우 에외를 발생시킨다.")
    @ValueSource(strings = {"2", "21"})
    @ParameterizedTest
    void 다리_길이가_범위를_벗어나는_경우(String bridgeSize) {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(bridgeSize.getBytes()));

        // when & then
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("이동할 칸이 U 혹은 D일 경우 입력받는데 성공한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동할_칸이_U_혹은_D인_경우(String userInput) {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when
        String moving = inputView.readMoving();

        // then
        assertThat(moving).isEqualTo(userInput);
    }

    @DisplayName("이동할 칸이 U 혹은 D가 아닌 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"I", "u", "1", ";"})
    @ParameterizedTest
    void 이동할_칸이_U_혹은_D가_아닐_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("I".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("재시작/종료 여부가 R 혹은 Q일 경우 입력받는데 성공한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 재시작_종료_여부가_R_혹은_Q일_경우(String userInput) {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // when
        String command = inputView.readGameCommand();

        // then
        assertThat(command).isEqualTo(userInput);
    }

    @DisplayName("재시작/종료 여부가 R 혹은 Q이 아닐 경우 예외를 발생시킨다.")
    @ValueSource(strings = {"D", "r", "1", ";"})
    @ParameterizedTest
    void 재시작_종료_여부가_R_혹은_Q가_아닐_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("D".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(NoSuchElementException.class);
    }
}