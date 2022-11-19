package view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void 다리_길이에_문자가_포함된_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("1l".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("다리 길이가 유효한 범위를 벗어나는 경우 에외를 발생시킨다.")
    @Test
    void 다리_길이가_범위를_벗어나는_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("2\n21".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("이동할 칸이 U 혹은 D일 경우 입력받는데 성공한다.")
    @Test
    void 이동할_칸이_U_혹은_D인_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("U".getBytes()));

        // when
        String moving = inputView.readMoving();

        // then
        assertThat(moving).isEqualTo("U");
    }

    @DisplayName("이동할 칸이 U 혹은 D가 아닌 경우 예외를 발생시킨다.")
    @Test
    void 이동할_칸이_U_혹은_D가_아닐_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("I".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("재시작/종료 여부가 R 혹은 Q일 경우 입력받는데 성공한다.")
    @Test
    void 재시작_종료_여부가_R_혹은_Q일_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("R".getBytes()));

        // when
        String command = inputView.readGameCommand();

        // then
        assertThat(command).isEqualTo("R");
    }

    @DisplayName("재시작/종료 여부가 R 혹은 Q일 경우 입력받는데 성공한다.")
    @Test
    void 재시작_종료_여부가_R_혹은_Q가_아닐_경우() {
        // given
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("D".getBytes()));

        // when & then
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(NoSuchElementException.class);
    }
}