package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String start="[";
    private static final String end="]";
    private static final String rightSpaceWithWall=" 0 |";
    private static final String wrongSpaceWithWall=" X |";
    private static final String emptySpaceWithWall="   |";
    private static final String rightSpaceWithoutWall=" 0 ";
    private static final String wrongSpaceWithoutWall=" X ";
    private static final String emptySpaceWithoutWall="   ";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge,Player player,String inputStep) {
        int curLocation = player.getCurrentLocation();
        printBridge(bridge,"U",inputStep,curLocation);
        printBridge(bridge,"D",inputStep,curLocation);
    }

    private void printBridge(Bridge bridge,String spaceStatus,String inputStep, int curLocation) {
        System.out.print(start);
        for(int i = 1; i < curLocation; i++){
            System.out.print(checkBridgeSpace(bridge, spaceStatus, i));
        }
        System.out.print(checkPlayerCurLocation(bridge,spaceStatus,inputStep,curLocation));
        System.out.println(end);
    }

    private static String checkBridgeSpace(Bridge bridge, String spaceStatus, int curBridgeLocation) {
        if(bridge.checkBridgeSpace(curBridgeLocation).equals(spaceStatus)){
           return rightSpaceWithWall;
        }
        return emptySpaceWithWall;
    }


    private String checkPlayerCurLocation(Bridge bridge, String spaceStatus, String inputStep, int curLocation){
        if(inputStep.equals(spaceStatus)){
            if(bridge.isSuccess(curLocation,inputStep)){
                return rightSpaceWithoutWall;
            }
            return wrongSpaceWithoutWall;
        }
        return emptySpaceWithoutWall;
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
