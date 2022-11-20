package bridge.game;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest extends NsTest {

    private static BridgeGame bridgeGame;
    private static List<String> bridge;
    private static final int bridgeLength = 2;

    @BeforeEach
    void makeBridge() throws IllegalArgumentException {
        bridgeGame = new BridgeGame();
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(BridgeGame.BridgeShape.DOWN.getIntegerValue(), BridgeGame.BridgeShape.DOWN.getIntegerValue()));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridgeAnswer(bridge);
    }

    /**
     * move - 사용자 위치 이동
     */
    @DisplayName("사용자의 이동 위치 저장 테스트 - 아래 칸")
    @Test
    void move_down_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        assertThat(bridgeGame.getBridge_userMove()).containsExactly("D");
    }

    @DisplayName("사용자의 이동 위치 저장 테스트 - 위 칸")
    @Test
    void move_up_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.UP.getStringValue());
        assertThat(bridgeGame.getBridge_userMove()).containsExactly("U");
    }

    /**
     * checkIfGameIsSucceed - 게임 성공 유무 확인
     */
    @DisplayName("게임 성공 확인 테스트")
    @Test
    void checkIfGameIsSucceed_success_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        assertThat(true).isEqualTo(bridgeGame.checkIfGameIsSucceed(bridgeLength));
    }

    @DisplayName("게임 미성공 확인 테스트")
    @Test
    void checkIfGameIsSucceed_not_seccess_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        bridgeGame.move(BridgeGame.BridgeShape.UP.getStringValue());
        assertThat(false).isEqualTo(bridgeGame.checkIfGameIsSucceed(bridgeLength));
    }

    /**
     * checkIfGameIsFailed - 게임 실패 유무 확인
     */
    @DisplayName("게임 실패 확인 테스트")
    @Test
    void checkIfGameIsFailed_fail_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        bridgeGame.move(BridgeGame.BridgeShape.UP.getStringValue());
        assertThat(true).isEqualTo(bridgeGame.checkIfGameIsFailed(bridgeLength));
    }

    @DisplayName("게임 미실패 확인 테스트")
    @Test
    void checkIfGameIsFailed_not_fail_테스트() {
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        bridgeGame.move(BridgeGame.BridgeShape.DOWN.getStringValue());
        assertThat(false).isEqualTo(bridgeGame.checkIfGameIsFailed(bridgeLength));
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
