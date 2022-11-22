package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame game) {
        BridgeGameInfo gameInfo = game.getInfo();
        String top ="["+preBridge(gameInfo)[1]+nowBridge(gameInfo)[1]+"]";
        String bottom ="["+preBridge(gameInfo)[0]+nowBridge(gameInfo)[0]+"]";
        System.out.println(top);
        System.out.println(bottom+'\n');
    }
    public String[] preBridge(BridgeGameInfo gameInfo){
        String[] pre = new String[2];
        pre[0]="";pre[1]="";
        int position=gameInfo.getPosition();
        int preIndex;
        for(int i=0; i<position; i++){
            preIndex=0;
            if(gameInfo.getBridgeAt(i).equals("U")) preIndex=1;
            pre[preIndex] += " O |";
            pre[1-preIndex] += "   |";
        }
        return pre;
    }
    public String[] nowBridge(BridgeGameInfo gameInfo){
        String[] now = new String[2];
        String result=" X " ;
        int index=0;
        if(gameInfo.getBridgeAt(gameInfo.getPosition()).equals(gameInfo.getPlayer())) result = " O ";
        if(gameInfo.getPlayer().equals("U")) index=1;
        now[index] = result;
        now[1-index] = "   ";
        return now;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame game) {
        BridgeGameInfo gameInfo = game.getInfo();
        String result = "실패";
        if(game.status()==Player.WIN)result="성공";
        System.out.println("최종 게임 결과");
        printMap(game);
        System.out.println("게임 성공 여부: "+result);
        System.out.println("총 시도한 횟수: "+gameInfo.getTrial());
    }
}
