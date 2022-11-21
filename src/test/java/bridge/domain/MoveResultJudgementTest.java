package bridge.domain;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MoveResultJudgementTest {
    private  MoveResultJudgement moveResultJudgement;
    private String moving = "D";
    private final List<String> bridge = List.of("U","D","D");
    @BeforeEach
    void setUp(){
        moveResultJudgement = new MoveResultJudgement(bridge);
    }
    @Test
    void move_result(){
        List<Boolean> result = List.of(false,true,true);
        for (int currentDistance = 0; currentDistance < bridge.size(); currentDistance++) {
            assertThat(moveResultJudgement.movedResult(moving,currentDistance))
                    .isEqualTo(result.get(currentDistance));
        }
    }
    @Test
    void is_game_complete(){
        List<Boolean> result = List.of(false,false,true);
        for (int currentDistance = 0; currentDistance < bridge.size(); currentDistance++) {
            assertThat(moveResultJudgement.isGameComplete(moving,currentDistance))
                    .isEqualTo(result.get(currentDistance));
        }
    }

}