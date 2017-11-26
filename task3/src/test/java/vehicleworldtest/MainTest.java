package vehicleworldtest;

import org.junit.BeforeClass;
import org.junit.Test;
import vehiclesworld.Fabrics.VehiclesFabric;
import vehiclesworld.Main;
import vehiclesworld.vehicles.*;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MainTest {
    static CVehicle[] arr;
    @BeforeClass
    public static void initArr(){
        arr = new CVehicle[20];
        for(int i=0;i<arr.length;i++){
            arr[i]=VehiclesFabric.nextCVehicle();
        }
    }
    @Test
    public void getFastestVehicles_GivesRightAnswer(){
        CVehicle[] fastest = Main.getFastestVehicles(arr);
        boolean areFastest = true;
        for(CVehicle vehicle : arr){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(fastest[1].getSpeed()<vehicle.getSpeed()){
                    areFastest=false;
                    break;
                }
            }
            else {
                if (vehicle.getClass().getName().equals("vehiclesworld.vehicles.CShip")) {
                    if(fastest[2].getSpeed()<vehicle.getSpeed()){
                        areFastest=false;
                        break;
                    }
                }
                else{
                    if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CCar")){
                        if(fastest[0].getSpeed()<vehicle.getSpeed()){
                            areFastest=false;
                            break;
                        }
                    }
                }
            }
        }
        assertTrue(areFastest);
    }
    @Test
    public void getCheapestVehicles_GivesRightAnswer(){
        CVehicle[] cheapest = Main.getCheapestVehicles(arr);
        boolean areCheapest = true;
        for(CVehicle vehicle : arr){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                if(cheapest[1].getCost()>vehicle.getCost()){
                    areCheapest=false;
                    break;
                }
            }
            else {
                if (vehicle.getClass().getName().equals("vehiclesworld.vehicles.CShip")) {
                    if(cheapest[2].getCost()>vehicle.getCost()){
                        areCheapest=false;
                        break;
                    }
                }
                else{
                    if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CCar")){
                        if(cheapest[0].getCost()>vehicle.getCost()){
                            areCheapest=false;
                            break;
                        }
                    }
                }
            }
        }
        assertTrue(areCheapest);
    }

    @Test
    public void getNewer_allNewerThanFiveYears(){
        boolean areNew = true;
        ArrayList<CVehicle>newer = Main.getNewer(arr);
        for(CVehicle vehicle:newer){
            if(2017-vehicle.getYear()>5){
                areNew=false;
                break;
            }
        }
        assertTrue(areNew);
    }
    //найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
    @Test
    public void getPlanes_GivesOnlyGoodPlanes(){
        ArrayList<CVehicle> planes = Main.getPlanes(arr);
        boolean areGoodPlanes = true;
        for(CVehicle vehicle : planes){
            if(!vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                areGoodPlanes=false;
                break;
            }
            else{
                if(((CPlane)vehicle).getHeight()<5000||vehicle.getYear()<2000){
                    areGoodPlanes=false;
                    break;
                }
            }
        }
        assertTrue(areGoodPlanes);
    }
    //найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
    @Test
    public void getFast_GivesOnlyGoodVehicles(){
        ArrayList<CVehicle> fast = Main.getFast(arr);
        boolean areGoodVehicles = true;
        for(CVehicle vehicle : fast){
            if(vehicle.getClass().getName().equals("vehiclesworld.vehicles.CPlane")){
                areGoodVehicles=false;
                break;
            }
            else{
                if(vehicle.getSpeed()>500||vehicle.getSpeed()<200){
                    areGoodVehicles=false;
                    break;
                }
            }
        }
        assertTrue(areGoodVehicles);
    }
    //создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
    @Test
    public void getFlyables_GivesAllFlyables(){
        boolean areFlyables = true;
        ArrayList<Flyable>flyables = Main.getFlyables(arr);
        for(CVehicle vehicle : arr){
            if(vehicle instanceof Flyable){
                if(!flyables.contains(vehicle)){
                    areFlyables=false;
                    break;
                }
            }
        }
        assertTrue(areFlyables);
    }
    @Test
    public void getMoveables_GivesAllMoveables(){
        boolean areMoveables = true;
        ArrayList<Moveable> moveables = Main.getMoveables(arr);
        for(CVehicle vehicle : arr){
            if(vehicle instanceof Moveable){
                if(!moveables.contains(vehicle)){
                    areMoveables=false;
                    break;
                }
            }
        }
        assertTrue(areMoveables);
    }
    @Test
    public void getSwimables_GivesAllSwimables(){
        boolean areSwimables = true;
        ArrayList<Swimable>swimables = Main.getSwimables(arr);
        for(CVehicle vehicle : arr){
            if(vehicle instanceof Swimable){
                if(!swimables.contains(vehicle)){
                    areSwimables=false;
                    break;
                }
            }
        }
        assertTrue(areSwimables);
    }
    /*
        CVehicle[] fastest = getFastestVehicles(arr);
        CVehicle[] cheapest = getCheapestVehicles(arr);
        ArrayList<CVehicle> newer = getNewer(arr);
        ArrayList<CVehicle> planes = getPlanes(arr);
        ArrayList<CVehicle> fast = getFast(arr);
        ArrayList<Flyable> flyables = getFlyables(arr);
        ArrayList<Moveable> moveables = getMoveables(arr);
        ArrayList<Swimable> swimables = getSwimables(arr);
     */
}
