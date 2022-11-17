package bridge.domain;

import static bridge.domain.Round.ROUND_LOWER_BOUND;
import static bridge.domain.Round.ROUND_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Round 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RoundTest {

    @ParameterizedTest
    @ValueSource(ints = {ROUND_LOWER_BOUND - 1, ROUND_UPPER_BOUND + 1, 9999})
    void valueOf_메서드는_범위밖의_값을_입력하면_IllegalArgumentException을_던진다(int number) {
        assertThatThrownBy(() -> Round.valueOf(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 라운드 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {ROUND_LOWER_BOUND, 10, ROUND_UPPER_BOUND})
    void valueOf_메서드는_범위내의_값을_입력하면_Round_인스턴스를_반환한다(int number) {
        assertThat(Round.valueOf(number)).isInstanceOf(Round.class);
    }

    @Test
    void naturalOrder_메서드는_Round를_오름차순으로_반환한다() {
        List<Round> naturalOrderedRound = IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());

        assertThat(Round.naturalOrder()).hasSameElementsAs(naturalOrderedRound);
    }
}
