package lld.vehiclerental.entity;

import lld.vehiclerental.constants.VehicleType;

public class Vehicle {

    private VehicleType vehicleType;


    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
