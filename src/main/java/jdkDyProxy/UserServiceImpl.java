package jdkDyProxy;

public class UserServiceImpl implements UserService{

    private TwoService twoService;

    public void setTwoService(TwoService twoService) {
        this.twoService = twoService;
    }

    @Override
    public void add() {

//        sum();
        System.out.println("--------------------add---------------");
//        twoService.TsFun1();
    }

    @Override
    public void sum() {
        System.out.println("--------------------sum---------------");
    }
}
