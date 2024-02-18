package racingcar;

public class Winner {
    private final String winner;

    private Winner(String winner) {
        this.winner = winner;
    }

    public static Winner valueOf(String racer) {
        return new Winner(racer);
    }

    public String getWinner() {
        return winner;
    }
}
