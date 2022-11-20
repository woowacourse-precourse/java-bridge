package bridge;

import bridge.model.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.ArrayList;
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
            Bridge bridge = new Bridge(makeBridgeInfo(newArrayList(1, 0, 1, 0, 0)));

            int expectedBridgeLength = 5;
            assertThat(bridge.getBridgeSize()).isEqualTo(expectedBridgeLength);
        }

        @Test
        @DisplayName("다리 안전한 칸 테스트")
        void bridgeSafetyTest() {
            Bridge bridge = new Bridge(makeBridgeInfo(newArrayList(1, 0, 0, 1, 1)));

            boolean expectedSafety = true;
            assertThat(bridge.isSafeSpot(3, BridgeLane.DOWN)).isEqualTo(expectedSafety);
        }
    }

    @Nested
    class MovementRecordTest {
        @Test
        @DisplayName("이동 기록 길이 테스트")
        void movementCountTest() {
            MovementRecord movementRecord = new MovementRecord();

            movementRecord.addMovementRecord(BridgeLane.UP);
            movementRecord.addMovementRecord(BridgeLane.UP);
            movementRecord.addMovementRecord(BridgeLane.UP);
            movementRecord.addMovementRecord(BridgeLane.UP);

            int expectedCount = 4;
            assertThat(movementRecord.getMovementCount()).isEqualTo(expectedCount);
        }

        @Test
        @DisplayName("이동 기록 테스트")
        void movementRecordTest() {
            MovementRecord movementRecord = new MovementRecord();

            movementRecord.addMovementRecord(BridgeLane.UP);
            movementRecord.addMovementRecord(BridgeLane.DOWN);
            movementRecord.addMovementRecord(BridgeLane.DOWN);
            movementRecord.addMovementRecord(BridgeLane.UP);

            BridgeLane expectedCount = BridgeLane.DOWN;
            assertThat(movementRecord.getMovementRecord(3)).isEqualTo(expectedCount);
        }
    }

    @Nested
    class BridgeGameTest {
        @Test
        @DisplayName("안전한 칸으로 이동하면 true를 반환한다.")
        void moveTest1() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0, 1, 0, 0, 1)));

            List<BridgeLane> moveSequence = newArrayList(BridgeLane.UP, BridgeLane.UP);
            moveSequentially(game, moveSequence);
            assertThat(getMoveRecord(game)).isEqualTo(moveSequence);
        }

        @Test
        @DisplayName("안전하지 않은 칸으로 이동하면 false를 반환한다.")
        void moveTest2() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0, 1, 0, 0, 1)));

            List<BridgeLane> moveSequence = newArrayList(BridgeLane.UP, BridgeLane.UP, BridgeLane.DOWN);
            moveSequentially(game, moveSequence);
            assertThat(getMoveRecord(game)).isEqualTo(moveSequence);
        }

        @Test
        @DisplayName("retry를 하면 시작점으로 돌아간다.")
        void moveAfterRetryTest() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0, 1, 0, 0, 1)));

            List<BridgeLane> moveSequence = newArrayList(BridgeLane.UP, BridgeLane.UP);
            moveSequentially(game, moveSequence);
            game.retry();
            game.move(BridgeLane.DOWN);

            assertThat(getMoveRecord(game)).isEqualTo(newArrayList(BridgeLane.DOWN));
        }

        @Test
        @DisplayName("retry를 한 만큼 시도 횟수가 카운팅 된다.")
        void tryCountTest() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0, 1, 0, 0, 1)));

            game.move(BridgeLane.DOWN);
            game.retry();
            game.move(BridgeLane.UP);

            int expectedTryCount = 2;
            assertThat(game.getTryCount()).isEqualTo(expectedTryCount);
        }

        @Test
        @DisplayName("최종 지점에 도달하지 않으면 결과의 상태가 TBD가 된다.")
        void isNotSuccessTest() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0, 1, 0, 0, 1)));

            game.move(BridgeLane.UP);
            game.move(BridgeLane.UP);
            game.move(BridgeLane.DOWN);

            BridgeGame.Status expectedStatus = BridgeGame.Status.TBD;
            assertThat(game.getStatus()).isEqualTo(expectedStatus);
        }

        @Test
        @DisplayName("안전하지 않은 칸으로 가면 결과의 상태가 FAIL이 된다.")
        void isNotSuccessTest2() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1, 0)));

            game.move(BridgeLane.UP);
            game.move(BridgeLane.UP);
            game.move(BridgeLane.UP);

            BridgeGame.Status expectedStatus = BridgeGame.Status.FAIL;
            assertThat(game.getStatus()).isEqualTo(expectedStatus);
        }

        @Test
        @DisplayName("안전한 칸으로 가면 결과의 상태가 success가 된다.")
        void isSuccessTest() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1, 1)));

            game.move(BridgeLane.UP);
            game.move(BridgeLane.UP);

            BridgeGame.Status expectedStatus = BridgeGame.Status.SUCCESS;
            assertThat(game.getStatus()).isEqualTo(expectedStatus);
        }

        @Test
        @DisplayName("retry를 하면 최근 이동 기록이 초기화 된다.")
        void lastMovementTest() {
            BridgeGame game = new BridgeGame(makeBridgeInfo(newArrayList(1)));

            game.move(BridgeLane.DOWN);
            game.retry();
            game.move(BridgeLane.UP);

            BridgeLane expectedSpotInfo = BridgeLane.UP;
            assertThat(game.getCurrentMovementRecord(1)).isEqualTo(expectedSpotInfo);
        }
    }

    private List<String> makeBridgeInfo(List<Integer> bridgeInfo) {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(bridgeInfo);
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        return bridgeMaker.makeBridge(bridgeInfo.size());
    }

    private void moveSequentially(BridgeGame game, List<BridgeLane> sequence) {
        for(BridgeLane bridgeLane : sequence) {
            game.move(bridgeLane);
        }
    }

    private List<BridgeLane> getMoveRecord(BridgeGame game) {
        List<BridgeLane> movementRecord = new ArrayList<>();
        for(int i = 1; i <= game.getCurrentPosition(); i++) {
            movementRecord.add(game.getCurrentMovementRecord(i));
        }
        return movementRecord;
    }
}
