package bridge;

import java.util.List;

// 사용자에게 게임 진행 상황과 결과를 출력하는 역할 수행
public class OutputView {

    // 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력
    public void printMap(List<String> gameBridgeCheck) {
        System.out.print("[ ");
        for(int idx=0; idx<gameBridgeCheck.size(); idx++) {
            System.out.print(gameBridgeCheck.get(idx));
            if(idx == gameBridgeCheck.size()-1) {
                System.out.println(" ]");
                return;
            }
            System.out.print(" | ");
        }
    }

    // 게임의 최종 결과를 정해진 형식에 맞춰 출력
    public void printResult(List<String> gameBridgeCheck, String gameProceed, int count) {
        this.printMap(gameBridgeCheck);
        System.out.println();

        if(gameProceed.equals("R")) { System.out.println("게임 성공 여부 : 성공"); }
        if(gameProceed.equals("Q")) { System.out.println("게임 성공 여부 : 실패"); }
        System.out.println("총 시도한 횟수 : " + count);
    }
}

// 추가된 요구 사항
// 1.제공된 OutputView 클래스를 활용해 구현
// 2.OutputView의 패키지는 변경 가능
// 3.OutputView의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경 가능
// 4.값 출력을 위해 필요한 메서드 추가 가능