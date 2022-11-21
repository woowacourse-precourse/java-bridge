package bridge;

import bridge.enums.BridgeMark;
import bridge.enums.GameStatus;
import bridge.model.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
    }

    @DisplayName("다리를 한 라운드 건널 때 게임 계속 가능 결과 반환")
    @Test
    void crossContinueResult() {
        GameStatus gameStatus = bridge.cross(1, BridgeMark.UP);
        assertThat(gameStatus.isContinue()).isTrue();
    }

    @DisplayName("다리를 한 라운드 건널 때 게임 실패 결과 반환")
    @Test
    void crossFailResult() {
        GameStatus gameStatus = bridge.cross(3, BridgeMark.DOWN);
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("다리를 한 라운드이자 마지막 라운드를 건널 때 게임 성공 결과 반환")
    @Test
    void crossSuccessResultInLast() {
        GameStatus gameStatus = bridge.cross(4, BridgeMark.DOWN);
        assertThat(gameStatus.isSuccess()).isTrue();
    }

    @DisplayName("다리를 한 라운드이자 마지막 라운드를 건널 때 게임 실패 결과 반환")
    @Test
    void crossFailResultInLast() {
        GameStatus gameStatus = bridge.cross(4, BridgeMark.UP);
        assertThat(gameStatus.isFail()).isTrue();
    }

    @DisplayName("다리의 길이가 3 미만이면 예외 발생")
    @Test
    void validateMinimumLength() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "U")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }

    @DisplayName("다리의 길이가 20 초과이면 예외 발생")
    @Test
    void validateMaximumLength() {
        assertThatThrownBy(() -> new Bridge(
                List.of("U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U", "U", "U", "U",
                        "U", "U", "U", "U", "U")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3이상 20이하 이어야 합니다.");
    }
}
