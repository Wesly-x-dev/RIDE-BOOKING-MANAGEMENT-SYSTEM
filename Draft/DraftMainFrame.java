package Draft;

import RideBookingManagement.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class DraftMainFrame extends JFrame implements ActionListener, MouseListener {

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
            bookTimeLabel;
    private JLabel rideTypeLabel, reqLabel, payViaLabel, accountNumber, bookHourLabel, luggageLabel, babySeatLabel,
            wheelChairLabel;

    private ImageIcon luggageImgIcon, wheelChairImageIcon, babySeatImgIcon;
    private JTextArea rideReciept;
    private JTextField pickupVenuetextArea, dropVenuetextArea, accountNumbertextArea;
    private ButtonGroup radioRideTypeGroup, radioRideAmPmGroup;
    private JRadioButton rideEco, ridePremium, payVBox1, payVBox2, payVBox3, rideAm, ridePm;
    private JCheckBox cBox1, cBox2, cBox3, termsAndCondCheckBox;
    private JComboBox choosePickLoc, chooseDropLoc, chooseHour, chooseMins;
    private JButton confirmBtn, exitProgram, anotherRideBtn, backToFormBtn;

    public DraftMainFrame() {
        super.setTitle("Shohoz Ride - Booking ride made easy!");
        super.setBounds(350, 10, 800, 800);
        super.setResizable(false);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logo = new ImageIcon("images//logo.png");

        super.setIconImage(logo.getImage());
        // =================== Fonts and Colors ==========================
        headingFont = new Font("MV Boli", Font.BOLD, 30);
        subHeadingFont = new Font("MV Boli", Font.BOLD, 20);
        labelFont = new Font("MV Boli", Font.BOLD, 15);

        labelColor = new Color(33, 33, 33);
        Border border = BorderFactory.createDashedBorder(Color.BLACK, 2, 2, 2, true);

        // =================== heading panel: logo, heading text etc
        // ===================================
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
        // =================== Passenger Information Panel
        // ==================================
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
        // ========================= TextArea: YOUR NAME
        // ==================================
        userNameTextArea = new JTextField();
        userNameTextArea.setBounds(60, 110, 180, 30);
        userNameTextArea.setFont(labelFont);
        userNameTextArea.addActionListener(this);
        addLiveValidation(userNameTextArea);

        // ========================= LABEL: USER PHONE NUMBER
        // ==================================
        userPhnLabel = new JLabel("Phone: ");
        userPhnLabel.setBounds(60, 150, 150, 30);
        userPhnLabel.setFont(labelFont);
        userPhnLabel.setForeground(labelColor);
        // ========================= TextArea: USER PHONE NUMBER
        // =================================
        userPhnTextArea = new JTextField();
        userPhnTextArea.setBounds(60, 180, 180, 30);
        userPhnTextArea.setFont(labelFont);
        userPhnTextArea.addActionListener(this);
        addLiveValidation(userPhnTextArea);

        // ========================= LABEL: USER Emergency PHONE NUMBER
        // ==================================
        userEmergencyPhnLabel = new JLabel("Emergency Contact: ");
        userEmergencyPhnLabel.setBounds(60, 220, 170, 30);
        userEmergencyPhnLabel.setFont(labelFont);
        userEmergencyPhnLabel.setForeground(labelColor);
        // ========================= TextArea: USER Emergency PHONE NUMBER
        // =================================
        userEmergencyPhnTextArea = new JTextField();
        userEmergencyPhnTextArea.setBounds(60, 250, 180, 30);
        userEmergencyPhnTextArea.setFont(labelFont);
        addLiveValidation(userEmergencyPhnTextArea);

        // ========================= LABEL: Gender Label
        // ==================================
        userGender = new JLabel("Gender: ");
        userGender.setBounds(30, 290, 80, 30);
        userGender.setFont(labelFont);
        userGender.setForeground(labelColor);
        // ========================== Choose gender ==================================
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
        // ========================== ADDING ==================================
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

        // ========================== vehicle type ComboBox LABEL
        // ==================================
        vehicleTypeLabel = new JLabel("Choose Vehicle: ");
        vehicleTypeLabel.setBounds(20, 165, 150, 30);
        vehicleTypeLabel.setForeground(labelColor);
        vehicleTypeLabel.setFont(labelFont);
        // ========================== vehicle type ComboBox
        // ==================================
        String vehicle[] = new String[] { "", "Motorbike", "CNG", "SUV", "MicroBus", "Hi-ace" };
        vehicleType = new JComboBox(vehicle);
        vehicleType.setBounds(20, 195, 150, 30);
        vehicleType.setFont(labelFont);
        vehicleType.addActionListener(this);
        // ========================= LABEL: Ride Type Label
        // ==================================
        rideTypeLabel = new JLabel("Ride Type: ");
        rideTypeLabel.setBounds(20, 240, 100, 30);
        rideTypeLabel.setFont(labelFont);
        rideTypeLabel.setForeground(labelColor);
        // ========================== Choose Quality Class
        // ==================================
        rideEco = new JRadioButton("Economy");
        rideEco.setBounds(120, 240, 100, 30);
        rideEco.setFont(labelFont);
        rideDetailsPanel.add(rideEco);

        ridePremium = new JRadioButton("Premium");
        ridePremium.setBounds(240, 240, 100, 30);
        ridePremium.setFont(labelFont);
        rideDetailsPanel.add(ridePremium);

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
        // ==================================
        pickupVenuelabel = new JLabel("Pickup Venue: ");
        pickupVenuelabel.setBounds(20, 65, 150, 30);
        pickupVenuelabel.setFont(labelFont);
        pickupVenuelabel.setForeground(labelColor);
        // ========================= TextArea: Pickup Location
        // ==================================
        pickupVenuetextArea = new JTextField();
        pickupVenuetextArea.setBounds(20, 95, 180, 30);
        pickupVenuetextArea.setFont(labelFont);
        addLiveValidation(pickupVenuetextArea);

        // ========================= LABEL: Drop Off LOCATION
        // ==================================
        dropVenuelabel = new JLabel("Drop Off venue: ");
        dropVenuelabel.setBounds(20, 125, 180, 30);
        dropVenuelabel.setFont(labelFont);
        dropVenuelabel.setForeground(labelColor);
        // ========================= TextArea: Pickup Location
        // ==================================
        dropVenuetextArea = new JTextField();
        dropVenuetextArea.setBounds(20, 155, 180, 30);
        dropVenuetextArea.setFont(labelFont);
        addLiveValidation(dropVenuetextArea);

        // ==========================Drop Down Menu: pickup
        // Location======================================
        pickUPLoclabel = new JLabel("Pick Up Location: ");
        pickUPLoclabel.setBounds(220, 65, 150, 30);
        pickUPLoclabel.setFont(labelFont);
        pickUPLoclabel.setForeground(labelColor);

        // ==========================Drop Down Menu: drop off
        // Location======================================
        dropOffLoclabel = new JLabel("Drop Off Location: ");
        dropOffLoclabel.setBounds(220, 125, 180, 30);
        dropOffLoclabel.setFont(labelFont);
        dropOffLoclabel.setForeground(labelColor);
        // ================================================================

        // ========================== Location select ComboBox
        // ==================================
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
        rideAm.addActionListener(this);
        bookRidePanel.add(rideAm);
        // =======================================================
        ridePm = new JRadioButton("PM");
        ridePm.setBounds(350, 220, 70, 30);
        ridePm.setFont(labelFont);
        ridePm.addActionListener(this);
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

        payViaLabel = new JLabel("Pay Via: ");
        payViaLabel.setBounds(20, 465, 80, 30);
        payViaLabel.setFont(labelFont);
        payViaLabel.setForeground(labelColor);
        // ========================== Choose gender ==================================
        payVBox1 = new JRadioButton("Bkash");
        payVBox1.setBounds(100, 465, 80, 30);
        payVBox1.setFont(labelFont);
        payVBox1.addActionListener(this);

        payVBox2 = new JRadioButton("Nagad");
        payVBox2.setBounds(180, 465, 80, 30);
        payVBox2.setFont(labelFont);
        payVBox2.addActionListener(this);

        payVBox3 = new JRadioButton("Credit/Debit");
        payVBox3.setBounds(260, 465, 120, 30);
        payVBox3.setFont(labelFont);
        payVBox3.addActionListener(this);

        radioGenderGroup = new ButtonGroup();
        radioGenderGroup.add(payVBox1);
        radioGenderGroup.add(payVBox2);
        radioGenderGroup.add(payVBox3);

        // ===================== Card Phone number for payment ============
        accountNumber = new JLabel("Account No: ");
        accountNumber.setBounds(20, 505, 105, 30);
        accountNumber.setFont(labelFont);
        accountNumber.setForeground(labelColor);

        // ========================= TextArea: Pickup Location
        // ==================================
        accountNumbertextArea = new JTextField();
        accountNumbertextArea.setBounds(135, 505, 180, 30);
        accountNumbertextArea.setFont(labelFont);
        addLiveValidation(accountNumbertextArea);

        // ======================== Checkbox: Terms and Condition ====================
        termsAndCondCheckBox = new JCheckBox("I accept the terms and conditions.");
        termsAndCondCheckBox.setBounds(80, 555, 250, 20);// (x,y,width, height)
        termsAndCondCheckBox.setFont(new Font("MV Boli", Font.BOLD, 12));
        termsAndCondCheckBox.setEnabled(false);
        termsAndCondCheckBox.addActionListener(this);

        // ========================== Confirm Button ======================
        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(80, 595, 120, 30);
        confirmBtn.setFont(labelFont);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setBackground(new Color(30, 136, 229));
        confirmBtn.setOpaque(true);
        confirmBtn.addActionListener(this);
        confirmBtn.setEnabled(false);
        // ========================== Exit Button ======================
        exitProgram = new JButton("Exit");
        exitProgram.setBounds(210, 595, 120, 30);
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

        // ========================== Back Button ======================
        backToFormBtn = new JButton("Back");
        backToFormBtn.setBounds(230, 585, 150, 40);
        backToFormBtn.setFont(labelFont);
        backToFormBtn.setForeground(Color.WHITE);
        backToFormBtn.setBackground(new Color(30, 136, 229));
        backToFormBtn.setOpaque(true);
        backToFormBtn.addActionListener(this);

        // ========================== Reposition/relabel Book Another Ride Button
        // ======================
        anotherRideBtn.setText("Book Another Ride!");
        anotherRideBtn.setBounds(420, 585, 210, 40);

        confirmationPanel.add(confirmationHeadingLabel);
        confirmationPanel.add(scrollPane);
        confirmationPanel.add(backToFormBtn);
        confirmationPanel.add(anotherRideBtn);

        confirmationPanel.setVisible(false);
        super.add(confirmationPanel);

    }

    // =======================================================================================
    // ================= Action Listener (refactored) ==================
    // =======================================================================================
    //
    // The single monolithic handler has been split into small, single-purpose
    // methods, one per concern. actionPerformed() now just reads as a sequence
    // of steps, in the same order the original logic ran in:
    //
    //   1. validate passenger info (only relevant when Confirm was clicked)
    //   2. refresh the vehicle image / A-C / music state
    //   3. validate pickup/drop-off location (only relevant for the combo boxes
    //      and Confirm)
    //   4. enable/disable the Terms & Conditions checkbox based on whether every
    //      required field has been filled in yet
    //   5. keep the Confirm button's enabled state in sync with the T&C checkbox
    //   6. run the Yes/No "confirm booking" dialog (only when everything above
    //      was valid)
    //   7. persist the customer record (only when Confirm was clicked)
    //   8. handle Exit / Back / Book-another-ride, which are independent of
    //      everything above
    //
    // Behaviour is intentionally kept identical to the original implementation
    // (including the pre-existing quirk where the customer record is saved
    // whenever Confirm is pressed and the text fields are non-empty, even if
    // the "Booking a ride - Confirm?" dialog was answered "No" or the location
    // was invalid). One genuine bug was fixed along the way: gender selection
    // previously fell back to "Female" whenever "Others" was chosen; it is now
    // read from whichever radio button is actually selected.
    //
    // Step 4 is new: the Terms & Conditions checkbox used to be enabled purely
    // by picking a valid pickup/drop-off pair. It's now gated on name, phone,
    // emergency contact, pickup/drop-off venue and location, vehicle, an AM/PM
    // time choice, and a payment method + account number all being filled in.
    // This runs on every event (including keystrokes in the text fields via
    // addLiveValidation) so the checkbox unlocks the moment the last field is
    // completed, from any order.
    // =======================================================================================
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == confirmBtn && !isPassengerInfoValid()) {
            return;
        }

        refreshVehicleSelection();

        boolean locationValid = true;
        if (source == choosePickLoc || source == chooseDropLoc || source == confirmBtn) {
            locationValid = isLocationSelectionValid(source);
        }

        updateTermsCheckboxAvailability();
        syncConfirmButtonWithTerms();

        if (source == confirmBtn && locationValid) {
            runConfirmBookingDialog();
        }

        if (source == confirmBtn) {
            saveCustomerRecord();
        }

        if (source == exitProgram) {
            confirmAndExit();
        }

        if (source == backToFormBtn) {
            showBookingForm();
        }

        if (source == anotherRideBtn) {
            resetFormForNewRide();
        }
    }

    // ----------------------------------------------------------------------
    // Step 1: Passenger info validation
    // ----------------------------------------------------------------------
    private boolean isPassengerInfoValid() {
        if (userNameTextArea.getText().isEmpty()) {
            rejectWithMessage("User name required!!");
            return false;
        }
        if (userPhnTextArea.getText().isEmpty()) {
            rejectWithMessage("Phone number required!!");
            return false;
        }

        // phone number validator but kaj kortese na ektu check koirooo
        // if(!userPhnTextArea.getText().matches("//d+"))
        // {
        // rejectWithMessage("Valid Phone number required!!");
        // return false;
        // }

        if (userEmergencyPhnTextArea.getText().isEmpty()) {
            rejectWithMessage("Please enter an emergency contact");
            return false;
        }

        // if(!userEmergencyPhnTextArea.getText().matches("//d+"))
        // {
        // rejectWithMessage("Please enter a valid emergency contact");
        // return false;
        // }

        if (!userMale.isSelected() && !userFemale.isSelected() && !userOther.isSelected()) {
            rejectWithMessage("Must select a gender");
            return false;
        }
        return true;
    }

    // ==============================================
    private void rejectWithMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
        confirmBtn.setEnabled(false);
        termsAndCondCheckBox.setSelected(false);
    }
    //================================================

    // ----------------------------------------------------------------------
    // Step 2: Vehicle image / A-C / music state
    // ----------------------------------------------------------------------
    private void refreshVehicleSelection() {
        int selected = vehicleType.getSelectedIndex();

        switch (selected) {
            case 0:
                carDetails = new ImageIcon("images//rideDetails.png");
                setAcAndMusicEnabled(false);
                break;
            case 1:
                carDetails = new ImageIcon("images//bike.png");
                carLabel.setBounds(70, 0, 200, 200);
                setAcAndMusicEnabled(false);
                break;
            case 2:
                carDetails = new ImageIcon("images//cng.png");
                carLabel.setBounds(70, 0, 200, 200);
                setAcAndMusicEnabled(false);
                break;
            case 3:
                carDetails = new ImageIcon("images//SUV.png");
                setAcAndMusicEnabled(true);
                break;
            case 4:
                carDetails = new ImageIcon("images//microbus.png");
                setAcAndMusicEnabled(true);
                break;
            case 5:
                carDetails = new ImageIcon("images//hiace.png");
                setAcAndMusicEnabled(true);
                break;
        }
        carLabel.setIcon(carDetails);
    }

    private void setAcAndMusicEnabled(boolean enabled) {
        acVehicleCheck.setEnabled(enabled);
        musicVehicleCheck.setEnabled(enabled);
        if (!enabled) {
            acVehicleCheck.setSelected(false);
            musicVehicleCheck.setSelected(false);
        }
    }

    // ----------------------------------------------------------------------
    // Step 3: Pickup / drop-off location validation
    // ----------------------------------------------------------------------
    private boolean isLocationPairValid() {
        String pickup = choosePickLoc.getSelectedItem().toString();
        String dropOff = chooseDropLoc.getSelectedItem().toString();
        return !pickup.isEmpty() && !dropOff.isEmpty() && !pickup.equals(dropOff);
    }

    private void showLocationErrorMessage(String pickup, String dropOff) {
        if (pickup.isEmpty() && dropOff.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Location Cannot be empty! Please fill them.");
        } else if (pickup.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please select Pickup Location!");
        } else if (pickup.equals(dropOff)) {
            JOptionPane.showMessageDialog(this, "Pickup location cannot be same as drop off location");
        } else {
            JOptionPane.showMessageDialog(this, "Please select Drop off Location!");
        }
    }


    private void resetConfirmationBtnState() {
        confirmBtn.setBackground(new Color(30, 136, 229));
        confirmBtn.setText("Confirm!");
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setEnabled(false);
        anotherRideBtn.setEnabled(false);
        termsAndCondCheckBox.setSelected(false);
    }

    private boolean isLocationSelectionValid(Object source) {
        String pickup = choosePickLoc.getSelectedItem().toString();
        String dropOff = chooseDropLoc.getSelectedItem().toString();
        boolean noVehicleChosen = vehicleType.getSelectedIndex() == 0;

        boolean invalid = !isLocationPairValid() || noVehicleChosen;

        if (!invalid) {
            return true;
        }

        if (source == confirmBtn) {
            showLocationErrorMessage(pickup, dropOff);
        }
        resetConfirmationBtnState();
        return false;
    }


    // ----------------------------------------------------------------------
    // Terms & Conditions checkbox gated on form completeness
    // ----------------------------------------------------------------------
    private boolean isAllRequiredInfoFilled() {
        boolean passengerInfoFilled = !userNameTextArea.getText().trim().isEmpty()
                && !userPhnTextArea.getText().trim().isEmpty()
                && !userEmergencyPhnTextArea.getText().trim().isEmpty();

        boolean venuesFilled = !pickupVenuetextArea.getText().trim().isEmpty()
                && !dropVenuetextArea.getText().trim().isEmpty();

        boolean vehicleChosen = vehicleType.getSelectedIndex() != 0;

        boolean timeChosen = rideAm.isSelected() || ridePm.isSelected();

        boolean paymentFilled = (payVBox1.isSelected() || payVBox2.isSelected() || payVBox3.isSelected())
                && !accountNumbertextArea.getText().trim().isEmpty();

        return passengerInfoFilled && venuesFilled && isLocationPairValid() && vehicleChosen
                && timeChosen && paymentFilled;
    }

    private void updateTermsCheckboxAvailability() {
        boolean allFilled = isAllRequiredInfoFilled();
        termsAndCondCheckBox.setEnabled(allFilled);
        if (!allFilled) {
            termsAndCondCheckBox.setSelected(false);
        }
    }


    // Lets a JTextField's Document trigger the same completeness check on every
    // keystroke, not just on Enter (which is all a plain addActionListener
    // would give us).
    private void addLiveValidation(JTextField field) {
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTermsCheckboxAvailability();
                syncConfirmButtonWithTerms();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTermsCheckboxAvailability();
                syncConfirmButtonWithTerms();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateTermsCheckboxAvailability();
                syncConfirmButtonWithTerms();
            }
        });
    }

    // ----------------------------------------------------------------------
    // Confirm button <-> Terms checkbox sync
    // ----------------------------------------------------------------------
    private void syncConfirmButtonWithTerms() {
        confirmBtn.setEnabled(termsAndCondCheckBox.isSelected());
        anotherRideBtn.setEnabled(false);
    }

    // ----------------------------------------------------------------------
    // "Booking a ride - Confirm?" Yes/No dialog
    // ----------------------------------------------------------------------
    private void runConfirmBookingDialog() {
        int response = JOptionPane.showConfirmDialog(this, "Booking a ride - Confirm?", "Confirm Ride",
                JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            confirmBtn.setBackground(Color.GREEN);
            confirmBtn.setText("Confirmed!");
            confirmBtn.setForeground(Color.BLACK);
            confirmBtn.setEnabled(false);
            anotherRideBtn.setEnabled(true);
            termsAndCondCheckBox.setEnabled(false);

            rideReciept.setCaretPosition(0);
            switchToConfirmationPanel();
        } else {
            confirmBtn.setBackground(new Color(30, 136, 229));
            confirmBtn.setText("Confirm!");
            confirmBtn.setForeground(Color.WHITE);
            confirmBtn.setEnabled(false);
            termsAndCondCheckBox.setSelected(false);
        }
    }

    private void switchToConfirmationPanel() {
        passangerDetailsPanel.setVisible(false);
        rideDetailsPanel.setVisible(false);
        bookRidePanel.setVisible(false);
        confirmationPanel.setVisible(true);
    }

    // ----------------------------------------------------------------------
    // customer record
    // ----------------------------------------------------------------------
    private void saveCustomerRecord() {
        String username = userNameTextArea.getText();
        String phone = userPhnTextArea.getText();
        String emergPhone = userEmergencyPhnTextArea.getText();
        String pickupVenue = pickupVenuetextArea.getText();
        String dropOffVenue = dropVenuetextArea.getText();
        String accNo = accountNumbertextArea.getText();

        if (username.isEmpty() || phone.isEmpty() || emergPhone.isEmpty()
                || pickupVenue.isEmpty() || dropOffVenue.isEmpty() || accNo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up information");
            return;
        }

        String vehicleChoice = vehicleType.getSelectedItem().toString();
        String pickLoc = choosePickLoc.getSelectedItem().toString();
        String dropLoc = chooseDropLoc.getSelectedItem().toString();
        String gender = getSelectedGender();
        String payVia = getSelectedPaymentMethod();
        String rideType = getSelectedRideType();
        String rideTime = getSelectedRideTime();
        String ac = textIfSelected(acVehicleCheck);
        String music = textIfSelected(musicVehicleCheck);
        String luggage = textIfSelected(cBox1);
        String childSeat = textIfSelected(cBox2);
        String wheelChair = textIfSelected(cBox3);

        Customer customer = new Customer(username, phone, emergPhone, pickupVenue, dropOffVenue, accNo,
                vehicleChoice, pickLoc, dropLoc, gender, payVia, rideType, rideTime, ac, music, luggage, childSeat,
                wheelChair);
        customer.insertInfo();
        display();
    }

    private String getSelectedRideType() {
        if (rideEco.isSelected()) {
            return rideEco.getText();
        }
        if (ridePremium.isSelected()) {
            return ridePremium.getText();
        }
        return "";
    }

    private String getSelectedRideTime() {
        String hour = chooseHour.getSelectedItem().toString();
        String mins = chooseMins.getSelectedItem().toString();
        String amPm = rideAm.isSelected() ? rideAm.getText() : (ridePm.isSelected() ? ridePm.getText() : "");
        return hour + ":" + mins + " " + amPm;
    }

    private String textIfSelected(JCheckBox checkBox) {
        return checkBox.isSelected() ? checkBox.getText() : "";
    }

    private String getSelectedGender() {
        if (userMale.isSelected()) {
            return userMale.getText();
        }
        if (userFemale.isSelected()) {
            return userFemale.getText();
        }
        if (userOther.isSelected()) {
            return userOther.getText();
        }
        return "";
    }

    private String getSelectedPaymentMethod() {
        if (payVBox1.isSelected()) {
            return payVBox1.getText();
        }
        if (payVBox2.isSelected()) {
            return payVBox2.getText();
        }
        if (payVBox3.isSelected()) {
            return payVBox3.getText();
        }
        return "";
    }

    // ----------------------------------------------------------------------
    // Exit / Back / Book another ride
    // ----------------------------------------------------------------------
    private void confirmAndExit() {
        int exitResponse = JOptionPane.showConfirmDialog(this, "Are you sure? \nClick Ok to Exit! ",
                "Terminate Program", JOptionPane.YES_NO_OPTION);
        if (exitResponse == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void showBookingForm() {
        confirmationPanel.setVisible(false);
        passangerDetailsPanel.setVisible(true);
        rideDetailsPanel.setVisible(true);
        bookRidePanel.setVisible(true);
    }

    private void resetFormForNewRide() {
        vehicleType.setSelectedIndex(0);
        setAcAndMusicEnabled(false);
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

        showBookingForm();
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