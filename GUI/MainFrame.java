package GUI;

import RideBookingManagement.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MainFrame extends JFrame implements ActionListener, MouseListener {
    // ======================= include panels here ========================
    private JPanel headingPanel, passangerDetailsPanel, rideDetailsPanel, bookRidePanel, confirmationPanel;
    // ======================== include components used in the full project
    // =======================
    private ImageIcon logo, carDetails;
    private JLabel logoLabel, headingTextlabel, tagLineLabel;

    private Font headingFont, subHeadingFont, labelFont;
    private Color labelColor;

    // ==================== Passangers Panel All components ===============
    private JLabel userName, paassangerSubHeading, userPhnLabel, userEmergencyPhnLabel, userGender;
    private JTextField userNameTextArea, userPhnTextArea, userEmergencyPhnTextArea;
    private JRadioButton userMale, userFemale, userOther;
    private ButtonGroup radioGenderGroup;
    // ==================== Ride/vehicle panel All components ===============
    private JLabel rideSubHeading, carLabel, vehicleTypeLabel;
    private JComboBox vehicleType;
    private JCheckBox musicVehicleCheck, acVehicleCheck;
    private ImageIcon bikeRideImg;
    // ==================== Ride Booking Components ===========================
    private JLabel bookRideHeadingLabel, pickupVenuelabel, dropVenuelabel, pickUPLoclabel, dropOffLoclabel,
            bookTimeLabel, totalPriceLabel;
    private JLabel rideTypeLabel, reqLabel, payViaLabel, accountNumber, bookHourLabel, luggageLabel, babySeatLabel,
            wheelChairLabel;
    private ImageIcon luggageImgIcon, wheelChairImageIcon, babySeatImgIcon;
    private JTextArea rideReciept, totalPrice;
    private JTextField pickupVenuetextArea, dropVenuetextArea, accountNumbertextArea;
    private ButtonGroup radioRideTypeGroup, radioRideAmPmGroup;
    private JRadioButton rideEco, ridePremium, payVBox1, payVBox2, payVBox3, rideAm, ridePm;
    private JCheckBox cBox1, cBox2, cBox3, termsAndCondCheckBox;
    private JComboBox choosePickLoc, chooseDropLoc, chooseHour, chooseMins;
    private JButton confirmBtn, exitProgram, anotherRideBtn;

    private double vehicleRate, vehicleClassificationRate=0, addonRate=0, distanceTravelled=1;

    //=================== CONSTRUCTOR ================================= 
    public MainFrame() {
        super.setTitle("Shohoz Ride - Booking ride made easy!");
        super.setBounds(350, 10, 800, 800);
        super.setResizable(false);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logo = new ImageIcon("images//logo_2.png");

        super.setIconImage(logo.getImage());
        // =================== Fonts and Colors ==========================
        headingFont = new Font("MV Boli", Font.BOLD, 30);
        subHeadingFont = new Font("MV Boli", Font.BOLD, 20);
        labelFont = new Font("MV Boli", Font.BOLD, 15);

        labelColor = new Color(33, 33, 33);
        Border border = BorderFactory.createDashedBorder(Color.BLACK, 2, 2, 2, true);

        // =================== heading panel: logo, heading text etc===================================
        headingPanel = new JPanel();
        headingPanel.setBounds(0, 0, 798, 110);
        headingPanel.setBackground(new Color(255, 107, 107));
        headingPanel.setOpaque(true);
        headingPanel.setLayout(null);

        logoLabel = new JLabel(logo);
        logoLabel.setBounds(5, 5, 100, 100);

        headingTextlabel = new JLabel("ShohozRide - Shohoz Ride, Shohoz Life");
        headingTextlabel.setFont(headingFont);
        headingTextlabel.setBounds(140, 30, 750, 40);
        headingTextlabel.setForeground(new Color(255, 255, 255));

        tagLineLabel = new JLabel("Ride Booking & Fleet Management System");
        tagLineLabel.setFont(labelFont);
        tagLineLabel.setBounds(250, 70, 700, 40);
        tagLineLabel.setForeground(new Color(255, 255, 255));

        headingPanel.add(logoLabel);
        headingPanel.add(headingTextlabel);
        headingPanel.add(tagLineLabel);
        super.add(headingPanel);

        // **********************************************************************************
        // ##################################################################################
        // =================== Passenger Information Panel ==================================
        passangerDetailsPanel = new JPanel();
        passangerDetailsPanel.setBounds(0, 110, 350, 340);
        passangerDetailsPanel.setBackground(new Color(255, 248, 240));
        passangerDetailsPanel.setLayout(null);

        // ========================== heading ==================================
        paassangerSubHeading = new JLabel("Passenger Information");
        paassangerSubHeading.setBorder(border);
        paassangerSubHeading.setFont(subHeadingFont);
        paassangerSubHeading.setForeground(labelColor);
        paassangerSubHeading.setHorizontalAlignment(JLabel.CENTER);
        paassangerSubHeading.setBounds(60, 30, 250, 30);

        // ============================================================================
        // ========================= LABEL: YOUR NAME ==================================
        userName = new JLabel("Full Name: ");
        userName.setBounds(60, 80, 150, 30);
        userName.setFont(labelFont);
        userName.setForeground(labelColor);
        // ========================= TextArea: YOUR NAME ==================================
        userNameTextArea = new JTextField();
        userNameTextArea.setBounds(60, 110, 180, 30);
        userNameTextArea.setFont(labelFont);
        userNameTextArea.addActionListener(this);

        // ========================= LABEL: USER PHONE NUMBER==================================
        userPhnLabel = new JLabel("Phone: ");
        userPhnLabel.setBounds(60, 150, 150, 30);
        userPhnLabel.setFont(labelFont);
        userPhnLabel.setForeground(labelColor);
        // ========================= TextArea: USER PHONE NUMBER =================================
        userPhnTextArea = new JTextField();
        userPhnTextArea.setBounds(60, 180, 180, 30);
        userPhnTextArea.setFont(labelFont);
        userPhnTextArea.addActionListener(this);

        // ========================= LABEL: USER Emergency PHONE NUMBER ==========================
        userEmergencyPhnLabel = new JLabel("Emergency Contact: ");
        userEmergencyPhnLabel.setBounds(60, 220, 170, 30);
        userEmergencyPhnLabel.setFont(labelFont);
        userEmergencyPhnLabel.setForeground(labelColor);
        // ========================= TextArea: USER Emergency PHONE NUMBER =======================
        userEmergencyPhnTextArea = new JTextField();
        userEmergencyPhnTextArea.setBounds(60, 250, 180, 30);
        userEmergencyPhnTextArea.setFont(labelFont);

        // ========================= LABEL: Gender Label ==================================
        userGender = new JLabel("Gender: ");
        userGender.setBounds(30, 290, 80, 30);
        userGender.setFont(labelFont);
        userGender.setForeground(labelColor);
        // ========================== RADIO BUTTION: Choose gender ==================================
        userMale = new JRadioButton("Male");
        userMale.setBounds(110, 290, 60, 30);
        userMale.setFont(labelFont);
        passangerDetailsPanel.add(userMale);

        userFemale = new JRadioButton("Female");
        userFemale.setBounds(170, 290, 80, 30);
        userFemale.setFont(labelFont);
        passangerDetailsPanel.add(userFemale);

        userOther = new JRadioButton("Others");
        userOther.setBounds(250, 290, 80, 30);
        userOther.setFont(labelFont);
        passangerDetailsPanel.add(userOther);

        radioGenderGroup = new ButtonGroup();
        radioGenderGroup.add(userOther);
        radioGenderGroup.add(userMale);
        radioGenderGroup.add(userFemale);
        // ========================== ADDING COMPONENTS IN TO THE PANELS AND FRAME ==================================
        passangerDetailsPanel.add(paassangerSubHeading);

        passangerDetailsPanel.add(userName);
        passangerDetailsPanel.add(userNameTextArea);

        passangerDetailsPanel.add(userPhnLabel);
        passangerDetailsPanel.add(userPhnTextArea);

        passangerDetailsPanel.add(userEmergencyPhnLabel);
        passangerDetailsPanel.add(userEmergencyPhnTextArea);

        passangerDetailsPanel.add(userGender);
        super.add(passangerDetailsPanel);
        // ***************************************************************************
        // ###########################################################################

        // ***************************************************************************
        // ###########################################################################
        // =================== Ride Details panels==================================
        rideDetailsPanel = new JPanel();
        rideDetailsPanel.setBounds(0, 452, 350, 307);
        rideDetailsPanel.setBackground(new Color(255, 248, 240));
        rideDetailsPanel.setLayout(null);

        // ========================== ==================================
        rideSubHeading = new JLabel("Vehicle Information");
        rideSubHeading.setFont(subHeadingFont);
        rideSubHeading.setHorizontalAlignment(JLabel.CENTER);
        rideSubHeading.setForeground(labelColor);
        rideSubHeading.setBorder(border);
        rideSubHeading.setBounds(60, 15, 250, 30);

        // ========================== Image Added ==================================
        carDetails = new ImageIcon("images//rideDetails.png");
        carLabel = new JLabel(carDetails);
        carLabel.setBounds(70, 5, 200, 200);

        // ========================== vehicle type ComboBox LABEL ==================================
        vehicleTypeLabel = new JLabel("Choose Vehicle: ");
        vehicleTypeLabel.setBounds(20, 165, 150, 30);
        vehicleTypeLabel.setForeground(labelColor);
        vehicleTypeLabel.setFont(labelFont);
        // ========================== vehicle type ComboBox ==================================
        String vehicle[] = new String[] { "", "Motorbike", "CNG", "SUV", "MicroBus", "Hi-ace" };
        vehicleType = new JComboBox(vehicle);
        vehicleType.setBounds(20, 195, 150, 30);
        vehicleType.setFont(labelFont);
        vehicleType.addActionListener(this);
        // ========================= LABEL: Ride Type Label ==================================
        rideTypeLabel = new JLabel("Ride Type: ");
        rideTypeLabel.setBounds(20, 240, 100, 30);
        rideTypeLabel.setFont(labelFont);
        rideTypeLabel.setForeground(labelColor);
        // ========================== Choose Quality Class ==================================
        rideEco = new JRadioButton("Economy");
        rideEco.setBounds(120, 240, 100, 30);
        rideEco.setFont(labelFont);
        rideDetailsPanel.add(rideEco);

        ridePremium = new JRadioButton("Premium");
        ridePremium.setBounds(240, 240, 100, 30);
        ridePremium.setFont(labelFont);
        rideDetailsPanel.add(ridePremium);

        rideEco.addActionListener(this);
        ridePremium.addActionListener(this);
        radioRideTypeGroup = new ButtonGroup();
        radioRideTypeGroup.add(rideEco);
        radioRideTypeGroup.add(ridePremium);

        // ===========================A/c and Music system ===================
        acVehicleCheck = new JCheckBox("A/C");
        acVehicleCheck.setBounds(190, 165, 100, 30);// (x,y,width, height)
        acVehicleCheck.setFont(labelFont);
        acVehicleCheck.addActionListener(this);

        musicVehicleCheck = new JCheckBox("Music");
        musicVehicleCheck.setBounds(190, 195, 100, 30);// (x,y,width, height)
        musicVehicleCheck.setFont(labelFont);
        musicVehicleCheck.addActionListener(this);

        acVehicleCheck.setEnabled(false);
        musicVehicleCheck.setEnabled(false);
        // ============================================================
        rideDetailsPanel.add(carLabel);
        rideDetailsPanel.add(rideSubHeading);
        rideDetailsPanel.add(vehicleType);
        rideDetailsPanel.add(vehicleTypeLabel);
        rideDetailsPanel.add(acVehicleCheck);
        rideDetailsPanel.add(musicVehicleCheck);
        rideDetailsPanel.add(rideTypeLabel);
        super.add(rideDetailsPanel);

        // ***************************************************************************
        // ###########################################################################
        // =================== Booking Details panels ==================================
        bookRidePanel = new JPanel();
        bookRidePanel.setBounds(352, 110, 448, 650);
        bookRidePanel.setBackground(new Color(255, 248, 240));
        bookRidePanel.setLayout(null);

        // ============================================================
        bookRideHeadingLabel = new JLabel("Book a Ride!");
        bookRideHeadingLabel.setFont(subHeadingFont);
        bookRideHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
        bookRideHeadingLabel.setForeground(labelColor);
        bookRideHeadingLabel.setBorder(border);
        bookRideHeadingLabel.setBounds(90, 30, 180, 30);
        // ============================================================
        // ========================= LABEL: PICKUP LOCATION
        // ============================================================
        pickupVenuelabel = new JLabel("Pickup Venue: ");
        pickupVenuelabel.setBounds(20, 65, 150, 30);
        pickupVenuelabel.setFont(labelFont);
        pickupVenuelabel.setForeground(labelColor);
        // ====================================================
        // ========================= TextArea: Pickup Location
        // ===================================================
        pickupVenuetextArea = new JTextField();
        pickupVenuetextArea.setBounds(20, 95, 180, 30);
        pickupVenuetextArea.setFont(labelFont);
        // ====================================================
        // ========================= LABEL: Drop Off LOCATION
        // ====================================================
        dropVenuelabel = new JLabel("Drop Off venue: ");
        dropVenuelabel.setBounds(20, 125, 180, 30);
        dropVenuelabel.setFont(labelFont);
        dropVenuelabel.setForeground(labelColor);
        
        
        // ====================================================
        // ========================= TextArea: Pickup Location
        // ====================================================
        dropVenuetextArea = new JTextField();
        dropVenuetextArea.setBounds(20, 155, 180, 30);
        dropVenuetextArea.setFont(labelFont);
        // ================================================================================================
        // ==========================Drop Down Menu: pickup Location======================================
        pickUPLoclabel = new JLabel("Pick Up Location: ");
        pickUPLoclabel.setBounds(220, 65, 150, 30);
        pickUPLoclabel.setFont(labelFont);
        pickUPLoclabel.setForeground(labelColor);
        // ================================================================================================
        // ==========================Drop Down Menu: drop off Location======================================
        dropOffLoclabel = new JLabel("Drop Off Location: ");
        dropOffLoclabel.setBounds(220, 125, 180, 30);
        dropOffLoclabel.setFont(labelFont);
        dropOffLoclabel.setForeground(labelColor);
        // ================================================================================================
        // ========================== Location select ComboBox ==================================
        String loc[] = new String[] { "", "Savar", "Kuril", "Mirpur", "Gulshan", "Badda", "Dhanmondi", "Mohammadpur" };

        choosePickLoc = new JComboBox(loc);
        choosePickLoc.setBounds(220, 95, 180, 30);
        choosePickLoc.setFont(labelFont);
        choosePickLoc.addActionListener(this);

        chooseDropLoc = new JComboBox(loc);
        chooseDropLoc.setBounds(220, 155, 180, 30);
        chooseDropLoc.setFont(labelFont);
        chooseDropLoc.addActionListener(this);

        // ================================================================
        // pick Date Time for the ride
        // ================================================================
        Integer hour[] = new Integer[12];
        Integer mins[] = new Integer[] { 00, 15, 30, 45 };
        for (int i = 0; i < 12; i++) {
            hour[i] = i;
        }
        // ====================== Label TIME =================================
        bookTimeLabel = new JLabel("Pick UP TIME: ");
        bookTimeLabel.setFont(labelFont);
        bookTimeLabel.setHorizontalAlignment(JLabel.LEFT);
        bookTimeLabel.setBounds(5, 220, 240, 30);
        bookRidePanel.add(bookTimeLabel);

        bookHourLabel = new JLabel("Hour  :  mins");
        bookHourLabel.setFont(labelFont);
        bookHourLabel.setHorizontalAlignment(JLabel.LEFT);
        bookHourLabel.setBounds(140, 190, 240, 30);
        bookRidePanel.add(bookHourLabel);
        // =======================================================
        chooseHour = new JComboBox(hour);
        chooseHour.setBounds(130, 220, 60, 30);
        chooseHour.setFont(labelFont);
        chooseHour.addActionListener(this);
        // =======================================================
        chooseMins = new JComboBox(mins);
        chooseMins.setBounds(200, 220, 60, 30);
        chooseMins.setFont(labelFont);
        chooseMins.addActionListener(this);
        // =======================================================
        rideAm = new JRadioButton("AM");
        rideAm.setBounds(270, 220, 70, 30);
        rideAm.setFont(labelFont);
        bookRidePanel.add(rideAm);
        // =======================================================
        ridePm = new JRadioButton("PM");
        ridePm.setBounds(350, 220, 70, 30);
        ridePm.setFont(labelFont);
        bookRidePanel.add(ridePm);
        // =======================================================
        radioRideAmPmGroup = new ButtonGroup();
        radioRideAmPmGroup.add(rideAm);
        radioRideAmPmGroup.add(ridePm);
        // ================================================================
        reqLabel = new JLabel("Add-on: ");
        reqLabel.setFont(subHeadingFont);
        reqLabel.setHorizontalAlignment(JLabel.CENTER);
        reqLabel.setBounds(70, 260, 240, 30);
        // =========================== CheckBox ===================
        cBox1 = new JCheckBox("Luggage Carrier");
        cBox1.setBounds(10, 410, 140, 30);
        cBox1.setFont(labelFont);

        cBox2 = new JCheckBox("Child Seat");
        cBox2.setBounds(320, 410, 120, 30);
        cBox2.setFont(labelFont);

        cBox3 = new JCheckBox("Wheel Chair");
        cBox3.setBounds(170, 410, 130, 30);
        cBox3.setFont(labelFont);

        cBox1.setEnabled(false);
        cBox2.setEnabled(false);
        cBox3.setEnabled(false);
        // =================== Add on images ==============================
        luggageImgIcon = new ImageIcon("images//addOn//luggage.png");
        luggageLabel = new JLabel(luggageImgIcon);
        luggageLabel.setBounds(0, 280, 160, 160);
        bookRidePanel.add(luggageLabel);

        wheelChairImageIcon = new ImageIcon("images//addOn//wheelChair.png");
        wheelChairLabel = new JLabel(wheelChairImageIcon);
        wheelChairLabel.setBounds(150, 280, 160, 160);
        bookRidePanel.add(wheelChairLabel);

        babySeatImgIcon = new ImageIcon("images//addOn//babySeat.png");
        babySeatLabel = new JLabel(babySeatImgIcon);
        babySeatLabel.setBounds(290, 280, 160, 160);
        bookRidePanel.add(babySeatLabel);

        //==========================================================================
        // ===================== Card Phone number for payment ============
        totalPriceLabel = new JLabel("TOTAL COST: ");
        totalPriceLabel.setBounds(100, 455, 115, 30);
        totalPriceLabel.setFont(labelFont);
        totalPriceLabel.setForeground(labelColor);

        // ========================= TextArea: Account number ==============
        totalPrice = new JTextArea();
        totalPrice.setBounds(220, 455, 150, 30);
        totalPrice.setForeground(Color.RED);
        totalPrice.setEditable(false);
        totalPrice.setFont(labelFont);
        //===========================================================================
        payViaLabel = new JLabel("Pay Via: ");
        payViaLabel.setBounds(20, 495, 80, 30);
        payViaLabel.setFont(labelFont);
        payViaLabel.setForeground(labelColor);
        // ========================== Choose payment method ==================================
        payVBox1 = new JRadioButton("Bkash");
        payVBox1.setBounds(100, 495, 80, 30);
        payVBox1.setFont(labelFont);

        payVBox2 = new JRadioButton("Nagad");
        payVBox2.setBounds(180, 495, 80, 30);
        payVBox2.setFont(labelFont);

        payVBox3 = new JRadioButton("Credit/Debit");
        payVBox3.setBounds(260, 495, 120, 30);
        payVBox3.setFont(labelFont);
        
        payVBox1.addActionListener(this);
        payVBox2.addActionListener(this);
        payVBox3.addActionListener(this);

        radioGenderGroup = new ButtonGroup();
        radioGenderGroup.add(payVBox1);
        radioGenderGroup.add(payVBox2);
        radioGenderGroup.add(payVBox3);

        // ===================== Card Phone number for payment ============
        accountNumber = new JLabel("Account No: ");
        accountNumber.setBounds(20, 540, 105, 30);
        accountNumber.setFont(labelFont);
        accountNumber.setForeground(labelColor);

        // ========================= TextArea: Account number ==============
        accountNumbertextArea = new JTextField();
        accountNumbertextArea.setBounds(135, 540, 240, 30);
        accountNumbertextArea.setFont(labelFont);
        accountNumbertextArea.addActionListener(this);

        // ======================== Checkbox: Terms and Condition ====================
        termsAndCondCheckBox = new JCheckBox("I accept the terms and conditions.");
        termsAndCondCheckBox.setBounds(80, 580, 250, 20);// (x,y,width, height)
        termsAndCondCheckBox.setFont(new Font("MV Boli", Font.BOLD, 12));
        termsAndCondCheckBox.setEnabled(false);
        termsAndCondCheckBox.addActionListener(this);

        // ========================== Confirm Button ======================
        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(80, 615, 120, 30);
        confirmBtn.setFont(labelFont);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setBackground(new Color(30, 136, 229));
        confirmBtn.setOpaque(true);
        confirmBtn.addActionListener(this);
        confirmBtn.setEnabled(false);
        // ========================== Exit Button ======================
        exitProgram = new JButton("Exit");
        exitProgram.setBounds(210, 615, 120, 30);
        exitProgram.setFont(labelFont);
        exitProgram.setForeground(Color.WHITE);
        exitProgram.setBackground(new Color(229, 30, 37));
        exitProgram.setOpaque(true);
        exitProgram.addActionListener(this);

        // ========================== Exit Button ======================
        anotherRideBtn = new JButton("Book more!");
        anotherRideBtn.setBounds(300, 380, 120, 30);
        anotherRideBtn.setFont(labelFont);
        anotherRideBtn.setForeground(Color.BLACK);
        anotherRideBtn.setBackground(new Color(209, 122, 24));
        anotherRideBtn.setOpaque(true);
        anotherRideBtn.addActionListener(this);
        anotherRideBtn.setEnabled(false);
        // =====================Adding =====================================
        bookRidePanel.add(pickupVenuelabel);
        bookRidePanel.add(pickupVenuetextArea);

        bookRidePanel.add(dropVenuelabel);
        bookRidePanel.add(dropVenuetextArea);

        bookRidePanel.add(pickUPLoclabel);
        bookRidePanel.add(choosePickLoc);
        bookRidePanel.add(dropOffLoclabel);
        bookRidePanel.add(chooseDropLoc);

        bookRidePanel.add(chooseHour);
        bookRidePanel.add(chooseMins);

        bookRidePanel.add(bookRideHeadingLabel);
        bookRidePanel.add(reqLabel);

        bookRidePanel.add(cBox1);
        bookRidePanel.add(cBox2);
        bookRidePanel.add(cBox3);

        bookRidePanel.add(totalPriceLabel);
        bookRidePanel.add(totalPrice);

        bookRidePanel.add(payViaLabel);
        bookRidePanel.add(payVBox3);
        bookRidePanel.add(payVBox2);
        bookRidePanel.add(payVBox1);

        bookRidePanel.add(accountNumber);
        bookRidePanel.add(accountNumbertextArea);
        bookRidePanel.add(termsAndCondCheckBox);

        bookRidePanel.add(confirmBtn);
        bookRidePanel.add(exitProgram);
        super.add(bookRidePanel);

        // ***********************************************************************************
        // ###########################################################################
        // =================== Confirmation / Receipt Panel
        // ==================================
        confirmationPanel = new JPanel();
        confirmationPanel.setBounds(0, 110, 798, 650);
        confirmationPanel.setBackground(new Color(255, 248, 240));
        confirmationPanel.setLayout(null);

        JLabel confirmationHeadingLabel = new JLabel("Ride Booked Successfully!");
        confirmationHeadingLabel.setFont(subHeadingFont);
        confirmationHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
        confirmationHeadingLabel.setForeground(labelColor);
        confirmationHeadingLabel.setBorder(border);
        confirmationHeadingLabel.setBounds(280, 20, 280, 30);

        // ========================== Full-size receipt text area
        // ==================================
        rideReciept = new JTextArea();
        rideReciept.setEditable(false);
        rideReciept.setLineWrap(true);
        rideReciept.setWrapStyleWord(true);
        rideReciept.setFont(labelFont);

        JScrollPane scrollPane = new JScrollPane(rideReciept);
        scrollPane.setBounds(20, 65, 758, 500);

        // ========================== Reposition/relabel Book Another Ride Button
        // ======================
        anotherRideBtn.setText("Book Another Ride!");
        anotherRideBtn.setBounds(300, 585, 210, 40);

        confirmationPanel.add(confirmationHeadingLabel);
        confirmationPanel.add(scrollPane);
        confirmationPanel.add(anotherRideBtn);

        confirmationPanel.setVisible(false);
        super.add(confirmationPanel);

    }

    //=================== Methods loading with conditional statements for error handling
    private Boolean passangerErrorInfoLogic(){
        if (userNameTextArea.getText().equals("")) {
                termsAndCondCheckBox.setSelected(false);
                JOptionPane.showMessageDialog(this, "User name required!!");
                confirmBtn.setEnabled(false);
                return false;
            }
        else if (userPhnTextArea.getText().equals("")) {
                termsAndCondCheckBox.setSelected(false);
                JOptionPane.showMessageDialog(this, "Phone number required!!");
                confirmBtn.setEnabled(false);
                return false;
            }
        
        else if (userEmergencyPhnTextArea.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Please enter an emergency contact");
                confirmBtn.setEnabled(false);
                termsAndCondCheckBox.setSelected(false);
                return false;
            }

        else if (!userMale.isSelected() && !userFemale.isSelected() && !userOther.isSelected()) {
                JOptionPane.showMessageDialog(this, "Must select a gender");
                confirmBtn.setEnabled(false);
                termsAndCondCheckBox.setSelected(false);
                return false;
            }
        else {return true;}        
    }

    private Boolean vehicleErrorInfoLogic(){
        // =============================== Vehicle image Selection
        // ================================
        int selected = vehicleType.getSelectedIndex();
        if (selected == 0) {
            carDetails = new ImageIcon("images//rideDetails.png");
            // ====================================
            acVehicleCheck.setEnabled(false);
            musicVehicleCheck.setEnabled(false);
            // ====================================
            acVehicleCheck.setSelected(false);
            musicVehicleCheck.setSelected(false);
            // ====================================
            termsAndCondCheckBox.setEnabled(false);
            // ====================================
            vehicleRate = 0;
            // ====================================
            cBox1.setEnabled(false);
            cBox2.setEnabled(false);
            cBox3.setEnabled(false);
            return false;
        }
        else if (selected == 1) {
            carDetails = new ImageIcon("images//bike.png");
            carLabel.setBounds(70, 0, 200, 200);
            // ====================================
            acVehicleCheck.setEnabled(false);
            musicVehicleCheck.setEnabled(false);
            // ====================================
            acVehicleCheck.setSelected(false);
            musicVehicleCheck.setSelected(false);
            // ===================================
            vehicleRate = 5;
            // ====================================
            cBox1.setEnabled(false);
            cBox2.setEnabled(false);
            cBox3.setEnabled(false);
        }
        else if (selected == 2) {
            carDetails = new ImageIcon("images//cng.png");
            carLabel.setBounds(70, 0, 200, 200);

            acVehicleCheck.setEnabled(false);
            musicVehicleCheck.setEnabled(false);

            acVehicleCheck.setSelected(false);
            musicVehicleCheck.setSelected(false);
            // ====================================
            vehicleRate = 8;
            // ====================================
            cBox1.setEnabled(true);
            cBox2.setEnabled(true);
            cBox3.setEnabled(true);
        }
        else if (selected == 3) {
            carDetails = new ImageIcon("images//SUV.png");
            acVehicleCheck.setEnabled(true);
            musicVehicleCheck.setEnabled(true);
            // ====================================
            vehicleRate = 100;
            // ====================================
            cBox1.setEnabled(true);
            cBox2.setEnabled(true);
            cBox3.setEnabled(true);

        }
        else if (selected == 4) {
            carDetails = new ImageIcon("images//microbus.png");
            acVehicleCheck.setEnabled(true);
            musicVehicleCheck.setEnabled(true);
            // ====================================
            vehicleRate = 300;
            // ====================================
            cBox1.setEnabled(true);
            cBox2.setEnabled(true);
            cBox3.setEnabled(true);

        }
        else if (selected == 5) {
            carDetails = new ImageIcon("images//hiace.png");
            acVehicleCheck.setEnabled(true);
            musicVehicleCheck.setEnabled(true);
            // ====================================
            vehicleRate = 350;
            // ====================================
            cBox1.setEnabled(true);
            cBox2.setEnabled(true);
            cBox3.setEnabled(true);
        }
        else{return false;}

        carLabel.setIcon(carDetails);
        return true;
    }

    private String getSelectedRideTime() {
        String hour = chooseHour.getSelectedItem().toString();
        String mins = chooseMins.getSelectedItem().toString();
        String amPm = rideAm.isSelected() ? rideAm.getText() : (ridePm.isSelected() ? ridePm.getText() : "");
        return hour + ":" + mins + " " + amPm;
    }

   private void getTravelCost(){
    String pick = choosePickLoc.getSelectedItem().toString();
    String drop = chooseDropLoc.getSelectedItem().toString();
    //=================================================================================== SAVAR ===========================================================================================
        if((pick.equals("Savar") && drop.equals("Kuril")) || (drop.equals("Savar") && pick.equals("Kuril")))
        {
            distanceTravelled = 35;
        }
        else if((pick.equals("Mirpur") && drop.equals("Savar")) || (drop.equals("Mirpur") && pick.equals("Savar")))
        {
            distanceTravelled = 20;
        }
        else if((pick.equals("Gulshan") && drop.equals("Savar")) || (drop.equals("Gulshan") && pick.equals("Savar")))
        {
            distanceTravelled = 45;
        }
        else if((pick.equals("Badda") && drop.equals("Savar")) || (drop.equals("Badda") && pick.equals("Savar")))
        {
            distanceTravelled = 25;
        }
        else if((pick.equals("Dhanmondi") && drop.equals("Savar")) || (drop.equals("Dhanmondi") && pick.equals("Savar")))
        {
            distanceTravelled = 32;
        }
        else if((pick.equals("Mohammadpur") && drop.equals("Savar")) || (drop.equals("Mohammadpur") && pick.equals("Savar")))
        {
            distanceTravelled = 28;
        }
        //=================================================================================== KURIL ===========================================================================================
        else if((pick.equals("Mirpur") && drop.equals("Kuril")) || (drop.equals("Mirpur") && pick.equals("Kuril")))
        {
            distanceTravelled = 15;
        }
        else if((pick.equals("Gulshan") && drop.equals("Kuril")) || (drop.equals("Gulshan") && pick.equals("Kuril")))
        {
            distanceTravelled = 15;
        }
        else if((pick.equals("Badda") && drop.equals("Kuril")) || (drop.equals("Badda") && pick.equals("Kuril")))
        {
            distanceTravelled = 18;
        }
        else if((pick.equals("Dhanmondi") && drop.equals("Kuril")) || (drop.equals("Dhanmondi") && pick.equals("Kuril")))
        {
            distanceTravelled = 25;
        }
        else if((pick.equals("Mohammadpur") && drop.equals("Kuril")) || (drop.equals("Mohammadpur") && pick.equals("Kuril")))
        {
            distanceTravelled = 21;
        }
        //=================================================================================== MIRPUR ===========================================================================================
        else if((pick.equals("Gulshan") && drop.equals("Mirpur")) || (drop.equals("Gulshan") && pick.equals("Mirpur")))
        {
            distanceTravelled = 20;
        }
        else if((pick.equals("Badda") && drop.equals("Mirpur")) || (drop.equals("Badda") && pick.equals("Mirpur")))
        {
            distanceTravelled = 30;
        }
        else if((pick.equals("Dhanmondi") && drop.equals("Mirpur")) || (drop.equals("Dhanmondi") && pick.equals("Mirpur")))
        {
            distanceTravelled = 23;
        }
        else if((pick.equals("Mohammadpur") && drop.equals("Mirpur")) || (drop.equals("Mohammadpur") && pick.equals("Mirpur")))
        {
            distanceTravelled = 18;
        }
        //=================================================================================== GULSHAN ===========================================================================================
        else if((pick.equals("Badda") && drop.equals("Gulshan")) || (drop.equals("Badda") && pick.equals("Gulshan")))
        {
            distanceTravelled = 30;
        }
        else if((pick.equals("Dhanmondi") && drop.equals("Gulshan")) || (drop.equals("Dhanmondi") && pick.equals("Gulshan")))
        {
            distanceTravelled = 23;
        }
        else if((pick.equals("Mohammadpur") && drop.equals("Gulshan")) || (drop.equals("Mohammadpur") && pick.equals("Gulshan")))
        {
            distanceTravelled = 18;
        }
        //=================================================================================== BADDA ===========================================================================================
        else if((pick.equals("Dhanmondi") && drop.equals("Badda")) || (drop.equals("Dhanmondi") && pick.equals("Badda")))
        {
            distanceTravelled = 23;
        }
        else if((pick.equals("Mohammadpur") && drop.equals("Badda")) || (drop.equals("Mohammadpur") && pick.equals("Badda")))
        {
            distanceTravelled = 18;
        }
        else
        {
            distanceTravelled = 0;
        }
    }
    
    private double getTotalCost(){
        return vehicleClassificationRate + addonRate + (vehicleRate * distanceTravelled);
    }
    // ================= Action Listener ==================

    private boolean locationValid=false;
    private boolean payment = false;

    @Override
    public void actionPerformed(ActionEvent e) {
        //======================= Data Insertion ========================
        String Username, phone, emergPhone, pickupVenue, dropOffVenue, accNo; // done
        String vehicleChoice, pickLoc, dropLoc; // done
        String gender, payVia, vehicleClass=""; // radio button type done alsooo
        String ac="", music="", luggage="", childSeat="", wheelChair=""; // check box uhhh faah brother

        termsAndCondCheckBox.setEnabled(false);
        boolean passsagerInfoCheck = passangerErrorInfoLogic();
        boolean vehicleInfoCheck = vehicleErrorInfoLogic();
        String pickUplocString = choosePickLoc.getSelectedItem().toString();
        String dropOffLocString = chooseDropLoc.getSelectedItem().toString();

        //========================= Travel cost logic ============================
        addonRate = 0;
        vehicleClassificationRate = 0;

        //========== vehicle class ==========
        if(rideEco.isSelected()){
            vehicleClassificationRate = 0;
        }
        else if(ridePremium.isSelected()){
            vehicleClassificationRate = 500;
        }

        if(cBox1.isSelected()){addonRate += 100;}
        if(cBox2.isSelected()){addonRate += 250;}
        if(cBox3.isSelected()){addonRate += 200;}

        getTravelCost();
        String cost = Double.toString(getTotalCost());
        totalPrice.setText(cost + "tk");
        //========================= Location error catching =====================
        if (e.getSource() == choosePickLoc || e.getSource() == chooseDropLoc) {
            if (pickUplocString.equals(dropOffLocString)) {
                JOptionPane.showMessageDialog(this, "Pickup location cannot be same as drop off location");
                locationValid = false;
            } 
            //=============================================================
            else if (pickUplocString.equals("") || dropOffLocString.equals("")) {
                // JOptionPane.showMessageDialog(this, "Location cannot be empty! Please fill them.");
                pickUPLoclabel.setForeground(Color.RED);
                locationValid = false;
            }

            else if (pickUplocString.equals("") && dropOffLocString.equals("")) {
                // JOptionPane.showMessageDialog(this, "Location cannot be empty! Please fill them.");
                dropOffLoclabel.setForeground(Color.RED);
                locationValid = false;
            }

            else {
                pickUPLoclabel.setForeground(Color.BLACK);
                dropOffLoclabel.setForeground(Color.BLACK);
                locationValid = true; 
            }
        }

        //=============== logic to enable terms and condition boxes and confirm button to confirm ======================
        if (passsagerInfoCheck == true && vehicleInfoCheck ==true && locationValid == true){
            termsAndCondCheckBox.setEnabled(true);

            if (termsAndCondCheckBox.isSelected()) {
                confirmBtn.setEnabled(true);
                anotherRideBtn.setEnabled(false);
            } 
            else {
                confirmBtn.setEnabled(false);
                anotherRideBtn.setEnabled(false);
            }
            if (e.getSource() == confirmBtn) {
                int response = JOptionPane.showConfirmDialog(this, "Booking a ride - Confirm?", "Confirm Ride",
                    JOptionPane.YES_NO_OPTION);

                if (response == JOptionPane.YES_OPTION) 
                {
                    confirmBtn.setBackground(Color.GREEN);
                    confirmBtn.setText("Confirmed!");
                    confirmBtn.setForeground(Color.BLACK);
                    confirmBtn.setEnabled(false);
                    anotherRideBtn.setEnabled(true);
                    termsAndCondCheckBox.setEnabled(false);
                    

                    Username = userNameTextArea.getText();
                    phone = userPhnTextArea.getText();
                    emergPhone = userEmergencyPhnTextArea.getText();
                    pickupVenue = pickupVenuetextArea.getText();
                    dropOffVenue = dropVenuetextArea.getText();
                    accNo = accountNumbertextArea.getText();
                    
                    vehicleChoice = vehicleType.getSelectedItem().toString();
                    pickLoc = choosePickLoc.getSelectedItem().toString();
                    dropLoc = chooseDropLoc.getSelectedItem().toString();


                    //=============================================================
                    if (pickUplocString.equals("") || dropOffLocString.equals("")) {
                        JOptionPane.showMessageDialog(this, "Location cannot be empty! Please fill them.");
                        locationValid = false;
                    }
                    //=============================================================
                    if (userMale.isSelected()) {
                        gender = userMale.getText();
                    } 
                    else {
                        gender = userFemale.getText();
                    }

                    // =================================
                    if(rideEco.isSelected()){
                        vehicleClass = rideEco.getText();
                    }
                    else if(ridePremium.isSelected()){
                        vehicleClass = ridePremium.getText();
                    }
                    // //===================================
                    if (payVBox1.isSelected()) {
                        payVia = payVBox1.getText();
                    } 
                    else if (payVBox2.isSelected()) {
                        payVia = payVBox2.getText();
                    } 
                    else {
                        payVia = payVBox3.getText();
                    }

                    //===================================
                    if (acVehicleCheck.isSelected() && musicVehicleCheck.isSelected()) {
                        ac = "Yes";
                        music = "Yes";
                    } 
                    else if (acVehicleCheck.isSelected()) {
                        ac = "Yes";
                        music = "No";
                    }
                    else if (musicVehicleCheck.isSelected()) {
                        music = "Yes";
                        ac = "No";
                    } 
                    else {
                        ac = "No";
                        music = "No";
                    }
                    // =================================
                    if (cBox1.isSelected() && cBox2.isSelected() && cBox3.isSelected()) {
                        luggage = cBox1.getText();
                        childSeat = cBox2.getText();
                        wheelChair = cBox3.getText();
                    }
                    else if (cBox1.isSelected() && cBox2.isSelected()) {
                        luggage = cBox1.getText();
                        childSeat = cBox2.getText();
                    } 
                    else if (cBox2.isSelected() && cBox3.isSelected()) {
                        childSeat = cBox2.getText();
                        wheelChair = cBox3.getText();
                    } 
                    else if (cBox1.isSelected() && cBox3.isSelected()) {
                        luggage = cBox1.getText();
                        wheelChair = cBox3.getText();
                    } 
                    else if (cBox1.isSelected()) {
                        luggage = cBox1.getText();
                    } 
                    else if (cBox2.isSelected()) {
                        childSeat = cBox2.getText();
                    }
                    else if (cBox3.isSelected()) {
                        wheelChair = cBox3.getText();
                    } 
                    else {
                        luggage = "";
                        childSeat = "";
                        wheelChair = "";
                        }

                    Customer obj1 = new Customer(Username, phone, emergPhone, pickupVenue, dropOffVenue, 
                        accNo, vehicleChoice, pickLoc, dropLoc, gender, payVia, vehicleClass, 
                        getSelectedRideTime(), ac, music, luggage, childSeat, wheelChair);

                    obj1.insertInfo();
                    display();
                    //=================================================================
                    rideReciept.setCaretPosition(0);
                    passangerDetailsPanel.setVisible(false);
                    rideDetailsPanel.setVisible(false);
                    bookRidePanel.setVisible(false);
                    confirmationPanel.setVisible(true);
                }

                else
                {
                    confirmBtn.setBackground(new Color(30, 136, 229));
                    confirmBtn.setText("Confirm!");
                    confirmBtn.setForeground(Color.WHITE);
                    confirmBtn.setEnabled(false);
                    termsAndCondCheckBox.setSelected(false);
                }
            }
        }

        if (e.getSource() == exitProgram) {
            int exitResponse = JOptionPane.showConfirmDialog(this, "Are you sure? \nClick Ok to Exit! ",
                    "Termiante Program", JOptionPane.YES_NO_OPTION);
            if (exitResponse == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
        // ========================= Book Another Ride button - backend
        if (e.getSource() == anotherRideBtn) {
            vehicleType.setSelectedIndex(0);
            acVehicleCheck.setSelected(false);
            acVehicleCheck.setEnabled(false);
            musicVehicleCheck.setSelected(false);
            musicVehicleCheck.setEnabled(false);
            radioRideTypeGroup.clearSelection();

            carDetails = new ImageIcon("images//rideDetails.png");
            carLabel.setIcon(carDetails);
            carLabel.setBounds(70, 5, 200, 200);

            pickupVenuetextArea.setText("");
            dropVenuetextArea.setText("");
            choosePickLoc.setSelectedIndex(0);
            chooseDropLoc.setSelectedIndex(0);

            cBox1.setSelected(false);
            cBox2.setSelected(false);
            cBox3.setSelected(false);

            radioGenderGroup.clearSelection();
            accountNumbertextArea.setText("");

            termsAndCondCheckBox.setSelected(false);
            termsAndCondCheckBox.setEnabled(true);

            confirmBtn.setBackground(new Color(30, 136, 229));
            confirmBtn.setText("Confirm!");
            confirmBtn.setForeground(Color.WHITE);
            confirmBtn.setEnabled(false);

            anotherRideBtn.setEnabled(false);

            confirmationPanel.setVisible(false);
            passangerDetailsPanel.setVisible(true);
            rideDetailsPanel.setVisible(true);
            bookRidePanel.setVisible(true);
        }
        // =======================================================================================
        // ============================================ Action perfomed ends here
        // =================================================================
    }

    // =======================================================================================
    // Mouse Listener
    // =======================================================================================
    // ================= mouse Listener ==================
    public void mouseClicked(MouseEvent me) {
        if (me.getSource() == confirmBtn) {
            confirmBtn.setBackground(Color.GREEN);
            confirmBtn.setText("Confirmed!");
            confirmBtn.setForeground(Color.BLACK);
            JOptionPane.showConfirmDialog(this, "Confirm?");

            confirmBtn.setBackground(new Color(30, 136, 229));
            confirmBtn.setText("Confirm!");
            confirmBtn.setForeground(Color.WHITE);
        }
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {

    }

    public void mouseEntered(MouseEvent me) {

    }

    public void mouseExited(MouseEvent me) {
    }
    // ==============================================

    private void display() {
        try {
            File file = new File("./Data/usersInfo.txt");
            if (file.exists()) {
                FileReader fr = new FileReader(file); // reads one character at a time
                BufferedReader br = new BufferedReader(fr); // reads one line at a time
                String line;
                while ((line = br.readLine()) != null) {
                    rideReciept.append(line + "\n");
                }
                br.close();
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error!");
        }
    }
}