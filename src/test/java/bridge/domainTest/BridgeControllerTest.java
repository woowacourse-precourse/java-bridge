package bridge.domainTest;


import bridge.config.BridgeConfig;
import bridge.controller.BridgeController;
import bridge.domain.BridgeStage;
import bridge.validator.Unit;
import bridge.view.Messages;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

public class BridgeControllerTest extends NsTest {
    BridgeConfig bridgeConfig = new BridgeConfig();
    BridgeController bridgeController = bridgeConfig.bridgeController();

    @BeforeAll
    static void reset() {
        BridgeStage.resetStage();
    }

    @Test
    @DisplayName("다리 길이 입력시 숫자가 아닌 값을 입력했을때 예외 반환")
    void numberFormat() {
        assertSimpleTest(() -> {
            runException("#");
            assertThat(output()).contains(Messages.ERROR_INPUT_NUMBER.getMessage());
        });
    }

    @Test
    @DisplayName("다리 길이 범위에 포함하지 않는 값을 입력하면 예외 발생")
    void bridgeSize() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(Messages.ERROR_BRIDGE_SIZE.getMessage());
        });
    }

    @Test
    @DisplayName("U, D가 아닌 값을 입력하면 예외 발생")
    void inputFormat() {
        assertSimpleTest(() -> {
            runException("3", "1");
            assertThat(output()).contains(Messages.ERROR_MOVE.getMessage());
        });
    }

    @Test
    @DisplayName("Q, R가 아닌 값을 입력하면 예외 발생")
    void retryFormat() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("3", "D", "1", "Q");
                    assertThat(output()).contains(Messages.ERROR_GAME_COMMAND.getMessage());
                },
                1, 1, 1
        );
    }

    @Test
    @DisplayName("게임을 끝까지 성공하면 SuccessException 발생하고 게임을 종료")
    void success() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("4", "U", "D", "U", "D");
                    assertThat(output()).contains(Unit.SUCCESS.getCommand());
                },
                1, 0, 1,0
        );
    }

    @Test
    @DisplayName("게임을 중간에 종료하면 QuitException 발생하고 게임을 종료")
    void quit() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("4", "U", "U", "Q");
                    assertThat(output()).contains(Unit.QUITE.getCommand());
                },
                1, 0, 1,0
        );
    }


    @Override
    protected void runMain() {
        bridgeController.playWithExceptionCatch();
    }
}