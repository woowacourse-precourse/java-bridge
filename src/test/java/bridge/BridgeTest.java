package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest extends NsTest {
    public static Exeption exeption = new Exeption();
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("다리 개수 예외_테스트_확인 에러메세지 발생")
    void 다리_개수_예외_발생_테스트_확인() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("문자를 입력했을 때 에러메세지 발생")
    @Test
    void 문자를_입력_했을_때() {
        assertSimpleTest(() -> {
            runException("abcd");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("숫자 범위를 잘못 입력했을 때 에러메세지 발생")
    @Test
    void 숫자_범위를_잘못_입력_했을_떄1() {
        assertSimpleTest(() -> {
            runException("25");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("숫자 범위를 잘못 입력했을 때 에러메세지 발생")
    @Test
    void 숫자_범위를_잘못_입력_했을_떄2() {
        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    @DisplayName("숫자 범위 잘못 입력했을 때_IllegalArgumentExcption_발생")
    @Test
    void 숫자_범위_잘못_입력_했을_때_IllegalArgumentExcption_발생() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> exeption.isRightRange("-1"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> exeption.isRightRange("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생")
    @Test
    void 유저_입력_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> exeption.isUorD("11"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("재시작_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생")
    @Test
    void 재시작_물음에_잘못된_값을_넣으면_IllegalArgumentExcption_발생() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> exeption.isRorQ("11"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 네개_한번에_성공_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U","U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O | O ]",
                    "[   | O |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O | O ]");
            int downSideIndex = output().indexOf("[   | O |   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    @Test
    void 다섯개_재시도_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(" ", "5", "U", "D", "U", "D", "R", "U", "D", "U", "U", "U");
                    assertThat(output()).contains(
                            "다리의 길이를 입력해주세요.",
                            "[ERROR] : 숫자를 입력해주세요 ",
                            "다리의 길이를 입력해주세요.",
                            "다리 건너기 게임을 시작합니다.",
                            "[ O |   | O |   ]",
                            "[   | O |   | X ]",
                            "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                            "최종 게임 결과",
                            "[ O |   | O | O | O ]",
                            "[   | O |   |   |   ]",
                            "게임 성공 여부: 성공",
                            "총 시도한 횟수: 2"

                    );
                    int upSideIndex = output().indexOf("[ O |   | O | O | O ]");
                    int downSideIndex = output().indexOf("[   | O |   |   |   ]");
                    assertThat(upSideIndex).isLessThan(downSideIndex);
                }, 1, 0, 1
        );
    }
    @Test
    void 실패_후_종료_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D","Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isEqualTo(downSideIndex);
        }, 1, 0, 1);
    }


    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
