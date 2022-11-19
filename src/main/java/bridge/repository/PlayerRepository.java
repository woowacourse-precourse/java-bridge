package bridge.repository;

import bridge.domain.player.Player;

public class PlayerRepository {

    private static final PlayerRepository playerRepository = new PlayerRepository();

    private Player player;

    private PlayerRepository() {
    }

    public static PlayerRepository getInstance() {
        return playerRepository;
    }

    public void update(Player player) {
        this.player = player;
    }

    public Player get() {
        return player;
    }
}
