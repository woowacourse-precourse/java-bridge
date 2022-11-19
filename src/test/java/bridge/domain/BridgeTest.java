package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Bridge 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeTest {
    @Test
    void size_메서드는_생성된_다리의_길이를_반환한다() {
        assertThat(new Bridge(List.of("U", "D", "D", "U")).size()).isEqualTo(4);
    }

    @Test
    void isEqualAtIndex_메서드는_특정_index_의_다리_위치가_맞는지를_반환한다() {
        Bridge bridge = new Bridge(List.of("U", "D", "D", "U"));

        assertThat(bridge.isEqualAtIndex(0, Position.UP)).isEqualTo(true);
        assertThat(bridge.isEqualAtIndex(1, Position.UP)).isEqualTo(false);
        assertThat(bridge.isEqualAtIndex(2, Position.UP)).isEqualTo(false);
        assertThat(bridge.isEqualAtIndex(3, Position.UP)).isEqualTo(true);
    }
}
