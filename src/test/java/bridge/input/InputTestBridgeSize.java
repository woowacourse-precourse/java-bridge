package bridge.input;

import bridge.Application;
import bridge.validation.ValidationCheck;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTestBridgeSize {
    @DisplayName("다리 길이 입력 테스트 : 숫자가 아닌 영어 입력")
    @Test
    void testBridgeSizeByNotANumber() {
        String input = "a";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().toInts(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력")
    @Test
    void testBridgeSizeOutOfRange1() {
        String input = "1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int bridgeSize = new ValidationCheck().toInts(input);
        assertThatThrownBy(() -> new ValidationCheck().checkBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력 2")
    @Test
    void testBridgeSizeOutOfRange2() {
        String input = "21";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int bridgeSize = new ValidationCheck().toInts(input);
        assertThatThrownBy(() -> new ValidationCheck().checkBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 소수 입력")
    @Test
    void testBridgeSizeByFloatingNumber() {
        String input = "3.5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().toInts(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : space bar (whitespace 입력)")
    @Test
    void testBridgeSizeBySpaceBar() {
        String input = " ";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().isBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 줄바뀜 문자 입력")
    @Test
    void testBridgeSizeByOpeningChar() {
        String input = "\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> new ValidationCheck().isBlank(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
