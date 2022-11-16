package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {

    @DisplayName("입력 받은 길이만큼 건널 수 있는 다리의 칸을 생성한다.")
    @Test
    public void 건널_수_있는_다리의_칸_생성_테스트() {
        String inputValue = "3";
        ArrayList<Integer> crossablePositions = Application.makeCrossablePositions(inputValue);

        Assertions.assertThat(crossablePositions.size()).isEqualTo(Integer.parseInt(inputValue));

        Assertions.assertThat(crossablePositions.stream().filter(crossablePosition ->
                (crossablePosition == 0 || crossablePosition == 1)).count()).isEqualTo(Integer.parseInt(inputValue));
    }

    @DisplayName("3에서 20 사이의 숫자를 길이로 입력받지 못하면 예외가 발생한다.")
    @Test
    public void 다리_길이_입력_유효성_테스트() {
        final String inputValue1 = "abc";
        final String inputValue2 = "111111111111111";
        Assertions.assertThatThrownBy(() -> Application.makeCrossablePositions(inputValue1))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() -> Application.makeCrossablePositions(inputValue2))
                .isInstanceOf(IllegalArgumentException.class);




    }

    @DisplayName("입력에 맞게 다리를 생성한다.")
    @Test
    public void 다리_생성_테스트() {

        ArrayList<StringBuilder> sb = new ArrayList<>();
        sb.add(new StringBuilder("[ "));
        sb.add(new StringBuilder("[ "));

        ArrayList<Integer> crossablePositions = new ArrayList<>(List.of(0, 0, 1));

        Application.makeBridge('U', sb, crossablePositions);

        Assertions.assertThat(sb.get(0)).isEqualTo("[ o ]");
        Assertions.assertThat(sb.get(1)).isEqualTo("[   ]");

        Application.makeBridge('U', sb, crossablePositions);

        Assertions.assertThat(sb.get(0)).isEqualTo("[ o | o ]");
        Assertions.assertThat(sb.get(1)).isEqualTo("[   |   ]");

        Application.makeBridge('U', sb, crossablePositions);

        Assertions.assertThat(sb.get(0)).isEqualTo("[ o | o |   ]");
        Assertions.assertThat(sb.get(1)).isEqualTo("[   |   | o ]");
    }
}
