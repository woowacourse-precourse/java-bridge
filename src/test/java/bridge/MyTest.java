package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MyTest {

    @DisplayName("입력 받은 길이만큼 건널 수 있는 다리의 칸을 생성한다.")
    @Test
    public void 다리_생성_테스트() {
        String inputValue = "3";
        ArrayList<Integer> crossablePositions = Application.makeCrossablePositions(inputValue);

        Assertions.assertThat(crossablePositions.size()).isEqualTo(Integer.parseInt(inputValue));

        Assertions.assertThat(crossablePositions.stream().filter(crossablePosition ->
                (crossablePosition == 0 || crossablePosition == 1)).count()).isEqualTo(Integer.parseInt(inputValue));
    }
}
