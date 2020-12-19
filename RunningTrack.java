public class RunningTrack implements Hindering {
    private int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    public void checkSuccess(Movable movable) {

        if (movable.isSuccess()) {
//            System.out.println(movable.run());
            movable.setSuccess(movable.getMaxRun() >= distance);
            if (movable.isSuccess())
                System.out.println(movable.getName() + " пробежал дистанцию в " + distance + " единиц(ы)");
            else
                System.out.println(movable.getName() + " не смог преодолеть дистанцию в " + distance + " единиц(ы)");
        }
    }
}
