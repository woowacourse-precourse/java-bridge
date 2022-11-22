package bridge.enums;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R", "재시도"),
    QUIT("Q", "종료");
    private final String shortcut;
    private final String description;

    GameCommand(String shortcut, String description) {
        this.shortcut = shortcut;
        this.description = description;
    }

    public static String getGuide() {
        StringBuilder guide = new StringBuilder();
        int totalCommandCount = GameCommand.values().length;

        guide.append("(");
        makeGuide(guide, totalCommandCount);
        guide.append(")");
        return guide.toString();
    }
    private static void makeGuide(StringBuilder guide, int totalCommandCount) {
        int count = 0;
        for (GameCommand gameCommand : GameCommand.values()) {
            count++;
            guide.append(gameCommand.description).append(": ").append(gameCommand.shortcut);
            if (count != totalCommandCount) {
                guide.append(", ");
            }
        }
    }

    public static boolean contains(String input) {
        return Arrays.stream(GameCommand.values())
                .map(element -> element.shortcut)
                .anyMatch(command -> command.equals(input));
    }

    public static GameCommand find(String command) {
        return Arrays.stream(GameCommand.values())
                .filter(element -> element.shortcut.equals(command))
                .findFirst().get();
    }

    public boolean isRetry() {
        return this.equals(RETRY);
    }


}
