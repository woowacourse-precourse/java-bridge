package bridge;

public class ErrorCheck {
    private final int MAX_LENGTH = 20;
    private final int MIN_LENGTH = 3;
    private final String QUIT = "Q";
    private final String RETRY = "R";
    private final String UP_BRIDGE_BTN = "U";
    private final String DOWN_BRIDGE_BTN = "D";

    public boolean isValidRetryOrQuit(String retry) {
        if(retry.equals(QUIT) || retry.equals(RETRY)) return true;
        System.out.println("[ERROR] Q 또는 R로 입력해주세요.");
        throw new IllegalArgumentException();
    }
    public boolean isValidInteger(String bridgeLength) {
        try{
            Integer.parseInt(bridgeLength);
            return true;
        }catch(Exception e){
            System.out.println("[ERROR] 다리의 길이는 숫자로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public boolean isValidBridgeLengthRange(String bridgeLength) {
        if(Integer.parseInt(bridgeLength)>MAX_LENGTH || Integer.parseInt(bridgeLength)<MIN_LENGTH) {
            System.out.println("[ERROR] 다리의 길이는 3~20 사이로 입력해주세요.");
            throw new IllegalArgumentException();
        }
        return true;
    }

    public boolean isValidUpOrDown(String nextMove) {
        if(!(nextMove.equals(UP_BRIDGE_BTN) || nextMove.equals(DOWN_BRIDGE_BTN))) {
            System.out.println("[ERROR] 위, 아래 중 하나만 선택해주세요.");
            throw new IllegalArgumentException();
        }
        return true;
    }
}