package com.example.one;

public class Vehicle {

    Vehicle(int slotNo){
        this.isOccupied =false;
        this.slotNo=slotNo+1;
    }

    private String reg_no;
    private String color;
    private int slotNo;
    private boolean isOccupied;

    String getColor() {
        return color;
    }

    String getReg_no() {
        return reg_no;
    }

    int getSlotNo() {
        return slotNo;
    }

    boolean isOccupied() {
        return isOccupied;
    }

    void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    void setColor(String color) {
        this.color = color;
    }

    void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    @Override
    public String toString() {
        return this.getSlotNo()+"\t"+this.reg_no+"\t"+this.color;
    }
}
