package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.api.Test;

@DisplayName("GameEntity 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class GameEntityTest {

    private FrontController frontController;

    @BeforeEach
    public final void setUp(){

        frontController = new FrontController();
    }

    @Test
    public void testSomething() {
        //given
        frontController.


        //when

        //then
    }
}