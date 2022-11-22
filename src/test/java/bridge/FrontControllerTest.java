package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("FrontController 클래스 점검")
@DisplayNameGeneration(ReplaceUnderscores.class)
class FrontControllerTest {

    private FrontController frontController;

    @BeforeEach
    void setUp() {

        frontController = new FrontController();

    }




    @DisplayName("다리가 정상적으로 생성")
    @Test
    public void setBridgeEntity(){
        //given
        BridgeEntity controller = frontController.bridgeRepository();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        // when
        List<String> entity = controller.manageBridgeStatus();
        List<String> domain = bridgeMaker.makeBridge(3);

        // then
        assertEquals(domain, entity);
    }
}