package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker, 5);
    }

    @DisplayName("다리 이동 테스트")
    @Test
    void 다리_이동() {
        Status status = bridgeGame.move("U");
        assertThat(status).isEqualTo(Status.HAS_NEXT);
    }

    @DisplayName("다리 이동 실패 테스트")
    @Test
    void 다리_이동_실패() {
        Status status = bridgeGame.move("D");
        assertThat(status).isEqualTo(Status.FAIL);
    }

    @DisplayName("다리 이동 완료 테스트")
    @Test
    void 다리_이동_완료() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("U");
        Status status = bridgeGame.move("U");
        assertThat(status).isEqualTo(Status.COMPLETE);
    }
}