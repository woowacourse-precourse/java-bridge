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
    @DisplayName("compare 메소드 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"Q"})
    void compareValue(String input) {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(new ArrayList<>());
        userMap.add(new ArrayList<>());
        bridge.BridgeGame bridgeGame = new bridge.BridgeGame(3);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        OutputStream out = new ByteArrayOutputStream();
        //when
        System.setIn(in);
        System.setOut(new PrintStream(out));
        List<List<String>> resultMap = bridgeGame.compareValue(userMap, "U",0);
        //then
        assertThat(out.toString().contains("[ O ]") || out.toString().contains("[ X ]")).isTrue();
    }
    @DisplayName("copy리스트 메소드 테스트")
    @Test
    void copyList() {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of(" "));
        userMap.add(List.of("O"));
        bridge.BridgeGame bridgeGame = new bridge.BridgeGame(3);
        //when
        List<List<String>> copyList = bridgeGame.getCopyList(userMap);
        //then
        assertThat(copyList).isNotSameAs(userMap);
        assertThat(copyList).isEqualTo(userMap);
    }
}
