package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeTest {

    private final Bridge bridge = new Bridge(List.of("U", "D"));

    @DisplayName("다리 생성시 소문자 포함하면 에러 반환 한다.")
    @Test
    void invalidSmallCharacterInput() {
        assertThatThrownBy(() -> new Bridge(List.of("d")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성시 공백문자 포함하면 에러 반환 한다.")
    @Test
    void invalidEmptyCharacterInput() {
        assertThatThrownBy(() -> new Bridge(List.of(" U")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성시 2개 이상 연이은 문자 포함하면 에러 반환 한다.")
    @Test
    void invalidCharacterSequenceInput() {
        assertThatThrownBy(() -> new Bridge(List.of("UD")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("윗칸으로 이동 가능하다.")
    @Test
    void possibleToMove() {
        assertThat(bridge.move(Step.UP)).isTrue();
    }

    @DisplayName("아랫칸으로 이동 가능하다.")
    @Test
    void imPossibleToMove() {
        assertThat(bridge.move(Step.DOWN)).isFalse();
    }

    @DisplayName("다리 길이 넘어가면 에러 반환 한다.")
    @Test
    void imPossibleToMoveOutBound() {
        bridge.move(Step.UP);
        bridge.move(Step.DOWN);
        assertThat(bridge.move(Step.DOWN)).isFalse();
    }

    @DisplayName("다리 끝에 도달 성공")
    @Test
    void isFinished() {
        bridge.move(Step.UP);
        bridge.move(Step.DOWN);
        assertThat(bridge.isFinished()).isTrue();
    }
}
