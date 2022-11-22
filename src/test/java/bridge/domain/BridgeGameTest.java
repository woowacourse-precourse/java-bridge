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
    private Player player;

    @BeforeEach
    private void setUp() {
        bridgeGame = BridgeGame.from(List.of("U", "D", "D", "U", "D", "D", "U", "D"));
        player = new Player();
    }

    private void movePlayerFromDirectionString(String movingPath) {
        for (String movingDirection : movingPath.split("")) {
            Tile targetTile = Tile.findByDirectionSign(movingDirection);
            bridgeGame.move(player, targetTile);
        }
    }

    @ParameterizedTest(name = "이동 결과 테스트 [{index}] : {0}이동 - 성공 여부 {1}")
    @CsvSource(value = {"UDDUD,true", "UDDUU,false"})
    void moveTest(String movingPath, boolean expectedResult) {
        movePlayerFromDirectionString(movingPath);

        assertThat(player.isAlive()).isEqualTo(expectedResult);
    }

    @ParameterizedTest(name = "다리건너기 성공 여부 테스트 [{index}] : 성공여부 - {1}")
    @CsvSource(value = {"UDDUDDUD,true", "UDDUD,false"})
    void isWinTest(String movingPath, boolean expectedResult) {
        movePlayerFromDirectionString(movingPath);

        assertThat(bridgeGame.isWin(player)).isEqualTo(expectedResult);
    }

    @DisplayName("재시작시 위치 초기화 테스트")
    @Test
    void retryTest() {
        String movingPath = "UDDUDDUU";

        movePlayerFromDirectionString(movingPath);
        bridgeGame.retry(player);

        final int initialPosition = -1;
        assertThat(player.isCurrentPosition(initialPosition)).isTrue();
    }

    @ParameterizedTest(name = "다리게임 다리 타일 체크 테스트 [{index}] : 테스트 결과 반환 - {2}")
    @CsvSource(value = {"3,DOWN,false", "0,UP,true"})
    void checkBridgeTileAtTest(int positionIndex, Tile tile, boolean expectedResult) {
        assertThat(bridgeGame.checkBridgeTileAt(positionIndex, tile)).isEqualTo(expectedResult);
    }
}