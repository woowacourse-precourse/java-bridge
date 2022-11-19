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

    @Test
    void 정상_다리가_존재하는_인덱스_물어봄() {
        Assertions.fail("TODO");
    }

    @Test
    void 예외_다리_범위_바깥_인덱스_물어봄() {
        Assertions.fail("TODO");
    }

    @Test
    void 예외_0보다_작은_인덱스로_물어봄() {
        Assertions.fail("TODO");
    }

    @Test
    void 예외_입력값이_FootrestLocation_아님() {
        Assertions.fail("TODO");
    }

}