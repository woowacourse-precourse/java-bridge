package bridge.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@Nested
class BridgeTest {
    @Test
    void 정상_입력값이_20개() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.size()).isEqualTo(20);
    }

    @Test
    void 정상_입력값이_3개() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("D");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.size()).isEqualTo(3);
    }

    @Test
    void 예외_입력값_3보다_작다() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            temp.add("D");
        }
        Assertions.assertThatThrownBy(() -> new Bridge(temp)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_입력값_20보다_크다() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            temp.add("D");
        }
        Assertions.assertThatThrownBy(() -> new Bridge(temp)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 예외_입력값에_U_D_이외_값() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add("D");
        }
        temp.add("NOT");
        Assertions.assertThatThrownBy(() -> new Bridge(temp)).isInstanceOf(IllegalArgumentException.class);
    }

    // canMove 테스트
    @Test
    void 정상_해당_위치에_갈수_있음() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.canMove(2, FootrestLocation.UP)).isTrue();
    }

    @Test
    void 정상_해당_위치에_갈수_없음() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.canMove(2, FootrestLocation.DOWN)).isFalse();
    }

    @Test
    void 예외_다리_범위_바깥_인덱스_물어봄() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThatThrownBy(() -> bridge.canMove(3, FootrestLocation.UP))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 예외_0보다_작은_인덱스로_물어봄() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThatThrownBy(() -> bridge.canMove(-1, FootrestLocation.UP))
                .isInstanceOf(IllegalStateException.class);
    }
    // 입력값이 FootrestLocation 아닌 경우는 입력 자체가 불가능

    //isLast
    @Test
    void 정상_해당_위치가_마지막_O() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.isLast(2)).isTrue();
    }

    @Test
    void 정상_해당_위치가_마지막_X() {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            temp.add("U");
        }
        Bridge bridge = new Bridge(temp);
        Assertions.assertThat(bridge.isLast(1)).isFalse();
    }
}