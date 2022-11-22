package bridge.domain;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private static BridgeGame bridgeGame;

    @DisplayName("이동 시 올바른 값을 저장한다.")
    @Test
    void move_테스트() {
        bridgeGame = new BridgeGame(3);
        bridgeGame.bridge = Arrays.asList("U", "D", "U");
        for (String e : Arrays.asList("U", "D", "D")) {
            bridgeGame.movingInput = e;
            bridgeGame.move(3);
        }
        assertEquals(bridgeGame.upSide.upSideArr, Arrays.asList("O", " ", " "));
        assertEquals(bridgeGame.downSide.downSideArr, Arrays.asList(" ", "O", "X"));
    }

    @DisplayName("재시도 선택 시 객체를 초기화한다.")
    @Test
    void retry_테스트() {
        bridgeGame.upSide.upSideArr.add("U");
        bridgeGame.downSide.downSideArr.add(" ");
        bridgeGame.retry();
        assertEquals(bridgeGame.upSide.upSideArr.size(), 0);
        assertEquals(bridgeGame.downSide.downSideArr.size(), 0);
    }

    @DisplayName("재시도 선택 시 변수 값을 변화한다.")
    @Test
    void retry_테스트2() {
        bridgeGame.movingCount = 3;
        Application.totalTrial = 6;
        bridgeGame.retry();
        assertEquals(bridgeGame.movingCount, 0);
        assertEquals(Application.totalTrial, 7);
    }

    @DisplayName("정답 시 결과가 객체에 올바르게 입려되는지 확인")
    @Test
    void rightWayMove_테스트() {
        bridgeGame = new BridgeGame(3);
        bridgeGame.bridge = Arrays.asList("U", "D", "U");
        for (String e : bridgeGame.bridge) {
            bridgeGame.movingInput = e;
            bridgeGame.rightWayMove();
        }
        assertEquals(bridgeGame.upSide.upSideArr, Arrays.asList("O", " ", "O"));
        assertEquals(bridgeGame.downSide.downSideArr, Arrays.asList(" ", "O", " "));
    }

    @DisplayName("오답 시 결과가 객체에 올바르게 입려되는지 확인")
    @Test
    void wrongWayMove_테스트() {
        bridgeGame = new BridgeGame(3);
        bridgeGame.bridge = Arrays.asList("U", "D", "U");
        bridgeGame.movingInput = "D";
        bridgeGame.wrongWayMove();
        assertEquals(bridgeGame.upSide.upSideArr, Arrays.asList(" "));
        assertEquals(bridgeGame.downSide.downSideArr, Arrays.asList("X"));
    }

    @DisplayName("정답 시 True 를 반환한다.")
    @Test
    void isRightWay_테스트() {
        bridgeGame = new BridgeGame(3);
        bridgeGame.bridge = Arrays.asList("U", "D", "U");
        bridgeGame.movingInput = "U";
        assertTrue(bridgeGame.isRightWay());
    }

    @DisplayName("오답 시 True 를 반환한다.")
    @Test
    void isWrongWay_테스트() {
        bridgeGame = new BridgeGame(3);
        bridgeGame.bridge = Arrays.asList("U", "D", "U");
        bridgeGame.movingInput = "D";
        assertTrue(bridgeGame.isWrongWay());
    }

    @DisplayName("다리를 생성하는 지 확인한다.")
    @Test
    void createBridge_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame.bridge = bridgeMaker.makeBridge(4);
        assertThat(bridgeGame.bridge).containsExactly("D", "U", "U", "U");
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