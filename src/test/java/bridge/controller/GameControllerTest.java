package bridge.controller;

import bridge.mock.MockObjectMaker;
import bridge.system.validation.InputToMovingPointValidator;
import bridge.view.outputview.OutputView;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameControllerTest 테스트 (= 통합테스트)")
class GameControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Nested
    @DisplayName("다리 건너기 게임 전체를 진행하는 doGame 메서드")
    class DoGameTest {
        @Test
        @DisplayName("게임이 진행됨에 따라 정확한 메시지가 출력된다.")
        void givenInputs_whenDoingGame_thenPrintsMessage() {
            //given
            GameController gameController
                    = MockObjectMaker.makeMockGameController(List.of(0, 1, 0, 1), List.of("4", "D", "U", "D", "U"));

            //when
            gameController.doGame();

            //then
            assertOutputInGivenInputsWhenDoingGameThenPrintsMessage();
        }

        @Test
        @DisplayName("게임 진행 중 잘못된 입력이 주어졌을 때 메시지를 출력하고 다시 받는 정확한 메시지가 출력된다.")
        void givenInvalidInputs_whenDoingGame_thenPrintsMessageAndInputAgain() {
            //given
            GameController gameController
                    = MockObjectMaker.makeMockGameController(List.of(0, 1, 0), List.of("3", "D", "O", "U", "D"));

            //when
            gameController.doGame();

            //then
            assertOutputInGivenInvalidInputsWhenDoingGameThenPrintsMessageAndInputAgain();
        }

        @Test
        @DisplayName("게임 진행 중 중도 포기했을 때 정확한 메시지가 출력된다.")
        void givenQuitingInputs_whenDoingGame_thenPrintsMessage() {
            //given
            GameController gameController
                    = MockObjectMaker.makeMockGameController(List.of(1, 1, 0), List.of("3", "D", "R", "D", "Q"));

            //when
            gameController.doGame();

            //then
            assertOutputInGivenQuitingInputsWhenDoingGameThenPrintsMessage();

        }

        private void assertOutputInGivenQuitingInputsWhenDoingGameThenPrintsMessage() {
            assertThat(captor.toString())
                    .isEqualTo(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ X ]") +
                            String.format(OutputView.ASKING_GAME_COMMAND_MESSAGE) +
                            getEachStepMessage("[   ]", "[ X ]") +
                            String.format(OutputView.ASKING_GAME_COMMAND_MESSAGE) +
                            getResultMapMessage("[   ]", "[ X ]") +
                            getResultMessage(false, 2)
                    );
        }

        private void assertOutputInGivenInvalidInputsWhenDoingGameThenPrintsMessageAndInputAgain() {
            assertThat(captor.toString())
                    .isEqualTo(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ O ]") +
                            getAskingNextMoveMessage() +
                            getErrorMessage(InputToMovingPointValidator.INVALID_INPUT_VALUE_MESSAGE) +
                            getStepMapMessage("[   | O ]", "[ O |   ]") +
                            getEachStepMessage("[   | O |   ]", "[ O |   | O ]") +
                            getResultMapMessage("[   | O |   ]", "[ O |   | O ]") +
                            getResultMessage(true, 1)
                    );
        }

        private void assertOutputInGivenInputsWhenDoingGameThenPrintsMessage() {
            assertThat(captor.toString())
                    .isEqualTo(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ O ]") +
                            getEachStepMessage("[   | O ]", "[ O |   ]") +
                            getEachStepMessage("[   | O |   ]", "[ O |   | O ]") +
                            getEachStepMessage("[   | O |   | O ]", "[ O |   | O |   ]") +
                            getResultMapMessage("[   | O |   | O ]", "[ O |   | O |   ]") +
                            getResultMessage(true, 1)
                    );
        }

        private String getGameStartMessage() {
            return String.format(OutputView.GAME_STARTING_MESSAGE +
                    OutputView.ASKING_BRIDGE_SIZE_MESSAGE);
        }

        private String getErrorMessage(String errorMessage) {
            return String.format(OutputView.ERROR_MESSAGE_FORMAT, errorMessage);
        }

        private String getEachStepMessage(String upBridgeMap, String downBridgeMap) {
            return getAskingNextMoveMessage() + getStepMapMessage(upBridgeMap, downBridgeMap);
        }

        private String getAskingNextMoveMessage() {
            return String.format(OutputView.ASKING_NEXT_STEP_MESSAGE);
        }

        private String getStepMapMessage(String upBridgeMap, String downBridgeMap) {
            return String.format(upBridgeMap + "%n" + downBridgeMap + "%n");
        }

        private String getResultMapMessage(String upBridgeMap, String downBridgeMap) {
            return String.format(OutputView.GAME_RESULT_PREFIX + getStepMapMessage(upBridgeMap, downBridgeMap));
        }

        private String getResultMessage(boolean isSucceed, int tryCount) {
            String succeedOrNotMessage = null;
            if (isSucceed) {
                succeedOrNotMessage = OutputView.GAME_SUCCESS_MESSAGE;
            }
            if (!isSucceed) {
                succeedOrNotMessage = OutputView.GAME_FAILURE_MESSAGE;
            }
            return succeedOrNotMessage + getTryingCountMessage(tryCount);
        }

        private String getTryingCountMessage(int tryCount) {
            return String.format(OutputView.TRY_COUNT_MESSAGE_FORMAT, tryCount);
        }
    }
}