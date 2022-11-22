package bridge;

import static bridge.Type.DirectionType.DOWN;
import static bridge.Type.DirectionType.UP;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.Type.DirectionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTypeTest {

    @DisplayName("UP 의 num 은 1이어야 한다")
    @Test
    void UP_GetNum_test() {
        int num = UP.getNum();
        assertThat(num).isEqualTo(1);
    }

    @DisplayName("UP 의 str 은 U이어야 한다")
    @Test
    void UP_GetStr_test() {
        String str = UP.getStr();
        assertThat(str).isEqualTo("U");
    }

    @DisplayName("Down 의 num 은 0이어야 한다")
    @Test
    void Down_GetNum_test() {
        int num = DOWN.getNum();
        assertThat(num).isEqualTo(0);
    }

    @DisplayName("Down 의 str 은 D이어야 한다")
    @Test
    void Down_GetStr_test() {
        String str = DOWN.getStr();
        assertThat(str).isEqualTo("D");
    }

    @DisplayName("Number 를 통해 String 을 찾을 수 있다")
    @Test
    void findByNum() {
        DirectionType directionType = DirectionType.findByNum(0);
        assertThat(directionType.getStr()).isEqualTo("D");
    }


    @DisplayName("String 를 통해 Number 을 찾을 수 있다")
    @Test
    void findByString() {
        DirectionType directionType = DirectionType.findByString("U");
        assertThat(directionType.getNum()).isEqualTo(1);
    }


    @DisplayName("String과 같은지 비교할 수 있다")
    @Test
    void equalTest() {
        String str = "D";
        assertThat(DOWN.equalDirection(str)).isEqualTo(true);
    }


}
