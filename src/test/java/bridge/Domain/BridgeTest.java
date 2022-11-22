package bridge.Domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void init(){
        bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
    }

    @DisplayName("다리의 각 칸은 U 또는 D로 이루어져 있어야 한다.")
    @Test
    void isUOrD() {
        bridge.makeBridge(3);
        List<String> spaces = bridge.getSpaces();

        assertThat(spaces.stream().allMatch(v -> v.equals("U") || v.equals("D"))).isTrue();
    }

    @DisplayName("다리는 입력한 사이즈만큼 만들어져야 한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,3", "10,10", "20,20"})
    void checkBridgeSize(int size, int expect){
        bridge.makeBridge(size);
        int result = bridge.getSize();

        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("주어진 인덱스에 해당하는 다리 칸 정보를 가져와야한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,0", "2,1"})
    void getIndexOf(int size, int index) {
        bridge.makeBridge(size);
        String result = bridge.getIndexOf(index);

        String expect = bridge.getSpaces().get(index);

        assertThat(result).isEqualTo(expect);
    }
}