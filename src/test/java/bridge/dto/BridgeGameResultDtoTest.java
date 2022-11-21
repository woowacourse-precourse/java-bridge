package bridge.dto;

import bridge.domain.GameResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("BridgeGameResultDto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameResultDtoTest {
    private final PlayLogDto logDto = new PlayLogDto("log");
    private final GameResult result = GameResult.SUCCESS;

    @Test
    void 잘_생성할_수_있다() {
        assertDoesNotThrow(() -> new BridgeGameResultDto(1, logDto, result));
    }

    @Test
    void 너무_작은_숫자가_들어오면_예외() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameResultDto(0, logDto, result));
            new BridgeGameResultDto(0, logDto, result);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("시도 횟수는 1이상이어야 합니다");
        }
    }

    @Test
    void bridge_에_null_이_포함되면_예외() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameResultDto(1, null, result));
            new BridgeGameResultDto(1, null, result);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("playLog 에는 null 이 들어올 수 없습니다");
        }
    }

    @Test
    void visited_에_null_이_포함되면_예외() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new BridgeGameResultDto(1, logDto, null));
            new BridgeGameResultDto(1, logDto, null);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("gameResult 에는 null 이 들어올 수 없습니다");
        }
    }
}
