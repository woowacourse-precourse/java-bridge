package bridge.domain.view;

import bridge.dto.CorrectInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OutputViewTest {
    OutputView outputView;
    List<CorrectInfo> correctInfos;

    @BeforeEach
    void beforeEach(){
        outputView = new OutputView();
        correctInfos = new ArrayList<>();
    }


    @Test
    @DisplayName("2칸 중 2칸을 적중")
    public void printMapCorrect() throws Exception{
        //given
        correctInfos.add(CorrectInfo.createCorrectInfo("U", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "D"));
        //when
        String bridge = outputView.printMap(correctInfos);
        //then

        assertThat(bridge).isEqualTo("[ O |   ]\n[   | O ]");
    }

    @Test
    @DisplayName("3칸 중 2칸만 적중")
    public void printMapInCorrect() throws Exception{
        //given
        correctInfos.add(CorrectInfo.createCorrectInfo("U", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "D"));
        //when
        String bridge = outputView.printMap(correctInfos);
        //then
        assertThat(bridge).isEqualTo("[ O |   ]\n[   | X ]");
    }

    @Test
    @DisplayName("실패 + 3회 메세지")
    public void printResultV1(){
        //given
        boolean success = false;
        int count = 3;
        correctInfos.add(CorrectInfo.createCorrectInfo("U", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "D"));
        //when
        String result = outputView.printResult(correctInfos, success, count);
        //then
        assertThat(result).contains("게임 성공 여부: 실패\n총 시도한 횟수: 3");
    }

    @Test
    @DisplayName("성공 + 1회 메세지")
    public void printResultV2() throws Exception{
        //given
        boolean success = true;
        int count = 1;
        correctInfos.add(CorrectInfo.createCorrectInfo("U", "U"));
        correctInfos.add(CorrectInfo.createCorrectInfo("D", "D"));
        //when
        String result = outputView.printResult(correctInfos, success, count);
        //then
        assertThat(result).contains("게임 성공 여부: 성공\n총 시도한 횟수: 1");
    }
}