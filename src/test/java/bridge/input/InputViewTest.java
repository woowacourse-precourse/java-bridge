package bridge.input;

import bridge.controller.GameCommand;
import bridge.controller.MoveCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    static class MockSizeBridgeInput implements BridgeInput {
        @Override
        public String readData() {
            return "2131af";
        }
    }

    BridgeInput inputer = new ConsoleBridgeInput();
    BridgeValidator validator = new BasicBridgeValidator();

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class inputSize {
        @DisplayName("3~20 사이의 값을 입력할 경우 값이 반환된다")
        @Test
        void correctBridgeSize1() {
            //given
            InputView inputView = new InputView(inputer, validator);

            //when
            String input = "3\n20";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            int size = inputView.readBridgeSize();
            int size2 = inputView.readBridgeSize();

            //then
            assertThat(size).isEqualTo(3);
            assertThat(size2).isEqualTo(20);
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 다리 길이 범위 외의 값을 입력할 경우 예외가 발생한다")
            @Test
            void exceptBridgeSizeRange1() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "21";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readBridgeSize)
                        .isInstanceOf(RuntimeException.class);
            }

            @DisplayName("입력 값이 정수가 아닌 경우 예외가 발생한다.")
            @Test
            void exceptBridgeSizeInteger1() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "2a";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readBridgeSize)
                        .isInstanceOf(RuntimeException.class);
            }

            @DisplayName("입력 값이 정수가 아닌 경우 예외가 발생한다.")
            @Test
            void exceptBridgeSizeInteger2() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "2.2";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readBridgeSize)
                        .isInstanceOf(RuntimeException.class);
            }
        }
    }

    @DisplayName("이동 입력 테스트")
    @Nested
    class inputMove {
        @DisplayName("MoveCommand 를 입력하면 해당 command가 반환된다")
        @Test
        void correctBridgeMove() {
            //given
            InputView inputView = new InputView(inputer, validator);

            //when
            String input = MoveCommand.UP.getCommand();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String move = inputView.readMoving();

            //then
            assertThat(move).isEqualTo("U");
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 Move Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptBridgeSizeRange1() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "f";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readGameCommand)
                        .isInstanceOf(RuntimeException.class);
            }
        }
    }

    @DisplayName("게임 재시작/ 종료 입력 테스트")
    @Nested
    class inputGameCommand {
        @DisplayName("GameCommand 를 입력할경우 해당 command가 반환된다")
        @Test
        void inputR() {
            //given
            InputView inputView = new InputView(inputer, validator);

            //when
            String input = GameCommand.RESTART.getCommand();
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            String move = inputView.readGameCommand();

            //then
            assertThat(move).isEqualTo(GameCommand.RESTART.getCommand());
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommand1() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "r";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readGameCommand)
                        .isInstanceOf(RuntimeException.class);
            }

            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommand2() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "1";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readGameCommand)
                        .isInstanceOf(RuntimeException.class);
            }

            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommand3() {
                //given
                InputView inputView = new InputView(inputer, validator);

                //when
                String input = "q";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                //then
                assertThatThrownBy(inputView::readGameCommand)
                        .isInstanceOf(RuntimeException.class);
            }
        }
    }
}