package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    @DisplayName("다리 길이가 3 이상 20 이하의 숫자범위 초과시, 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource({"1","2","21","22","100"})
    void isValidateSize(int size) {
        assertThatThrownBy(() -> new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("건널 수 있는 U(위 칸), D(아래 칸) 생성")
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        for (int size = 3; size <= 20; size++) {
            List<String> list = bridgeMaker.makeBridge(size);
            int count = 0;
            count = countUpDown(list, count);
            Assertions.assertThat(count).isEqualTo(size);
        }
    }

    private static int countUpDown(List<String> list, int count) {
        for (String element : list) {
            if (list.contains("U") || list.contains("D")) {
                count++;
            }
        }
        return count;
    }

}