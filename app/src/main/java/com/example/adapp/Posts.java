package com.example.adapp;


public class Posts {
    private String name ;
    private String dob ;
    private String phones;
    private String address;

    public Posts(){

    }

    public Posts(String name, String dob, String phones, String address) {
        this.name = name;
        this.dob = dob;
        this.phones = phones;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setPhones(String phones) {
        this.phones = phones;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getDob() { return dob;
    }

    public String getPhones() {
        return phones;
    }

    public String getAddress() {
        return address;
    }


}



