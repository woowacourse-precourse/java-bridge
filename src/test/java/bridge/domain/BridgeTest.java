package bridge.domain;

import static bridge.constant.Direction.LOWER;
import static bridge.constant.Direction.UPPER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import bridge.constant.Direction;

public class BridgeTest {

    @Test
    void 특정_데크_특정_방향이_이동가능한지_알_수_있다() {
        List<Direction> bridgeDirections = List.of(UPPER, LOWER, UPPER, LOWER, UPPER);
        Bridge bridge = new Bridge(getCapitalLetters(bridgeDirections));

        assertThat(bridge.isMovable(new Position(1), LOWER)).isTrue();
    }

    private List<String> getCapitalLetters(List<Direction> bridgeDirections) {
        return bridgeDirections.stream()
                .map(Direction::capitalLetter)
                .collect(Collectors.toList());
    }
}
