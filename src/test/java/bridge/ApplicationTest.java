package bridge;

import static bridge.domain.BridgeMap.LOSE;
import static bridge.domain.BridgeMap.WIN;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import bridge.controller.BridgeController;
import bridge.exception.BridgeException;
import bridge.service.BridgeGame;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeController bridgeController = new BridgeController();
    private final OutputView outputView = new OutputView();
    private final BridgeException bridgeException = new BridgeException();

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

    // 예외처리 테스트
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
    void 예외_테스트_게임_재시작_여부_R_또는_Q가_아닌_문자를_입력하는_경우() {
        assertThatThrownBy(() -> {
            bridgeException.gameCommandException("G");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] R, Q 중에서 하나의 문자를 입력하시오.");
    }


    // 게임 서비스 동작 확인
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
    void 게임_재시작() {
        // given
        List<String> nowBridge = new ArrayList<>();
        nowBridge.add("U");

        // when
        boolean result = bridgeGame.retry(nowBridge, "R");

        // then
        assertEquals(true, result);
    }

    @Test
    void 게임_승리_여부() {
        // given
        List<String> nowBridge = List.of("U", "D", "D");
        List<String> generatedBridge = List.of("U", "D", "D");

        // when
        String result = bridgeGame.isGameWin(nowBridge, generatedBridge);

        // then
        assertEquals(WIN.getElement(), result);
    }

    @Test
    void 정답_판별() {
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

    // 출력 기능 동작 확인
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

    @Test
    void 게임_최종_결과_화면() {
        // given
        List<String> nowBridge = List.of("U", "D", "U");
        List<String> generatedBridge = List.of("U", "D", "D");

        // when
        StringBuffer bridgeScreen = bridgeController.printMapController(nowBridge, generatedBridge);
        String output = outputView.printResult(2, bridgeScreen, LOSE.getElement());

        // then
        assertEquals("최종 게임 결과\n" + "[ O |   | X ]\n[   | O |   ]\n"
                + "\n" + "게임 성공 여부: 실패\n" + "총 시도한 횟수: 2", output);
    }


    // 랜덤 다리 생성 사이즈 확인

    @Test
    void 생성된_다리_사이즈() {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> bridge = bridgeMaker.makeBridge(10);

        // then
        assertEquals(10, bridge.size());
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
