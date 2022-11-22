package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeEntity 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class BridgeEntityTest {

    BridgeMaker bridgeMaker;
    BridgeRepository bridgeEntityByController;

    @BeforeEach
    void setUp() {
        bridgeEntityByController = new FrontController().bridgeRepository();
    }


    @Test
    public void compareBridge(){
        //given
        List<String> actual = bridgeEntityByController.manageBridgeStatus();
        BridgeMaker expect = bridgeMaker;

        //when
        assertEquals(expect, actual);
    }

}