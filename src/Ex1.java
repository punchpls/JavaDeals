class Cycle{
    public void ride(){
        System.out.println("fuck");
    }
}

class Unicycle extends Cycle{
    public void balance(){
        System.out.println("Inside Cycle balance");
    }
}

class Bicycle extends Cycle{
    public void balance(){
        System.out.println("Inside Bicycle balance");
    }
}

class Tricycle extends Cycle{}

public class Ex1{
    public static void main(String[] args){
        Cycle [] cycleVehicles = new Cycle[]{
                new Unicycle(),
                new Bicycle(),
                new Tricycle()
        };
        for (int i = 0; i < cycleVehicles.length; i++){
            ((Bicycle)cycleVehicles[i]).balance();
        }
    }
}
