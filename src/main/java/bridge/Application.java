package bridge;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        ArrayList<Integer> crossablePositions = makeCrossablePositions("3");
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
