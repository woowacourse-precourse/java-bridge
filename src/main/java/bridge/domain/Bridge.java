package bridge.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import bridge.constant.Direction;

public class Bridge {

    private final List<Deck> decks;

    public Bridge(List<String> capitalLetters) {
        this.decks = capitalLetters.stream()
                .map(Deck::new)
                .collect(Collectors.toList());
    }

    public boolean isMovable(Position position, Direction direction) {
        if (isArrived(position)) {
            return false;
        }
        Deck deck = decks.get(position.getPosition());
        return isDeckMovable(deck, direction);
    }

    private boolean isDeckMovable(Deck deck, Direction direction) {
        if (Objects.nonNull(deck)) {
            return deck.isMovable(direction);
        }
        return false;
    }

    public boolean isArrived(Position position) {
        return position.isGreaterOrEqualThan(decks.size());
    }
}
