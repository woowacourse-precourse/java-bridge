package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    // 게임 생성 확인 출력 메서드
    public void createGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
    }

    // 사용자가 칸을 이동할 때 사용하는 메서드
    public static void move(List<String> gameBridgeMoving, String gameBridgeMoveKey) {
        gameBridgeMoving.add(gameBridgeMoveKey);
    }

    // 사용자가 이동한 구간 확인
    public static List<String> check(List<String> gameBridgeMoving,List<String> gameBridge) {
        List<String> gameBridgeCheck = new ArrayList<>();
        String checkResult = "";
        for(int idx=0; idx<gameBridgeMoving.size(); idx++) {
            if(gameBridgeMoving.get(idx).equals(gameBridge.get(idx))) { checkResult = "O"; }
            if(!gameBridgeMoving.get(idx).equals(gameBridge.get(idx))) { checkResult = "X"; }
            gameBridgeCheck.add(checkResult);
        }

        return gameBridgeCheck;
    }

    // 사용자가 게임을 다시 시도할 때 사용하는 메서드
    public void retry(List<String> gameBridgeMoving,List<String> gameBridgeCheck) {
        gameBridgeMoving.clear();
        gameBridgeCheck.clear();
    }
}

// 추가된 요구 사항
// 1.제공된 BridgeGame 클래스를 활용해 구현
// 2.BridgeGame에 필드(인스턴스 변수)를 추가 가능
// 3.BridgeGame의 패키지는 변경 가능
// 4.BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
// 5.게임 진행을 위해 필요한 메서드 추가 하거나 변경 가능
