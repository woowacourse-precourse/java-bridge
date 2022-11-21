package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    @BeforeEach
    void beforeEach() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker, 5);
    }

    @DisplayName("빈 다리를 초기화 후 상태를 검증한다.")
    @Test
    void 빈_다리_초기화_후_상태_검증() {
        // given
        List<List<String>> side = new ArrayList<>();

        // when
        int bridgeSize = bridgeGame.initBridgeStatus(side).size();

        // then
        assertThat(bridgeSize).isEqualTo(2);
    }

    @DisplayName("다리 내의 내용을 모두 삭제했을 때의 상태를 검증한다.")
    @Test
    void 다리_내용_삭제_후_상태_검증() {
        // given
        List<List<String>> side = new ArrayList<>();

        // when
        bridgeGame.initBridgeStatus(side);
        side.get(0).add("O");
        side.get(1).add(" ");

        // then
        assertThat(bridgeGame.clearMap(side)).isEmpty();
    }
}
