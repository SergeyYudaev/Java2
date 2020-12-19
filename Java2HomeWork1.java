public class Java2HomeWork1 {
    public static void main(String[] args) {
        Movable human1 = new Human("human1", 2, 10);
        Movable human2 = new Human("human2", 3, 3);
        Movable robot1 = new Robot("robot1", 1, 7);
        Movable robot2 = new Robot("robot2", 6, 5);
        Movable cat1 = new Cat("cat1", 3, 10);
        Movable cat2 = new Cat("cat2", 8, 8);

        Hindering wall1 = new Wall(2);
        Hindering wall2 = new Wall(3);
        Hindering runningTrack1 = new RunningTrack(5);
        Hindering runningTrack2 = new RunningTrack(4);

        Movable[] movables = {human1, human2, robot1, robot2, cat1, cat2};
        Hindering[] hinderings = {wall1, wall2, runningTrack1, runningTrack2};

        for (int i = 0; i < hinderings.length; i++) {
            System.out.println("\nПрепятствие " + (i + 1));
            for (int j = 0; j < movables.length; j++) {
                hinderings[i].checkSuccess(movables[j]);

            }

        }

    }

}
