package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame = new BridgeGame();
    List<String> a = Arrays.asList("D", "U", "D", "U");
    List<String> test;

    @Test
    void move더하기printRecord() {
        //BridgeGame bridgeGame = new BridgeGame();

        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        bridgeGame.move("D", a, 0);
        bridgeGame.move("U", a, 1);
        bridgeGame.move("U", a, 2);
        bridgeGame.move("U", a, 3);
        for (int i = 0; i < printUpRecord().size(); i++)
            System.out.print(printUpRecord().get(i));
        for (int i = 0; i < printDownRecord().size(); i++)
            System.out.print(printDownRecord().get(i));
    }

    public List<String> printUpRecord() {
        List<String> recordTable = new ArrayList<>();
        recordTable.add("[");
        for (int i = 0; i < bridgeGame.trialMap_up.size(); i++) {
            if (0 < i)
                recordTable.add("|");
            recordTable.add(bridgeGame.trialMap_up.get(i));
        }
        recordTable.add("]\n");

        return recordTable;
    }

    public List<String> printDownRecord() {
        List<String> recordTable = new ArrayList<>();
        recordTable.add("[");
        for (int i = 0; i < bridgeGame.trialMap_down.size(); i++) {
            if (0 < i)
                recordTable.add("|");
            recordTable.add(bridgeGame.trialMap_down.get(i));
        }
        recordTable.add("]\n");
        return recordTable;
    }
}