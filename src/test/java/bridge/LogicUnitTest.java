package bridge;

import static bridge.Constant.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.BridgeGame.MoveResult;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LogicUnitTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 기능_BridgeGame_move() {
        List<String> bridge = newArrayList("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        MoveResult moveResult = bridgeGame.move("U");
        moveResult = bridgeGame.move("D");
        moveResult = bridgeGame.move("D");
        assertThat(moveResult.nowBridge.toString()).isEqualTo("[U, D, D]");
        assertThat(moveResult.flag).isEqualTo(0);
    }

    @Test
    void 기능_BridgeGame_retry() {
        List<String> bridge = newArrayList("U", "D", "U");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int retryFlag = bridgeGame.retry("R");
        assertThat(retryFlag).isEqualTo(1);
    }

    @Test
    void 기능_Application_playGame() {
        List<String> bridge = newArrayList("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame(bridge);
        System.setIn(new ByteArrayInputStream("U\nD\nU".getBytes()));
        Application application = new Application();
        MoveResult playResult = application.playGame(bridgeGame);
        assertThat(playResult.flag).isEqualTo(MOVERESULT_FLAG_INVALID);
        assertThat(playResult.nowBridge.toString()).isEqualTo("[U, D, U]");
    }

    @Test
    void 기능_OutputView_printMap() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));
        bridgeGame.move("U");
        bridgeGame.move("D");
        MoveResult moveResult = bridgeGame.move("U");
        OutputView outputView = new OutputView();
        outputView.printMap(moveResult);
        assertThat(output()).contains("[ O |   | X ]\n[   | O |   ]");
    }

//    @Test
//    void 기능_Application_startGame() {
//        assertRandomNumberInRangeTest(() -> {
//            run("3", "U", "D", "U");
//            assertThat(output()).contains(
//                    "최종 게임 결과",
//                    "[ O |   | O ]",
//                    "[   | O |   ]",
//                    "게임 성공 여부: 성공",
//                    "총 시도한 횟수: 1"
//            );
//
//            int upSideIndex = output().indexOf("[ O |   | O ]");
//            int downSideIndex = output().indexOf("[   | O |   ]");
//            assertThat(upSideIndex).isLessThan(downSideIndex);
//        }, 1, 0, 1);
//    }

    @Test
    void 예외_다리길이_숫자아닌경우() {
            InputView inputView = new InputView();
            System.setIn(new ByteArrayInputStream("3".getBytes()));
            int test = inputView.handleCheckLengthValidate("a");
            assertThat(output()).contains(ERROR_MESSAGE);
    }

//    @ValueSource(strings = {"a", "U", "D", "Q"})
//    @ParameterizedTest
//    void 다리길이_숫자아니면_예외처리() {
//        assertSimpleTest(() -> {
//            runReadBridgeSizeTest(input);
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }

    @Test
    void 예외_다리길이_3미만_20초과() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("3".getBytes()));
        int test = inputView.handleCheckLengthRangeValidate(21);
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    void 예외_이동_UorD_아닌경우() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("U".getBytes()));
        String test = inputView.handleCheckMoveValidate("E");
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    void 예외_재시작_RorQ아닌경우() {
        InputView inputView = new InputView();
        System.setIn(new ByteArrayInputStream("R".getBytes()));
        String test = inputView.handleCheckGameCommandValidate("E");
        assertThat(output()).contains(ERROR_MESSAGE);
    }

//    private void runReadBridgeSizeTest(final Object args) {
//        System.setIn(new ByteArrayInputStream("a".getBytes()));
//        InputView inputView = new InputView();
//        System.out.println(inputView.readBridgeSize());
//    }


//    protected final void runStartGameTest(final String... args) {
//        command(args);
//        runStartGame();
//    }
//
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
