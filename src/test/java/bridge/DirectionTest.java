package bridge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @DisplayName("Direction 생성 테스트")
    @Test
    public void generateDirection(){
        assertThrows(IllegalArgumentException.class, ()->{
            Direction.valueOf("qwe");
        });
        Direction d = Direction.valueOf("D");
        assertSame(Direction.D, d);
    }

}