package RideBookingManagement;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;

public class Customer {
    //===== Text Filed att========
    private String name, phone, emergPhone;



    private File file;
    private FileWriter fwriter;


    public Customer(){}
    public Customer(String name, String phone, String emergPhone){
        this.name = name;
        this.phone = phone;
        this.emergPhone = emergPhone;
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
            fwriter.write("Name: " + name + "\n");
            fwriter.write("Phone: " + phone + "\n");
            fwriter.write("Emergency Contact: " + emergPhone + "\n");
            fwriter.write("--------------------------------------------------------" + "\n");
            fwriter.flush();
            fwriter.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error writing to file!");
        }
    }


}
