public interface Movable {
    String jump();
    String run();
    String getName();
    int getMaxJump();
    int getMaxRun();
    boolean isSuccess();
    String toString();
    void setSuccess(boolean success);

}
