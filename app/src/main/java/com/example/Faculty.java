package com.example;





import com.google.gson.annotations.SerializedName;

public class Faculty {

    @SerializedName("name")
    private String name;

    @SerializedName("eCode") // Important: matches JSON "eCode"
    private String ecode;

    @SerializedName("email")
    private String email;

    @SerializedName("contact")
    private String contact;

    @SerializedName("coordinator")
    private String coordinator;

    @SerializedName("year")
    private String year;

    @SerializedName("responsibility")
    private String responsibility;

    @SerializedName("seatingVenue")
    private String seatingVenue;

    @SerializedName("block")
    private String block;

    // Default constructor for Retrofit
    public Faculty() {
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEcode() {
        return ecode;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getYear() {
        return year;
    }

    public String getResponsibility() {
        return responsibility;
    }

    public String getSeatingVenue() {
        return seatingVenue;
    }

    public String getBlock() {
        return block;
    }
}
