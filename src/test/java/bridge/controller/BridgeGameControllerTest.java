package bridge.controller;

import bridge.core.BridgeGame;
import bridge.core.GameStatusOperator;
import bridge.domain.Bridge;
import bridge.type.FinishCondition;
import bridge.type.ProcessCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BridgeGameControllerTest {

    Bridge bridge;
    GameStatusOperator gameStatusOperator;
    BridgeGame bridgeGame;
    Scanner scanner;

    @BeforeEach
    void initBridgeGame() {
        bridge = new Bridge(List.of("U", "D", "U", "D"));
        gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        bridgeGame = new BridgeGame(bridge, gameStatusOperator);
    }

    @DisplayName("플레이어의 입력에 따라 게임 종료된 후 다리 건너기를 성공했는지 확인한다.")
    @ParameterizedTest
    @MethodSource("providePlayerInput")
    void movePlayerUntilQuit(List<String> playerInput, FinishCondition finishCondition) {
        setInputBuffer(playerInput);
        ProcessCondition startCondition = bridgeGame.start();
        ProcessCondition endCondition = BridgeGameHandler.executeGame(startCondition, bridgeGame);
        assertThat(endCondition).isEqualTo(finishCondition);
    }

    private static Stream<Arguments> providePlayerInput() {
        return Stream.of(
                Arguments.of(List.of("U\n", "D\n", "U\n", "D"), FinishCondition.FINISHED),
                Arguments.of(List.of("U\n", "D\n", "D\n", "Q"), FinishCondition.NOT_FINISHED),
                Arguments.of(List.of("U\n", "D\n", "D\n", "R\n", "U\n", "D\n", "U\n", "D"), FinishCondition.FINISHED),
                Arguments.of(List.of("D\n", "Q"), FinishCondition.NOT_FINISHED),
                Arguments.of(List.of("U\n", "U\n", "R\n", "D\n", "Q"), FinishCondition.NOT_FINISHED),
                Arguments.of(List.of("U\n", "D\n", "U\n", "U\n", "Q"), FinishCondition.NOT_FINISHED)
        );
    }

    private void setInputBuffer(List<String> playerInput) {
        InputStream in = createInputStream(playerInput);
        System.setIn(in);
        scanner = new Scanner(System.in);
    }

    private InputStream generatePlayerInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private InputStream createInputStream(List<String> inputBuffer) {
        List<InputStream> streams = inputBuffer.stream()
                .map(this::generatePlayerInput)
                .collect(Collectors.toList());
        return new SequenceInputStream(Collections.enumeration(streams));
    }
}