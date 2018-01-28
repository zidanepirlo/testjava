package callback;

import Entity.Student;

public class TestCallBack {

    public void callbackOne(){

        SendMsg sendMsg = new SendMsg();
        sendMsg.synSend("yuanqing", new Callback() {
            @Override
            public void operationComplete() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Iam operationComplete!");
                return;
            }
        });

        System.out.println("AAAAAAAAAAA");
    }

    public void callbackTwo(){

        SendMsg sendMsg = new SendMsg();
        sendMsg.synSendByValue("yuanqing", new CallbackByValue<Student>() {
            @Override
            public void operationComplete(Student student) {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(student.getId());
                System.out.println(student.getAge());
                System.out.println("Iam operationComplete!");
                return;

            }
        });

        System.out.println("AAAAAAAAAAA");
    }
}
