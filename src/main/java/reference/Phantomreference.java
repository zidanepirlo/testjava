package reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class Phantomreference {

    public static void main(String[] args) {

        ReferenceQueue queue = new ReferenceQueue();
        Reference ref = new PhantomReference(new Phantomreference(), queue);
        System.out.println(ref);
        try {
            System.out.println(queue.remove(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.gc();
        try {
            System.out.println(queue.remove(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
