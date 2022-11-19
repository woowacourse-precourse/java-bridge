package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

public class MapConverterTest {

    @Test
    @DisplayName("문자로 처리되어 있는 map을 2차원 평면의 그림으로 변환")
    void convertMap() {
        List<String> map = List.of("U", "D", "U", "D", "D");
        String[][] detailedMap = new String[][]{
                {" ", "O", " ", "O", "O"},
                {"O", " ", "O", " ", " "}
        };
        assertThat(MapConverter.convertMap(map)).isEqualTo(detailedMap);

        map = List.of("U", "D", "U", "D", "ND");
        detailedMap = new String[][]{
                {" ", "O", " ", "O", "X"},
                {"O", " ", "O", " ", " "}
        };
        assertThat(MapConverter.convertMap(map)).isEqualTo(detailedMap);

    }

}
