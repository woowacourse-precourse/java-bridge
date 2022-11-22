package bridge.controller;

import bridge.Application;
import bridge.constant.message.InputMessage;
import bridge.constant.message.OutputMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.constant.BridgeControl.QUIT;
import static bridge.constant.BridgeControl.RESTART;
import static bridge.constant.BridgeMove.DOWN;
import static bridge.constant.BridgeMove.UP;
import static bridge.constant.BridgeRange.MAX_LENGTH;
import static bridge.constant.BridgeRange.MIN_LENGTH;
import static bridge.constant.message.ExceptionMessage.*;
import static bridge.constant.message.InputMessage.PLAY_CONTROL;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeControllerTest extends NsTest {

    @Test
    @DisplayName("잘못된 입력이 들어왔을 때 다시 시도하고, 정상적인 값이 들어왔을 때 종료하는지 체크한다.")
    void 잘못된_입력_재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("0", "2j3", "5", "D", "Q");
            assertThat(output()).contains(
                    InputMessage.START.getMessage(),
                    InputMessage.BRIDGE_LENGTH.getMessage(),
                    String.format(BRIDGE_LENGTH_RANGE.getMessage(),
                            MIN_LENGTH.getNumber(), MAX_LENGTH.getNumber()),
                    BRIDGE_LENGTH_TYPE.getMessage(),
                    String.format(InputMessage.SELECT_MOVE.getMessage(), UP.getIdentifier(), DOWN.getIdentifier()),
                    "[   ]",
                    "[ X ]",
                    String.format(PLAY_CONTROL.getMessage(), RESTART.getIdentifier(), QUIT.getIdentifier()),
                    "최종 게임 결과",
                    "[   ]",
                    "[ X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}