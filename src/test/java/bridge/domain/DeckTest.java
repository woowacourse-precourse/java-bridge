package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

import bridge.constant.Direction;

public class DeckTest {

    @Test
    void 잘못된_생성_방향은_예외를_던진다() {
        String anomalyDirection = "ASDF";

        assertThatIllegalArgumentException().isThrownBy(() -> new Deck(anomalyDirection));
    }

    @Test
    void 위_아래_둘_중_하나만_이동가능하다() {
        Deck deck = new Deck(Direction.UPPER.capitalLetter());

        assertThat(deck.isMovable(Direction.UPPER)).isTrue();
        assertThat(deck.isMovable(Direction.LOWER)).isFalse();
    }
}
