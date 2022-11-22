package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    private BridgeNumberGenerator numberGenerator;
    private BridgeMaker bridgeMaker;
    private List<String> bridge;
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(3);
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("다리 이동 결과를 올바르게 구하는지 테스트")
    @ParameterizedTest
    @CsvSource("0, U, true, 0, D, false")
    public void 다리_이동_결과_테스트(int index, String moving, boolean expected) {
        boolean actual = bridgeGame.move(index, moving);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("시도 횟수가 올바르게 증가하는지 테스트")
    @Test
    void 총_시도_횟수_증가_테스트() {
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
    }

    @DisplayName("게임 결과가 올바르게 초기화 되는지 테스트")
    @Test
    void 현재_게임_결과_초기화_테스트() {
        bridgeGame.move(0, "D");
        bridgeGame.move(1, "D");
        bridgeGame.retry();
        assertThat(bridgeGame.getResults().size()).isEqualTo(0);
    }
}
