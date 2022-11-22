package bridge;

import java.util.LinkedList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }


    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public String upperMap = "[ ";
    public String lowerMap = "[ ";
    public String error = "";
    public int i = 0;
    public boolean firstORretry = false;

    public int possibleToGo;


    public LinkedList<Integer> ll = new LinkedList<>();

    public String Move() {
        BridgeGame gameStart = new BridgeGame();
        String userMover = gameStart.move(); // 이동할 칸 선택(U or D)
        if (userMover.equals("U") == false && userMover.equals("D") == false) {
            error = "ERROR";
            return error;
        }
        return userMover;
    }

    public List<String> makeBridge(int size) {
        BridgeRandomNumberGenerator ranVal = new BridgeRandomNumberGenerator();
        String userMove = Move();
        if (userMove == "ERROR") {
            return null;
        }


        possibleToGo = ranVal.generate();
        if (firstORretry == false) { // 첫 시도시 다리 만들기
            ll.add(possibleToGo);
        }

        if (firstORretry == true) { // 재시작시 똑같은 다리 만들기
            try {
                possibleToGo = ll.get(i);
                i++;
            } catch (IndexOutOfBoundsException e) {
                firstORretry = false;
            }

        }
/**
 * 다리 만들기
 * */
        upperMap = upperMap.replace(" ]", "");
        lowerMap = lowerMap.replace(" ]", "");

        if (upperMap.length() != 2) { // && upperMap.!= (size * 4 - 3)
            upperMap = new StringBuilder(upperMap).append(" | ").toString();
            lowerMap = new StringBuilder(lowerMap).append(" | ").toString();
        }

        if (userMove.equals("U") && possibleToGo == 0) {
            upperMap = new StringBuilder(upperMap).append("X").toString();
            lowerMap = new StringBuilder(lowerMap).append(" ").toString();
        } else if (userMove.equals("U") && possibleToGo == 1) {
            upperMap = new StringBuilder(upperMap).append("O").toString();
            lowerMap = new StringBuilder(lowerMap).append(" ").toString();
        } else if (userMove.equals("D") && possibleToGo == 0) {
            upperMap = new StringBuilder(upperMap).append(" ").toString();
            lowerMap = new StringBuilder(lowerMap).append("O").toString();
        } else if (userMove.equals("D") && possibleToGo == 1) {
            upperMap = new StringBuilder(upperMap).append(" ").toString();
            lowerMap = new StringBuilder(lowerMap).append("X").toString();
        }

        upperMap = new StringBuilder(upperMap).append(" ]").toString();
        lowerMap = new StringBuilder(lowerMap).append(" ]").toString();

        return null;
    }
}
