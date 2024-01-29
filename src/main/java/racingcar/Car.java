package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    protected String getName() {
        return name;
    }

    protected int moveForward() {
        Ready4Racing racing = new Ready4Racing();
        int randomNumber = racing.getNumber();

        if (randomNumber >= 4) {
            position++;
        }

        System.out.print(name + " : ");

        if (position > 0) {
            for (int i = 0; i < position; i++) {
                System.out.print("-");
            }
        }
        System.out.println();

        return position;
    }

}
