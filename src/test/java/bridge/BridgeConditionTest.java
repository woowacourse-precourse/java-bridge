package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeConditionTest {
    private static final String ERROR_MESSAGE = "[ERROR]";


    @Test
    public void PrintTest(){

    }

    @Test
    public void findByDataValueTest(){
        String[] inputs = new String[]{"U", "D"};

        for(String input : inputs) {
            if(input.equals("U"))
                assertThat(BridgeCondition.findByDataValue(input)).isEqualTo(BridgeCondition.UP);
            else if(input.equals("D"))
                assertThat(BridgeCondition.findByDataValue(input)).isEqualTo(BridgeCondition.DOWN);
        }
    }

    @Test
    public void findByInputTest(){
        int[] inputs = new int[]{0, 1};

        for(int input : inputs) {
            if(input == 1)
                assertThat(BridgeCondition.findByInput(input)).isEqualTo(BridgeCondition.UP);
            else if(input == 0)
                assertThat(BridgeCondition.findByInput(input)).isEqualTo(BridgeCondition.DOWN);
        }
    }

    @Test
    public void ExceptionTest(){

        assertThatThrownBy(() -> BridgeCondition.findByDataValue("S")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BridgeCondition.findByDataValue("SA")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> BridgeCondition.findByDataValue("23")).isInstanceOf(IllegalArgumentException.class);
    }

}
