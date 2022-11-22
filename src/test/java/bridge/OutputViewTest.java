package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView = new OutputView();

    @Test
    void checkIndexTrue() {
        //GIVEN
        BirdgeMoveType GIVEN = BirdgeMoveType.upGoMovement;
        //WHEN
        List<ArrayList<String>> result = outputView.checkIndex(GIVEN);
        //THEN
        assertThat(outputView.printMapBorder(result).get(0)).contains("[ O ]");

        //List[0] Up했을때 리스트 | [1] down리스트
    }
    @Test
    @DisplayName("입력값과 랜덤으로 생성 값에 따라 리스트생성")

    void checkIndexFalse() {
        //GIVEN
        BirdgeMoveType GIVEN = BirdgeMoveType.upGoMovement;
        //WHEN
        List<ArrayList<String>> result = outputView.checkIndex(GIVEN);
        //THEN
        assertThat(outputView.printMapBorder(result).get(1)).contains("[   ]");

        //List[0] 윗길 | [1] 아랫길
    }
    @Test
    @DisplayName("리스트 내용물 출력형태로 고정하기")
    void printMapDetail() {


        //GIVEN
        List<ArrayList<String>> mapList = outputView.checkIndex(BirdgeMoveType.upGoMovement);
        //WHEN
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        outputView.printMapDetail(mapList);

        //THEN
        Assertions.assertThat("[ O ]\r\n" +
                "[   ]\r\n").isEqualTo(out.toString());

        //WHEN
        outputView.printMapBorder(mapList);
        //THEN
        Assertions.assertThat("[ O ]\r\n" +
                "[   ]\r\n").isEqualTo(out.toString());

    }
    @Test
    @DisplayName("리스트 내용물 추가시에 형태 고정(|구분자)")
    void printMapBorder() {


        //GIVEN
        List<ArrayList<String>> mapList = outputView.checkIndex(BirdgeMoveType.upGoMovement);
        outputView.checkIndex(BirdgeMoveType.downGoMovement);

        //WHEN
        List<String> result = outputView.printMapBorder(mapList);
        //THEN
        Assertions.assertThat(List.of("[ O |   ]","[   | O ]")).isEqualTo(result);

    }
}