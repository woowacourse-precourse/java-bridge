package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private Bridge basicBridge;

    @BeforeEach
    private void setUp() {
        bridgeGame = new BridgeGame();
        basicBridge = Bridge.from(List.of("U", "D", "D", "U", "D", "D", "U", "D"));
    }

    @ParameterizedTest(name = "이동 결과 테스트 [{index}] : {0}이동 - 성공 여부 {1}")
    @CsvSource(value = {"UDDUD,true", "UDDUU,false"})
    void moveTest(String movingPath, boolean expectedResult) {

        Player player = new Player();
        boolean actualResult = false;

        for (String movingDirection : movingPath.split("")) {
            BridgeTile targetTile = BridgeTile.findByTilePosition(movingDirection);
            actualResult = bridgeGame.move(basicBridge, player, targetTile);
        }

        assertThat(actualResult).isEqualTo(expectedResult);
    }

}