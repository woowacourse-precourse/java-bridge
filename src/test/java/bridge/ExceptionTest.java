package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.Domain.Bridge;
import bridge.Domain.Command;
import bridge.Domain.Movement;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.basic.BasicRadioButtonUI;

public class ExceptionTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @DisplayName("다리게임에서 다리 생성시, 입력이 정수가 아니면 예외가 발생한다.")
    @Test
    void createBridgeByNotNumericInput() {
        assertThatThrownBy(() -> new Bridge("asd"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리게임에서 다리 생성시, 입력이 20을 넘어가는 정수면 예외가 발생한다.")
    @Test
    void createBridgeOutOfMaxSize() {
        assertThatThrownBy(() -> new Bridge("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리게임에서 다리 생성시, 입력이 3보다 작은 정수면 예외가 발생한다.")
    @Test
    void createBridgeOutOfMinSize() {
        assertThatThrownBy(() -> new Bridge("2"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리게임에서 움직임을 입력받으면, 알파벳이 아닐 경우에는 예외가 발생한다.")
    @Test
    void createMovementNotAlphabetic() {
        assertThatThrownBy(() -> new Movement("E"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리게임에서 움직임을 입력받으면, Enum클래스에 정의된 움직임이 아닐 경우에는 예외가 발생한다.")
    @Test
    void createMovementNotValidAlphabet() {
        assertThatThrownBy(() -> new Movement("E"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리게임 실패시, 게임 재시작 또는 종료를 위한 입력이 알파벳이 아닌 경우 예외가 발생한다.")
    @Test
    void createCommandNotAlphabetic() {
        assertThatThrownBy(() -> new Command("4"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리게임 실패시, 게임 재시작 또는 종료를 위한 입력이 Q 또는 R이 아닌 경우 예외가 발생한다.")
    @Test
    void createCommandNotValidAlphabet() {
        assertThatThrownBy(() -> new Command("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }



    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
