package bridge.model;

import bridge.model.dto.GameResultDto;
import bridge.model.dto.MapDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void setUp() {
        bridgeGame.start(3);
    }

    @DisplayName("이동 가능 여부 판단 기능 테스트")
    @Test
    void isMovableTest() {
        boolean result = bridgeGame.isMovable("U");
        Assertions.assertThat(result).isIn(true, false);
    }

    @DisplayName("게임 결과 도출 기능 테스트")
    @Test
    void finishTest() {
        GameResultDto successResult = bridgeGame.finish(true);
        Assertions.assertThat(successResult).isNotNull();
        Assertions.assertThat(successResult.getMapData()).isInstanceOf(MapDto.class);
        Assertions.assertThat(successResult.getTotalTrials()).isEqualTo(1);
        Assertions.assertThat(successResult.getTotalResult()).isEqualTo("성공");

        GameResultDto failResult = bridgeGame.finish(false);
        Assertions.assertThat(failResult.getTotalResult()).isEqualTo("실패");
    }

    @Test
    void createMapTest() {
        Assertions.assertThat(bridgeGame.createMap()).isInstanceOf(MapDto.class);
    }
}