package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final String IS_CORRECT = " O ";
    private final String IS_NOT_CORRECT = " X ";
    private final String SPACE = "   ";
    private final String START_BRACKET = "[";
    private final String END_BRACKET = "]";
    private final String MIDDLE_BRACKET = "|";
    private StringBuilder sb1 = new StringBuilder();
    private StringBuilder sb2 = new StringBuilder();
    private int level = 0;
    private int tryCount = 1;

    public List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println(GameMessage.GAME_RESULT_MESSAGE.getMessage());
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move(List<String> bridge, String moving, int level) {
        isStart(level);
        isUp(bridge, moving, level);
        isDown(bridge, moving, level);
        isLast(bridge, level);

        String result = sb1.substring(0,sb1.length()-1) + END_BRACKET;
        String result2 = sb2.substring(0,sb2.length()-1) + END_BRACKET;

        return result+System.getProperty("line.separator")+result2;
    }

    public void isSuccess(List<String> bridge, int level) {
        if (level == bridge.size()) {
            System.out.println(GameMessage.GAME_SUC_MESSAGE.getMessage());
        }
        if (level != bridge.size()) {
            System.out.println(GameMessage.GAME_FAIL_MESSAGE.getMessage());
        }
    }

    public StringBuilder getSb1() {
        return sb1;
    }

    public StringBuilder getSb2() {
        return sb2;
    }

    public void isStart(int level) {
        if (level == 0) {
            sb1.append(START_BRACKET);
            sb2.append(START_BRACKET);
        }
    }

    public void isUp(List<String> bridge, String moving, int level) {
        String compareBridgeAndMoving = compareBridgeAndMoving(bridge, moving, level);

        if (bridge.get(level).equals("U")) {
            if (compareBridgeAndMoving.equals(IS_NOT_CORRECT)) {
                sb1.append(SPACE);
                sb2.append(compareBridgeAndMoving);
            }
            if (compareBridgeAndMoving.equals(IS_CORRECT)) {
                sb1.append(compareBridgeAndMoving);
                sb2.append(SPACE);
            }
        }
    }

    public void isDown(List<String> bridge, String moving, int level) {
        String compareBridgeAndMoving = compareBridgeAndMoving(bridge, moving, level);

        if (bridge.get(level).equals("D")) {
            if (compareBridgeAndMoving.equals(IS_NOT_CORRECT)) {
                sb1.append(compareBridgeAndMoving);
                sb2.append(SPACE);
            }
            if (compareBridgeAndMoving.equals(IS_CORRECT)) {
                sb1.append(SPACE);
                sb2.append(compareBridgeAndMoving);
            }
        }
    }

    public void isLast(List<String> bridge, int level) {
        if (bridge.size() - 1 != level) {
            sb1.append(MIDDLE_BRACKET);
            sb2.append(MIDDLE_BRACKET);
        }
        if (bridge.size() - 1 == level) {
            sb1.append(END_BRACKET);
            sb2.append(END_BRACKET);
        }
    }

    public String compareBridgeAndMoving(List<String> bridge, String moving, int level) {
        String result = "";
        if (bridge.get(level).equals(moving)) {
            result = IS_CORRECT;
        }
        if (!bridge.get(level).equals(moving)) {
            result = IS_NOT_CORRECT;
        }
        return result;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printBeforeMap(int level) {
        String result = goToBeforeLevelSB(level);
        System.out.println(result);
    }

    private String goToBeforeLevelSB(int level) {
        String result = "";
        if (level == 0) {
            sb1.delete(0, sb1.length());
            sb2.delete(0, sb2.length());
        }
        if (level != 0) {
            sb1.delete(sb1.length() - 4, sb1.length());
            sb2.delete(sb2.length() - 4, sb2.length());

            result = sb1.substring(0, sb1.length() - 1) + END_BRACKET + "\n" + sb2.substring(0, sb2.length() - 1) + END_BRACKET;
        }
        return result;
    }

    public String makeCurrentResultMap(int bridgeSize) {
        String result = sb1 + "\n" + sb2;
        if (level != bridgeSize) {
            result = sb1.deleteCharAt(sb1.length()-1)+END_BRACKET + "\n" + sb2.deleteCharAt(sb2.length()-1)+END_BRACKET;
        }

        return result;
    }

    public void printGameStartMessage() {
        System.out.println(GameMessage.GAME_START_MESSAGE.getMessage());
    }

    public void printRequestBridgeSizeMessage() {
        System.out.println(GameMessage.REQUEST_BRIDGE_SIZE_MESSAGE.getMessage());
    }

    public void printRequestMovingMessage() {
        System.out.println();
        System.out.println(GameMessage.REQUEST_MOVING_MESSAGE.getMessage());
    }

    public void printRequestRetryMessage() {
        System.out.println(GameMessage.REQUEST_RETRY_MESSAGE.getMessage());
    }

    public int getLevel() {
        return level;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void nextLevel() {
        this.level = level+1;
    }

    public void goToBackStage() {
        this.tryCount = tryCount+1;
        this.level = level-1;
    }


}
