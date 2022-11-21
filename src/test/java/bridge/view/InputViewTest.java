package bridge.view;

import bridge.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private InputStream generateUserInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("다리의 길이를 입력받는다.")
    void 다리의_길이를_입력받는다(){
        //given
        InputView inputView = new InputView();

        //when
        InputStream in = generateUserInput("3");
        System.setIn(in);

        //then
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @Test
    @DisplayName("다리의 길이가 범위를 벗어날 경우 예외가 발생한다.")
    void 다리의_길이가_범위를_벗어날_경우_예외가_발생한다() {
        // given
        InputView inputView = new InputView();

        // when

        // then
        assertThatThrownBy(() -> inputView.validateBridgeSize("22"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    @DisplayName("입력받은 길이가 숫자가 아닌경우 예외가 발생한다.")
    void test() {
        // given
        InputView inputView = new InputView();

        // when

        // then
        assertThatThrownBy(() -> inputView.validateBridgeSize("15j"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이동할 칸 U를 입력받는다.")
    void 이동할_칸_U를_입력받는다() {
        //given
        InputView inputView = new InputView();

        //when
        InputStream in = generateUserInput("U");
        System.setIn(in);

        // then
        assertThat(inputView.readMoving()).isEqualTo("U");
    }

    @Test
    @DisplayName("이동할 칸 D를 입력받는다.")
    void 이동할_칸_D를_입력받는다() {
        //given
        InputView inputView = new InputView();

        //when
        InputStream in = generateUserInput("D");
        System.setIn(in);
        String move = inputView.readMoving();

        // then
        assertThat(move).isEqualTo("D");
    }

    @Test
    @DisplayName("이동할 칸이 U 또는 D가 아닐 경우 예외가 발생한다.")
    void 이동할_칸이_U_또는_D가_아닐_경우_예외가_발생한다() {
        // given
        InputView inputView = new InputView();

        // when

        // then
        assertThatThrownBy(() -> inputView.validateBridgeSize("F"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("게임 커멘드 R을 입력받는다.")
    void 게임_커멘드_R을_입력받는다() {
        // given
        InputView inputView = new InputView();

        // when
        InputStream in = generateUserInput("R");
        System.setIn(in);

        // then
        assertThat(inputView.readGameCommand()).isEqualTo("R");
    }

    @Test
    @DisplayName("게임 커멘드 Q를 입력받는다.")
    void 게임_커멘드_Q를_입력받는다() {
        // given
        InputView inputView = new InputView();

        // when
        InputStream in = generateUserInput("Q");
        System.setIn(in);

        // then
        assertThat(inputView.readGameCommand()).isEqualTo("Q");
    }

    @Test
    @DisplayName("게임 커멘드가 R 또는 Q가 아닐 경우 예외가 발생한다.")
    void 게임_커멘드가_R_또는_Q가_아닐_경우_예외가_발생한다() {
        // given
        InputView inputView = new InputView();

        // when

        // then
        assertThatThrownBy(() -> inputView.validateBridgeSize("F"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
