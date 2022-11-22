package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private List<String> testBridge;

    final private
    @BeforeEach
    void init() {
        List<Integer> testNumbers = newArrayList(1, 0, 0, 1, 1);
        testBridge = (new BridgeMaker(new ApplicationTest.TestNumberGenerator(newArrayList(testNumbers)))).makeBridge(testNumbers.size());

        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(testNumbers));
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

    @DisplayName("재시작을 하면 count 1증가, bridge 그대로, move 초기화 되는지 테스트")
    @Test
    void 재시작_테스트() throws NoSuchFieldException, IllegalAccessException {
        Field countField = bridgeGame.getClass().getDeclaredField("count");
        Field bridgeField = bridgeGame.getClass().getDeclaredField("bridge");
        Field moveField = bridgeGame.getClass().getDeclaredField("move");
        countField.setAccessible(true);
        bridgeField.setAccessible(true);
        moveField.setAccessible(true);
        bridgeGame.retry();
        assertThat(countField.get(bridgeGame)).isEqualTo(2);
        assertThat(bridgeField.get(bridgeGame)).isEqualTo(testBridge);
        assertThat(moveField.get(bridgeGame)).isEqualTo(Arrays.asList());
    }
}