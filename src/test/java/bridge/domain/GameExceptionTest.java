package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.*;

class GameExceptionTest {
    @DisplayName("시스템 에러가 아닌 경우 False를 반환한다.")
    @EnumSource(
            mode = EnumSource.Mode.EXCLUDE,
            names = {"SYSTEM_ERROR_BRIDGE_GENERATE", "SYSTEM_ERROR_GAME_RESULT"}
    )
    @ParameterizedTest(name = "{index}. 발생 예외: {0}")
    public void systemErrorReturnFalseTest(GameException gameException) throws Exception {
        assertThat(GameException.isSystemError(gameException)).isFalse();
    }

    @DisplayName("시스템 에러 발생 시 True를 반환한다.")
    @EnumSource(
            mode = EnumSource.Mode.INCLUDE,
            names = {"SYSTEM_ERROR_BRIDGE_GENERATE", "SYSTEM_ERROR_GAME_RESULT"}
    )
    @ParameterizedTest(name = "{index}. 발생 예외: {0}")
    public void systemErrorReturnTrueTest(GameException gameException) throws Exception {
        assertThat(GameException.isSystemError(gameException)).isTrue();
    }
}