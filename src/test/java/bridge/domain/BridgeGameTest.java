package bridge.domain;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private List<String> bridge;
    private List<String> upBridge;
    private List<String> downBridge;
    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame();
        bridge = Arrays.asList("U", "D", "U");
        upBridge = bridgeGame.getUpBridge();
        downBridge = bridgeGame.getDownBridge();
    }

    @Test
    void 갈수있는칸으로이동했을경우() {
        boolean answer = true;
        Assertions.assertThat(bridgeGame.move(bridge, 0, "U")).isEqualTo(answer);
    }

    @Test
    void 갈수없는칸으로이동했을경우() {
        boolean answer = false;
        Assertions.assertThat(bridgeGame.move(bridge, 0, "D")).isEqualTo(answer);
    }

    @Test
    void 재시작하였을때총게임횟수확인() {
        bridgeGame.retry();
        int answer = 2;
        Assertions.assertThat(bridgeGame.getTotalGamePlay()).isEqualTo(answer);
    }

    @Test
    void 건널수있는칸_위칸일경우() {
        List<String> upAnswer = List.of("O");
        List<String> downAnswer = List.of(" ");
        bridgeGame.canCross("U");
        Assertions.assertThat(bridgeGame.getUpBridge()).isEqualTo(upAnswer);
        Assertions.assertThat(bridgeGame.getDownBridge()).isEqualTo(downAnswer);
    }

    @Test
    void 건널수있는칸_아래칸일경우() {
        List<String> upAnswer = List.of(" ");
        List<String> downAnswer = List.of("O");
        bridgeGame.canCross("D");
        Assertions.assertThat(bridgeGame.getUpBridge()).isEqualTo(upAnswer);
        Assertions.assertThat(bridgeGame.getDownBridge()).isEqualTo(downAnswer);
    }

    @Test
    void 건널수없는칸_위칸일경우() {
        List<String> upAnswer = List.of("X");
        List<String> downAnswer = List.of(" ");
        bridgeGame.canNotCross("U");
        Assertions.assertThat(bridgeGame.getUpBridge()).isEqualTo(upAnswer);
        Assertions.assertThat(bridgeGame.getDownBridge()).isEqualTo(downAnswer);
    }

    @Test
    void 건널수없는칸_아래칸일경우() {
        List<String> upAnswer = List.of(" ");
        List<String> downAnswer = List.of("X");
        bridgeGame.canNotCross("D");
        Assertions.assertThat(bridgeGame.getUpBridge()).isEqualTo(upAnswer);
        Assertions.assertThat(bridgeGame.getDownBridge()).isEqualTo(downAnswer);
    }
}