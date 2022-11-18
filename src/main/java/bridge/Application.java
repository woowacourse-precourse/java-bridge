package bridge;

public class Application {

    public static void main(String[] args) {

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();

        while(true) {
            //이동할 칸 입력받음
            InputView makeBridge = new InputView();

            String yesOrNo = "";

            int bridgeLength = makeBridge.readBridgeSize();         // 다리의 길이
            int maxBridgeLength = 0;
            while(yesOrNo != "X") {
                String movingUpDown = makeBridge.readMoving();          // U이면 위, D이면 아래

                String mainBridge1 = "[ ";                                //윗층
                String mainBridge2 = "[ ";                                //아랫층

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
//                mainBridge1 += " | ";
//                mainBridge2 += " | ";
                maxBridgeLength += 1;
            }
        }
    }
}
