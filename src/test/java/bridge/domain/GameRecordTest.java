package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameRecordTest {
    private GameRecord gameRecord;

    @BeforeEach
    void initializeRecord() {
        gameRecord = new GameRecord();
    }

    @DisplayName("재시작 기록 테스트")
    @Nested
    class RecordRetryTest {
        @DisplayName("재시작하면 시도횟수가 1 늘어나는지 테스트")
        @Test
        void checkTryCountIncrement() {
            int oldTryCount = gameRecord.getTryCount();

            gameRecord.recordRetry();

            assertThat(gameRecord.getTryCount()).isEqualTo(oldTryCount + 1);
        }

        @DisplayName("재시작하면 이동기록이 초기화되는지 테스트")
        @Test
        void checkCrossedRecordInitialize() {
            gameRecord.recordMove("D", false);

            gameRecord.recordRetry();

            assertThat(gameRecord.getCrossedRecord().get("upperCrossedRecord")).isEmpty();
            assertThat(gameRecord.getCrossedRecord().get("lowerCrossedRecord")).isEmpty();
        }
    }

    @DisplayName("이동 기록 테스트")
    @Nested
    class RecordMoveTest {
        @DisplayName("한 칸 이동시 이동에 성공한 경우 기록 테스트 - 위로 이동한 경우")
        @Test
        void case1() {
            boolean isDead = false;

            gameRecord.recordMove("U", isDead);

            assertThat(gameRecord.getCrossedRecord().get("upperCrossedRecord").get(0))
                    .isEqualTo(" O ");
            assertThat(gameRecord.getCrossedRecord().get("lowerCrossedRecord").get(0))
                    .isEqualTo("   ");
        }

        @DisplayName("한 칸 이동시 이동에 성공한 경우 기록 테스트 - 아래로 이동한 경우")
        @Test
        void case2() {
            boolean isDead = false;

            gameRecord.recordMove("D", isDead);

            assertThat(gameRecord.getCrossedRecord().get("upperCrossedRecord").get(0))
                    .isEqualTo("   ");
            assertThat(gameRecord.getCrossedRecord().get("lowerCrossedRecord").get(0))
                    .isEqualTo(" O ");
        }

        @DisplayName("한 칸 이동시 이동에 실패한 경우 기록 테스트 - 위로 이동한 경우")
        @Test
        void case3() {
            boolean isDead = true;

            gameRecord.recordMove("U", isDead);

            assertThat(gameRecord.getCrossedRecord().get("upperCrossedRecord").get(0))
                    .isEqualTo(" X ");
            assertThat(gameRecord.getCrossedRecord().get("lowerCrossedRecord").get(0))
                    .isEqualTo("   ");
        }

        @DisplayName("한 칸 이동시 이동에 실패한 경우 기록 테스트 - 아래로 이동한 경우")
        @Test
        void case4() {
            boolean isDead = true;

            gameRecord.recordMove("D", isDead);

            assertThat(gameRecord.getCrossedRecord().get("upperCrossedRecord").get(0))
                    .isEqualTo("   ");
            assertThat(gameRecord.getCrossedRecord().get("lowerCrossedRecord").get(0))
                    .isEqualTo(" X ");
        }
    }
}
