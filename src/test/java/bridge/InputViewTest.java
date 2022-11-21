package bridge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {
    @DisplayName("다리 길이 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3"})
    void readBridgeSize(String input) {
        //given
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        int size = inputView.readBridgeSize();
        //then
        assertThat(size).isSameAs(3);
    }
    @DisplayName("이동할 칸 U 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U"})
    void readMovingU(String input) {
        //given
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        String move = inputView.readMoving();
        //then
        assertThat(move).isEqualTo("U");
    }
    @DisplayName("이동할 칸 D 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"D"})
    void readMovingD(String input) {
        //given
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        String move = inputView.readMoving();
        //then
        assertThat(move).isEqualTo("D");
    }
    @DisplayName("게임 재시작 및 종료 입력 테스트 Q")
    @ParameterizedTest
    @ValueSource(strings = {"Q"})
    void readGameCommandQ(String input) {
        //given
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        String move = inputView.readGameCommand();
        //then
        assertThat(move).isEqualTo("Q");
    }
    @DisplayName("게임 재시작 및 종료 입력 테스트 R")
    @ParameterizedTest
    @ValueSource(strings = {"R"})
    void readGameCommandR(String input) {
        //given
        InputView inputView = new InputView();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //when
        System.setIn(in);
        String move = inputView.readGameCommand();
        //then
        assertThat(move).isEqualTo("R");
    }
    @DisplayName("값이 정수가 아닐 경우 테스트")
    @Test
    void isValidateValue() {
        //given
        InputView inputView = new InputView();
        String size = "3s";
        //when
        try {
            inputView.isValidateValue(size);
        } catch (IllegalArgumentException e) {
            //then
            assertThat(e.getMessage()).isEqualTo("[ERROR]: 정수로 변환될 수 없음");
        }
    }
    @DisplayName("값이 유효한 범위가 아닐 경우 테스트")
    @Test
    void isValidateRange() {
        //given
        InputView inputView = new InputView();
        String size = "25";
        //when
        try {
            inputView.isValidateRange(size);
        } catch (IllegalArgumentException e) {
            //then
            assertThat(e.getMessage()).isEqualTo("[ERROR]: 범위 초과 3~20사이로 재입력");
        }
    }
    @DisplayName("값이 U,D가 아닐 경우 테스트")
    @Test
    void isValidateUD() {
        //given
        InputView inputView = new InputView();
        String size = "R";
        //when
        try {
            inputView.isValidateUD(size);
        } catch (IllegalArgumentException e) {
            //then
            assertThat(e.getMessage()).isEqualTo("[ERROR]: U과 D만 입력");
        }
    }
}
