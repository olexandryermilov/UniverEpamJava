package vehiclesworld;


import vehiclesworld.Fabrics.VehiclesFabric;
import vehiclesworld.vehicles.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static CVehicle[] getCheapestVehicles(CVehicle[] arr){
        CVehicle[] cheapest = new CVehicle[3];
        for(CVehicle vehicle :arr){
            System.out.println(vehicle.getClass().getName());
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(cheapest[1]==null)cheapest[1]=vehicle;
                else if(cheapest[1].getCost()>vehicle.getCost())cheapest[1]=vehicle;
            }
            else {
                if (vehicle.getClass().getName().equals("vehiclesworld.vehicles.CShip")) {
                    if (cheapest[2] == null) cheapest[2] = vehicle;
                    else if (cheapest[2].getCost() > vehicle.getCost()) cheapest[2] = vehicle;
                }
                else{
                    if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CCar")){
                        if(cheapest[0]==null)cheapest[0]=vehicle;
                        else if(cheapest[0].getCost()>vehicle.getCost())cheapest[0]=vehicle;
                    }
                }
            }
        }
        return cheapest;
    }
    public static CVehicle[] getFastestVehicles(CVehicle[] arr){
        CVehicle[] fastest = new CVehicle[3];
        for(CVehicle vehicle :arr){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(fastest[1]==null)fastest[1]=vehicle;
                else if(fastest[1].getSpeed()<vehicle.getSpeed())fastest[1]=vehicle;
            }
            else {
                if (vehicle.getClass().getName().equals("vehiclesworld.vehicles.CShip")) {
                    if (fastest[2] == null) fastest[2] = vehicle;
                    else if (fastest[2].getSpeed() < vehicle.getSpeed()) fastest[2] = vehicle;
                }
                else{
                    if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CCar")){
                        if(fastest[0]==null)fastest[0]=vehicle;
                        else if(fastest[0].getSpeed()<vehicle.getSpeed())fastest[0]=vehicle;
                    }
                }
            }
        }
        return fastest;
    }
    public static ArrayList<CVehicle> getNewer(CVehicle[] arr){
        ArrayList<CVehicle>newer = new ArrayList<>();
        for(CVehicle vehicle: arr){
            if(2017-vehicle.getYear()<=5)newer.add(vehicle);
        }
        return newer;
    }
    public static ArrayList<CVehicle> getPlanes(CVehicle[] arr){
        ArrayList<CVehicle> planes = new ArrayList<>();
        for(CVehicle vehicle :arr){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(((CPlane)vehicle).getHeight()>5000&&(vehicle).getYear()>2000)planes.add(vehicle);
            }
        }
        return planes;
    }
    public static ArrayList<CVehicle> getFast(CVehicle[] arr){
        ArrayList<CVehicle>fast = new ArrayList<>();
        for(CVehicle vehicle :arr){
            if (!(vehicle instanceof CPlane) && vehicle.getSpeed() <= 500 && vehicle.getSpeed() >= 200) fast.add(vehicle);
        }
        return fast;
    }
    public static ArrayList<Flyable> getFlyables(CVehicle[] arr){
        ArrayList<Flyable> flyables = new ArrayList<>();
        for(CVehicle vehicle:arr){
            if(vehicle instanceof Flyable)flyables.add((Flyable) vehicle);
        }
        return flyables;
    }
    public static ArrayList<Moveable> getMoveables(CVehicle[] arr){
        ArrayList<Moveable> moveables = new ArrayList<>();
        for(CVehicle vehicle:arr){
            if(vehicle instanceof Moveable)moveables.add((Moveable) vehicle);
        }
        return moveables;
    }
    public static ArrayList<Swimable> getSwimables(CVehicle[] arr){
        ArrayList<Swimable> swimables = new ArrayList<>();
        for(CVehicle vehicle:arr){
            if(vehicle instanceof Swimable)swimables.add((Swimable) vehicle);
        }
        return swimables;
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
            arr[i]= VehiclesFabric.nextCVehicle();
        }
        CVehicle[] fastest = getFastestVehicles(arr);
        CVehicle[] cheapest = getCheapestVehicles(arr);
        ArrayList<CVehicle> newer = getNewer(arr);
        ArrayList<CVehicle> planes = getPlanes(arr);
        ArrayList<CVehicle> fast = getFast(arr);
        ArrayList<Flyable> flyables = getFlyables(arr);
        ArrayList<Moveable> moveables = getMoveables(arr);
        ArrayList<Swimable> swimables = getSwimables(arr);
        System.out.println(Arrays.toString(fastest));
        System.out.println(Arrays.toString(cheapest));
        System.out.println(newer);
        System.out.println(planes);
        System.out.println(fast);
        System.out.println(flyables);
        System.out.println(moveables);
        System.out.println(swimables);
    }
}
