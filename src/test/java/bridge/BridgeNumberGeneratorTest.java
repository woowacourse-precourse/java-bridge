package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeNumberGeneratorTest {

    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    @DisplayName("인터페이스 구현 객체를 통함 랜덤 넘버 생성 테스트")
    @Test
    void createRandomNumber() {
        int randomNumber;

        randomNumber = bridgeNumberGenerator.generate();

        assertThat(randomNumber).isBetween(0, 1);
    }
}