package bridge.domain;

import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeMaker;
import bridge.domain.bridge.Move;
import bridge.support.FakeBridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static bridge.domain.bridge.Move.DOWN;
import static bridge.domain.bridge.Move.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeTest {

    Bridge bridge;
    int bridgeSize;

    @BeforeEach
    void init() {
        bridgeSize = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(new FakeBridgeNumberGenerator(newArrayList(0, 1, 0)));
        List<String> rawBridge = bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(rawBridge);
    }

    @Test
    void getUnit_위치에_맞는_BridgeUnit을_리턴한다() {
        //given
        List<String> expect = List.of(DOWN, UP, DOWN).stream()
                .map(Move::getCode)
                .collect(Collectors.toList());

        //when
        List<String> res = Stream.iterate(0, i -> i < bridgeSize, i -> i + 1)
                .map(position -> bridge.getBridgeBlock(position))
                .collect(Collectors.toList());

        //then
        assertThat(res).isEqualTo(expect);
    }

    @Test
    void getSize_다리_사이즈를_리턴한다() {
        //when
        int res = bridge.getSize();

        assertThat(res).isEqualTo(bridgeSize);
    }
}