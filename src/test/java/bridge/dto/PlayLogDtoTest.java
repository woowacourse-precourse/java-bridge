package bridge.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@DisplayName("PlayLogDto 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PlayLogDtoTest {
    @Test
    void PlayLogDto_클래스는_잘_생성됨() {
        assertDoesNotThrow(() -> new PlayLogDto("log"));
    }

    @Test
    void PlayLogDto_를_생성할_때는_null_이_들어오면_안된다() {
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new PlayLogDto(null));
            new PlayLogDto(null);
        } catch (final IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("로그에는 null 이 들어오면 안됩니다");
        }
    }
}
