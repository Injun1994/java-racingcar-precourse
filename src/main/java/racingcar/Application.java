package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Ready4Racing racing = new Ready4Racing();

        List<Car> racerList = racing.getRacerList();

        int attempts = racing.getNumberOfAttempts();

        System.out.println("\n" + Info.racingResult);

        int maxPos = 0;
        String winner = "";

        for (int i = 0; i < attempts; i++) {
            for (Car car : racerList) {
                int pos = car.moveForward();
                String racer = car.getName();

                if (maxPos == pos) {
                    if (!winner.contains(racer)) {
                        winner += ", " + racer;
                    }
                } else if (maxPos < pos) {
                    maxPos = pos;
                    winner = racer;
                }
            }
            System.out.println();
        }

        if (winner.startsWith(", ")) {
            winner = winner.substring(0, 2);
        }

        System.out.println(Info.finalWinner + winner);
    }
}
