package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("알맞은 길이를 입력하면 해당 길이의 다리를 생성한다.")
    @Test
    void makeBridge() {
        //given
        int size = 5;

        //when
        List<String> bridges = bridgeMaker.makeBridge(size);

        //then
        assertThat(bridges).isNotEmpty();
        assertThat(bridges.size()).isEqualTo(size);
    }

    @DisplayName("생성된 다리의 칸은 정해진 값(U or D)만을 가진다.")
    @Test
    void bridgeCellTypeTest() {
        //given
        int size = 5;

        //when
        List<String> bridges = bridgeMaker.makeBridge(size);

        //then
        List<String> cellTypes = Arrays.stream(BridgeCellType.values())
            .map(BridgeCellType::getCellType)
            .collect(Collectors.toList());

        bridges.forEach(cell -> assertThat(cellTypes).contains(cell));
    }

}