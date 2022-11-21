package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.bridge.maker.BridgeMaker;
import bridge.domain.bridge.maker.BridgeMakerFake;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeTest {

    @Test
    void 한칸을_건널때_생존상태를_반환합니다() {
        var makeBridge = new BridgeMaker(
                new BridgeMakerFake(stringToNumberList("1,0,1,0"))
        );
        var bridgeSize = new BridgeSize("4");

        var bridge = new Bridge(makeBridge, bridgeSize);

        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.SURVIVE);
    }

    @Test
    void 한칸을_건널때_생존실패상태를_반환합니다() {
        var makeBridge = new BridgeMaker(
                new BridgeMakerFake(stringToNumberList("1,0,1,0"))
        );
        var bridgeSize = new BridgeSize("4");

        var bridge = new Bridge(makeBridge, bridgeSize);

        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.DIE);
    }

    private List<Integer> stringToNumberList(final String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}