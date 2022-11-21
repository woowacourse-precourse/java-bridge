package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    @DisplayName("move 메소드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Q"})
    void move(String input) {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(new ArrayList<>());
        userMap.add(new ArrayList<>());
        BridgeGame bridgeGame = new BridgeGame(3);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        List<List<String>> resultMap = bridgeGame.move(userMap, "U");
        //then
        assertThat(resultMap.get(0).contains("O") || resultMap.get(0).contains("X")).isTrue();
    }
}
