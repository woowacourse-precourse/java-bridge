package bridge.service;

import bridge.view.Valification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ValificationTest {
    Valification valification = new Valification();

    @Nested
    class verifyBridgeSizeTest {

        @DisplayName("다리 길이를 2 입력했을때 에러 뜨는지 확인")
        @Test
        void case1() {
            int testNumber = 2;

            assertThatThrownBy(() -> valification.verifyBridgeSize(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }

        @DisplayName("다리 길이를 21 입력했을때 에러 뜨는지 확인")
        @Test
        void case2() {
            int testNumber = 21;

            assertThatThrownBy(() -> valification.verifyBridgeSize(testNumber))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("다리 길이는 3부터 20 사이의 숫자여야 합니다.");

        }
    }

    @Nested
    class verifyUorDTest {

        @DisplayName("U를 두번 입력했을때 에러 뜨는지 확인")
        @Test
        void caase1() {
            String test = "UU";

            assertThatThrownBy(() -> valification.verifyUorD(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("U, D 두개 중에 하나 선택 해야 합니다.");
        }

        @DisplayName("D를 두번 입력했을때 에러 뜨는지 확인")
        @Test
        void caase2() {
            String test = "DD";

            assertThatThrownBy(() -> valification.verifyUorD(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("U, D 두개 중에 하나 선택 해야 합니다.");
        }

        @DisplayName("U나 D 가 아닌 다른 문자를 입력했을때 에러 뜨는지 확인")
        @Test
        void caase3() {
            String test = "A";

            assertThatThrownBy(() -> valification.verifyUorD(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("U, D 두개 중에 하나 선택 해야 합니다.");
        }

    }

    @Nested
    class verifyQorRTest {

        @DisplayName("R를 두번 입력했을 때 에러 뜨는지 확인 ")
        @Test
        void caase1() {
            String test = "RR";

            assertThatThrownBy(() -> valification.verifyQorR(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("R, Q 두개 중에 하나 선택 해야 합니다.");
        }

        @DisplayName("Q를 두번 입력했을 때 에러 뜨는지 확인")
        @Test
        void caase2() {
            String test = "QQ";

            assertThatThrownBy(() -> valification.verifyQorR(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("R, Q 두개 중에 하나 선택 해야 합니다.");
        }

        @DisplayName("R이나 Q가 아닌 다른 문자를 입력했을 때 에러 뜨는지 확인")
        @Test
        void caase3() {
            String test = "U";

            assertThatThrownBy(() -> valification.verifyQorR(test))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("R, Q 두개 중에 하나 선택 해야 합니다.");
        }
    }

}