package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeTest {
//ParameterizedTest 로 바꿔서 해보기
    List<String> list1 = List.of("U");
    List<String> list2 = List.of("D");
    Bridge bridge1 = new Bridge(list1);
    Bridge bridge2 = new Bridge(list2);

    String input1 = "U";
    String input2 = "U";
    int index = 0;

    @Test
    void 다리_각_칸의_값과_입력값을_비교하는_기능_테스트() {
        PassFail result = bridge1.compare(input1, index);
        Assertions.assertThat(result).isEqualTo(PassFail.PASS);

        PassFail result2 = bridge2.compare(input2, index);
        Assertions.assertThat(result2).isEqualTo(PassFail.FAIL);
    }
}