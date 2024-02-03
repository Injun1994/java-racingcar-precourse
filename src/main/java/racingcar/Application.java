package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        ReadyForRacing racing = new ReadyForRacing();

        List<Car> racerList = racing.getRacerList();
        List<Winner> winners = new ArrayList<>();

        int attempts = racing.getNumberOfAttempts();

        System.out.println("\n" + Info.RACING_RESULT);

        int maxPosition = 0;

        for (int i = 0; i < attempts; i++) {
            for (Car car : racerList) {
                int pos = car.moveForward();
                String racer = car.getName();
                Winner winner = null;

                if (maxPosition == pos) {

                    for (Winner single : winners) {
                        if (!single.getWinner().equals(racer)) {
                            winner = new Winner(racer);
                            winners.add(winner);
                        }
                    }

                    if(winners.size() == 0) {
                        winners.add(new Winner(racer));
                    }
                } else if (maxPosition < pos) {
                    maxPosition = pos;

                    winners.clear();
                    winner = new Winner(racer);
                    winners.add(winner);
                }
            }
            System.out.println();
        }

        System.out.println(Info.FINAL_WINNER + racing.arrange(winners));
    }
}
