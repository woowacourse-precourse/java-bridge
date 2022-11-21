package bridge;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserTest {
    private final static List<String> bridge = List.of("U", "D", "U");

    @Test
    void 플레이어가_이동한_방향이_맞는지_테스트() {
        String correctDirection = "U";
        String unCorrectDirection = "D";
        User player = new User();
        assertThat(player.move(bridge, unCorrectDirection)).isEqualTo(false);
        assertThat(player.move(bridge, correctDirection)).isEqualTo(true);
    }

    @Test
    void 플레이어가_이동_2번_성공하고_3번쨰_방향이_맞는지_테스트() {
        User player = new User();
        assertThat(player.move(bridge, "U")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(true);
        assertThat(player.move(bridge, "U")).isEqualTo(true);
    }

    @Test
    void 플레이어가_이동_2번_성공하고_3번쨰_방향이_틀린지_테스트() {
        User player = new User();
        assertThat(player.move(bridge, "U")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(false);
    }

    @Test
    void 한번_움직이고_게임결과가_제대로_나오는지() {
        User player = new User();
        List<Result> gameResults = List.of(new Result("U", true));
        player.move(bridge, "U");
        boolean isSame = isCorrectResult(player.makeGameResult(), gameResults);
        assertThat(isSame).isEqualTo(true);
    }

    @Test
    void 두번_움직이고_게임결과가_제대로_나오는지() {
        User player = new User();
        List<Result> gameResults = List.of(new Result("U", true), new Result("U", false));
        player.move(bridge, "U");
        player.move(bridge, "U");
        boolean isSame = isCorrectResult(player.makeGameResult(), gameResults);
        assertThat(isSame).isEqualTo(true);
    }

    private boolean isCorrectResult(List<Result> testResults, List<Result> expectResults){
        for (int i = 0; i < testResults.size(); i++){
            if (!testResults.get(i).isSameResult(expectResults.get(i))){
                return false;
            }
        }
        return true;
    }
}
