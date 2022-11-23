package bridge.domain.bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    Bridge bridge = new Bridge(List.of("U", "D", "D"));

    @Nested
    @DisplayName("건널 수 있는지 결과 출력하는 로직 검증")
    class IsCorrectMove {

        @Nested
        @DisplayName("정답")
        class Correct {

            @Test
            @DisplayName("첫 번쨰 타입 정답일 경우 True 반환")
            void 첫_번째() {
                // given
                int index = 0;
                String bridgeType = "U";
                // when
                boolean result = bridge.isCorrect(index, bridgeType);
                // then
                assertThat(result).isTrue();
            }

            @Test
            @DisplayName("두 번쨰 타입 정답일 경우 True 반환")
            void 두_번째() {
                // given
                int index = 1;
                String bridgeType = "D";
                // when
                boolean result = bridge.isCorrect(index, bridgeType);
                // then
                assertThat(result).isTrue();
            }

            @Test
            @DisplayName("세 번쨰 타입 정답일 경우 True 반환")
            void 세_번째() {
                // given
                int index = 2;
                String bridgeType = "D";
                // when
                boolean result = bridge.isCorrect(index, bridgeType);
                // then
                assertThat(result).isTrue();
            }
        }

        @Nested
        @DisplayName("오답")
        class UnCorrect {

            @Test
            @DisplayName("오답일 경우 false 반환")
            void 오답() {
                // given
                int index = 2;
                String bridgeType = "U";
                // when
                boolean result = bridge.isCorrect(index, bridgeType);
                // then
                assertThat(result).isFalse();
            }
        }
    }

    @Nested
    @DisplayName("움직일 수 있는지 확인하는 로직 검증")
    class CanMove {

        @Test
        @DisplayName("길이가 3일때, 주어진 index가 2면 움직일 수 없음")
        void 움직일_수_없음() {
            // given
            int bridgeIndex = 2;
            // when
            boolean result = bridge.canMove(bridgeIndex);
            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("길이가 3일때, 주어진 index가 1이면 움직일 수 있음")
        void 움질일_수_있음() {
            // given
            int bridgeIndex = 1;
            // when
            boolean result = bridge.canMove(bridgeIndex);
            // then
            assertThat(result).isTrue();
        }
    }
}