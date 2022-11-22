package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.move;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Test
    @DisplayName("위층 다리를 건널 차례일 때 U를 입력하면 다리가 잘 건너지는가?")
    void if_U_but_put_U(){
        String selectMove = "U";
        List<String> bridgeShape = new ArrayList<>(List.of("U"));
        String moveResult = move(selectMove, bridgeShape);
        assertThat(moveResult).isEqualTo(selectMove);
    }

    @Test
    @DisplayName("아래층 다리를 건널 차례일 때 D를 입력하면 다리가 잘 건너지는가?")
    void if_D_but_put_D(){
        String selectMove = "D";
        List<String> bridgeShape = new ArrayList<>(List.of("D"));
        String moveResult = move(selectMove, bridgeShape);
        assertThat(moveResult).isEqualTo(selectMove);
    }

    @Test
    @DisplayName("위층 다리를 건널 차례일 때 D를 입력하면 다리 건너기가 끝나는가?")
    void if_U_but_put_D(){
        String selectMove = "D";
        List<String> bridgeShape = new ArrayList<>(List.of("U"));
        String moveResult = move(selectMove, bridgeShape);
        assertThat(moveResult).isEqualTo("END");
    }

    @Test
    @DisplayName("아래층 다리를 건널 차례일 때 U를 입력하면 다리 건너기가 끝나는가?")
    void if_D_but_put_U(){
        String selectMove = "U";
        List<String> bridgeShape = new ArrayList<>(List.of("D"));
        String moveResult = move(selectMove, bridgeShape);
        assertThat(moveResult).isEqualTo("END");
    }
}
