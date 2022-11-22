package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String[] move(int maxBridgeLength,String movingUpDown, String yesOrNo) {

            String[] subBridge = new String[2];

            if(maxBridgeLength == 0) {
                if (movingUpDown.equals("U")) {
                    subBridge[0] = yesOrNo;
                    subBridge[1] = " ";
                } else if (movingUpDown.equals("D")) {
                    subBridge[0] = " ";
                    subBridge[1] = yesOrNo;
                }
                //2번째 이상부터 다리 만들때
            }else if(maxBridgeLength != 0){
                if (movingUpDown.equals("U")) {
                    subBridge[0] = " | " + yesOrNo;
                    subBridge[1] = " | " + " ";
                } else if (movingUpDown.equals("D")) {
                    subBridge[0] = " | " + " ";
                    subBridge[1] = " | " + yesOrNo;
                }
            }
            return subBridge;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String retry(String reOrStop, String[] subBridge, int howManyGames) {
        if(reOrStop.equals("Q")){
            System.out.println("최종 게임 결과");
            System.out.println(subBridge[0] + " ]");
            System.out.println(subBridge[1] + " ]");

            System.out.println("게임 성공 여부: 실패");
            System.out.println("총 시도한 횟수: " + howManyGames);
            return "Quit";
        }
        return "Retry";
    }
}
