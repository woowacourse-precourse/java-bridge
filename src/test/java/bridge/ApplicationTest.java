package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

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
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_길이_입력_예외상황() {
        assertSimpleTest(() -> {
            runException("13.");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("hello");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("25");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 이동방향_입력_예외상황() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateReadMoving("1"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.validateReadMoving("K"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시도_입력_예외상황() {
        InputView inputView = new InputView();
        assertThatThrownBy(() -> inputView.validateReadGameCommand("1"))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> inputView.validateReadGameCommand("K"))
            .isInstanceOf(IllegalArgumentException.class);
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
