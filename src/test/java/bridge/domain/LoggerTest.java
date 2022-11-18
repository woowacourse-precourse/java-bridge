package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("Logger 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LoggerTest {
    @Test
    void put_메서드에_null_이_들어오면_예외가_발생한다() {
        Logger logger = new Logger();
        try {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> logger.put(null, true));
            logger.put(null, true);
        } catch (IllegalArgumentException expected) {
            assertThat(expected.getMessage()).isEqualTo("다음 위치에 null 이 들어올 수 없습니다");
        }
    }

    @Test
    void calculateMap_메서드는_주어진_결과에_따라_출력할_수_있는_결과물을_만들어낸다() {
        Logger logger = new Logger();
        logger.put(Position.UP, true);
        assertThat(logger.calculateMap()).isEqualTo("[ O ]\n[   ]");
        logger.put(Position.UP, true);
        assertThat(logger.calculateMap()).isEqualTo("[ O | O ]\n[   |   ]");
        logger.put(Position.DOWN, false);
        assertThat(logger.calculateMap()).isEqualTo("[ O | O |   ]\n[   |   | X ]");
    }
}
