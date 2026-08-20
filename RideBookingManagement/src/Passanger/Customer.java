package Passanger;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Customer {
    //===== Text Filed att========
    private String name, phone, emergPhone, pickupVenue, dropOffVenue, accNo;
    //====== Drop downs ========
    private String vehicleChoice, pickLoc, dropLoc;
    //====== radio btns =======
    private String gender, payVia;
    private static double eco = 1, premium = 1.5; //premium is 1.5 times expensive

    //===== Square boxs ======
    private String ac, music, luggage, childSeat, wheelChair;


    private File file;
    private FileWriter fwriter;


    public Customer(){}
    public Customer(String name, String phone, String emergPhone, String  pickupVenue, String dropOffVenue, String accNo, String vehicleChoice, String pickLoc, String gender, String payVia){
        this.name = name;
        this.phone = phone;
        this.emergPhone = emergPhone;
        this.pickupVenue = pickupVenue;
        this.dropOffVenue = dropOffVenue;
        this.accNo = accNo;
        this.vehicleChoice = vehicleChoice;
        this.pickLoc = pickLoc;
        this.gender = gender;
        this.payVia = payVia;
    }
    public void recordData(String name) {
        try {
            file = new File("./Data/"+name+".txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            String timeAndDate = myDateObj.format(myFormatObj);

            fwriter = new FileWriter(file, true); //ensure to not overwrite the existing text in the file
            fwriter.write("Date and Time: " + timeAndDate + "\n");
            fwriter.write("========================================================" + "\n");
            fwriter.write("Name: " + name + "\n");
            fwriter.write("Phone: " + phone + "\n");
            fwriter.write("Gender: " + gender + "\n");
            fwriter.write("Emergency Contact: " + emergPhone + "\n");
            fwriter.write("Vehicle Selected: " + vehicleChoice + "\n");
            fwriter.write("Ac: " + ac + "\n");
            fwriter.write("Music: " + music + "\n");
            fwriter.write("Ride Class: " + eco + premium + "\n");

            fwriter.write("PickUp Time: " + oops_principle + "\n");
            fwriter.write("Pickup Date: " + oops_principle + "\n");

            fwriter.write("Pickup at: " + pickupVenue+ ", "+ pickLoc + "\n");
            fwriter.write("Dropoff at: " + dropOffVenue+ ", "+ dropLoc + "\n");

            fwriter.write("Extra: " + luggage+ childSeat+ wheelChair + "\n");
            fwriter.write("Payment Account Number: (" + payVia + ")" + accNo + "\n");
            fwriter.write("--------------------------------------------------------" + "\n");
            fwriter.flush();
            fwriter.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }


}
