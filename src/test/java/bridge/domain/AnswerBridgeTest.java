package bridge.domain;

import static bridge.constant.MovingDirection.D;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.MovingDirection;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerBridgeTest {

    @Test
    void 입력한_다리_위치의_방향반환_성공() throws Exception {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U", "D"));
        MovingDirection movingDirection = answerBridge.getMovingDirection(1);
        assertThat(movingDirection).isEqualTo(D);
    }

    @Test
    void 입력한_다리의_위치가_마지막_위치인지_여부반환_성공() throws Exception {
        AnswerBridge answerBridge = new AnswerBridge(List.of("U", "D", "U", "D"));
        assertThat(answerBridge.isLastPosition(4)).isTrue();
    }

}