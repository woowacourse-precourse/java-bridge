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
    private GameEntity gameEntity;
    private BridgeEntity bridgeEntity;

    @BeforeEach
    void setUp() {

        frontController = new FrontController();
        gameEntity = frontController.gameRepository();
        bridgeEntity = frontController.bridgeRepository();

    }




    @Test
    public void buildBridgeAutomatically() throws Exception{
        //given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> expect = bridgeMaker.makeBridge(3);

        //when
        List<String> actual = frontController.bridgeRepository().manageBridgeStatus();

        //then
        assertEquals(expect, actual);
    }
}