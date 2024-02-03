package racingcar;

public class Winner {

    private static String winner;

    public Winner(String winner) {
        this.winner = winner;
    }

    protected String getWinner() {
        return winner;
    }
}
