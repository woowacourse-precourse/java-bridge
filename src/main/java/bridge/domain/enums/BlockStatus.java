package bridge.domain.enums;

import static bridge.messages.ErrorMessage.BLOCK_SYMBOL_ERROR;
import static bridge.messages.ErrorMessage.RANDOM_NUMBER_ERROR;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum BlockStatus {
    UP(1, "U"),
    DOWN(0, "D");

    private final int crossableNumber;
    private final String crossableSymbol;

    BlockStatus(final int crossableNumber, final String crossableSymbol) {
        this.crossableNumber = crossableNumber;
        this.crossableSymbol = crossableSymbol;
    }

    public static List<BlockStatus> convertToBlockStatues(List<String> symbolBlocks) {
        return symbolBlocks.stream()
                .map(BlockStatus::findByCrossableSymbol)
                .collect(Collectors.toList());
    }

    public static BlockStatus findByCrossableSymbol(final String symbolBlock) {
        return Arrays.stream(BlockStatus.values())
                .filter(blockStatus -> blockStatus.hasCrossableSymbol(symbolBlock))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(BLOCK_SYMBOL_ERROR));
    }

    public boolean hasCrossableSymbol(final String symbolBlock) {
        return this.crossableSymbol
                .equals(symbolBlock);
    }

    public static List<String> createSymbolBlocks(final List<Integer> numberBlocks) {
        return numberBlocks.stream()
                .map(BlockStatus::getCrossableSymbol)
                .collect(Collectors.toList());
    }

    public static String getCrossableSymbol(final int crossableNumber) {
        return Arrays.stream(BlockStatus.values())
                .filter(blockStatus -> blockStatus.hasCrossableNumber(crossableNumber))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(RANDOM_NUMBER_ERROR))
                .crossableSymbol;
    }

    public boolean hasCrossableNumber(final int crossableNumber) {
        return this.crossableNumber == crossableNumber;
    }


}
