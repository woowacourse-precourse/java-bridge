package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printCase(String type){
        if(type.equals("start")){
            System.out.println("다리 건너기 게임을 시작합니다.");
            System.out.println("다리의 길이를 입력해주세요.");
        }else if(type.equals("play")){
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        }else if(type.equals("regame")){
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(char[][] bridgeMap, StringBuilder sb) {
        for(int i=0;i<bridgeMap.length;i++){
            sb.append(calcMap(bridgeMap, sb, i));
        }
        System.out.println(sb);
    }

    private char calcMap(char[][] bridgeMap, StringBuilder sb, int i) {
        char temp = ' ';
        for(int j = 0; j< bridgeMap[0].length; j++, temp = ' '){
            if(j == 0) sb.append("[ ");
            if(j > 0) sb.append(" | ");
            if(bridgeMap[i][j] == 'O' || bridgeMap[i][j] == 'X') temp = bridgeMap[i][j];
            sb.append(temp);
            if(j == bridgeMap[0].length-1) sb.append(" ] \n");
        }
        return temp;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String result, char[][] map, int tryCnt) {
        System.out.println("최종 게임 결과");
        this.printMap(map, new StringBuilder());
        System.out.println("게임 성공 여부: " + result);
        System.out.println("총 시도한 횟수: " + tryCnt);
    }
}
