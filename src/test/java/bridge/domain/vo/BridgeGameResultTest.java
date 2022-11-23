package bridge.domain.vo;

import bridge.domain.vo.enumeration.MovingType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static bridge.domain.vo.BridgeGameResult.confirmGameResult;
import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameResultTest {

    boolean isMatched = true;
    String userMoving = "U";
    String upMoving = MovingType.UP.getMovingType();
    String downMoving = MovingType.DOWN.getMovingType();

    @DisplayName("BridgeGameResult를 생성한다.")
    @Test
    void createBridgeGameResultTest() {
        assertThat(confirmGameResult(isMatched, userMoving))
                .isInstanceOf(BridgeGameResult.class);

        assertThat(confirmGameResult(isMatched, userMoving).getIsMatched())
                .isTrue();

        assertThat(confirmGameResult(isMatched, userMoving).getUserMoving())
                .isEqualTo(upMoving);
    }

    @DisplayName("MovingType 중 'U'인지 확인한다.")
    @Test
    void checkUpTest() {
        assertThat(BridgeGameResult.checkUp(upMoving))
                .isTrue();
    }

    @DisplayName("MovingType 중 'D'인지 확인한다.")
    @Test
    void checkDown() {
        assertThat(BridgeGameResult.checkDown(downMoving))
                .isTrue();
    }
}