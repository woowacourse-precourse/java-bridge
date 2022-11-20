package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTypeTest {

    @Nested
    @DisplayName("숫자로 BridgeType 가져오기 로직 검증")
    class getBridgeTypeByNumNotation{

        @Test
        @DisplayName("입력이 1이면 가져온 BridgeType의 engNotation은 U")
        void 입력_1(){
            // given
            int numNotation = 1;
            // when
            String resultEngNotation = getResultEngNotation(numNotation);
            // then
            assertThat(resultEngNotation).isEqualTo("U");
        }

        @Test
        @DisplayName("입력이 0이면 가져온 BridgeType의 engNotation은 D")
        void 입력_2(){
            // given
            int numNotation = 0;
            // when
            String resultEngNotation = getResultEngNotation(numNotation);
            // then
            assertThat(resultEngNotation).isEqualTo("D");
        }

        @Test
        @DisplayName("1이나 2가 아닌 입력이 들어오면 예외")
        void 예외(){
            // given
            int numNotation = 2;
            // when
            // then
            assertThatThrownBy(() -> getResultEngNotation(numNotation))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        private String getResultEngNotation(int numNotation) {
            BridgeType result = BridgeType.getBridgeTypeByNumNotation(numNotation);
            return result.getEngNotation();
        }
    }
}