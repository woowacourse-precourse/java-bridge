package bridge.controller;

import bridge.mock.MockObjectMaker;
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
                    = MockObjectMaker.makeMockGameController(List.of(0, 1, 0, 1), "4", "D", "U", "D", "U");

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
                    = MockObjectMaker.makeMockGameController(List.of(0, 1, 0), "3", "D", "O", "U", "D");

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
                    = MockObjectMaker.makeMockGameController(List.of(1, 1, 0), "3", "D", "R", "D", "Q");

            //when
            gameController.doGame();

            //then
            assertOutputInGivenQuitingInputsWhenDoingGameThenPrintsMessage();

        }

        private void assertOutputInGivenQuitingInputsWhenDoingGameThenPrintsMessage() {
            assertThat(captor.toString())
                    .isEqualTo(String.format(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ X ]") +
                            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n" + "%n" +
                            getEachStepMessage("[   ]", "[ X ]") +
                            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)%n" + "%n" +
                            getResultMapMessage("[   ]", "[ X ]") +
                            getResultMessage(false, 2)
                    ));
        }

        private void assertOutputInGivenInvalidInputsWhenDoingGameThenPrintsMessageAndInputAgain() {
            assertThat(captor.toString())
                    .isEqualTo(String.format(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ O ]") +
                            getAskingNextMoveMessage() +
                            "[ERROR] 이동할 칸으로는 대문자 U 또는 D 둘 중 하나만 입력하실 수 있습니다. 다시 입력해 주세요.%n" +
                            getStepMapMessage("[   | O ]", "[ O |   ]") +
                            getEachStepMessage("[   | O |   ]", "[ O |   | O ]") +
                            getResultMapMessage("[   | O |   ]", "[ O |   | O ]") +
                            getResultMessage(true, 1)
                    ));
        }

        private void assertOutputInGivenInputsWhenDoingGameThenPrintsMessage() {
            assertThat(captor.toString())
                    .isEqualTo(String.format(getGameStartMessage() +
                            getEachStepMessage("[   ]", "[ O ]") +
                            getEachStepMessage("[   | O ]", "[ O |   ]") +
                            getEachStepMessage("[   | O |   ]", "[ O |   | O ]") +
                            getEachStepMessage("[   | O |   | O ]", "[ O |   | O |   ]") +
                            getResultMapMessage("[   | O |   | O ]", "[ O |   | O |   ]") +
                            getResultMessage(true, 1)
                    ));
        }

        private String getGameStartMessage() {
            return "다리 건너기 게임을 시작합니다.%n" + "%n" +
                    "다리의 길이를 입력해주세요.%n" + "%n";
        }

        private String getEachStepMessage(String upBridgeMap, String downBridgeMap) {
            return getAskingNextMoveMessage() + getStepMapMessage(upBridgeMap, downBridgeMap);
        }

        private String getAskingNextMoveMessage() {
            return "이동할 칸을 선택해주세요. (위: U, 아래: D)%n";
        }

        private String getStepMapMessage(String upBridgeMap, String downBridgeMap) {
            return upBridgeMap + "%n" + downBridgeMap + "%n" + "%n";
        }

        private String getResultMapMessage(String upBridgeMap, String downBridgeMap) {
            return "최종 게임 결과%n" + getStepMapMessage(upBridgeMap, downBridgeMap);
        }

        private String getResultMessage(boolean isSucceed, int tryCount) {
            String succeedMessage = null;
            if (isSucceed) {
                succeedMessage = "성공";
            }
            if (!isSucceed) {
                succeedMessage = "실패";
            }
            return String.format("게임 성공 여부: %s%%n" + "총 시도한 횟수: %d", succeedMessage, tryCount);
        }
    }
}