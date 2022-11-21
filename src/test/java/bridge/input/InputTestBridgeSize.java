package bridge.input;

import bridge.Application;
import bridge.validation.ValidationCheck;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputTestBridgeSize extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private ValidationCheck validationCheck;
    @BeforeEach
    void beforeTestSetting(){
        validationCheck = new ValidationCheck();
    }
    @DisplayName("다리 길이 입력 테스트 : 숫자가 아닌 영어 입력")
    @Test
    void testBridgeSizeByNotANumber() {
        InputStream in = new ByteArrayInputStream("a".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.toInts(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력")
    @Test
    void testBridgeSizeOutOfRange1() {
        InputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        int bridgeSize = validationCheck.toInts(Console.readLine());
        assertThatThrownBy(() -> validationCheck.checkBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 범위를 벗어나는 숫자 입력 2")
    @Test
    void testBridgeSizeOutOfRange2() {
        InputStream in = new ByteArrayInputStream("21".getBytes());
        System.setIn(in);
        int bridgeSize = validationCheck.toInts(Console.readLine());
        assertThatThrownBy(() -> validationCheck.checkBridgeSizeRange(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 소수 입력")
    @Test
    void testBridgeSizeByFloatingNumber() {
        InputStream in = new ByteArrayInputStream("3.5".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.toInts(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : space bar (whitespace 입력)")
    @Test
    void testBridgeSizeBySpaceBar() {
        InputStream in = new ByteArrayInputStream(" ".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.isBlank(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("다리 길이 입력 테스트 : 줄바뀜 문자 입력")
    @Test
    void testBridgeSizeByOpeningChar() {
        InputStream in = new ByteArrayInputStream("\n".getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> validationCheck.isBlank(Console.readLine()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
