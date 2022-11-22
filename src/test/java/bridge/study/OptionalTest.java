package bridge.study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

public class OptionalTest {

    @Test
    @DisplayName("옵셔널의 orElseThrow는 값이 있으면 해당 값을 반환한다.")
    void Optional_orElseThrow_값_반환_기능_테스트() {
        Optional<String> test = Optional.of("hello");
        assertThat(test.orElseThrow()).isEqualTo("hello");
    }

    @Test
    @DisplayName("옵셔널의 orElseThrow는 값이 없으면 명시해준 에러를 발생시킨다.")
    void Optional_orElseThrow_예외_발생_테스트() {
        Optional<String> test = Optional.empty();
        assertThatThrownBy(() -> test.orElseThrow(() -> new IllegalArgumentException("값이 없는 경우")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
