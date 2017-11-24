package vehiclesworld;


import vehiclesworld.vehicles.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Main {

    private static Random random = new Random(42);
    private static CVehicle[] arr;
    private static CVehicle[] getCheapestVehicles(){
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
    private static CVehicle[] getFastestVehicles(){
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
    private static ArrayList<CVehicle> getNewer(){
        ArrayList<CVehicle>newer = new ArrayList<>();
        for(CVehicle vehicle: arr){
            if(2017-vehicle.getYear()<=5)newer.add(vehicle);
        }
        return newer;
    }
    private static ArrayList<CVehicle> getPlanes(){
        ArrayList<CVehicle> planes = new ArrayList<>();
        for(CVehicle vehicle :arr){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(((CPlane)vehicle).getHeight()>5000&&(vehicle).getYear()>2000)planes.add(vehicle);
            }
        }
        return planes;
    }
    private static ArrayList<CVehicle> getFast(){
        ArrayList<CVehicle>fast = new ArrayList<>();
        for(CVehicle vehicle :arr){
            if (!(vehicle instanceof CPlane) && vehicle.getSpeed() <= 500 && vehicle.getSpeed() >= 200) fast.add(vehicle);
        }
        return fast;
    }
    private static ArrayList<Flyable> getFlyables(){
        ArrayList<Flyable> flyables = new ArrayList<>();
        for(CVehicle vehicle:arr){
            if(vehicle instanceof Flyable)flyables.add((Flyable) vehicle);
        }
        return flyables;
    }
    private static ArrayList<Moveable> getMoveables(){
        ArrayList<Moveable> moveables = new ArrayList<>();
        for(CVehicle vehicle:arr){
            if(vehicle instanceof Moveable)moveables.add((Moveable) vehicle);
        }
        return moveables;
    }
    private static ArrayList<Swimable> getSwimables(){
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
        arr = new CVehicle[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=VehiclesFabric.nextCVehicle();
        }
        CVehicle[] fastest = getFastestVehicles();
        CVehicle[] cheapest = getCheapestVehicles();
        ArrayList<CVehicle> newer = getNewer();
        ArrayList<CVehicle> planes = getPlanes();
        ArrayList<CVehicle> fast = getFast();
        ArrayList<Flyable> flyables = getFlyables();
        ArrayList<Moveable> moveables = getMoveables();
        ArrayList<Swimable> swimables = getSwimables();
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
