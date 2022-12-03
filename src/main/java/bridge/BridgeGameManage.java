package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameManage {
    BridgeGame bGame = new BridgeGame();
    OutputView out  = new OutputView();
    InputView input  = new InputView();
    String[] result = new String[2];
    int cnt = 1;
    public void playGame (List<String> bridge, int bSize, List<String> moveInfo){
        for (int idx = 0; idx < bSize; idx++) {
            String userMove = getUserMove();
            moveInfo.add(userMove);
            out.printMap(moveInfo, bridge);
            if (bGame.move(userMove, bridge.get(idx)) == 0)
                break;
        }
    }
    public String[] manage(List<String> bridge,int bSize) {
        while(true) {
            List<String> moveInfo = new ArrayList<>();
            playGame(bridge,bSize,moveInfo);
            String flag = out.getCheckFlag();
            if(control(flag)==1)
                break;
            cnt++;
        }
        return result;
    }
    public int control (String flag){
        if (flag.equals("성공")) {
            winGame();
            return 1;
        }
        if (flag.equals("실패")) {
            loseGame();
            if(bGame.retry(input.readGameCommand(),cnt)[0].equals("종료"))
                return 1;
        }
        return 0;
    }
    public void winGame (){
        result[0]="성공";
        result[1]=String.valueOf(cnt);
    }
    public void loseGame() {
        result[0]="실패";
        result[1]=String.valueOf(cnt);
    }
    public String getUserMove(){
        String move = input.readMoving();
        return move;
    }
}
