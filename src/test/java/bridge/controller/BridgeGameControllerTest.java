package bridge.controller;

import bridge.util.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameControllerTest extends NsTest{
    BridgeGameController bridgeGameController;

    @BeforeEach
    void setup(){
        bridgeGameController=new BridgeGameController();
    }
    @Test
    @DisplayName("다리의 길이가 잘못된 입력이면 계속 입력받는지 확인")
    void inputBridgeSize(){
        assertRandomNumberInRangeTest(() -> {
            run("K", "3", "U", "U", "Q");
            assertThat(output()).contains(ErrorMessage.ERROR_IS_NOT_DIGIT.print());
        }, 1, 0, 1);
    }
    @Test
    @DisplayName("이동할 칸이 잘못된 입력이면 계속 입력받는지 확인")
    void inputMoveOne(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "K", "U", "U", "Q");
            assertThat(output()).contains(ErrorMessage.ERROR_MOVING.print());
        }, 1, 0, 1);
    }
    @Test
    void inputRetryOrQuit(){
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "J", "Q");
            assertThat(output()).contains(ErrorMessage.ERROR_RETRY_OR_QUIT.print());
        }, 1, 0, 1);
    }
    @Override
    protected void runMain() {
        bridgeGameController.gameStart();
    }
}