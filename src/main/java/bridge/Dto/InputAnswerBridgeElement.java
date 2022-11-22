package bridge.Dto;

import java.util.Arrays;

public enum InputAnswerBridgeElement {
    D(0,"D"),U(1,"U");

    final int randomNumber;
    final String bridgeType;

    InputAnswerBridgeElement(int randomNumber, String bridgeType) {
        this.bridgeType = bridgeType;
        this.randomNumber = randomNumber;
    }

    public static String inputBridgeType(int randomNumber){
        return Arrays.stream(InputAnswerBridgeElement.values())
                .filter( x -> x.randomNumber == randomNumber)
                .findAny()
                .get().bridgeType;
    }
}
