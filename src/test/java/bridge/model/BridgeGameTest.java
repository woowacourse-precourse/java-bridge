package bridge.model;

import bridge.data.Moving;
import bridge.data.Pass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    void set() {
        bridgeGame = new BridgeGame(new ArrayList<>(List.of("U", "D", "U")));
    }

    @DisplayName("다리를 성공적으로 건너면 true, 건너기에 실패하면 false를 리턴")
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    @ParameterizedTest(name = "[{index}] length={0} returned={1}")
    void moveTest(String moving, boolean result) {
        assertThat(bridgeGame.move(moving)).isEqualTo(result);
    }

    @DisplayName("다리를 끝까지 건넌 상태면 true, 아니라면 false를 리턴")
    @Test
    void allPassTest() {
        bridgeGame.move("U");
        assertThat(bridgeGame.allPass()).isFalse();

        bridgeGame.move("D");
        assertThat(bridgeGame.allPass()).isFalse();

        bridgeGame.move("U");
        assertThat(bridgeGame.allPass()).isTrue();
    }

    @DisplayName("다리를 잘 건넜으면 O, 실패했으면 X를 저장")
    @Test
    void getMovingMapTest() {
        bridgeGame.move("U");
        assertThat(bridgeGame.getMovingMap().get(Moving.UP.ordinal()).get(0)).isEqualTo(Pass.YES.getLabel());
        assertThat(bridgeGame.getMovingMap().get(Moving.DOWN.ordinal()).get(0)
        ).isEqualTo(Pass.NOTHING.getLabel());

        bridgeGame.move("U");
        assertThat(bridgeGame.getMovingMap().get(Moving.UP.ordinal()).get(1)).isEqualTo(Pass.NO.getLabel());
        assertThat(bridgeGame.getMovingMap().get(Moving.DOWN.ordinal()).get(1)
        ).isEqualTo(Pass.NOTHING.getLabel());
    }

    @DisplayName("재시작이 정상적으로 동작하는지 테스트")
    @Test
    void retryTest() {
        bridgeGame.move("D");
        bridgeGame.retry();
        assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        assertThat(bridgeGame.getMovingMap().get(0).size()).isEqualTo(0);
        assertThat(bridgeGame.getMovingMap().get(1).size()).isEqualTo(0);
    }
}