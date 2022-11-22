package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

public class MapMakerTest {
    private final List<String> Move = List.of("U", "D", "U");
    private final List<Boolean> compare = List.of(true, true, false);
    private final int up = 0;
    private final int down = 1;

    @Test
    void MapMakerTest() {
        MapMaker mapMaker = new MapMaker();
        List<List<String>> out = new ArrayList<>();

        out.add(new ArrayList<>());
        out.add(new ArrayList<>());
        int index = 0;

        for(String move : Move) {
            out = mapMaker.MakeMap(move, compare.get(index++));
        }

        List<String> Up = out.get(up);
        List<String> Down = out.get(down);

        assertThat(Up).isEqualTo(List.of("O", " ", "X"));
        assertThat(Down).isEqualTo(List.of(" ", "O", " "));
    }
}
