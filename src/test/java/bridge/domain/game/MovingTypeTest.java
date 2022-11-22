package bridge.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MovingTypeTest {

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
            MovingType result = MovingType.getMovingTypeByNumNotation(numNotation);
            return result.getEngNotation();
        }
    }

    @Nested
    @DisplayName("BridgeType에 포함된 옵션인지 확인하는 로직 검증")
    class ContainOption{

        @Test
        @DisplayName("선택지에 없는 옵션은 false값 리턴")
        void 선택지에_없는_옵션(){
            // given
            String bridgeType = "X";
            // when
            boolean result = MovingType.isContains(bridgeType);
            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("U 옵션은 true 값 리턴")
        void 선택지에_있는_U_옵션(){
            // given
            String bridgeType = "U";
            // when
            boolean result = MovingType.isContains(bridgeType);
            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("D 옵션은 true 값 리턴")
        void 선택지에_있는_D_옵션(){
            // given
            String bridgeType = "D";
            // when
            boolean result = MovingType.isContains(bridgeType);
            // then
            assertThat(result).isTrue();
        }
    }
}