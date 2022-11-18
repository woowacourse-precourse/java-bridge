package bridge.input;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {
    static class MockSizeBridgeInput3 implements BridgeInput {
        @Override
        public String readData() {
            return "3";
        }
    }

    static class MockSizeBridgeInput20 implements BridgeInput {
        @Override
        public String readData() {
            return "20";
        }
    }

    static class MockBridgeInputU implements BridgeInput {
        @Override
        public String readData() {
            return "U";
        }
    }

    static class MockBridgeInputD implements BridgeInput {
        @Override
        public String readData() {
            return "D";
        }
    }

    static class MockBridgeInputR implements BridgeInput {
        @Override
        public String readData() {
            return "R";
        }
    }

    static class MockBridgeInputQ implements BridgeInput {
        @Override
        public String readData() {
            return "Q";
        }
    }

    @DisplayName("다리 길이 입력 테스트")
    @Nested
    class inputSize {
        @DisplayName("3~20 사이의 값을 입력할 경우 값이 반환된다 - 1")
        @Test
        void correctBridgeSize1() {
            //given
            BridgeInput input = new MockSizeBridgeInput3();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            int size = inputView.readBridgeSize();

            //then
            assertThat(size).isEqualTo(3);
        }

        @DisplayName("3~20 사이의 값을 입력할 경우 값이 반환된다 - 2")
        @Test
        void correctBridgeSize2() {
            //given
            BridgeInput input = new MockSizeBridgeInput20();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            int size = inputView.readBridgeSize();

            //then
            assertThat(size).isEqualTo(20);
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 다리 길이 범위 외의 값을 입력할 경우 false 가 반환된다. - 1")
            @Test
            void exceptBridgeSizeRange1() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateBridgeSize("21");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("정해진 다리 길이 범위 외의 값을 입력할 경우 false 가 반환된다. - 1")
            @Test
            void exceptBridgeSizeRange2() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateBridgeSize("2");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("입력 값이 정수가 아닌 경우 false 가 반환된다. - 1")
            @Test
            void exceptBridgeSizeInteger1() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateBridgeSize("a2");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("입력 값이 정수가 아닌 경우 false 가 반환된다. - 2")
            @Test
            void exceptBridgeSizeInteger2() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateBridgeSize("2.2");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("입력 값이 정수가 아닌 경우 false 가 반환된다. - 3")
            @Test
            void exceptBridgeSizeInteger3() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateBridgeSize("ab");

                //then
                assertThat(bool).isFalse();
            }
        }
    }

    @DisplayName("이동 입력 테스트")
    @Nested
    class inputMove {
        @DisplayName("U를 입력할 경우 char U 가 반환된다")
        @Test
        void correctBridgeMoveU() {
            //given
            BridgeInput input = new MockBridgeInputU();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            char move = inputView.readMoving();

            //then
            assertThat(move).isEqualTo('U');
        }

        @DisplayName("D를 입력할 경우 char D 가 반환된다")
        @Test
        void correctBridgeMoveD() {
            //given
            BridgeInput input = new MockBridgeInputD();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            char move = inputView.readMoving();

            //then
            assertThat(move).isEqualTo('D');
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 Move Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptBridgeSizeRange1() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateMoveCommand("F");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("정해진 Move Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptBridgeSizeRange2() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateMoveCommand("2");

                //then
                assertThat(bool).isFalse();
            }
        }
    }

    @DisplayName("게임 재시작/ 종료 입력 테스트")
    @Nested
    class inputGameCommand {
        @DisplayName("R을 입력할 경우 char R 이 반환된다")
        @Test
        void inputR() {
            //given
            BridgeInput input = new MockBridgeInputR();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            char gameCommand = inputView.readGameCommand();

            //then
            assertThat(gameCommand).isEqualTo('R');
        }

        @DisplayName("Q을 입력할 경우 char Q 이 반환된다")
        @Test
        void inputQ() {
            //given
            BridgeInput input = new MockBridgeInputQ();
            BridgeInputValidator validator = new BasicBridgeInputValidator();
            InputView inputView = new InputView(input, validator);

            //when
            char gameCommand = inputView.readGameCommand();

            //then
            assertThat(gameCommand).isEqualTo('Q');
        }

        @DisplayName("예외 테스트")
        @Nested
        class exceptSize {
            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommandE() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateGameCommand("E");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommandr() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateGameCommand("r");

                //then
                assertThat(bool).isFalse();
            }

            @DisplayName("정해진 Game Command 가 아닐 경우 false 를 반환한다.")
            @Test
            void exceptGameCommand4a() {
                //given
                BridgeInputValidator validator = new BasicBridgeInputValidator();

                //when
                boolean bool = validator.validateGameCommand("4a");

                //then
                assertThat(bool).isFalse();
            }
        }
    }
}