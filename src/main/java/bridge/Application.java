package bridge;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<Integer> crossablePositions = makeCrossablePositions("3");


    }

    static ArrayList<StringBuilder> makeBridge(char input, ArrayList<StringBuilder> sb, ArrayList<Integer> crossablePositions) {

        int curIndex = sb.size() / 5;

        StringBuilder upBridge = sb.get(0);
        StringBuilder downBridge = sb.get(1);

        upBridge.replace(upBridge.length() - 1, upBridge.length(), "| ");
        downBridge.replace(downBridge.length() - 1, downBridge.length(), "| ");

        if (input == 'U') {
            downBridge.append("   ]");
            if (crossablePositions.get(curIndex) == 0) {
                upBridge.append(" o ]");

            } else {
                upBridge.append(" x ]");

            }
        } else {
            upBridge.append("   ]");
            if (crossablePositions.get(curIndex) == 1) {
                downBridge.append(" o ]");
            } else {
                downBridge.append(" x ]");
            }
        }

        return sb;


    }


    static ArrayList<Integer> makeCrossablePositions(String input) {

        int length;

        try {
            length = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 3에서 20 사이의 숫자만 입력해주세요");
        }

        ArrayList<Integer> crossablePositions = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            crossablePositions.add(new BridgeRandomNumberGenerator().generate());
        }

        return crossablePositions;
    }
}
