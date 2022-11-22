package bridge.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicBridgeInputAlphabetParserTest extends NsTest{

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 빈 문자열일 경우 (공백)")
    @Test
    void checkAlphabetException1() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("  ", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳이 아닌 경우 (숫자)")
    @Test
    void checkAlphabetException2() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("3", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳이 아닌 다른게 섞인 경우")
    @Test
    void checkAlphabetException3() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("3a3", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳인데 소문자가 섞인 경우")
    @Test
    void checkAlphabetException4() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("e", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳이 아닌 다른게 섞인 경우 2")
    @Test
    void checkAlphabetException5() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("E3", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳이 여러개로 구성된 경우")
    @Test
    void checkAlphabetException6() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("EE", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 알파벳이 여러개로 구성된 경우 (대,소문자 섞임)")
    @Test
    void checkAlphabetException7() {
        assertThatThrownBy(() -> BasicBridgeInputAlphabetParser.parseBridgeGameInput("Ee", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 값이 대문자 알파벳이 맞는지 확인하기 - 올바른 알파벳 입력 - 한 글자")
    @Test
    void checkAlphabetException8() {
        BasicBridgeInputAlphabetParser.parseBridgeGameInput("E", 0);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}