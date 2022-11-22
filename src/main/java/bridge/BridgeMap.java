package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeMap {
    public String[] makeMap(BridgeGame bridgeGame) {
        String[] map;
        List<String> bridge = bridgeGame.getBridge();
        List<String> moves = bridgeGame.getMoves();

        List<String> bridgeSide = makeBridgeSide(bridge, moves);
        map = mapMaker(bridgeSide);
        return map;
    }

    public List<String> makeBridgeSide(List<String> bridge, List<String> moves) {
        List<String> bridgeSide = new ArrayList<>();
        for (int currentStep = 0; currentStep < moves.size(); currentStep++) {
            if (moves.get(currentStep).equals(bridge.get(currentStep))) {
                bridgeSide.add(moves.get(currentStep));
                continue;
            }
            bridgeSide.add(moves.get(currentStep)+"X");
        }
        return bridgeSide;
    }

    public String[] mapMaker(List<String> bridgeInfo) {
        String[] map = {"", ""};
        for (String currentMove : bridgeInfo) {
            map[0] = makeUpSide(currentMove, map[0]);
            map[1] = makeDownSide(currentMove, map[1]);
        }
        map[0] += "]";
        map[1] += "]";
        return map;
    }

    public String makeUpSide(String move, String upSide) {
        if (move.equals("U")) {
            return correctSide(upSide);
        }
        if (move.equals("D")) {
            return otherSide(upSide);
        }
        if (move.equals("UX")) {
            return wrongSide(upSide);
        }
        return notWrongSide(upSide);
    }

    private String makeDownSide(String move, String downSide) {
        if (move.equals("D")) {
            return correctSide(downSide);
        }
        if (move.equals("U")) {
            return otherSide(downSide);
        }
        if (move.equals("DX")) {
            return wrongSide(downSide);
        }
        return notWrongSide(downSide);
    }

    public String correctSide(String side) {
        if (side.equals("")) {
            return "[ O ";
        }
        return side + "| O ";
    }

    public String otherSide(String side) {
        if (side.equals("")) {
            return "[   ";
        }
        return side + "|   ";
    }

    public String wrongSide(String side) {
        if (side.equals("")) {
            return "[ X ";
        }
        return side + "| X ";
    }

    public String notWrongSide(String side) {
        if (side.equals("")) {
            return "[   ";
        }
        return side + "|   ";
    }
}
