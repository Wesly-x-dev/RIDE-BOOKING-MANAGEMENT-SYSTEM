package RideBookingManagement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

public class Customer {
    //===== Text Filed att========
    // private String Username, phone, emergPhone;
    private String Username, phone, emergPhone, pickupVenue, dropOffVenue, accNo, vehicleChoice, pickLoc, dropLoc, gender, payVie, totalBill;
    private String rideType, rideTime, ac, music, luggage, childSeat, wheelChair, vehivleRentPerKm,vehicleBillRide, addOnTotalprice;
    private File file;
    private FileWriter fwriter;

    public Customer(){}
    public Customer
        (
        String Username, String  phone,String  emergPhone,String  pickupVenue,String  dropOffVenue,String  accNo,
        String  vehicleChoice,String  pickLoc,String  dropLoc,String  gender,String  payVie,String  rideType,String  rideTime,String  ac,
        String  music,String  luggage,String  childSeat,String  wheelChair, String totalBill, String vehivleRentPerKm, String vehicleBillRide,
        String addOnTotalprice
        ){
            this.Username = Username;
            this.phone = phone;
            this.emergPhone = emergPhone;
            this.gender = gender;

            this.vehicleChoice = vehicleChoice;
            this.rideType = rideType;
            this.ac = ac;
            this.music = music;
            
            this.pickupVenue = pickupVenue;
            this.dropOffVenue = dropOffVenue;
            this.pickLoc = pickLoc;
            this.dropLoc = dropLoc;
            this.rideTime = rideTime;

            this.luggage = luggage;
            this.childSeat = childSeat;
            this.wheelChair = wheelChair;
            
            this.accNo = accNo;
            this.payVie = payVie;
            this.totalBill = totalBill;
            this.addOnTotalprice = addOnTotalprice;
            this.vehivleRentPerKm = vehivleRentPerKm;
            this.vehicleBillRide = vehicleBillRide;
    }


    public void insertInfo() {
        try {
            file = new File("./Data/usersInfo.txt");
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            fwriter = new FileWriter(file, true);
            fwriter.write(" ==================== BOOKING RECIEPT =================== " + "\n");
            fwriter.write(" \t               ShohozRide - Booking Successful!               " + "\n");
            fwriter.write(" ===================================================== " + "\n");

            fwriter.write(" PASSENGER INFORMATION: "+ "\n");
            fwriter.write(" ---------------------------------------------------------------- "+ "\n");
            fwriter.write(" Name:\t\t\t" + Username + "\n");
            fwriter.write(" Phone:\t\t\t" + phone +  "\n");
            fwriter.write(" Emergency Contact:\t\t" + emergPhone + "\n");
            fwriter.write(" Gender:\t\t\t" + gender + "\n");
            fwriter.write("\n");
            fwriter.write(" TRIP DETAILS: "+ "\n");
            fwriter.write(" ---------------------------------------------------------------- "+ "\n");
            fwriter.write(" Pick UP:     \t\t\t" + pickupVenue + " ," +pickLoc + "\n");
            fwriter.write(" Drop At:     \t\t\t" + dropOffVenue + " ," +dropLoc + "\n");
            fwriter.write(" Pick UP Time:\t\t\t" + rideTime + "\n");
            fwriter.write("\n");
            fwriter.write("\n");
            fwriter.write(" VEHICLE & PREFERENCES: "+ "\n");
            fwriter.write(" ---------------------------------------------------------------- "+ "\n");
            fwriter.write(" Vehicle Type:    \t\t" + vehicleChoice + "("+ rideType +")"+"\n");
            fwriter.write(" Air Conditioning:\t\t" + ac + "\n");
            fwriter.write(" In-Ride Music:   \t\t" + music + "\n");
            fwriter.write(" Add-ons:         \t\t" + luggage + ", " + childSeat + ", " + wheelChair + "\n");  
            fwriter.write("\n");

            fwriter.write(" BILLING & PAYMENT SUMMARY: "+ "\n");
            fwriter.write(" ---------------------------------------------------------------- "+ "\n");
            fwriter.write(" Payment Method:     ("+  accNo+")" + payVie + "\n");
            fwriter.write("\n");
            fwriter.write(" Base Rate: ----------------------- " + vehivleRentPerKm + "  BDT / km \n");
            fwriter.write(" Ride Fare: ----------------------- " + vehicleBillRide + " BDT  \n");
            fwriter.write(" Add-on Total:--------------------- " + addOnTotalprice + " BDT  \n");
            fwriter.write(" ---------------------------------------------------------------- " +   "\n");
            fwriter.write(" TOTAL AMOUNT PAID: ---------------"  + totalBill + " BDT \n");
            fwriter.write("\n");
            fwriter.write(" ==================== BOOKING RECIEPT =================== " +   "\n");
            fwriter.write(" \t             Thank you for riding with ShohozRide!                " +   "\n");
            fwriter.write(" ===================================================== " +   "\n");
            fwriter.write("\n");
            fwriter.write("\n");

            fwriter.flush();
            fwriter.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }
}