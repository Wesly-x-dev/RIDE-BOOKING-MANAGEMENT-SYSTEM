package RideBookingManagement;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

public class Customer {
    //===== Text Filed att========
    // private String Username, phone, emergPhone;
    private String Username, phone, emergPhone, pickupVenue, dropOffVenue, accNo, vehicleChoice, pickLoc, dropLoc, gender, payVie;
    private File file;
    private FileWriter fwriter;

    public Customer(){}
    public Customer(String Username, String  phone,String  emergPhone,String  pickupVenue,String  dropOffVenue,String  accNo,String  vehicleChoice,String  pickLoc,String  dropLoc,String  gender,String  payVie){
        this.Username = Username;
        this.phone = phone;
        this.emergPhone = emergPhone;
        this.gender = gender;

        this.vehicleChoice = vehicleChoice;
        
        this.pickupVenue = pickupVenue;
        this.dropOffVenue = dropOffVenue;
        this.pickLoc = pickLoc;
        this.dropLoc = dropLoc;
        
        this.accNo = accNo;
        this.payVie = payVie;
    }


    public void insertInfo() {
        try {
            file = new File("./Data/usersInfo.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            // ========================= Time =================================================
            // LocalDateTime myDateObj = LocalDateTime.now();
            // DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");
            // String timeAndDate = myDateObj.format(myFormatObj);
            // ========================= Time =================================================

            fwriter = new FileWriter(file, true); //ensure to not overwrite the existing text in the file
            // fwriter.write("Date and Time: " + timeAndDate + "\n");
            fwriter.write("========================================================" + "\n");
            fwriter.write("Name: " + Username + "\n");
            fwriter.write("Phone: " + phone + "\n");
            fwriter.write("Emergency Contact: " + emergPhone + "\n");
            fwriter.write("Gender: " + gender + "\n");

            fwriter.write("Vehicle selected: " + vehicleChoice + "\n");
            
            fwriter.write("Pick UP: " + pickupVenue + " ," +pickLoc + "\n");
            fwriter.write("Drop At: " + dropOffVenue + " ," +dropLoc + "\n");

            fwriter.write("Payment: ("+ payVie +")"+ accNo + "\n");
            fwriter.write("--------------------------------------------------------" + "\n");
            fwriter.flush();
            fwriter.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }


}
