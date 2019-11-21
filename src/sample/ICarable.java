package sample;

public interface ICarable {
    public void feed(int ammout, String foodName);
    public boolean isAlive(int actualDate);
    public boolean isAdult(float age);

    public String getSpicieInformation();
}
