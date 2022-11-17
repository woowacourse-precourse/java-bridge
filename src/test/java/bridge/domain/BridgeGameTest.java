package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private Bridge basicBridge;
    private Player player;

    @BeforeEach
    private void setUp() {
        bridgeGame = new BridgeGame();
        basicBridge = Bridge.from(List.of("U", "D", "D", "U", "D", "D", "U", "D"));
        player = new Player();
    }

    @ParameterizedTest(name = "이동 결과 테스트 [{index}] : {0}이동 - 성공 여부 {1}")
    @CsvSource(value = {"UDDUD,true", "UDDUU,false"})
    void moveTest(String movingPath, boolean expectedResult) {

        boolean actualResult = false;

        for (String movingDirection : movingPath.split("")) {
            BridgeTile targetTile = BridgeTile.findByTilePosition(movingDirection);
            actualResult = bridgeGame.move(basicBridge, player, targetTile);
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "다리건너기 성공 여부 테스트 [{index}] : 성공여부 - {1}")
    @CsvSource(value = {"UDDUDDUD,true", "UDDUD,false"})
    void isWinTest(String movingPath, boolean expectedResult) {

        for (String movingDirection : movingPath.split("")) {
            BridgeTile targetTile = BridgeTile.findByTilePosition(movingDirection);
            bridgeGame.move(basicBridge, player, targetTile);
        }

        assertThat(bridgeGame.isWin(basicBridge, player)).isEqualTo(expectedResult);
    }

    @DisplayName("재시작시 위치 초기화 테스트")
    @Test
    void retryTest() {
        String movingPath = "UDDUDDUD";

        for (String movingDirection : movingPath.split("")) {
            BridgeTile targetTile = BridgeTile.findByTilePosition(movingDirection);
            bridgeGame.move(basicBridge, player, targetTile);
        }
        bridgeGame.retry(player);

        assertThat(bridgeGame.isWin(basicBridge, player)).isFalse();
    }
}