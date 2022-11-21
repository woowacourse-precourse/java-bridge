package bridge;

import bridge.generator.BridgeNumberGenerator;
import bridge.generator.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 하단이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("D").getBridge()).isEqualTo("[   ]\n[ O ]\n");
    }

    @Test
    void 상단이동_테스트() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("U").getBridge()).isEqualTo("[ O ]\n[   ]\n");
    }

    @Test
    void 하단이동_테스트_실패() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("U","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("D").getBridge()).isEqualTo("[   ]\n[ X ]\n");
    }

    @Test
    void 상단이동_테스트_실패() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThat(bridgeGame.move("U").getBridge()).isEqualTo("[ X ]\n[   ]\n");
    }

    @Test
    void 잘못된_입력() {
        BridgeGame bridgeGame = new BridgeGame(new ArrayList<>(Arrays.asList("D","D","D")),new ArrayList<>());
        assertThatThrownBy(()->bridgeGame.move("T")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void retry() {
    }
}