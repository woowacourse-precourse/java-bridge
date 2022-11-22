package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalResultTest {

    private static final BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"), 1);
    private static final PlayerMap playerMap1 = new PlayerMap(
            List.of("O", " ", "X"),
            List.of(" ", "O", " ")
    );

    private static final PlayerMap playerMap2 = new PlayerMap(
            List.of("O", " "),
            List.of(" ", "O")
    );

    private static final PlayerMap playerMap3 = new PlayerMap(
            List.of("O", " ", " "),
            List.of(" ", "O", "O")
    );

    @DisplayName("이동한 칸을 건널 수 없다면 true를 반환한다")
    @Test
    void loseGameTest() {
        TotalResult result = new TotalResult(bridgeGame, playerMap1);
        assertThat(result.loseGame()).isTrue();
    }

    @DisplayName("이동한 칸을 건널 수 있다면 false를 반환한다")
    @Test
    void notLoseGameTest() {
        TotalResult result = new TotalResult(bridgeGame, playerMap2);
        assertThat(result.loseGame()).isFalse();
    }


    @DisplayName("다리를 끝까지 건너면 true를 반환한다")
    @Test
    void winGameTest() {
        TotalResult result = new TotalResult(bridgeGame, playerMap3);
        assertThat(result.winGame()).isTrue();
    }

    @DisplayName("다리 끝까지 이동했지만 건널 수 없다면 false를 반환한다")
    @Test
    void notWinGameTest1() {
        TotalResult result = new TotalResult(bridgeGame, playerMap1);
        assertThat(result.winGame()).isFalse();
    }

    @DisplayName("이동한 칸을 건널 수 있지만 다리 끝까지 이동하지 않았다면 false를 반환한다")
    @Test
    void notWinGameTest2(){
        TotalResult result = new TotalResult(bridgeGame, playerMap2);
        assertThat(result.winGame()).isFalse();
    }

    @DisplayName("총 시도 횟수를 반환한다")
    @Test
    void getTryCntTest() {
        TotalResult result = new TotalResult(bridgeGame, playerMap1);
        assertThat(result.getTryCnt()).isEqualTo(1);
    }
}
