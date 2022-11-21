package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    private Result result;

    @BeforeEach
    void init() {
        result = new Result();
    }

    @Test
    @DisplayName("첫 생성 시 움직임 확인")
    void checkFirstMovable() {
        assertThat(result.movable()).isTrue();
    }

    @Test
    @DisplayName("다리 건너기 실패시 움직임 확인")
    void checkMovableAfterCross() {
        result.updateState("U", false);

        assertThat(result.movable()).isFalse();
    }

    @Test
    @DisplayName("게임 진행 상황 업데이트 사용자 입력값 확인")
    void checkUserInputUpdateState() {
        result.updateState("U", true);
        result.updateState("U", true);
        result.updateState("D", true);

        assertThat(result.getInput(0)).isEqualTo("U");
        assertThat(result.getInput(1)).isEqualTo("U");
        assertThat(result.getInput(2)).isEqualTo("D");
    }

    @Test
    @DisplayName("다리를 여러번 건넌 후 상태 크기 확인")
    void checkStateSize() {
        result.updateState("U", true);
        result.updateState("U", true);
        result.updateState("D", true);

        assertThat(result.stateSize()).isEqualTo(3);
    }
}
