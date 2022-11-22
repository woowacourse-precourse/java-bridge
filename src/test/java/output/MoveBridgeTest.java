package output;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.OutputView;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class MoveBridgeTest {
    OutputView outputView = new OutputView();

    @Test
    void 이동한_다리_출력1(){
        String move_bridge = outputView.make_string(List.of("O","O","X"," ","X"));
        assertThat(move_bridge).isEqualTo("[ O | O | X |   | X ]");
    }

    @Test
    void 이동한_다리_출력2(){
        String move_bridge = outputView.make_string(List.of(" ","O","O"));
        assertThat(move_bridge.length()).isEqualTo(13);
    }
}
