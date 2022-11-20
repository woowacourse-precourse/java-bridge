package bridge.model;

import bridge.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MapTest {

    @DisplayName("움직임이 주어졌을 때 해당 움직임에 해당하는 맵이 생성됨")
    @Test
    void createMapTest(){
        //given
        Map map = new Map();
        Map map2 = new Map();

        //when
        map.insertMove(Move.U);
        map.insertMove(Move.D);
        map.insertMove(Move.U);

        map2.insertMove(Move.U);
        map2.insertMove(Move.D);

        //then
        assertThat(map.toString()).isEqualTo("[ O |   | O ]\n[   | O |   ]");
        assertThat(map2.toString()).isEqualTo("[ O |   ]\n[   | O ]");
    }
}
