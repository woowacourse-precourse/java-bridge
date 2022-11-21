package bridge.Domain;


import bridge.EnumCollections.BridgeResultType;
import bridge.EnumCollections.BridgeType;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultGeneratorTest {
    private GameResultGenerator gameResultGenerator;
    private GameResult moveUpSuccessResult;
    private GameResult moveDownFailResult;
    private GameResult moveUpFailResult;
    private GameResult moveDownSuccessResult;


    @BeforeEach
    void beforeEach() {
        this.gameResultGenerator = new GameResultGenerator();
        this.moveUpSuccessResult = new GameResult(BridgeType.UP, BridgeResultType.POSSIBLE);
        this.moveDownSuccessResult = new GameResult(BridgeType.DOWN, BridgeResultType.POSSIBLE);
        this.moveUpFailResult = new GameResult(BridgeType.UP, BridgeResultType.IMPOSSIBLE);
        this.moveDownFailResult = new GameResult(BridgeType.DOWN, BridgeResultType.IMPOSSIBLE);
    }

    @Nested
    @DisplayName("getUpperBridgeResult 메소드 테스트")
    class TestGetUpperBridgeResult {
        @Test
        @DisplayName("게임 결과가 Up/성공일 때 'O' 리턴")
        void getUpperBridgeResult_gameResultIsUpSuccess_returnO() {
            String result = gameResultGenerator.getUpperBridgeResult(moveUpSuccessResult);
            String expect = BridgeResultType.POSSIBLE.getResult();
            assertThat(result).isEqualTo(expect);
        }

        @Test
        @DisplayName("게임 결과가 Up/실패일 때 'X' 리턴")
        void getUpperBridgeResult_gameResultIsUpFail_returnX() {
            String result = gameResultGenerator.getUpperBridgeResult(moveUpFailResult);
            String expect = BridgeResultType.IMPOSSIBLE.getResult();
            assertThat(result).isEqualTo(expect);
        }

        @Test
        @DisplayName("게임 결과가 Down일 때 ' ' 리턴")
        void getUpperBridgeResult_gameResultIsDown_returnNone() {
            String result = gameResultGenerator.getUpperBridgeResult(moveDownFailResult);
            String expect = BridgeResultType.NONE.getResult();
            assertThat(result).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("getLowerBridgeResult 메소드 테스트")
    class TestGetLowerBridgeResult {
        @Test
        @DisplayName("게임 결과가 Down/성공일 때 'O' 리턴")
        void getLowerBridgeResult_gameResultIsDownSuccess_returnO() {
            String result = gameResultGenerator.getLowerBridgeResult(moveDownSuccessResult);
            String expect = BridgeResultType.POSSIBLE.getResult();
            assertThat(result).isEqualTo(expect);
        }

        @Test
        @DisplayName("게임 결과가 Down/실패일 때 'X' 리턴")
        void getLowerBridgeResult_gameResultIsDownFail_returnX() {
            String result = gameResultGenerator.getLowerBridgeResult(moveDownFailResult);
            String expect = BridgeResultType.IMPOSSIBLE.getResult();
            assertThat(result).isEqualTo(expect);
        }

        @Test
        @DisplayName("게임 결과가 Up일 때 ' ' 리턴")
        void getLowerBridgeResult_gameResultIsUp_returnNone() {
            String result = gameResultGenerator.getLowerBridgeResult(moveUpFailResult);
            String expect = BridgeResultType.NONE.getResult();
            assertThat(result).isEqualTo(expect);
        }

    }

    @Nested
    @DisplayName("addBridgeStatus 메소드 테스트")
    class TestAddBridgeStatus {
        private final List<String> expectSuccess = List.of("O");
        private final List<String> expectNone = List.of(" ");

        @Test
        @DisplayName("위쪽 게임 결과와, 아래쪽 게임 결과 입력 시 bridge 리스트에 상태 저장")
        void addBridgeStatus_inputUpperResultAndLowerResult_saveResultInBridgeList() {
            gameResultGenerator.addBridgeStatus("O", " ");
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(gameResultGenerator).as("위쪽 다리 상태 저장 확인")
                    .extracting("upperBridge").isEqualTo(expectSuccess);
            softAssertions.assertThat(gameResultGenerator).as("아래쪽 다리 상태 저장 확인")
                    .extracting("lowerBridge").isEqualTo(expectNone);
            softAssertions.assertAll();
        }
    }

    @Nested
    @DisplayName("getGameResultOutput 메소드 테스트")
    class TestGetGameResultOutput {

        private void setGameResult() {
            gameResultGenerator.addBridgeStatus("O", " ");
            gameResultGenerator.addBridgeStatus(" ", "O");
            gameResultGenerator.addBridgeStatus(" ", "X");
        }

        @Test
        @DisplayName("위쪽, 아래쪽 게임 결과 문자열로 리턴")
        void getGameResultOutput_setGameResult_returnBridgeStatus() {
            setGameResult();
            String result = gameResultGenerator.getGameResultOutput();
            String expect = "[ O |   |   ]\n[   | O | X ]";
            assertThat(result).isEqualTo(expect);
        }

    }

    @Nested
    @DisplayName("makeBridgeOutput 메소드 테스트")
    class TestMakeBridgeOutput {

        @Test
        @DisplayName("다리 생태 리스트를 요구하는 형식에 맞는 문자열로 리턴")
        void getGameResultOutput_inputBridgeStatus_returnBridgeWithFormat() {
            List<String> bridge = List.of("O", " ", "O", "X");
            String result = gameResultGenerator.makeBridgeOutput(bridge);
            String expect = "[ O |   | O | X ]";
            assertThat(result).isEqualTo(expect);
        }

    }

    @Nested
    @DisplayName("initGameResult 메소드 테스트")
    class TestInitGameResult {

        @Test
        @DisplayName("")
        void initGameResult_() {
            gameResultGenerator.initGameResult();
            List<String> expect = List.of();
            SoftAssertions softAssertions = new SoftAssertions();
            softAssertions.assertThat(gameResultGenerator).as("위쪽 다리 상태 초기화")
                    .extracting("upperBridge").isEqualTo(expect);
            softAssertions.assertThat(gameResultGenerator).as("아래쪽 다리 상태 초기화")
                    .extracting("lowerBridge").isEqualTo(expect);
            softAssertions.assertAll();
        }
    }

    @Nested
    @DisplayName("getBridgeStatus 메소드 테스트")
    class TestGetBridgeStatus {
        @Test
        @DisplayName("")
        void getBridgeStatus_() {
            String result = gameResultGenerator.getBridgeStatus(moveUpSuccessResult);
            String expect = "[ O ]\n[   ]";
            assertThat(result).isEqualTo(expect);
        }
    }
}