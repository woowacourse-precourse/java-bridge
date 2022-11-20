package bridge.controller;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameControllerTest extends NsTest {

    private BridgeGameController gameController;
    public final String ERROR_PREFIX = "[ERROR] ";

    @BeforeEach
    void setup(){
        gameController = new BridgeGameController();
    }

    @DisplayName("입력받은 다리 길이가 숫자가 아닌 경우")
    @ParameterizedTest
    @ValueSource(strings = {"a", "A", " ", "aaa", "\r\n"})
    void bridgeSizeErrorTest(String bridgeSize){
        assertSimpleTest(() -> {
            runException(bridgeSize);
            assertThat(output()).contains(ERROR_PREFIX);
        });
    }


    @Override
    protected void runMain() {
        gameController.start();
    }

//    public static class Error {
//
//        public static final String BRIDGE_SIZE_ERROR_MESSAGE = ERROR_PREFIX + "다리 길이가 3이상 20이하의 값이 아닙니다.";
//        public static final String MOVE_DIRECTION_ERROR_MESSAGE = ERROR_PREFIX + "입력값이 U 또는 D가 아닙니다.";
//        public static final String RETRY_ERROR_MESSAGE = ERROR_PREFIX + "입력값이 R 또는 Q가 아닙니다.";
//        public static final String INPUT_VALUE_FORMAT_ERROR_MESSAGE = ERROR_PREFIX + "입력받은 값이 숫자 형태가 아닙니다.";
//    }
}