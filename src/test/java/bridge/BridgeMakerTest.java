package bridge;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeMakerTest {

    @Test
    @DisplayName("생성된 다리의 길이가 입력한 다리의 길이와 일치하는가?")
    void bridge_length() {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("U와 D로 만들어진 다리를 UpDown Enum을 통해 다시 1과 0으로 바꾸었을 때 처음 입력한 값과 같은가?")
    void bridge_Number() {
        List<Integer> compareNumber = new ArrayList<>();
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        List<Integer> generatorNumbers = new ArrayList<>(List.of(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        for (String shape : bridge) {
            int shapeUD = UpDown.test(shape);
            compareNumber.add(shapeUD);
        }
        assertThat(compareNumber).isEqualTo(generatorNumbers);

    }

}
