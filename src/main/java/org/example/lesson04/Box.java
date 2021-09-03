package org.example.lesson04;

public class Box {
    private Integer ballCounter;

    public Box() {
        this.ballCounter = 0;
    }

    public Integer getBallCounter() {
        return ballCounter;
    }

    public void setBallCounter(Integer ballCounter) {
        this.ballCounter = ballCounter;
    }

    public void deleteBall() throws BoxIsEmptyException {
        if(ballCounter == 0) {
            throw new BoxIsEmptyException();
        }
        ballCounter--;
    }

    public void addBall() {
        ballCounter ++;
    }

    public void mixBalls() {
        if (ballCounter == 0) {
            throw new NullPointerException();
        }
    }
}
