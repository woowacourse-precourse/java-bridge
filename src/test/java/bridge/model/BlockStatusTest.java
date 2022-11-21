package bridge.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BlockStatusTest {
    @Test
    void of() {
        assertThat(BlockStatus.of(true)).isEqualTo(BlockStatus.O);
        assertThat(BlockStatus.of(false)).isEqualTo(BlockStatus.X);
    }

    @Test
    void enumToString() {
        assertThat(BlockStatus.O.toString()).isEqualTo(" O ");
        assertThat(BlockStatus.X.toString()).isEqualTo(" X ");
        assertThat(BlockStatus.UNSELECT.toString()).isEqualTo("   ");
    }
}