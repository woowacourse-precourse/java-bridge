package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @DisplayName("다음 위치가 이동할 수 있는 다리 칸인지 확인 ")
    @Test
    void move() {
        BridgeGame bridgeGame = bridgeGameGenerate(List.of("U", "D", "D"));
        String direct = "U";
        assertThat(bridgeGame.move(direct)).isTrue();
    }

    @DisplayName("다리의 결과값이 조건에 따라 저장이 되는지 확인")
    @Test
    void 다리_결과값_저장_테스트() {
        BridgeGame bridgeGame = bridgeGameGenerate(List.of("U", "D", "D"));
        List<String> direct = List.of("U", "D", "U");
        bridgeMarkGenerate(bridgeGame, direct);
        assertThat(bridgeGame.getBridgeMap()).containsExactly(List.of("O", " ", "X"), List.of(" ", "O", " "));
    }

    @DisplayName("다리 게임 재시도 시 이전 다리 결과값이 되는지 확인")
    @Test
    void 다리_게임_재시도_다리_결과값_테스트() {
        BridgeGame bridgeGame = bridgeGameGenerate(List.of("U", "D", "D"));
        List<String> direct = List.of("U", "D", "U");
        bridgeMarkGenerate(bridgeGame, direct);
        bridgeGame.retry();
        assertThat(bridgeGame.getBridgeMap()).containsExactly(List.of("O", " "), List.of(" ", "O"));
    }

    private BridgeGame bridgeGameGenerate(List<String> bridge) {
        return new BridgeGame(bridge);
    }

    private void bridgeMarkGenerate(BridgeGame bridgeGame, List<String> direct) {
        List<Boolean> result = moveResultGenerate(bridgeGame, direct);

        for (int i = 0; i < result.size(); i++) {
            bridgeGame.bridgeMark(direct.get(i), result.get(i));
        }
    }

    private List<Boolean> moveResultGenerate(BridgeGame bridgeGame, List<String> direct) {
        List<Boolean> result = new ArrayList<>();

        for (String d : direct) {
            boolean move = bridgeGame.move(d);
            result.add(move);
        }
        return result;
    }
}