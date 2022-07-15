package racingcar;

public class Car {
    private final String name;
    MoveCondition moving;
    private int position = 0;

    public Car(String name) {
        this.name = name;
        moving = new CurrentMove();
    }
    public String getName(){
        return this.name;
    }
    public void move(){
        position += moving.forword();
    }

    public int getPosition() {
        return position;
    }
}
