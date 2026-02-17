package com.sau.librraryplacment.dto;

public class Place {
    int Id;
    String building;
    String floor;
    String room;
    int seat;

    public Place() {

    }

    public Place(int id, String building, String floor, String room, int seat) {
        Id = id;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.seat = seat;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }
/*
    @Override
    public String toString(){
        return "Car{" +
                "id=" + Id +
                ", brand='" + building + '\'' +
                ", model='" + floor + '\'' +
                ", plate='" + seat + '\'' +
                '}';
    }

*/
}
