package bridge.domain;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import bridge.constant.Direction;

public class PlayerTest {

    @Test
    void 다리를_이동할_수_있다() {
        List<Direction> bridgeDirections = List.of(UPPER, LOWER, LOWER, LOWER, UPPER);
        Bridge bridge = Bridge.from(getCapitalLetters(bridgeDirections));

        Player player = new Player(bridge);
        assertThat(player.moveNext(UPPER)).isTrue();
        assertThat(player.moveNext(LOWER)).isTrue();
        assertThat(player.moveNext(UPPER)).isFalse();
    }

    @Test
    void 다리_끝에_도달했는지_알_수_있다() {
        List<Direction> bridgeDirections = Collections.emptyList();
        Bridge bridge = Bridge.from(getCapitalLetters(bridgeDirections));

        Player player = new Player(bridge);

        assertThat(player.isArrived()).isTrue();
    }

    private List<String> getCapitalLetters(List<Direction> bridgeDirections) {
        return bridgeDirections.stream()
                .map(Direction::capitalLetter)
                .collect(Collectors.toList());
    }
}
