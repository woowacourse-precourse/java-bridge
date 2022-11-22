package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InfiniteInputTest {
    private final int defaultValue = 0;
    private OutputView outputView;
    private InfiniteInput<Integer> integerInfiniteInput;

    @BeforeEach
    void setIntegerInfiniteInput(){
        outputView = new OutputView();
        integerInfiniteInput = new InfiniteInput<>(defaultValue);
    }

    @DisplayName("defaultValue 값이 반환될 때까지 계속해서 실행한다.")
    @Test
    void testGetInput(){
        int count = 3;
        Counter counter = new Counter(count);
        assertSimpleTest(() -> {
           integerInfiniteInput.getInput(() -> counter.run(), outputView);
           assertThat(counter.getCount())
                   .isEqualTo(count);
        });
    }

    private class Counter{
        private int count;
        private final int target;

        public Counter(int target){
            count = 0;
            this.target = target;
        }

        /***
         * target - count 번 메소드를 실행
         * <p>
         * 실행 시 count 값을 증가시키며 target 값에 도달했을 때 count 값을 반환하고 그 외에는 defaultValue 값을 반환한다.
         */
        public int run(){
            ++this.count;
            if(this.count == this.target){
                return this.count;
            }
            return defaultValue;
        }

        public int getCount() {
            return count;
        }
    }
}
