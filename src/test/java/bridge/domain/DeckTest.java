package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Test;

public class DeckTest {

    @Test
    void 방향이_위나_아래가_아니면_예외를_던진다() {
        String anomalyDirection = "ASDF";

        assertThatIllegalArgumentException().isThrownBy(() -> new Deck(anomalyDirection));
    }
}
