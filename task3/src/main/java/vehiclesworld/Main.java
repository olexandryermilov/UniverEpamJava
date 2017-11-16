package vehiclesworld;


import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static Random random = new Random(42);
    private static CVehicle nextCVehicle(){
        int x = Math.abs(random.nextInt())%5;
        switch(x){
            case 0: return new CCar(20000-random.nextInt()%10000,250-random.nextInt()%100,2017-random.nextInt()%20);
            case 1: return new CPlane(2000000-random.nextInt()%1000000,900-random.nextInt()%300,
                    2017-random.nextInt()%10,250-random.nextInt()%100,11000-random.nextInt()%4000);
            case 2: return new CShip(2000000-random.nextInt()%1000000,600-random.nextInt()%300,
                    2017-random.nextInt()%10,350-random.nextInt()%100,"Odessa");
            case 3: return new Batmobile(100000-random.nextInt()%10000,350-random.nextInt()%100,2017-random.nextInt()%5);
            case 4: return new Amphibia(80000-random.nextInt()%20000,300-random.nextInt()%100,2017-random.nextInt()%10);
            default:return null;
        }
    }
    /*
    1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
    найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
     найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
     добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
     */
    public static void main(String[] args) {
        CVehicle[] arr = new CVehicle[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=nextCVehicle();
        }
        CVehicle[] fastest = new CVehicle[3];
        CVehicle[] cheapest = new CVehicle[3];
        ArrayList<CVehicle> newer = new ArrayList<>();
        ArrayList<CVehicle> planes = new ArrayList<>();
        ArrayList<CVehicle> fast = new ArrayList<>();
        ArrayList<Flyable> flyables = new ArrayList<>();
        ArrayList<Moveable> moveables = new ArrayList<>();
        ArrayList<Swimable> swimables = new ArrayList<>();
        for(CVehicle vehicle :arr){
            if(2017-vehicle.getYear()<=5)newer.add(vehicle);
            if(vehicle.getClass().getName().equals("CPlane")){
                if(fastest[1]==null)fastest[1]=vehicle;
                else if(fastest[1].getSpeed()<vehicle.getSpeed())fastest[1]=vehicle;
                if(cheapest[1]==null)cheapest[1]=vehicle;
                else if(cheapest[1].getCost()>vehicle.getCost())cheapest[1]=vehicle;
                if(((CPlane)vehicle).getHeight()>5000&&(vehicle).getYear()>2000)planes.add(vehicle);
            }
            else {
                if (vehicle.getSpeed() <= 500 && vehicle.getSpeed() >= 200) fast.add(vehicle);
                if (vehicle.getClass().getName().equals("CShip")) {
                    if (fastest[2] == null) fastest[2] = vehicle;
                    else if (fastest[2].getSpeed() < vehicle.getSpeed()) fastest[2] = vehicle;
                    if (cheapest[2] == null) cheapest[2] = vehicle;
                    else if (cheapest[2].getCost() > vehicle.getCost()) cheapest[2] = vehicle;
                }
                else{
                    if(vehicle.getClass().getName().equals("CCar")){
                        if(fastest[0]==null)fastest[0]=vehicle;
                        else if(fastest[0].getSpeed()<vehicle.getSpeed())fastest[0]=vehicle;
                        if(cheapest[0]==null)cheapest[0]=vehicle;
                        else if(cheapest[0].getCost()>vehicle.getCost())cheapest[0]=vehicle;
                    }
                }
            }
            if(vehicle instanceof Flyable)flyables.add((Flyable) vehicle);
            if(vehicle instanceof Moveable)moveables.add((Moveable) vehicle);
            if(vehicle instanceof Swimable)swimables.add((Swimable) vehicle);
        }

    }
}
