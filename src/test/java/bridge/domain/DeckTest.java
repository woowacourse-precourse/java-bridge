package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class DeckTest {

    private static final String CAPITAL_LETTER_UPPER = "U";
    private static final String CAPITAL_LETTER_LOWER = "D";

    @Test
    void 방향이_위나_아래가_아니면_예외를_던진다() {
        String anomalyDirection = "ASDF";

        assertThatIllegalArgumentException().isThrownBy(() -> new Deck(anomalyDirection));
    }

    @Test
    void 특정_방향이_이동가능한지_알_수_있다() {
        Deck deck = new Deck(CAPITAL_LETTER_UPPER);

        assertThat(deck.isMovable(CAPITAL_LETTER_UPPER)).isTrue();
        assertThat(deck.isMovable(CAPITAL_LETTER_LOWER)).isFalse();
    }
}
