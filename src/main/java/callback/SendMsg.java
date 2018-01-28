package callback;

import Entity.Student;

public class SendMsg {

    public void synSend(final String msg,Callback callback){

        System.out.println("SendMsg.synSend "+msg);
        callback.operationComplete();
    }

    public void synSendByValue(final String msg,CallbackByValue callbackByValue){
        System.out.println("SendMsg.synSend "+msg);
        Student student = new Student();
        student.setId("1111");
        student.setAge(40);
        callbackByValue.operationComplete(student);
    }
}
