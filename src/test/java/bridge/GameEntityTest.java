package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;

@DisplayName("GameEntity 클래스")
@DisplayNameGeneration(ReplaceUnderscores.class)
class GameEntityTest {

    private FrontController frontController;

    @BeforeEach
    public final void setUp(){

        frontController = new FrontController();
    }

}