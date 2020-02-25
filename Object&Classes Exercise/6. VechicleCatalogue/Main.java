package SoftUni.VehicleCatalogue;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Vehicle> vehicles = new ArrayList<>();
        boolean stopFilingCatalog = false;


        while (!stopFilingCatalog) {
            String[] tokens = sc.nextLine().split(" ");
            String model;
            String color;
            int horsePower;

            if (tokens[0].equals("truck")) {
                model = tokens[1];
                color = tokens[2];
                horsePower = Integer.parseInt(tokens[3]);

                Vehicle vehicle = new Vehicle("Truck", model, color, horsePower);
                vehicles.add(vehicle);

            } else if (tokens[0].equals("car")) {
                model = tokens[1];
                color = tokens[2];
                horsePower = Integer.parseInt(tokens[3]);

                Vehicle vehicle = new Vehicle("Car", model, color, horsePower);
                vehicles.add(vehicle);
            }

            if (tokens[0].equals("End")) {
                stopFilingCatalog = true;
            }

        }

        boolean closeTheCatalog = false;


        double carsTotalHorsePower = 0;
        double truckTotalHorsePower = 0;

        int carsCounter = 0;
        int truckCounter = 0;

            while (!closeTheCatalog){
                String command = sc.nextLine();

                    for (Vehicle it: vehicles) {

                        if(it.getType().equals("Truck")){
                            truckTotalHorsePower += it.getHorsePower();
                            truckCounter++;
                        }else {
                            carsTotalHorsePower += it.getHorsePower();
                            carsCounter++;
                        }
                        if(command.equals(it.getModel())){
                            System.out.println( it.toString());
                        }
                    }

                if(command.equals("Close the Catalogue")){
                    closeTheCatalog = true;
                }
            }

        System.out.printf("Cars have average horsepower of: %.2f.\n",carsTotalHorsePower / carsCounter);
        System.out.printf("Trucks have average horsepower of: %.2f.",truckTotalHorsePower / truckCounter);

        }
    }

