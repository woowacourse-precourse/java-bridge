package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @DisplayName("다리 한 부분을 만들떄 랜덤 숫자로 1을 받으면 U를 반환한다.")
    @Test
    public void makeBridgeOnePart_give1_returnU() {
        String result;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker one = new BridgeMaker(bridgeNumberGenerator);

        result = one.makeBridgeOnePart(1);

        assertThat(result).isEqualTo("U");
    }

    @DisplayName("다리 한 부분을 만들떄 랜덤 숫자로 0을 받으면 D를 반환한다.")
    @Test
    public void makeBridgeOnePart_give0_returnD() {
        String result;
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker one = new BridgeMaker(bridgeNumberGenerator);

        result = one.makeBridgeOnePart(0);

        assertThat(result).isEqualTo("D");
    }
}