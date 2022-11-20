package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import bridge.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

class ValidatorTest {

    @DisplayName("입력된 리스트의 길이가 주어진 범위에 속하는지 검증")
    @Test
    void 입력된_리스트의_길이가_주어진_범위에_속하는지_검증하는_기능_테스트(){
        //given
        int startInclusive = 3;
        int endInclusive = 5;
        List<Integer> case1 = List.of(1,2,3);
        List<Integer> case2 = List.of();
        List<Integer> case3 = List.of(1,2,3,4,5,6);

        //when
        Throwable result1 = catchThrowable(()->{
            Validator.validateListLengthInRange(case1, startInclusive, endInclusive);
        });
        Throwable result2 = catchThrowable(()->{
            Validator.validateListLengthInRange(case2, startInclusive, endInclusive);
        });
        Throwable result3 = catchThrowable(()->{
            Validator.validateListLengthInRange(case3, startInclusive, endInclusive);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }
}