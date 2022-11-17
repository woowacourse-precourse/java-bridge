package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker;

    @BeforeEach()
    void setUp() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }
}
