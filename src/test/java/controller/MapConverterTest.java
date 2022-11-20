package controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("initial로 처리되어 있는 map이 2차원 평면 map으로 정상 변환되는지 확인.")
public class MapConverterTest {
    @Test
    @DisplayName("U,D로 이루어진 map에 대해 정상적으로 변환이 되는지 확인.")
    void convertMap1() {
        assertThat(MapConverter.convertMap(List.of("U", "D", "U", "D", "D"))).isEqualTo(
                new String[][]{
                        {" ", "O", " ", "O", "O"},
                        {"O", " ", "O", " ", " "}
                }
        );
    }

    @Test
    @DisplayName("NU,ND로 이루어진 map에 대해 정상적으로 변환이 되는지 확인.")
    void convertMap2() {
        assertThat(MapConverter.convertMap(List.of("NU", "ND", "NU", "ND", "ND"))).isEqualTo(
                new String[][]{
                        {" ", "X", " ", "X", "X"},
                        {"X", " ", "X", " ", " "}
                }
        );
    }

    @Test
    @DisplayName("initial이 혼합된 map이 정상적으로 변환이 되는지 확인.")
    void convertMap3() {
        assertThat(MapConverter.convertMap(List.of("U", "D", "D", "U", "ND"))).isEqualTo(
                new String[][]{
                        {" ", "O", "O", " ", "X"},
                        {"O", " ", " ", "O", " "}
                }
        );
    }
}
