package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @DisplayName("다리 길이에 대한 입력을 있는 그대로 받고 있는지 검증합니다.")
    @Test
    public void readBridgeSizeTest() {
        //given
        String input = "3";

        //when
        InputStream sysInBackup = System.in; // System.in을 원래대로 복구하기 위해 선언
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String inputResult = InputView.readBridgeSize();

        //then
        assertThat(inputResult).isEqualTo(input);
        System.setIn(sysInBackup);
    }

    @DisplayName("다리 길이 입력값이 숫자인지 검증")
    @Test
    public void validateBridgeLengthTest() {
        String input = "12ee334";

        assertThatThrownBy(() -> InputView.validateBridgeLength(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 입력의 범위 유효성 검증")
    @Test
    public void validateBridgeLengthRange() {
        int input = 45;

        assertThatThrownBy(() -> InputView.validateBridgeLengthRange(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
