package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class DeckTest {

    private static final String CAPITAL_LETTER_UPPER = "U";
    private static final String CAPITAL_LETTER_LOWER = "D";

    @Test
    void 잘못된_생성_방향은_예외를_던진다() {
        String anomalyDirection = "ASDF";

        assertThatIllegalArgumentException().isThrownBy(() -> new Deck(anomalyDirection));
    }

    @Test
    void 위_아래_둘_중_하나만_이동가능하다() {
        Deck deck = new Deck(CAPITAL_LETTER_UPPER);

        assertThat(deck.isMovable(CAPITAL_LETTER_UPPER)).isTrue();
        assertThat(deck.isMovable(CAPITAL_LETTER_LOWER)).isFalse();
    }

    @Test
    void 잘못된_방향은_예외를_던진다() {
        String anomalyDirection = "ASDF";
        Deck deck = new Deck(CAPITAL_LETTER_UPPER);

        assertThatIllegalArgumentException().isThrownBy(() -> deck.isMovable(anomalyDirection));
    }
}
