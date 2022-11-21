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
    void 플레이어가_이동_2번_성공하고_3번쨰_방향이_맞는지_테스트(){
        User player = new User();
        assertThat(player.move(bridge, "U")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(true);
        assertThat(player.move(bridge, "U")).isEqualTo(true);
    }

    @Test
    void 플레이어가_이동_2번_성공하고_3번쨰_방향이_틀린지_테스트(){
        User player = new User();
        assertThat(player.move(bridge, "U")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(true);
        assertThat(player.move(bridge, "D")).isEqualTo(false);
    }

    @Test
    void 플레이어_게임_결과반환기능이_제대로_동작하는지(){
        User player = new User();
        player.move(bridge, "U");
        assertThat(player.makeGameResult()).isEqualTo(List.of(true));
        player.move(bridge, "U");
        assertThat(player.makeGameResult()).isEqualTo(List.of(true,false));
        player.move(bridge, "D");
        assertThat(player.makeGameResult()).isEqualTo(List.of(true,true));
        player.move(bridge, "U");
        assertThat(player.makeGameResult()).isEqualTo(List.of(true,true,true));
    }
}
