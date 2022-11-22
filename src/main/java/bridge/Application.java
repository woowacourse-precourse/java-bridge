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
//        } else if (!yourBridge.get(i).equals(movingUpDown)) {  //오답
//            return "X";
//        }
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


        int bridgeLength = makeBridge.readBridgeSize();             // 다리의 길이

        int howManyGames = 0;                                       //게임 시도한 횟수 count

        String reOrStop = "";                                       //게임 재시작 여부

        while(true) {
            List<String> yourBridge = bridgeMake.makeBridge(bridgeLength);

            String yesOrNo = "";
            howManyGames += 1;

            int maxBridgeLength = 0;

            String mainBridge1 = "[ ";                                //윗층
            String mainBridge2 = "[ ";                                //아랫층


            //U,D에 따라서 다리를 만듬
            //refact List<String> yourBridge, String yesOrNO,
            for(int i = 0; i < bridgeLength; i++) {
                String movingUpDown = makeBridge.readMoving();

                //refact - 1
                if (yourBridge.get(i).equals(movingUpDown)) {       //정답
                    yesOrNo = "O";
                } else if (!yourBridge.get(i).equals(movingUpDown)) {  //오답
                    yesOrNo = "X";
                }

                //refact - 2
                //처음에 다리 만들때
                if(maxBridgeLength == 0) {
                    if (movingUpDown.equals("U")) {
                        mainBridge1 += yesOrNo;
                        mainBridge2 += " ";
                    } else if (movingUpDown.equals("D")) {
                        mainBridge1 += " ";
                        mainBridge2 += yesOrNo;
                    }
                    //2번째 이상부터 다리 만들때
                }else if(maxBridgeLength != 0){
                    if (movingUpDown.equals("U")) {
                        mainBridge1 += " | " + yesOrNo;
                        mainBridge2 += " | " + " ";
                    } else if (movingUpDown.equals("D")) {
                        mainBridge1 += " | " + " ";
                        mainBridge2 += " | " + yesOrNo;
                    }
                }

                System.out.println(mainBridge1 + " ]");
                System.out.println(mainBridge2 + " ]");
                maxBridgeLength += 1;
                if(yesOrNo.equals("X")){
                    break;
                }
            }

            //성공시 최종 게임 결과
            if(countChar(mainBridge1,'O') + countChar(mainBridge2, 'O') == bridgeLength){
                System.out.println("최종 게임 결과");
                System.out.println(mainBridge1 + " ]");
                System.out.println(mainBridge2 + " ]");

                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: " + howManyGames);
                break;
            }
            reOrStop = makeBridge.readGameCommand();

            //실패시 쵲오 게임 결과
            if(reOrStop.equals("R")){
                continue;
            }else if(reOrStop.equals("Q")){
                System.out.println("최종 게임 결과");
                System.out.println(mainBridge1 + " ]");
                System.out.println(mainBridge2 + " ]");

                System.out.println("게임 성공 여부: 실패");
                System.out.println("총 시도한 횟수: " + howManyGames);
                break;
            }
        }
    }
}
