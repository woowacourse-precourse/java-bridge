package bridge.view;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {
    @Nested
    class ReadSizeTest extends NsTest {
        @DisplayName("입력 안내문 출력 테스트")
        @Test
        void testPrint() {
            Assertions.assertSimpleTest(() -> run("5"));
            assertThat(output()).contains("다리의 길이를 입력해주세요.");
        }

        @DisplayName("에러 메세지 정상 출력 테스트")
        @Test
        void ErrorMessage() {
            try {
                Assertions.assertSimpleTest(() -> run("입력 오류"));
            } catch (IllegalArgumentException e) {
                assertThat(e.getMessage()).isEqualTo("[ERROR] 숫자만 입력할 수 있습니다.");
            }
        }

        @DisplayName("스페이스바 입력")
        @Test
        void nonNumeric1() {
            assertThatThrownBy(() -> run(" "))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("영어 입력")
        @Test
        void nonNumeric2() {
            assertThatThrownBy(() -> run("three"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("한글 입력")
        @Test
        void nonNumeric3() {
            assertThatThrownBy(() -> run("삼"))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            InputView.readBridgeSize();
        }
    }

    @Nested
    class ReadMoveTest extends NsTest {
        @DisplayName("입력 안내문 출력 테스트")
        @Test
        void testPrint() {
            Assertions.assertSimpleTest(() -> run("U"));
            assertThat(output()).contains("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            InputView.readMoving();
        }
    }

    @Nested
    class ReadGameCommandTest extends NsTest {
        @DisplayName("입력 안내문 출력 테스트")
        @Test
        void testPrint() {
            Assertions.assertSimpleTest(() -> run("Q"));
            assertThat(output()).contains("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        }

        @Override
        protected void runMain() {
            InputView inputView = new InputView();
            InputView.readGameCommand();
        }
    }

}