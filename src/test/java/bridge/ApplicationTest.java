package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.model.Bridge;
import bridge.domain.model.GameResultInformation;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach
    void resetAll() throws NoSuchFieldException, IllegalAccessException {
        resetBridge();
        resetBridgeCreated();
        resetCountOfRetry();
    }

    void resetBridge() throws NoSuchFieldException, IllegalAccessException {
        Bridge bridgeInstance = new Bridge();
        Field bridge = Bridge.class.getDeclaredField("bridge");

        bridge.setAccessible(true);
        bridge.set(bridgeInstance, new ArrayList<>());
        bridge.setAccessible(false);
    }

    void resetBridgeCreated() throws NoSuchFieldException, IllegalAccessException {
        Bridge bridgeInstance = new Bridge();
        Field bridgeCreated = Bridge.class.getDeclaredField("bridgeCreated");

        bridgeCreated.setAccessible(true);
        bridgeCreated.set(bridgeInstance, false);
        bridgeCreated.setAccessible(false);
    }

    void resetCountOfRetry() throws NoSuchFieldException, IllegalAccessException {
        GameResultInformation gameResultInformation = new GameResultInformation();
        Field countOfRetry = GameResultInformation.class.getDeclaredField("countOfTry");

        countOfRetry.setAccessible(true);
        countOfRetry.set(gameResultInformation, 1);
        countOfRetry.setAccessible(false);
    }
}
