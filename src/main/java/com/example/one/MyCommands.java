package com.example.one;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@ShellComponent("MyParking")
public class MyCommands {

    private static final String PROLOGUE="Slot No.\tRegistration No.\tColor\n";
    private Vehicle[] vehicles;

    @ShellMethod("Create Parking lot")
    public String create_parking_lot(int size) {
        vehicles=new Vehicle[size];
        for (int i = 0; i < size; i++) {
            vehicles[i] = new Vehicle(i);
        }
        return "Created a Parking lot with " + size + " Slots";
    }

    @ShellMethod("Park Vehicle in next available parking")
    public String park(String reg_no, String color) {
        Optional<Vehicle> nextItem = Arrays.stream(vehicles).filter(p -> !p.isOccupied()).findFirst();
        if (nextItem.isPresent()) {
            Vehicle vehicle = nextItem.get();
            vehicles[vehicle.getSlotNo()-1].setOccupied(true);
            vehicles[vehicle.getSlotNo()-1].setColor(color);
            vehicles[vehicle.getSlotNo()-1].setReg_no(reg_no);
            return "Allocated Slot number:\t" + (vehicle.getSlotNo());
        } else return "Sorry parking lot is full";
    }

    @ShellMethod(" leave parking facility")
    public String leave(int slot_no) {
        if(slot_no<vehicles.length&&vehicles[slot_no-1].isOccupied()){
            vehicles[slot_no-1].setOccupied(false);
            return "Slot number \t"+(slot_no)+"\t is Free.";
        }
        return (slot_no) + " is Empty";
    }

    @ShellMethod("list all Parked vehicles")
    public String status() {
        if(vehicles!=null)
        return PROLOGUE.concat(Arrays.stream(vehicles).filter(Vehicle::isOccupied).map(Object::toString)
                .collect(Collectors.joining("\n")));
        else  return "Parking lot details not available";
    }

    @ShellMethod("list all registration numbers of cars with given color")
    public String registration_numbers_for_cars_with_colour(String color){
        if(vehicles!=null) {
            List<String> result = Arrays.stream(vehicles).filter(p ->p.isOccupied()&&
                    p.getColor().equalsIgnoreCase(color)).map(Vehicle::getReg_no).collect(Collectors.toList());
            if(result.size()>0)
            return String.join(", ", result);
            return "Not found";
        }
        else  return "Parking lot details not available";
    }


    @ShellMethod("list parking slots of cars with given color")
    public String slot_numbers_for_cars_with_colour(String color){
        if(vehicles!=null) {
            List<Integer> result = Arrays.stream(vehicles).filter(p ->p.isOccupied()&&
                    p.getColor().equalsIgnoreCase(color)).map(Vehicle::getSlotNo).collect(Collectors.toList());
            if(result.size()>0)
                return result.stream().map(Objects::toString).collect(Collectors.joining(", "));
            return "Not found";

        }
        else  return "Parking lot details not available";
    }

    @ShellMethod("list slot number of car with given registration number")
    public String slot_number_for_registration_number(String reg_no){
        if(vehicles!=null) {
            List<Integer> result = Arrays.stream(vehicles).filter(p ->p.isOccupied()&&
                    p.getReg_no().equalsIgnoreCase(reg_no)).map(Vehicle::getSlotNo).collect(Collectors.toList());
            if(result.size()>0)
                return result.stream().map(Objects::toString).collect(Collectors.joining(", "));
            return "Not found";

        }
        else  return "Parking lot details not available";
    }

}
