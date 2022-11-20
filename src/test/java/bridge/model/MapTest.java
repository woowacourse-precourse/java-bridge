package bridge.model;

import bridge.Move;
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

        Map map = new Map(generatedMap);
        Map map2 = new Map(generatedMap);

        //when
        map.insertMove(Move.U);
        map.insertMove(Move.D);
        map.insertMove(Move.U);

        map2.insertMove(Move.U);
        map2.insertMove(Move.U);

        //then
        assertThat(map.toString()).isEqualTo("[ O |   | O ]\n[   | O |   ]");
        assertThat(map2.toString()).isEqualTo("[ O | X ]\n[   |   ]");
    }
}
