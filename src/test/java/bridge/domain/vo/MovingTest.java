package bridge.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.vo.Moving.createMoving;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class MovingTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("U 또는 D의 문자 1개를 입력 시 예외가 발생하지 않는다.")
    @Test
    void SuccessCase() {
        assertThatCode(() -> createMoving("U"))
                .doesNotThrowAnyException();

        assertThatCode(() -> createMoving("D"))
                .doesNotThrowAnyException();
    }

    @DisplayName("U 또는 D의 문자 1개를 입력 시 성공적으로 Moving을 생성한다.")
    @Test
    void createGameCommandTest() {
        assertThat(createMoving("U"))
                .isInstanceOf(Moving.class);

        assertThat(createMoving("D"))
                .isInstanceOf(Moving.class);
    }

    @DisplayName("Moving을 1개 이상의 문자를 입력 시 예외가 발생한다.")
    @Test
    void case1() {
        assertThatThrownBy(() -> createMoving("hi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }

    @DisplayName("Moving을 U 또는 D로 입력하지 않을 시 예외가 발생한다.")
    @Test
    void case2() {
        assertThatThrownBy(() -> createMoving("A"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE);
    }
}