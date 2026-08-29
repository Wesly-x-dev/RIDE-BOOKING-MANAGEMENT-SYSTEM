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
            fwriter.write(" ======================================================== " + "\n");
            fwriter.write(" ============ ShohozRide - Booking Successful! ========== " + "\n");
            fwriter.write(" ======================================================== " + "\n");

            fwriter.write(" Passanger Information: "+ "\n");
            fwriter.write(" --------------------- "+ "\n");
            fwriter.write(" Name: " + Username + "\n");
            fwriter.write(" Phone: " + phone + "\n");
            fwriter.write(" Emergency Contact: " + emergPhone + "\n");
            fwriter.write(" Gender: " + gender + "\n");

            fwriter.write("\n");
            fwriter.write(" Vehicle Details: "+ "\n");
            fwriter.write(" ---------------- "+ "\n");
            fwriter.write(" Vehicle selected: " + vehicleChoice + "\n");
            fwriter.write(" Ride Type: " + rideType + "\n");
            
            fwriter.write("\n");
            fwriter.write(" Ride Details: "+ "\n");
            fwriter.write(" -------------"+ "\n");
            fwriter.write(" Pick UP: " + pickupVenue + " ," +pickLoc + "\n");
            fwriter.write(" Drop At: " + dropOffVenue + " ," +dropLoc + "\n");
            fwriter.write(" Pick UP Time: " + rideTime + "\n");
            fwriter.write("\n");

            fwriter.write(" Passangers' Preference: "+ "\n");
            fwriter.write(" ----------------------"+ "\n");
            fwriter.write(" Add-ons: " + luggage + ", " + childSeat + ", " + wheelChair + "\n");
            fwriter.write(" A/C: " + ac + "\n");
            fwriter.write(" Music: " + music + "\n");
            fwriter.write("\n");

            fwriter.write(" Payment Details: "+ "\n");
            fwriter.write(" -----------------"+ "\n");
            fwriter.write(" Payment: ("+ payVie +")-------- " + accNo + "\n");
            fwriter.write("\n");
            fwriter.write(" Vehicle Rent: (Per Km) -------- " + vehivleRentPerKm + " tk \n");
            fwriter.write(" Vehicle Rent: (This Ride) ----- " + vehicleBillRide + " tk \n");
            fwriter.write(" Add On Bill: (Total) ---------- " + addOnTotalprice + " tk \n");
            fwriter.write(" ===================================================" +   "\n");
            fwriter.write(" Total Bill: ------------------- " + totalBill + " tk \n");
            fwriter.write(" ===================================================" +   "\n");
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