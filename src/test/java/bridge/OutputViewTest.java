package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OutputViewTest {

    @Test
    @DisplayName("다리의 출력이 잘 되는지 확인")
    public void printMapTest() {
        OutputView outputView = new OutputView();
        List<String> yesOrNo = new ArrayList<String>();
        yesOrNo.add("O");
        yesOrNo.add("O");
        yesOrNo.add("O");
        int size = 3;
        List<String> upAndDown = new ArrayList<String>();
        upAndDown.add("U");
        upAndDown.add("U");
        upAndDown.add("U");
        String[][] answer = {{"O", }, {"O", }, {"O", }};
        String answers = Arrays.deepToString(answer);
        answers.replaceAll(",", "|");
        assertThat(outputView.printMap(yesOrNo, upAndDown, size).equals(answers));
    }
}
