package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    static final String START_MAP="[ ";
    static final String END_MAP=" ]";
    static final String BRIDGE_DIVISION=" | ";
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String SingleMap) {
        System.out.print(START_MAP);
        System.out.print(SingleMap.charAt(0));
        for(int i=1;i<SingleMap.length();i++){
            System.out.print(BRIDGE_DIVISION);
            System.out.print(SingleMap.charAt(i));
        }
        System.out.println(END_MAP);
    }
    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(SingleMap singleMaps) {
        System.out.println("최종 게임 결과");
        printMap(singleMaps.convertToSingleMap("U"));
        printMap(singleMaps.convertToSingleMap("D"));
        System.out.println("게임 성공 여부: "+isSuccess(singleMaps.bridgeGame));
        System.out.println("총 시도한 횟수: "+singleMaps.bridgeGame.getPlayCount());
    }

    private String isSuccess(BridgeGame bridgeGame){
        if(bridgeGame.isSuccess()){
            return "성공";
        }
        return "실패";
    }
}
