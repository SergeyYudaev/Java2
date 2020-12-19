public class Human implements Movable {
    private String name;
    private int maxJump;
    private int maxRun;
    private boolean success = true;


    public Human(String name, int maxJump, int maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public String jump() {
        return name + " прыгает на " + maxJump + " единиц(ы)";
    }

    public String run() {
        return name + " бегает на " + maxRun + " единиц(ы)";
    }

    public String getName() {
        return name;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public int getMaxRun() {
        return maxRun;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
