package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.util.Message;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 재시도_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "R","U","D");
            assertThat(output()).contains(
                    "[ O |   ]",
                    "[   | X ]",
                    Message.GAME_COMMAND_INPUT_MESSAGE
            );
        }, 1,1,0);
    }

    @Test
    void 중간_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "D","D","U","U","Q");
            assertThat(output()).contains("게임 성공 여부: 실패");
            int upSideIndex = output().indexOf("[   |   | O | X ]");
            int downSideIndex = output().indexOf("[ O | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 0,0,1,0);
    }

    @Test
    void gameCommand_재입력_반복_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "1","2","3","R","U","D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    Message.ILLEGAL_GAME_COMMAND_ERROR_MESSAGE,
                    Message.GAME_COMMAND_INPUT_MESSAGE
            );
        }, 1,1,0);
    }

    @Test
    void moveCommand_재입력_반복_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "1","2","3","U", "D","R","U","D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    Message.ILLEGAL_MOVE_REQUEST_ERROR_MESSAGE,
                    Message.MOVE_INPUT_MESSAGE
            );
        }, 1,1,0);
    }

    @Test
    void bridgeSize_재입력_반복_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run( "-100","1","2","3","U", "D","R","U","D");
            assertThat(output()).contains(
                    ERROR_MESSAGE,
                    Message.ILLEGAL_BRIDGE_SIZE_ERROR_MESSAGE,
                    Message.BRIDGE_SIZE_INPUT_MESSAGE
            );
        }, 1,1,0);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
