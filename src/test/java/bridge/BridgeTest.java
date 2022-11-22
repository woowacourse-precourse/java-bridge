package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {
    @Test
    @DisplayName("bridge 생성 후에 next 실행시 요소가 제대로 반환되는가")
    void createBridgeAndCallNext() throws Exception {
        //given
        List<String> bridgeInput = List.of("U", "D", "U", "D", "U");
        Bridge bridge = new Bridge(bridgeInput);
        List<Character> expect = List.of(
                new BridgeElement("U").getElement(),
                new BridgeElement("D").getElement(),
                new BridgeElement("U").getElement(),
                new BridgeElement("D").getElement(),
                new BridgeElement("U").getElement()
        );
        List<Character> result = new ArrayList<>();
        //when
        for (int i = 0; i < bridgeInput.size(); i++) {
            result.add(bridge.next().getElement());
        }
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("리셋 후에 next 실행시 요소가 제대로 반환되는가")
    void resetAndCallNext() throws Exception {
        //given
        List<String> bridgeInput = List.of("U", "D", "U", "D", "U");
        Bridge bridge = new Bridge(bridgeInput);
        List<Character> expect = List.of(
                new BridgeElement("U").getElement(),
                new BridgeElement("D").getElement(),
                new BridgeElement("U").getElement(),
                new BridgeElement("D").getElement(),
                new BridgeElement("U").getElement()
        );
        List<Character> result = new ArrayList<>();
        //when
        for (int i = 0; i < bridgeInput.size(); i++) {
            bridge.next();
        }
        bridge.reset();

        for (int i = 0; i < bridgeInput.size(); i++) {
            result.add(bridge.next().getElement());
        }
        //then
        assertThat(result).isEqualTo(expect);
    }

}