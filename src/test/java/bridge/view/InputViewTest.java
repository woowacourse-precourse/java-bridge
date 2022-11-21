package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.*;

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

    @Nested
    @DisplayName("이동 옵션 입력 검증")
    class MovingOption{

        @Nested
        @DisplayName("유효하지 않은 타입의 입력 검증")
        class InValid{

            @Test
            @DisplayName("숫자 입력시 예외 출력")
            void 숫자_입력(){
                // given
                String input = "1";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readMoving());
            }

            @Test
            @DisplayName("한글 입력시 예외 출력")
            void 한글_입력(){
                // given
                String input = "가";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readMoving());
            }

            @Test
            @DisplayName("기호 입력시 예외 출력")
            void 기호_입력(){
                // given
                String input = "*";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readMoving());
            }
        }

        @Nested
        @DisplayName("유효하지 않은 옵션의 입력")
        class InvalidOption{

            @Test
            @DisplayName("U나 D가 아닌 경우")
            void 유효하지_않은_옵션(){
                // given
                String input = "X";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readMoving());
            }
        }


        @Nested
        @DisplayName("유효한 입력")
        class Valid{

            @Test
            @DisplayName("U 입력시 U 반환")
            void 대문자_입력U(){
                // given
                String input = "U";
                // when
                setSetIn(input);
                String result = inputView.readMoving();
                // then
                assertThat(result).isEqualTo("U");
            }

            @Test
            @DisplayName("u 입력시 U 반환")
            void 소문자_입력u(){
                // given
                String input = "u";
                // when
                setSetIn(input);
                String result = inputView.readMoving();
                // then
                assertThat(result).isEqualTo("U");
            }
            @Test
            @DisplayName("D 입력시 D 반환")
            void 대문자_입력D(){
                // given
                String input = "D";
                // when
                setSetIn(input);
                String result = inputView.readMoving();
                // then
                assertThat(result).isEqualTo("D");
            }

            @Test
            @DisplayName("d 입력시 D 반환")
            void 소문자_입력d(){
                // given
                String input = "d";
                // when
                setSetIn(input);
                String result = inputView.readMoving();
                // then
                assertThat(result).isEqualTo("D");
            }
        }
    }

    @Nested
    @DisplayName("재시작 옵션 입력 검증")
    class RestartOption{

        @Nested
        @DisplayName("유효하지 않은 타입의 입력 검증")
        class InValid{

            @Test
            @DisplayName("숫자 입력시 예외 출력")
            void 숫자_입력(){
                // given
                String input = "1";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readGameCommand());
            }

            @Test
            @DisplayName("한글 입력시 예외 출력")
            void 한글_입력(){
                // given
                String input = "가";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readGameCommand());
            }

            @Test
            @DisplayName("기호 입력시 예외 출력")
            void 기호_입력(){
                // given
                String input = "*";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readGameCommand());
            }
        }

        @Nested
        @DisplayName("유효하지 않은 옵션의 입력")
        class InvalidOption{

            @Test
            @DisplayName("Q나 R이 아닌 경우")
            void 유효하지_않은_옵션(){
                // given
                String input = "X";
                // when
                setSetIn(input);
                // then
                assertThatThrownBy(() ->
                        inputView.readGameCommand());
            }
        }

        @Nested
        @DisplayName("유효한 입력")
        class ValidOption{

            @Test
            @DisplayName("Q 입력시 Q 반환")
            void 입력_Q(){
                // given
                String input = "Q";
                // when
                setSetIn(input);
                String result = inputView.readGameCommand();
                // then
                assertThat(result).isEqualTo("Q");
            }

            @Test
            @DisplayName("q 입력시 Q 반환")
            void 입력_q(){
                // given
                String input = "q";
                // when
                setSetIn(input);
                String result = inputView.readGameCommand();
                // then
                assertThat(result).isEqualTo("Q");
            }

            @Test
            @DisplayName("R 입력시 R 반환")
            void 입력_R(){
                // given
                String input = "R";
                // when
                setSetIn(input);
                String result = inputView.readGameCommand();
                // then
                assertThat(result).isEqualTo("R");
            }

            @Test
            @DisplayName("r 입력시 R 반환")
            void 입력_r(){
                // given
                String input = "r";
                // when
                setSetIn(input);
                String result = inputView.readGameCommand();
                // then
                assertThat(result).isEqualTo("R");
            }
        }
    }
    }