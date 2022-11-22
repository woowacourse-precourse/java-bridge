package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeElementTest {
    @Test
    @DisplayName("다리요소 생성 후 반환값 비교")
    void createElementAndGet() throws Exception {
        //given
        String rawElement = "U";
        Character expect = 'U';
        //when
        BridgeElement bridgeElement = new BridgeElement(rawElement);
        Character result = bridgeElement.getElement();
        //then
        assertThat(result).isEqualTo(expect);
    }
}