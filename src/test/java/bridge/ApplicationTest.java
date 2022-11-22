package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.Controller.BridgeSizeValidator;
import bridge.Controller.GameCommandValidator;
import bridge.Controller.MovingCommandValidator;
import bridge.Controller.Validator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeResult;
import bridge.View.InputView;
import bridge.View.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 입력 가능한 범위를 초과하였습니다.(3 <= N <= 20)";
    private static final String ERROR_NON_EXISTENT_COMMAND = "[ERROR] 올바르지 않은 명령입니다.";
    private static InputStream in;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Validator validator;
    private static BridgeGame bridgeGame;
    private static BridgeResult bridgeResult;

    //region 다리길이입력 단위 테스트 케이스
    @Test
    void 다리길이입력_예외테스트_문자입력(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("a");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_제어문자입력(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("\n");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최소경계값초과(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("2");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최대경계값초과(){
        assertThatThrownBy(() -> {
            validator = new BridgeSizeValidator();
            validator.validate("31");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_기능테스트_최소경계값(){
        String input = "3";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(3);
    }

    @Test
    void 다리길이입력_기능테스트_최대경계값(){
        String input = "30";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(30);
    }
    //endregion

    //region 다리생성 단위 테스트 케이스
    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 다리_생성_테스트_길이30() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0,
                1, 0, 0, 1, 1, 1, 0, 0, 1, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(30);
        assertThat(bridge).containsExactly(
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D",
                "U", "D", "D", "U", "U", "U", "D", "D", "U", "D");
    }
    //endregion

    //region 이동할 칸 입력 단위 테스트 케이스
    @Test
    void 이동할_칸_입력_예외테스트_지정문자이외입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("B");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_소문자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("u");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_숫자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("5");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_예외테스트_제어문자입력(){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("\r");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_기능테스트_U(){
        String input = "U";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readMoving();
        assertThat(movingCommand).isEqualTo("U");
    }

    @Test
    void 이동할_칸_입력_기능테스트_D(){
        String input = "D";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readMoving();
        assertThat(movingCommand).isEqualTo("D");
    }
    //endregion

    //region 다리이동결과 단위 테스트 케이스
    @Test
    void 다리이동결과출력_기능테스트_성공(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeResult = new BridgeResult();
        bridgeResult = bridgeGame.move(0, "U", bridgeResult);
        outputView.printMap(bridgeResult);
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }
    @Test
    void 다리이동결과출력_기능테스트_실패1(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeResult = new BridgeResult(
                new LinkedList<>(List.of("O")),
                new LinkedList<>(List.of(" "))
        );
        bridgeResult = bridgeGame.move(1, "U", bridgeResult);
        outputView.printMap(bridgeResult);
        assertThat(output()).contains(
                "[ O | X ]",
                "[   |   ]"
        );
    }

    @Test
    void 다리이동결과출력_기능테스트_실패2(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U", "U", "D"));
        bridgeResult = new BridgeResult(
                new LinkedList<>(List.of("O", " ", "O")),
                new LinkedList<>(List.of(" ", "O", " "))
        );
        bridgeResult = bridgeGame.move(3, "D", bridgeResult);
        outputView.printMap(bridgeResult);
        assertThat(output()).contains(
                "[ O |   | O |   ]",
                "[   | O |   | X ]"
        );
    }

    @Test
    void 다리이동결과출력_기능테스트_실패3(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U", "U", "D"));
        bridgeResult = new BridgeResult(
                new LinkedList<>(List.of("O", " ")),
                new LinkedList<>(List.of(" ", "O"))
        );
        bridgeResult = bridgeGame.move(2, "U", bridgeResult);
        bridgeResult = bridgeGame.move(3, "D", bridgeResult);
        outputView.printMap(bridgeResult);
        assertThat(output()).contains(
                "[ O |   | O |   ]",
                "[   | O |   | X ]"
        );
    }
    //endregion

    //region 재시작 혹은 종료 입력 단위 테스트 케이스
    @Test
    void 재시작혹은종료_예외테스트_지정문자이외입력(){
        assertThatThrownBy(() -> {
            validator = new GameCommandValidator();
            validator.validate("ㅁ");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 재시작혹은종료_예외테스트_소문자입력(){
        assertThatThrownBy(() -> {
            validator = new GameCommandValidator();
            validator.validate("r");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 재시작혹은종료_예외테스트_숫자입력(){
        assertThatThrownBy(() -> {
            validator = new GameCommandValidator();
            validator.validate("1");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 재시작혹은종료_예외테스트_제어문자입력(){
        assertThatThrownBy(() -> {
            validator = new GameCommandValidator();
            validator.validate("\n");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    @Test
    void 이동할_칸_입력_기능테스트_R(){
        String input = "R";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String gameCommand = inputView.readGameCommand();
        assertThat(gameCommand).isEqualTo("R");
    }
    //endregion

    //region 재시작 시 초기화 단위 테스트 케이스
    @Test
    void 재시작시초기화_기능테스트1(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeResult = new BridgeResult();
        bridgeResult = bridgeGame.move(0, "D", bridgeResult);
        assertThat(bridgeResult.getLastResult()).isEqualTo("X");
    }

    @Test
    void 재시작시초기화_기능테스트2(){
        bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        bridgeResult = new BridgeResult();
        bridgeResult = bridgeGame.move(0, "U", bridgeResult);
        assertThat(bridgeResult.getLastResult()).isEqualTo("O");
    }
    //endregion

    //region 최종 결과 출력 단위 테스트 케이스
    @Test
    void 최종결과출력_기능테스트(){
        bridgeResult = new BridgeResult(
                new LinkedList<>(List.of("O", " ", "O")),
                new LinkedList<>(List.of(" ", "O", " "))
        );
        String result = "실패";
        if (bridgeResult.getLastResult().equals("O")){
            result = "성공";
        }
        outputView.printResult(bridgeResult, result, 3);
        assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
        );
        int upSideIndex = output().indexOf("[ O |   | O ]");
        int downSideIndex = output().indexOf("[   | O |   ]");
        assertThat(upSideIndex).isLessThan(downSideIndex);
    }
    //endregion

    @Test
    void 이동할_칸_입력_기능테스트_Q(){
        String input = "Q";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String gameCommand = inputView.readGameCommand();
        assertThat(gameCommand).isEqualTo("Q");
    }
    //endregion

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
