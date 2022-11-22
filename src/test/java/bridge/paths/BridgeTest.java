package bridge.paths;

import bridge.identifiers.Direction;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class BridgeTest {

    @Test
    void 안전경로가_주어지지_않으면_예외처리한다(){
        assertThatThrownBy(()->{
            Bridge bridge = new Bridge(null);
        }).isInstanceOf(IllegalStateException.class);
    }

    @Nested
    class CanBeSteppedByTest {

        @Test
        void 안전경로가_사용자_경로와_같을_때_확인() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.DOWN);

            assertThat(bridge.canBeSteppedBy(playerPath)).isTrue();
        }

        @Test
        void 안전경로가_사용자_경로와_다를_때_확인() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.UP);

            assertThat(bridge.canBeSteppedBy(playerPath)).isFalse();
        }
    }

    @Nested
    class IsCompletedWithTest {
        @Test
        void 안전경로가_사용자_경로와_완전히_같을_때_확인() {
            Bridge bridge = new Bridge(List.of("U", "D", "D"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.DOWN);

            assertThat(bridge.canBeSteppedBy(playerPath)).isTrue();
        }

        @Test
        void 안전경로가_사용자_경로와_끝부분이_다를_때_확인() {
            Bridge bridge = new Bridge(List.of("D", "D", "U"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.UP);

            assertThat(bridge.canBeSteppedBy(playerPath)).isFalse();
        }

        @Test
        void 안전경로가_사용자_경로와_중간부분이_다를_때_확인() {
            Bridge bridge = new Bridge(List.of("U", "U", "U"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.UP);

            assertThat(bridge.canBeSteppedBy(playerPath)).isFalse();
        }

        @Test
        void 안전경로가_사용자_경로와_첫부분이_다를_때_확인() {
            Bridge bridge = new Bridge(List.of("D", "D", "D"));
            PlayerPath playerPath = new PlayerPath();
            playerPath.saveDirection(Direction.UP);
            playerPath.saveDirection(Direction.DOWN);
            playerPath.saveDirection(Direction.DOWN);

            assertThat(bridge.canBeSteppedBy(playerPath)).isFalse();
        }
    }

}