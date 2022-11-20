package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String mapStart = "[ ";
    public static final String mapEnd = " ]";
    public static final String mapSeparator = " | ";
    public static final String mapRight = "O";
    public static final String mapWrong = "X";
    public static final String mapBlank = " ";
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public String createMapByLine(List<String> totalMove, int curLocation, List <String> bridge, String type){
        String mapResult = "";
        mapResult = mapResult+mapStart;
        for(int i=0; i<curLocation; i++){
            String selectedCurMove = totalMove.get(i);
            String bridgeCurMove = bridge.get(i);
            if(!selectedCurMove.equals(type))
                mapResult = mapResult+mapBlank;
            if(selectedCurMove.equals(type) && selectedCurMove.equals(bridgeCurMove))
                mapResult = mapResult+mapRight;
            if(selectedCurMove.equals(type) && !selectedCurMove.equals(bridgeCurMove))
                mapResult = mapResult+mapWrong;
            if(i!=(curLocation-1))
                mapResult = mapResult+mapSeparator;
        }
        mapResult = mapResult+mapEnd;
        return mapResult;
    }
}
