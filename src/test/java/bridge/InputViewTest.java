package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class InputViewTest {

    @ValueSource(strings = {"12", "A", "u", "d", "가"})
    @ParameterizedTest
    void 이동명령_예외테스트(String move) {
        //given
        InputView inputView = new InputView();

        //when, then
        assertThatThrownBy(() -> inputView.readMoving(move))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 이동명령_테스트(String move) {
        //given
        InputView inputView = new InputView();

        //when, then
        assertThat(inputView.readMoving(move)).isEqualTo(Move.valueOf(move));

    }
}