package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(boolean success, List<String> upList, List<String> downList, int count) {
        String successMessage = "성공";



        System.out.println("최종 게임 결과");
        for(int i = 0; i < upList.size(); i++){
            System.out.print(upList.get(i));
            if(i != upList.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();


        for(int i = 0; i < downList.size(); i++){
            System.out.print(downList.get(i));
            if(i != downList.size()-1){
                System.out.print(" ");
            }
        }
        System.out.println();

        if(success){
            System.out.println("게임 성공 여부: " + successMessage);
        }
        System.out.println("총 시도한 횟수: " + count);

    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }



}
