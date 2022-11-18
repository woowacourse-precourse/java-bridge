package bridge.domain.bridge.model;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMapComponentTest {
    @Test
    public void 숫자로_생성_하는_경우_테스트() {
        int up = 1;
        int down = 0;
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(BridgeMapComponent.fromCode(up)).isEqualTo(BridgeMapComponent.UP);
                    softAssertions.assertThat(BridgeMapComponent.fromCode(down)).isEqualTo(BridgeMapComponent.DOWN);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "3"})
    public void 잘못된_숫자로_생성시_예외_발생(Integer input) {
        Assertions.assertThatThrownBy(() ->
                        BridgeMapComponent.fromCode(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void 시그니처로_생성_하는_경우_테스트() {
        String up = "U";
        String down = "D";
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(BridgeMapComponent.fromSignature(up)).isEqualTo(BridgeMapComponent.UP);
                    softAssertions.assertThat(BridgeMapComponent.fromSignature(down)).isEqualTo(BridgeMapComponent.DOWN);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "C", "UP"})
    public void 잘못된_시그니처로_생성시_경우_예외_발생(String input) {
        Assertions.assertThatThrownBy(() ->
                        BridgeMapComponent.fromSignature(input))
                .isInstanceOf(NoSuchElementException.class);
    }

}