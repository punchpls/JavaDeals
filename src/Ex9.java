class Rodent{
    void eat(){
        System.out.println("Rodent is eating smth");
    }

    void voice(){
        System.out.println("Rodent is making noise");
    }
}

class Mouse extends Rodent{
    @Override
    void eat(){
        System.out.println("Mouse is eating smth");
    }
    @Override
    void voice(){
        System.out.println("Mouse is making noise");
    }
}

class Gerbil extends Rodent{
    @Override
    void eat(){
        System.out.println("Gerbil is eating smth");
    }
    @Override
    void voice(){
        System.out.println("Gerbil is making noise");
    }
}

class Hamster extends Rodent{
    @Override
    void eat(){
        System.out.println("Hamster is eating smth");
    }
    @Override
    void voice(){
        System.out.println("Hamster is making noise");
    }
}

public class Ex9 {
    public static void main(String[] args) {
        Rodent[] RodentArray = {
                new Mouse(),
                new Gerbil(),
                new Hamster()
        };
        for (Rodent R : RodentArray) {
            R.eat();
            R.voice();
        }
    }
}
