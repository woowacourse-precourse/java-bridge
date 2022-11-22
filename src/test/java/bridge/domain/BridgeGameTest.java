package bridge.domain;

import bridge.utils.MapType;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private List<String> bridge;
    private BridgeGame bridgeGame;
    private int cnt;
    private int currentLocation;

    @BeforeEach
    void setUp() {
        bridge = new ArrayList<>(List.of("U", "D", "U"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("게임실행횟수와 다리 길이가 맞지 않으면 false 가 반환된다.")
    @Test
    void isFinishWithAllCollectTest() {
        cnt = 2;
        boolean finishWithAllCollect = bridgeGame.isFinishWithAllCollect();
        Assertions.assertThat(finishWithAllCollect).isFalse();
    }

    @DisplayName("사용자 입력값과 다리 현재 위치 정답이 일치하면 true 가 반환된다.")
    @Test
    void isCorrectTest() {
        String movingValue = "U";
        currentLocation = 1;
        boolean isCorrect = bridgeGame.isCorrect(movingValue);
        Assertions.assertThat(isCorrect).isTrue();
    }

    @DisplayName("사용자 입력값과 이동 후 결과값을 받아 MapType 을 추출한다.")
    @Test
    void findMapType() {
        String movingValue = "U";
        boolean moveResult = true;
        MapType mapType = bridgeGame.findMapType(movingValue, moveResult);
        Assertions.assertThat(mapType).isEqualTo(MapType.U_O);
    }

    @DisplayName("재시작 커맨드에 Q를 입력하면 false 가 출력되어 종료한다.")
    @Test
    void retry() {
        String tryCommand = "Q";
        boolean isRetry = bridgeGame.retry(tryCommand);
        Assertions.assertThat(isRetry).isFalse();
    }
}