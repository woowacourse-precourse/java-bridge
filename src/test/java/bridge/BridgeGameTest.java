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
    @DisplayName("유저가 건너간 다리 결과 리스트 테스트")
    @Test
    void exchangeValue() {
        //given
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(new ArrayList<>());
        userMap.add(new ArrayList<>());
        bridge.BridgeGame bridgeGame = new bridge.BridgeGame(3);
        //when
        List<List<String>> lists = bridgeGame.exchangeValue(userMap, "O", "U");
        //then
        assertThat(lists.get(0)).isEqualTo(List.of("O"));
    }
    @DisplayName("재시도 Q일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"Q"})
    void retryQ(String input) {
        //given
        List<List<String>> tempMap = new ArrayList<>(2);
        tempMap.add(new ArrayList<>());
        tempMap.add(new ArrayList<>());
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of("O"));
        userMap.add(List.of(" "));
        bridge.BridgeGame bridgeGame = new bridge.BridgeGame(3);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        List<List<String>> lists = bridgeGame.retry(tempMap,userMap);
        //then
        assertThat(lists.get(0)).isEqualTo(List.of("O"));
    }
    @DisplayName("재시도 R일 경우")
    @ParameterizedTest
    @ValueSource(strings = {"R"})
    void retryR(String input) {
        //given
        List<List<String>> tempMap = new ArrayList<>(2);
        tempMap.add(new ArrayList<>());
        tempMap.add(new ArrayList<>());
        List<List<String>> userMap = new ArrayList<>(2);
        userMap.add(List.of("O"));
        userMap.add(List.of(" "));
        bridge.BridgeGame bridgeGame = new bridge.BridgeGame(3);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        List<List<String>> lists = bridgeGame.retry(tempMap,userMap);
        //then
        assertThat(lists).isEqualTo(tempMap);
    }
}
