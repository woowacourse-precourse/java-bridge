package bridge.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TryCountDtoTest {
    @Nested
    @DisplayName("tryCount의 카운트를 올리는 addCount 메서드")
    class AddCountTest {
        @Test
        @DisplayName("addCount 를 호출한 객체의 카운트가 1 올라간다.")
        void whenAddingCount_thenAddsCount() {
            //given
            TryCountDto tryCount = new TryCountDto();
            assertThat(tryCount.toString())
                    .as("생성했을 때 기본값은 0").isEqualTo("0");
            //when
            tryCount.addCount();

            //then
            assertThat(tryCount.toString())
                    .as("매서드를 호출하면 새 객체가 생성되지 않고 호출한 객체의 값이 변경된다.").isEqualTo("1");
        }
    }
}