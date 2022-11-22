package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ui.InputView;
import ui.OutputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static bridge.ApplicationTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeGameTest {

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("다리를 생성하는 기능, 위 칸이면 \"U\", 아래 칸이면 \"D\"로 표현해야 한다.")
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> newBridge = bridgeMaker.makeBridge(3);
        assertThat(newBridge).containsExactly("D", "U", "U");
    }

    @DisplayName("애플리케이션 실행 시 다리 길이를 입력받아 리턴한다.")
    @Test
    void createBridgeTest() {
        BridgeGame bridgeGame = new BridgeGame();
        assertEquals(bridgeGame.createBridge(5).size(), 5);
    }

    @DisplayName("한 턴을 실행할 때마다 점수를 계산해 리턴한다.")
    @Test
    void calculateScoreTest() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.setNewBridge(List.of("U", "D", "D"));
        assertEquals(bridgeGame.calculateScore(List.of("U", "D", "U")), 2);

    }

    @DisplayName("입력한 이동 값을 반환한다.")
    @Test
    void moveTest() {
        BridgeGame bridgeGame = new BridgeGame();
        InputStream in = generateUserInput("U");
        System.setIn(in);
        Scanner sc = new Scanner(System.in);
        assertThat(bridgeGame.move()).isInstanceOf(String.class);
    }

    @DisplayName("사용자의 입력 값을 업데이트 한다.")
    @Test
    void updatePlayerInputTest() {
        BridgeGame bridgeGame = new BridgeGame();
        List<String> playerInput = new ArrayList<>(List.of("U", "D"));
        assertThat(bridgeGame.updatePlayerInput(playerInput, "U")).containsExactly("U", "D", "U");
    }
}
