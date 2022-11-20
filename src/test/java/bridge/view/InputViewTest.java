package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputViewTest {

    // 사용자 입력
    static void putSystemInput(String input) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    /**
     * readBridgeSize - 다리의 길이 입력
     */
    @DisplayName("다리의 길이는 3 이상 ~ 20 이하의 숫자")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void readBridgeSize_테스트(String input) {
        putSystemInput(input);
        assertThat(Integer.parseInt(input)).isEqualTo(InputView.readBridgeSize());
    }

    @DisplayName("다리의 길이 입력에 대한 예외처리")
    @ValueSource(strings = {"-11", "0", "21", "1아랄라0", "아랄라", "aralla"})
    @ParameterizedTest
    void readBridgeSize_예외_테스트(String input) {
        putSystemInput(input);
        assertSimpleTest(() ->
                assertThatThrownBy(InputView::readBridgeSize)
                        .isInstanceOf(IllegalArgumentException.class));
    }

}
