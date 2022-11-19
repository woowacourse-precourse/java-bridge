package bridge.domain;

import static bridge.domain.Round.ROUND_LOWER_BOUND;
import static bridge.domain.Round.ROUND_UPPER_BOUND;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
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
    @ValueSource(ints = {ROUND_LOWER_BOUND - 1, ROUND_UPPER_BOUND + 1, -1, 1000})
    void valueOf_메서드는_범위를_벗어난_값을_입력받으면_IllegalArugmentException을_던진다(int round) {
        Assertions.assertThatThrownBy(() -> Round.valueOf(round))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("허용된 라운드 범위를 벗어났습니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {ROUND_LOWER_BOUND, 10, ROUND_UPPER_BOUND})
    void valueOf_메서드는_범위_내_값을_입력받으면_해당_라운드_인스턴스를_반환한다(int round) {
        Round result = Round.valueOf(round);

        assertThat(result).isInstanceOf(Round.class);
    }

    @Test
    void nextRound_메서드는_다음_라운드를_반환한다() {
        Round round = Round.valueOf(1);
        Round result = round.nextRound();

        assertThat(result).isEqualTo(Round.valueOf(2));
    }

    @Test
    void firstRound_메서드는_1라운드를_반환한다() {
        Round result = Round.firstRound();

        assertThat(result).isEqualTo(Round.valueOf(1));
    }

    @Test
    void naturalOrder_메서드는_Round를_오름차순으로_반환한다() {
        List<Round> naturalOrderedRound = IntStream.rangeClosed(ROUND_LOWER_BOUND, ROUND_UPPER_BOUND)
                .mapToObj(Round::valueOf)
                .collect(Collectors.toList());

        assertThat(Round.naturalOrder()).hasSameElementsAs(naturalOrderedRound);
    }
}
