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
    void 생성자는_범위밖의_값을_입력하면_IllegalArgumentException을_던진다(int number) {
        assertThatThrownBy(() -> new Round(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 라운드 범위를 벗어났습니다.");
    }

    @Test
    void nextRound_메서드를_사용하여_허용된_범위를_넘어간다면_IllegalArgumentException을_던진다() {
        Round round = new Round(ROUND_UPPER_BOUND);
        assertThatThrownBy(round::nextRound)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 라운드 범위를 벗어났습니다.");
    }

    @Test
    void nextRound_메서드는_라운드_값을_1_증가시킨다() {
        Round round = new Round(1);
        round.nextRound();

        assertThat(round).isEqualTo(new Round(2));
    }

    @Test
    void reset_메서드는_라운드_값을_1로_초기화한다() {
        Round round = new Round(20);
        round.reset();

        assertThat(round).isEqualTo(new Round(1));
    }

    @Test
    void naturalOrder_메서드는_Round를_오름차순으로_반환한다() {
        List<Round> naturalOrderedRound = IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(Round::new)
                .collect(Collectors.toList());

        assertThat(Round.naturalOrder()).hasSameElementsAs(naturalOrderedRound);
    }
}
