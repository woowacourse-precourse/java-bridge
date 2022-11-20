package bridge;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("makeBridge 메소드에 3부터 20 사이의 숫자를 입력하였을 때 방향을 담은 숫자 크기의 리스트를 반환하는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 6, 19, 20})
    void makeBridge_test(int size) {
        List<String> directions = List.of("U", "D");

        List<String> actual = bridgeMaker.makeBridge(size);

        assertThat(actual.stream()
                .filter(direction -> directions.stream().anyMatch(Predicate.isEqual(direction)))
                .count()).isEqualTo(size);
    }

    @DisplayName("makeBridge 메소드에 3부터 20 이외의 숫자를 입력하였을 때 오류를 발생시키는지 확인")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21, 22, 23})
    void makeBridge_error_test(int size) {
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}