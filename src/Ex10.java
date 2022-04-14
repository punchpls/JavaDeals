class BaseClass{
    void oneMethod(){
        System.out.println("Inside Method One");
        this.twoMethod();
    }
    void twoMethod(){
        System.out.println("Inside Method Two");
    }
}

class SubClass extends BaseClass{
    @Override
    void twoMethod(){
        System.out.println("Inside overriden Method Two");
    }
}

public class Ex10 {
    public static void main(String[] args){
        BaseClass S = new SubClass();
        S.oneMethod();
    }
}
