public class Wall implements Hindering {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public void checkSuccess(Movable movable) {

        if (movable.isSuccess()) {
//            System.out.println(movable.jump());
            movable.setSuccess(movable.getMaxJump() >= height);
            if (movable.isSuccess())
                System.out.println(movable.getName() + " перепрыгнул через стену высотой " + height + " единиц(ы)");
            else
                System.out.println(movable.getName() + " не смог перепрыгнуть через стену высотой " + height + " единиц(ы)");
        }
    }


}
