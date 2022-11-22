package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import constant.Values.MoveCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckerTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    void 기능_테스트_다리길이_입력() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkValidate("15")).isEqualTo(15);
        });
    }

    @DisplayName("올바른 이동 커맨드 입력 시 정상 동작")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void 기능_테스트_이동_입력(String input) {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkMoveValidate(input)).isEqualTo(input);
        });
    }

    @Test
    void 기능_테스트_이동_결과() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkMoveSuccess("U", "U")).isEqualTo(MoveCase.UP_UP);
            assertThat(new Checker().checkMoveSuccess("U", "D")).isEqualTo(MoveCase.UP_DOWN);
            assertThat(new Checker().checkMoveSuccess("D", "D")).isEqualTo(MoveCase.DOWN_DOWN);
            assertThat(new Checker().checkMoveSuccess("D", "U")).isEqualTo(MoveCase.DOWN_UP);
        });
    }


    @DisplayName("올바른 재시도 커맨드 입력 시 정상 동작")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void 기능_테스트_재시도_입력(String input) {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkGameOption(input)).isEqualTo(input);
            assertThat(new Checker().checkGameOption(input)).isEqualTo(input);
        });
    }


    @Test
    void 기능_테스트_재시도() {
        assertSimpleTest(() -> {
            assertThat(new Checker().checkRetry("R")).isEqualTo(true);
        });
    }


    @DisplayName("잘못된 다리 길이 입력 시 예외 처리")
    @ValueSource(strings = {"A", "-5", "22", " ", "qerqw", " 5 ", " 7", "7 "})
    @ParameterizedTest
    void 예외_테스트_다리길이(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkValidate(input);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("잘못된 이동 커맨드 입력 시 예외 처리")
    @ValueSource(strings = {"A", "-5", "22", " ", "qerqw", " 5 ", " 7", "7 "})
    @ParameterizedTest
    void 예외_테스트_이동(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkMoveValidate(input);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @DisplayName("잘못된 재시작 커맨드 입력 시 예외 처리")
    @ValueSource(strings = {"A", "-5", "22", " ", "qerqw", " 5 ", " 7", "7 "})
    @ParameterizedTest
    void 예외_테스트_재시작(String input) {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> {
                new Checker().checkGameOption(input);
            }).isInstanceOf(IllegalArgumentException.class);
            output().contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {

    }
}
