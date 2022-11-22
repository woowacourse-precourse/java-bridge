package bridge;

import java.util.List;

public class Application{

    public static int countChar(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static String getYesNo(List<String> yourBridge, int i, String movingUpDown){
        if (yourBridge.get(i).equals(movingUpDown)) {       //정답
            return "O";
        }
        return "X";
    }


    public static void main(String[] args) {

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        //이동할 칸 입력받음
        InputView makeBridge = new InputView();
        BridgeRandomNumberGenerator bridgeRandomNum = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMake = new BridgeMaker(bridgeRandomNum);
        BridgeGame manageGame = new BridgeGame();


        int bridgeLength = makeBridge.readBridgeSize();             // 다리의 길이

        int howManyGames = 0;                                       //게임 시도한 횟수 count

        String reOrStop = "";                                       //게임 재시작 여부

        while(true) {

            List<String> yourBridge = bridgeMake.makeBridge(bridgeLength);

            String yesOrNo = "";
            howManyGames += 1;
            int ii = 0;
            int maxBridgeLength = 0;
            String[] mainBridge = new String[2];
            mainBridge[0] = "[ ";                                   //윗층
            mainBridge[1] = "[ ";                                   //아랫층

            while(!yesOrNo.equals("X") && maxBridgeLength != bridgeLength) {
                String movingUpDown = makeBridge.readMoving();

                yesOrNo = getYesNo(yourBridge, ii, movingUpDown);

                //String[]으로 받아서 조금더 짧게 만들어볼수도 있겠다
                mainBridge[0] += manageGame.move(maxBridgeLength, movingUpDown, yesOrNo)[0];
                mainBridge[1] += manageGame.move(maxBridgeLength, movingUpDown, yesOrNo)[1];

                System.out.println(mainBridge[0] + " ]");
                System.out.println(mainBridge[1] + " ]");
                maxBridgeLength += 1;
                ii +=1;

            }

            //성공시 최종 게임 결과
            if(countChar(mainBridge[0],'O') + countChar(mainBridge[1], 'O') == bridgeLength){
                System.out.println("최종 게임 결과");
                System.out.println(mainBridge[0] + " ]");
                System.out.println(mainBridge[1] + " ]");

                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: " + howManyGames);
                break;
            }
            reOrStop = makeBridge.readGameCommand();                            //reOrStop = "R" or "Q"

            String finalReSt = manageGame.retry(reOrStop, mainBridge, howManyGames);

            if(finalReSt.equals("Quit")){
                break;
            }else if(finalReSt.equals("Retry")){
                continue;
            }
        }
    }
}
