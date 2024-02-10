package racingcar;

public class Winner {
    protected String winner;

    public String valueOf(String racer) {
        if (!"".equals(racer)) {
            winner = racer;
        }
        return winner;
    }
}
