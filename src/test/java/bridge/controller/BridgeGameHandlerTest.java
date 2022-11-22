package bridge.controller;

import bridge.core.BridgeGame;
import bridge.core.exception.Error;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BridgeGameHandlerTest {

    BridgeGameHandler bridgeGameHandler;
    Scanner scanner;
    ByteArrayOutputStream output;

    @BeforeEach
    void setUp() {
        bridgeGameHandler = new BridgeGameHandler();
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void restoreSetUp() {
        System.setOut(System.out);
        output.reset();
    }

    @DisplayName("다리 길이에 대한 잘못된 입력이 주어질 경우 예외가 발생한다.")
    @ParameterizedTest
    @MethodSource("providePlayerInput")
    void inputInvalidBridgeLength(List<String> playerInput, String errorMessage) {
        setInputBuffer(playerInput);
        bridgeGameHandler.initGame();
        assertThat(output.toString()).contains(errorMessage);
    }

    private static Stream<Arguments> providePlayerInput() {
        return Stream.of(
                Arguments.of(List.of("a\n", "3"), Error.NON_NUMERIC_ERROR.getMessage()),
                Arguments.of(List.of("@\n", "3"), Error.NON_NUMERIC_ERROR.getMessage()),
                Arguments.of(List.of(" \n", "3"), Error.NON_NUMERIC_ERROR.getMessage()),
                Arguments.of(List.of("\n", "3"), Error.NON_NUMERIC_ERROR.getMessage()),
                Arguments.of(List.of("1\n", "3"), Error.OUT_OF_RANGE_ERROR.getMessage()),
                Arguments.of(List.of("30\n", "3"), Error.OUT_OF_RANGE_ERROR.getMessage())
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