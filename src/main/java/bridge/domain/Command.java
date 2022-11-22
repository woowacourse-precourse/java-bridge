package bridge.domain;

public enum Command {
    UP("U", "위", 1),
    DOWN("D", "아래", 0),
    RETRY("R", "재시도", -1),
    QUIT("Q", "종료", -1);

    private String abbreviation;
    private String korExplanation;
    private int numberCode;

    Command(String abbreviation, String korExplanation, int numberCode) {
        this.abbreviation = abbreviation;
        this.korExplanation = korExplanation;
        this.numberCode = numberCode;
    }

    public static String getAbbreviationBy(int code) {
        if (code == 1) {
            return Command.UP.abbreviation;
        }
        return Command.DOWN.abbreviation;
    }

    public static Command getByAbbreviation(String abbreviation) {
        if (abbreviation.equals(Command.UP.getAbbreviation())) {
            return Command.UP;
        }
        return Command.DOWN;
    }

    public String getKor() {
        return this.korExplanation;
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }
}
