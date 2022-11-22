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
        }).isInstanceOf(InternalError.class);
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


}