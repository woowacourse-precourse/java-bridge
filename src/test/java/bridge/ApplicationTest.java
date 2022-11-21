package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.service.BridgeGame;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

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
    void 예외_테스트_다리_길이에_음수를_입력할_때() {
        assertSimpleTest(() -> {
            runException("-1");
            assertThat(output()).contains("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        });
    }

    @Test
    void 예외_테스트_다리_길이가_int_범위를_넘어설_때() {
        assertSimpleTest(() -> {
            runException("11111111111");
            assertThat(output()).contains("[ERROR] 3이상 20 이하 숫자를 입력해주시오.");
        });
    }

    @Test
    void 예외_테스트_다리를_선택할_때_U_또는_D가_아닌_문자를_입력하는_경우() {
        assertSimpleTest(() -> {
            runException("5", "Q");
            assertThat(output()).contains("[ERROR] U, D 중에서 하나의 문자를 입력하시오.");
        });
    }

    @Test
    void 생성된_다리_사이즈() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(10);

        // then
        assertEquals(10, bridge.size());
    }

    @Test
    void 다리_이동_후_가장_최근에_건넌_다리_검사() {
        // given
        List<String> bridge = new ArrayList<>();
        bridge.add("U");

        // when
        bridgeGame.move("U", bridge);

        // then
        assertEquals(2, bridge.size());
        assertEquals("U", bridge.get(1));
    }

    @Test
    void 게임_진행_여부() {
        // given
        List<String> generatedBridge = new ArrayList<>();
        generatedBridge.add("U");
        generatedBridge.add("D");
        List<String> nowBridge = new ArrayList<>();
        nowBridge.add("U");
        nowBridge.add("U");

        // when
        boolean gameSuccess = bridgeGame.compareBridge(nowBridge, generatedBridge);

        // then
        assertEquals(false, gameSuccess);
    }

    @Test
    void 지금까지_건넌_다리_출력_화면() {
        // given
        List<String> nowBridge = List.of("U", "D", "U");
        List<String> generatedBridge = List.of("U", "D", "D");

        // when
        StringBuffer output = outputView.printMap(nowBridge, generatedBridge);

        // then
        assertEquals("[ O |   | X ]\n[   | O |   ]\n", output.toString());
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
