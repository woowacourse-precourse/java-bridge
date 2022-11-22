package bridge.domain;

public class Player {

    private int position;
    private String lastSelection;
    private boolean isAlive;

    public Player() {
        this.position = 0;
        this.lastSelection = "";
        this.isAlive = true;
    }

    public int getPosition() {
        return position;
    }

    public String getLastSelection() {
        return lastSelection;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void updateSelection(String playerSelection) {
        this.lastSelection = playerSelection;
    }

    public void die() {
        this.isAlive = false;
    }

    public void updatePosition() {
        this.position++;
    }

    public boolean matches(String answer) {
        return lastSelection.equals(answer);
    }
}
