package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constant.BridgeGameStstus;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeGameTest {
    @ParameterizedTest
    @MethodSource("moveTestProvider")
    void moveTest(List<String> bridge, List<String> moveInfo, BridgeGameStstus lastStatus, int lastStep) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (String dir : moveInfo) {
            bridgeGame.move(dir);
        }
        assertThat(bridgeGame.getStatus()).isEqualTo(lastStatus);
        assertThat(bridgeGame.getStep()).isEqualTo(lastStep);
    }

    private static List<Arguments> moveTestProvider() {
        List<String> bridge = List.of(
                "U", "D", "D", "D", "U"
        );
        return List.of(
                Arguments.of(
                        bridge,
                        List.of(
                                "U", "D", "D", "D", "U"
                        ),
                        BridgeGameStstus.SUCCESS,
                        5
                ),
                Arguments.of(
                        bridge,
                        List.of(
                                "U", "D", "D", "U"
                        ),
                        BridgeGameStstus.FAIL,
                        4
                ),
                Arguments.of(
                        bridge,
                        List.of(
                                "U", "D", "D"
                        ),
                        BridgeGameStstus.PROCEEDING,
                        3
                )
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {3,5,10})
    void retryTest(int cnt){
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>());
        for(int i=0;i<cnt;i++){
            bridgeGame.retry();
        }
        assertThat(bridgeGame.getTryCnt()).isEqualTo(cnt + 1);
    }
}
