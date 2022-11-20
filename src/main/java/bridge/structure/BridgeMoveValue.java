package bridge.structure;

import java.util.Arrays;

public enum BridgeMoveValue {

    DOWN(0, "D"),
    UP(1, "U"),
    ;

    private static final String WARM = "[ERROR]";
    private static final String WARM_INNER_ERROR = WARM + " 죄송합니다. 내부 오류 입니다!";
    private static final String WARM_CHOICE_AGAIN = WARM + " 디시 선택해 주세요";


    private final int numberIdentifier;
    private final String stringIdentifier;

    BridgeMoveValue(int numberIdentifier, String stringIdentifier) {
        this.numberIdentifier = numberIdentifier;
        this.stringIdentifier = stringIdentifier;
    }

    public int getNumberIdentifier() {
        return numberIdentifier;
    }

    public String getStringIdentifier() {
        return stringIdentifier;
    }

    public static BridgeMoveValue generate(int numberIdentifier) {
        return Arrays.stream(BridgeMoveValue.values())
                .filter(bridgeMove -> bridgeMove.getNumberIdentifier() == numberIdentifier)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WARM_INNER_ERROR));
    }

    public static BridgeMoveValue generate(String stringIdentifier) {
        return Arrays.stream(BridgeMoveValue.values())
                .filter(bridgeMove -> bridgeMove.getStringIdentifier()
                        .equals(stringIdentifier))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WARM_CHOICE_AGAIN));
    }

    public static void validateInput(String input) {
        Arrays.stream(BridgeMoveValue.values())
                .filter(bridgeMoveValue -> bridgeMoveValue.getStringIdentifier()
                        .equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WARM_CHOICE_AGAIN));
    }
}