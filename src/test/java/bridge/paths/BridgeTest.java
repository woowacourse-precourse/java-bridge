package bridge.paths;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


class BridgeTest {

    @Test
    void 다리길이가_안전경로_길이와_다르면_예외처리한다(){
        Assertions.assertThatThrownBy(()->{
            List<String> securePath = List.of("U", "D", "D");
            Bridge bridge = new Bridge(securePath, 2);
        }).isInstanceOf(InternalError.class);
    }

    @Test
    void 안전경로가_주어지지_않으면_예외처리한다(){
        Assertions.assertThatThrownBy(()->{
            Bridge bridge = new Bridge(null, 0);
        }).isInstanceOf(InternalError.class);
    }
}