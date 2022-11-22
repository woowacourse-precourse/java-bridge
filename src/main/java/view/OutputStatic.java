package view;

public enum OutputStatic {
    START("["),
    END("]"),
    MIDDLE("|"),
    SUCCESS("성공"),
    FAIL("실패"),
    TRY_COUNT("총 시도한 횟수: %s"),
    END_GAME("게임 성공 여부: "),
    TRUE_PRINT("O"),
    FALSE_PRINT("X"),
    SPACE_PRINT(" ");

    private final String outputPrint;

    OutputStatic(String outputPrint) {
        this.outputPrint = outputPrint;
    }

    public String getOutputPrint() {
        return outputPrint;
    }
}
