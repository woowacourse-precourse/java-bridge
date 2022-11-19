package bridge;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("makeBridge 메소드에 숫자를 입력하였을 때 방향을 담은 숫자 크기의 리스트를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void makeBridge_test(int size) {
        List<String> directions = List.of("U", "D");

        List<String> actual = bridgeMaker.makeBridge(size);

        assertThat(actual.stream()
                .filter(direction -> directions.stream().anyMatch(Predicate.isEqual(direction)))
                .count()).isEqualTo(size);
    }
}