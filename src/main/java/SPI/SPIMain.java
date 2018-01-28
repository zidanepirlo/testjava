package SPI;

import java.util.ServiceLoader;

public class SPIMain {

    public static void main(String[] args) {

        ServiceLoader<Cmand> loader = ServiceLoader.load(Cmand.class);
        System.out.println(loader);

        for (Cmand Cmand : loader) {
            Cmand.execute();
        }
    }
}
