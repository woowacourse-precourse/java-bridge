package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {
    @DisplayName("다리 크기를 입력할 때, 숫자가 아닌 값을 넣으면 예외가 발생한다.")
    @Test
    void enterBridgeSizeByInvalidValue() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 숫자가 아닙니다.");
                }
        );
    }

    @DisplayName("다리 크기를 입력할 때, 3부터 20 사이의 숫자가 아니면 예외가 발생한다.")
    @Test
    void enterBridgeSizeByInvalidRange() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("21"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 3부터 20 사이의 숫자가 아닙니다.");
        });
    }

    @DisplayName("다리 이동 방향을 입력할 때, 입력 값이 단일 문자가 아니면 예외가 발생한다.")
    @Test
    void enterBridgeMoveByNotSingleCharacter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("3", "ab"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 입력 값이 단일 문자가 아닙니다.");
        });
    }

    @DisplayName("다리 이동 방향을 입력할 때, 이미 정해진 값 외의 입력 값은 예외가 발생한다.")
    @Test
    void enterBridgeMoveByInvalidValue() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("3", "A"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 방향을 잘못 입력하셨습니다.");
        });
    }

    @DisplayName("게임 재시작 여부를 입력할 때, 입력 값이 단일 문자가 아니면 예외가 발생한다.")
    @Test
    void enterGameCommandByNotSingleCharacter() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("3", "U", "Ab"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 입력 값이 단일 문자가 아닙니다.");
        });
    }

    @DisplayName("게임 재시작 여부를 입력할 때, 이미 정해진 값 외의 입력 값은 예외가 발생한다.")
    @Test
    void enterGameCommandByInvalidValue() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("3", "U", "A"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 재시작 여부를 잘못 입력하셨습니다.");
        });
    }

    @Override
    protected void runMain() { Application.main(new String[]{}); }
}
