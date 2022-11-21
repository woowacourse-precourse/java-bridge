package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {

    @DisplayName("움직임이 주어졌을 때 해당 움직임에 해당하는 맵이 생성됨")
    @Test
    void createMapTest(){
        //given
        List<String> generatedMap = List.of("U","D","U");

        Map map = Map.generateMap();
        Map map2 = Map.generateMap();

        //when
        map.insertMove("O",0);
        map.insertMove("O",1);
        map.insertMove("O",0);

        map2.insertMove("O",0);
        map2.insertMove("X",0);

        //then
        assertThat(map.toString()).isEqualTo("[ O |   | O ]\n[   | O |   ]");
        assertThat(map2.toString()).isEqualTo("[ O | X ]\n[   |   ]");
    }
}
