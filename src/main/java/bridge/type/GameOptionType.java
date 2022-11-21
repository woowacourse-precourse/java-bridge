package bridge.type;

public enum GameOptionType {
    R("RESTART"), Q("QUIT");

    private final String option;

    GameOptionType(String option) {
        this.option = option;
    }

    public String getOption() {
        return option;
    }
}
