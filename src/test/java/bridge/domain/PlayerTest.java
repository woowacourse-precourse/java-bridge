package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    private Player player;

    @BeforeEach
    private void setup() {
        player = new Player();
    }

    @ParameterizedTest(name = "이동 후 위치 확인 테스트 [{index}] : 확인 결과 - {2}")
    @CsvSource(value = {"3,2,true", "4,4,false"})
    void moveTest(int movingTime, int expectedPosition, boolean expectedResult) {
        for (int i = 0; i < movingTime; i++) {
            player.moveForward(Tile.UP);
        }

        assertThat(player.isCurrentPosition(expectedPosition)).isEqualTo(expectedResult);
    }

    @DisplayName(value = "사망 후 부활처리 후 위치 초기화 테스트")
    @Test
    void dieTest() {
        for (int i = 0; i < 4; i++) {
            player.moveForward(Tile.UP);
        }
        player.die();
        player.resurrect();

        assertThat(player.isCurrentPosition(-1)).isTrue();
    }

    @DisplayName(value = "이동 기록 확인 테스트")
    @Test
    void movingLogTest() {
        player.moveForward(Tile.UP);
        player.moveForward(Tile.DOWN);
        player.moveForward(Tile.UP);

        assertThat(player.getPassedTileLogOf(1)).isEqualTo(Tile.DOWN);
    }

    @DisplayName(value = "시도 횟수 확인 테스트")
    @Test
    void tryCuntTest() {
        int dieCount = 3;
        for (int i = 0; i < dieCount; i++) {
            player.die();
            player.resurrect();
        }
        int expectedTryCount = dieCount + 1;

        assertThat(player.getTryCount()).isEqualTo(expectedTryCount);
    }

}