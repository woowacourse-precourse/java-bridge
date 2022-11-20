package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeRandomNumberGeneratorTest {

    private static final int RANDOM_LOWER_INCLUSIVE = 0;
    private static final int RANDOM_UPPER_INCLUSIVE = 1;

    List<Integer> numbers;

    @BeforeEach
    @DisplayName("테스트를 위한 리스트 초기화")
    void init() {
        numbers = new ArrayList();
    }

    @DisplayName("0 또는 1 의 숫자만 나오는지 확인하는 테스트")
    @Test
    void generate() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        for (int i = 0; i < 100; i++) {
            numbers.add(bridgeNumberGenerator.generate());
        }
        assertThat(numbers.stream().allMatch(number -> number == RANDOM_LOWER_INCLUSIVE || number == RANDOM_UPPER_INCLUSIVE))
                .isTrue();
    }
}