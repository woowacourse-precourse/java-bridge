package bridge;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {


    static int[][] arr;

    static String inputBridgeStr;

    static InputView inputView = new InputView();


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     * <p>
     * U, D를 입력해서 위로 가거나 아래로 내려간다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */



    // boolean 타입으로 만들어서  ??? ??? 가능하면
    // 가능:
    // 불가능:
    public boolean move(String generatedBridgeStr, String currBridgeStr) {   // 1011110111 , 1011...., [  | O | O |  |  ]

        // 사용자의 입력을 하나씩 받으면서 성공처리 실패처리를 한다.
        int idx = currBridgeStr.length() - 1;

        if(idx < 0){
            System.out.println("currBridgeStr : null");
            return false;
        }

        // 성공
        if (generatedBridgeStr.charAt(idx) == currBridgeStr.charAt(idx)) {

            return true;

        }
            return false;


    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }
}
