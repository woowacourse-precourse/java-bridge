package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    @DisplayName("[성공] 0을 D로 변환시켜주는 기능")
    @Test
    void parseDownByZero() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.parseUpOrDownByNumber(0)).isEqualTo("D");
    }

    @DisplayName("[성공] 1을 U로 변환시켜주는 기능")
    @Test
    void parseUpByOne() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.parseUpOrDownByNumber(1)).isEqualTo("U");
    }

    @DisplayName("[예외 발생] 0이나 1 이외의 값일 경우 IllegalArgumentException 발생")
    @Test
    void parseUpOrDownByRangeNumber() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.parseUpOrDownByNumber(2)).isInstanceOf(
            IllegalArgumentException.class);
    }

    @DisplayName("[성공] 입력 받은 길이만큼 다리 생성")
    @Test
    void makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(4).size()).isEqualTo(4);
    }
}
