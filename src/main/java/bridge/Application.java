package bridge;

public class Application {

    public static int countChar(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        //이동할 칸 입력받음
        InputView makeBridge = new InputView();

        int bridgeLength = makeBridge.readBridgeSize();             // 다리의 길이
        int howManyGames = 0;                                       //게임 시도한 횟수 count

        String reOrStop = "";

        while(true) {
            String yesOrNo = "";
            howManyGames += 1;

            int maxBridgeLength = 0;

            String mainBridge1 = "[ ";                                //윗층
            String mainBridge2 = "[ ";                                //아랫층

            while(yesOrNo != "X" || maxBridgeLength == bridgeLength) {
                String movingUpDown = makeBridge.readMoving();          // U이면 위, D이면 아래


                BridgeRandomNumberGenerator randomNumber = new BridgeRandomNumberGenerator();
                int whichBridge = randomNumber.generate();              // 1이면 U, 0이면 D가 맞는거!

                //추후에 boolean 메서드로 묶을 예정

                if (whichBridge == 1 && movingUpDown.equals("U")) {       //정답
                    yesOrNo = "O";
                } else if (whichBridge == 0 && movingUpDown.equals("D")) {  //정답
                    yesOrNo = "O";
                } else if (whichBridge == 1 && movingUpDown.equals("D")) {  //오답
                    yesOrNo = "X";
                } else if (whichBridge == 0 && movingUpDown.equals("U")) {  //오답
                    yesOrNo = "X";
                }

                if(maxBridgeLength == 0) {
                    if (movingUpDown.equals("U") && yesOrNo.equals("O")) {
                        mainBridge1 += yesOrNo;
                        mainBridge2 += " ";
                    } else if (movingUpDown.equals("D") && yesOrNo.equals("O")) {
                        mainBridge1 += " ";
                        mainBridge2 += yesOrNo;
                    } else if (movingUpDown.equals("U") && yesOrNo.equals("X")) {
                        mainBridge1 += yesOrNo;
                        mainBridge2 += " ";
                    } else if (movingUpDown.equals("D") && yesOrNo.equals("X")) {
                        mainBridge1 += " ";
                        mainBridge2 += yesOrNo;
                    }
                }else if(maxBridgeLength != 0){
                    if (movingUpDown.equals("U") && yesOrNo.equals("O")) {
                        mainBridge1 += " | " + yesOrNo;
                        mainBridge2 += " | " + " ";
                    } else if (movingUpDown.equals("D") && yesOrNo.equals("O")) {
                        mainBridge1 += " | " + " ";
                        mainBridge2 += " | " + yesOrNo;
                    } else if (movingUpDown.equals("U") && yesOrNo.equals("X")) {
                        mainBridge1 += " | " + yesOrNo;
                        mainBridge2 += " | " + " ";
                    } else if (movingUpDown.equals("D") && yesOrNo.equals("X")) {
                        mainBridge1 += " | " + " ";
                        mainBridge2 += " | " + yesOrNo;
                    }
                }

                System.out.println(mainBridge1 + " ]");
                System.out.println(mainBridge2 + " ]");
                maxBridgeLength += 1;
            }
            int cntMainB1 = 0;
            int cntMainB2 = 0;

            if(countChar(mainBridge1,'O') + countChar(mainBridge2, 'O') == bridgeLength){
                System.out.println("게임 성공 여부: 성공");
                System.out.println("총 시도한 횟수: " + howManyGames);
            }
            reOrStop = makeBridge.readGameCommand();

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
