package bridge.Domain;

import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private Player player;
    private GameResultGenerator gameResultGenerator;

    @BeforeEach
    void beforeEach() {
        List<String> makeBridge = List.of("U", "D", "D", "U", "D", "D", "U");
        Bridge bridge = new Bridge(makeBridge);
        this.player = new Player(bridge);
        this.gameResultGenerator = new GameResultGenerator();
        this.bridgeGame = new BridgeGame(player, gameResultGenerator);
    }

    public void moveSuccessBeforeTest() {
        String position = "U";
        bridgeGame.move(position);
    }

    public void moveFailBeforeTest() {
        String position = "D";
        bridgeGame.move(position);
    }

    @Nested
    @DisplayName("move 메소드 테스트")
    class TestMove {
        @Test
        @DisplayName("플레이어가 이동가능한 곳으로 움직일 경우 게임 결과는 Possible")
        void move_playerMoveToValidPosition_bridgeTypeIsPossible() {
            String position = "U";
            bridgeGame.move(position);

            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(bridgeGame).as("사용자 입력이 U일 때 BridgeType은 UP")
                    .extracting("gameResult").extracting("position").isEqualTo(BridgeType.UP);
            softAssertions.assertThat(bridgeGame).as("사용자가 다리 이동 성공한 경우 BridgeResultType은 POSSIBLE")
                    .extracting("gameResult").extracting("result").isEqualTo(BridgeResultType.POSSIBLE);
            softAssertions.assertAll();
        }

        @Test
        @DisplayName("플레이어가 이동 불가능한 곳으로 움직일 경우 게임 결과는 Impossible")
        void move_playerMoveToInvalidPosition_bridgeTypeIsImpossible() {
            String position = "D";
            bridgeGame.move(position);

            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(bridgeGame).as("사용자 입력이 D일 때 BridgeType은 DOWN")
                    .extracting("gameResult").extracting("position").isEqualTo(BridgeType.DOWN);
            softAssertions.assertThat(bridgeGame).as("사용자가 다리에서 떨어질 경우 BridgeResultType은 IMPOSSIBLE")
                    .extracting("gameResult").extracting("result").isEqualTo(BridgeResultType.IMPOSSIBLE);
            softAssertions.assertAll();
        }
    }

    @Nested
    @DisplayName("retry 메소드 테스트")
    class TestRetry {
        @Test
        @DisplayName("")
        void retry_gameStartCountIncrease() {
            bridgeGame.retry();
            final int expect = 2;
            assertThat(bridgeGame).extracting("gameStartCount").isEqualTo(expect);
        }

        @Test
        @DisplayName("플레이어 distance 초기화")
        void retry_initPlayerDistance() {
            bridgeGame.retry();
            final int expect = -1;
           assertThat(player).extracting("distance").isEqualTo(expect);
        }

        @Test
        @DisplayName("gameResultGenerator 게임 결과 초기화")
        void retry_initGameResultGeneratorBridge() {
            bridgeGame.retry();
            List<String> expect = List.of();

            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(gameResultGenerator)
                    .as("upperBridge 결과 초기화").extracting("upperBridge").isEqualTo(expect);
            softAssertions.assertThat(gameResultGenerator)
                    .as("lowerBridge 결과 초기화").extracting("lowerBridge").isEqualTo(expect);
            softAssertions.assertAll();
        }


    }

    @Nested
    @DisplayName("getBridgeStatusAfterMove 메소드 테스트")
    class TestGetBridgeStatusAfterMove {
        @Test
        @DisplayName("플레이어가 이동 성공 시 성공한 다리 상태 리턴")
        void getBridgeStatusAfterMove_positionIsValid_returnSuccessBridgeStatus() {
            moveSuccessBeforeTest();
            String expect = "[ O ]\n[   ]";
            String result = bridgeGame.getBridgeStatusAfterMove();
            assertThat(result).isEqualTo(expect);
        }

        @Test
        @DisplayName("플레이어가 이동 실패 시 실패한 다리 상태 리턴")
        void getBridgeStatusAfterMove_positionIsInvalid_returnFailBridgeStatus() {
            moveFailBeforeTest();
            String expect = "[   ]\n[ X ]";
            String result = bridgeGame.getBridgeStatusAfterMove();
            assertThat(result).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("isMoveSuccess 메소드 테스트")
    class TestIsMoveSuccess {
        @Test
        @DisplayName("플레이어가 이동 가능한 곳으로 움직인 경우 true 리턴")
        void isMoveSuccess_positionIsValid_returnTrue() {
            moveSuccessBeforeTest();
            boolean result = bridgeGame.isMoveSuccess();
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("플레이어가 이동 불가능한 곳으로 움직인 경우 false 리턴")
        void isMoveSuccess_positionIsInvalid_returnFalse () {
            moveFailBeforeTest();
            boolean result = bridgeGame.isMoveSuccess();
            assertThat(result).isFalse();
        }
    }
}