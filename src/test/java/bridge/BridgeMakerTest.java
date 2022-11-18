package bridge;

import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {
    @DisplayName("0이 들어오면 다리에 'D'가 추가되고 1이 들어오면 다리에 'U'가 추가된다.")
    @Test
    void createOneBlock() {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(BridgeMaker.makeOneBlock(0)).as("0인 경우").isEqualTo("D");
        softAssertions.assertThat(BridgeMaker.makeOneBlock(1)).as("1인 경우").isEqualTo("U");
        softAssertions.assertAll();
    }
}