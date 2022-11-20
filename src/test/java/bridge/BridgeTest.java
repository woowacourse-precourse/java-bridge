package bridge;

import bridge.model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {
    @Nested
    class BridgeMakerTest {
        @Test
        @DisplayName("다리 정보 String List 생성 테스트")
        void bridgeMakerTest() {
            List<String> bridge = makeBridgeInfo(newArrayList(1, 0, 0));
            assertThat(bridge).containsExactly("U", "D", "D");
        }
    }

    @Nested
    class BridgeStateTest {
        @Test
        @DisplayName("다리 길이 테스트")
        void bridgeLengthTest() {
            Bridge bridge = makeBridge(newArrayList(1, 0, 1, 0, 0));

            int expectedBridgeLength = 5;
            assertThat(bridge.getBridgeLength()).isEqualTo(expectedBridgeLength);
        }

        @Test
        @DisplayName("다리 안전한 칸 테스트")
        void bridgeSafetyTest() {
            Bridge bridge = makeBridge(newArrayList(1, 0, 0, 1, 1));

            boolean expectedSafety = true;
            assertThat(bridge.isSafeSpot(4, SpotInfo.FIRST)).isEqualTo(expectedSafety);
        }
    }

    @Nested
    class MovementRecordTest {
        @Test
        @DisplayName("이동 기록 길이 테스트")
        void movementCountTest() {
            MovementRecord movementRecord = new MovementRecord();

            movementRecord.addMovementRecord(SpotInfo.FIRST);
            movementRecord.addMovementRecord(SpotInfo.FIRST);
            movementRecord.addMovementRecord(SpotInfo.FIRST);
            movementRecord.addMovementRecord(SpotInfo.FIRST);

            int expectedCount = 4;
            assertThat(movementRecord.getMovementCount()).isEqualTo(expectedCount);
        }

        @Test
        @DisplayName("이동 기록 테스트")
        void movementRecordTest() {
            MovementRecord movementRecord = new MovementRecord();

            movementRecord.addMovementRecord(SpotInfo.FIRST);
            movementRecord.addMovementRecord(SpotInfo.SECOND);
            movementRecord.addMovementRecord(SpotInfo.SECOND);
            movementRecord.addMovementRecord(SpotInfo.FIRST);

            SpotInfo expectedCount = SpotInfo.SECOND;
            assertThat(movementRecord.getMovementRecord(3)).isEqualTo(expectedCount);
        }
    }

    @Nested
    class BridgeGameTest {
        @Test
        @DisplayName("안전한 칸으로 이동하면 true를 반환한다.")
        void moveTest1() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0, 1, 0, 0, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);

            boolean expectedOutput = true;
            assertThat(game.move(SpotInfo.FIRST)).isEqualTo(expectedOutput);
        }

        @Test
        @DisplayName("안전하지 않은 칸으로 이동하면 false를 반환한다.")
        void moveTest2() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0, 1, 0, 0, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.FIRST);

            boolean expectedOutput = false;
            assertThat(game.move(SpotInfo.FIRST)).isEqualTo(expectedOutput);
        }

        @Test
        @DisplayName("retry를 하면 시작점으로 돌아간다.")
        void moveAfterRetryTest() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0, 1, 0, 0, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);
            game.retry();

            boolean expectedOutput = false;
            assertThat(game.move(SpotInfo.FIRST)).isEqualTo(expectedOutput);
        }

        @Test
        @DisplayName("retry를 한 만큼 시도 횟수가 카운팅 된다.")
        void tryCountTest() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0, 1, 0, 0, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.FIRST);
            game.retry();
            game.move(SpotInfo.FIRST);

            int expectedTryCount = 2;
            assertThat(game.getResult().getTryCount()).isEqualTo(expectedTryCount);
        }

        @Test
        @DisplayName("최종 지점에 도달하지 않으면 결과의 상태가 success가 되지 않는다.")
        void isNotSuccessTest() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0, 1, 0, 0, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.FIRST);

            boolean expectedSuccess = false;
            assertThat(game.getResult().isSuccess()).isEqualTo(expectedSuccess);
        }

        @Test
        @DisplayName("안전하지 않은 칸으로 가면 결과의 상태가 success가 되지 않는다.")
        void isNotSuccessTest2() {
            Bridge bridge = makeBridge(newArrayList(1, 1, 0));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);

            boolean expectedSuccess = false;
            assertThat(game.getResult().isSuccess()).isEqualTo(expectedSuccess);
        }

        @Test
        @DisplayName("안전한 칸으로 가면 결과의 상태가 success가 된다.")
        void isSuccessTest() {
            Bridge bridge = makeBridge(newArrayList(1, 1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.SECOND);
            game.move(SpotInfo.SECOND);

            boolean expectedSuccess = true;
            assertThat(game.getResult().isSuccess()).isEqualTo(expectedSuccess);
        }

        @Test
        @DisplayName("retry를 하면 최근 이동 기록이 초기화 된다.")
        void lastMovementTest() {
            Bridge bridge = makeBridge(newArrayList(1));
            BridgeGame game = new BridgeGame(bridge);

            game.move(SpotInfo.FIRST);
            game.retry();
            game.move(SpotInfo.SECOND);

            SpotInfo expectedSpotInfo = SpotInfo.SECOND;
            assertThat(game.getResult().getLastMovementRecord(1)).isEqualTo(expectedSpotInfo);
        }
    }

    private Bridge makeBridge(List<Integer> bridgeInfo) {
        List<String> stringBridgeInfo = makeBridgeInfo(bridgeInfo);
        return new Bridge(stringBridgeInfo);
    }

    private List<String> makeBridgeInfo(List<Integer> bridgeInfo) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridgeInfo);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(bridgeInfo.size());
    }
}
