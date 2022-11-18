package bridge.domain.bridge.model;

import java.util.NoSuchElementException;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMapDirectionTest {
    @Test
    public void 숫자로_생성_하는_경우_테스트() {
        int up = 1;
        int down = 0;
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(BridgeDirection.fromCode(up)).isEqualTo(BridgeDirection.UP);
                    softAssertions.assertThat(BridgeDirection.fromCode(down)).isEqualTo(BridgeDirection.DOWN);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "3"})
    public void 잘못된_숫자로_생성시_예외_발생(Integer input) {
        Assertions.assertThatThrownBy(() ->
                        BridgeDirection.fromCode(input))
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    public void 시그니처로_생성_하는_경우_테스트() {
        String up = "U";
        String down = "D";
        SoftAssertions.assertSoftly(softAssertions -> {
                    softAssertions.assertThat(BridgeDirection.fromSignature(up)).isEqualTo(BridgeDirection.UP);
                    softAssertions.assertThat(BridgeDirection.fromSignature(down)).isEqualTo(BridgeDirection.DOWN);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "C", "UP"})
    public void 잘못된_시그니처로_생성시_경우_예외_발생(String input) {
        Assertions.assertThatThrownBy(() ->
                        BridgeDirection.fromSignature(input))
                .isInstanceOf(NoSuchElementException.class);
    }

}