package bridge;

import bridge.Model.BridgeSizeValidator;
import bridge.Model.GameCommandValidator;
import bridge.Model.MovingCommandValidator;
import bridge.Model.Validator;
import bridge.View.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

public class InputTest extends NsTest {

    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 숫자 이외의 값을 입력할 수 없습니다.";
    private static final String ERROR_OUT_OF_RANGE = "[ERROR] 입력 가능한 범위를 초과하였습니다.(3 <= N <= 20)";
    private static final String ERROR_NON_EXISTENT_COMMAND = "[ERROR] 올바르지 않은 명령입니다.";
    private static final InputView inputView = new InputView();
    private static InputStream in;
    private Validator validator;

    void bridgeSizeValidationTest(String input, String ERROR){
        validator = new BridgeSizeValidator();
        assertThatThrownBy(() -> {
            validator.validate(input);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    void bridgeSizeUserInputTest(String input, int expected){
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int bridgeSize = inputView.readBridgeSize();
        assertThat(bridgeSize).isEqualTo(expected);
    }

    //region 다리길이입력 단위 테스트 케이스
    @Test
    void 다리길이입력_예외테스트_문자입력(){
        bridgeSizeValidationTest("a", ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_제어문자입력(){
        bridgeSizeValidationTest("\n", ERROR_NON_NUMERIC_VALUE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최소경계값초과(){
        bridgeSizeValidationTest("2", ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_예외테스트_범위초과_최대경계값초과(){
        bridgeSizeValidationTest("31", ERROR_OUT_OF_RANGE);
    }

    @Test
    void 다리길이입력_기능테스트_최소경계값(){
        bridgeSizeUserInputTest("3", 3);
    }

    @Test
    void 다리길이입력_기능테스트_최대경계값(){
        bridgeSizeUserInputTest("30", 30);
    }

    @Test
    void 다리길이입력_기능테스트_예외발생시_재입력(){
        String input = "a\n2\n3";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            inputView.readBridgeSize();
            assertThat(output()).contains("[ERROR]", "다리의 길이를 입력해주세요.");
            String target = "다리의 길이를 입력해주세요.";
            // 해당 문자열이 반복된 횟수 == 재입력이 일어난 횟수
            int count = (output().length() - output().replace(target, "").length()) / target.length();
            assertThat(count).isEqualTo(3);
        });
    }
    //endregion

    void movingCommandValidationTest(String input){
        assertThatThrownBy(() -> {
            validator = new MovingCommandValidator();
            validator.validate("B");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    void movingCommandUserInputTest(String input, String expected){
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readMoving();
        assertThat(movingCommand).isEqualTo(expected);
    }

    //region 이동할 칸 입력 단위 테스트 케이스
    @Test
    void 이동할_칸_입력_예외테스트_지정문자이외입력(){
        movingCommandValidationTest("B");
    }

    @Test
    void 이동할_칸_입력_예외테스트_소문자입력(){
        movingCommandValidationTest("u");
    }

    @Test
    void 이동할_칸_입력_예외테스트_숫자입력(){
        movingCommandValidationTest("5");
    }

    @Test
    void 이동할_칸_입력_예외테스트_제어문자입력(){
        movingCommandValidationTest("\r");
    }

    @Test
    void 이동할_칸_입력_기능테스트_U(){
        movingCommandUserInputTest("U", "U");
    }

    @Test
    void 이동할_칸_입력_기능테스트_D(){
        movingCommandUserInputTest("D", "D");
    }

    @Test
    void 이동할_칸_입력_기능테스트_예외발생시_재입력(){
        String input = "b\nu\nU";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            inputView.readMoving();
            assertThat(output()).contains("[ERROR]", "이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String target = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
            // 해당 문자열이 반복된 횟수 == 재입력이 일어난 횟수
            int count = (output().length() - output().replace(target, "").length()) / target.length();
            assertThat(count).isEqualTo(3);
        });
    }
    //endregion

    void gameCommandValidationTest(String input){
        assertThatThrownBy(() -> {
            validator = new GameCommandValidator();
            validator.validate("B");
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_NON_EXISTENT_COMMAND);
    }

    void gameCommandUserInputTest(String input, String expected){
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String movingCommand = inputView.readGameCommand();
        assertThat(movingCommand).isEqualTo(expected);
    }

    //region 재시작 혹은 종료 입력 단위 테스트 케이스
    @Test
    void 재시작혹은종료_예외테스트_지정문자이외입력(){
        gameCommandValidationTest("ㅁ");
    }

    @Test
    void 재시작혹은종료_예외테스트_소문자입력(){
        gameCommandValidationTest("r");
    }

    @Test
    void 재시작혹은종료_예외테스트_숫자입력(){
        gameCommandValidationTest("1");
    }

    @Test
    void 재시작혹은종료_예외테스트_제어문자입력(){
        gameCommandValidationTest("\n");
    }

    @Test
    void 재시작혹은종료_기능테스트_R(){
        gameCommandUserInputTest("R", "R");
    }

    @Test
    void 재시작혹은종료_기능테스트_Q(){
        gameCommandUserInputTest("Q", "Q");
    }

    @Test
    void 재시작혹은종료_기능테스트_예외발생시_재입력(){
        String input = "a\n2\nQ";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertSimpleTest(() -> {
            inputView.readGameCommand();
            assertThat(output()).contains("[ERROR]", "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String target = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
            // 해당 문자열이 반복된 횟수 == 재입력이 일어난 횟수
            int count = (output().length() - output().replace(target, "").length()) / target.length();
            assertThat(count).isEqualTo(3);
        });
    }
    //endregion

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
