package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    InputView inputView = new InputView();

    private void setSetIn(String input) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Nested
    @DisplayName("다리 길이 입력 검증")
    class BridgeLength{

        @Nested
        @DisplayName("숫자가 아닌 다른 것이 입력된 경우")
        class NotNumeric{

            @Test
            @DisplayName("한글 입력시 예외 발생")
            void 한글_입력(){
                // given
                String input = "ㄱ";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

            @Test
            @DisplayName("영어 입력시 예외 발생")
            void 영어_입력(){
                // given
                String input = "a";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

            @Test
            @DisplayName("기호 입력시 예외 발생")
            void 기호_입력(){
                // given
                String input = "*";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

            @Test
            @DisplayName("+가 붙은 범위 내 숫자 들어오면 정상 처리")
            void 기호_붙은_양수_입력(){
                // given
                String input = "+3";
                // when
                setSetIn(input);
                int result = inputView.readBridgeLength();
                // then
                assertThat(result).isEqualTo(3);
            }
        }

        @Nested
        @DisplayName("지정된 길이의 범위를 벗어나는 경우")
        class OutOfRange{

            @Test
            @DisplayName("범위 미만일 경우 예외 발생")
            void 범위_미만(){
                // given
                String input = "2";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

            @Test
            @DisplayName("범위 초과일 경우 예외 발생")
            void 범위_초과(){
                // given
                String input = "21";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readBridgeLength());
            }

        }
    }
}