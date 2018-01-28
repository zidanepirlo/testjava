package SPI;

public class ShutdownCommand implements Cmand {
    public void execute() {
        System.out.println("shutdown....");
    }
}
