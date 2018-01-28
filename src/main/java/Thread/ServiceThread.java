package Thread;

public abstract class ServiceThread implements Runnable {

    private Thread thread;

    private String name;

    public ServiceThread(String name) {
        this.thread = new Thread(this,name);
        this.name = name;
    }

}
