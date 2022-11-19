package bridge;

import bridge.util.BridgeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeMapTest {
    List<String> moves;
    BridgeMap bridgeMap;
    String answer;

    @Test
    void moveSuccessDisplayTest()
    {
        setData(List.of("U","D","D","U","U","D"));
        setAnswer(  "[ O |   |   | O | O |   ]",
                    "[   | O | O |   |   | O ]");

        for (String nextMove : moves) bridgeMap.extendMap(nextMove,true);

        Assertions.assertEquals(bridgeMap.toString(), answer);
    }

    @Test
    void moveFailDisplayTest()
    {
        setData(List.of("D","U","D","D","D","U"));
        setAnswer(  "[   | O |   |   |   | O |   ]",
                    "[ O |   | O | O | O |   | X ]");
        for (String nextMove : moves) bridgeMap.extendMap(nextMove,true);
        bridgeMap.extendMap("D",false);

        Assertions.assertEquals(bridgeMap.toString(),answer);
    }

    @Test
    void displayTest()
    {
        setData(List.of("D","U","D","U","U","U","D"));
        setAnswer(  "[   | X |   | O | X | O |   ]",
                    "[ O |   | X |   |   |   | X ]");
        List<Boolean> moveResult = List.of(true,false,false,true,false,true,false);

        for (int position = 0; position < moveResult.size(); position++)
            bridgeMap.extendMap(moves.get(position),moveResult.get(position));

        Assertions.assertEquals(bridgeMap.toString(),answer);
    }

    void setData(List<String> moves)
    {
        this.moves = moves;
        bridgeMap = new BridgeMap();
    }

    void setAnswer(String upperComponent,String lowerComponent)
    {
        this.answer = String.join("\n",upperComponent,lowerComponent);
    }

}
