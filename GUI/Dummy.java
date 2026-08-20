package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Dummy extends JFrame implements ActionListener, MouseListener {

    //======================= include panels here ========================
    private JPanel headingPanel, passangerDetailsPanel, rideDetailsPanel, bookRidePanel;

    //======================== include components used in the full project =======================
    private ImageIcon logo, carDetails;
    private  JLabel logoLabel, headingTextlabel, tagLineLabel;

    private  Font headingFont, subHeadingFont, labelFont;
    private Color labelColor;

    // ==================== Passangers Panel All components ===============
    private  JLabel  userName, paassangerSubHeading, userPhnLabel, userEmergencyPhnLabel, userGender;
    private JTextField userNameTextArea, userPhnTextArea, userEmergencyPhnTextArea;
    private JRadioButton userMale, userFemale,userOther;
    private ButtonGroup radioGenderGroup;

    // ==================== Ride/vehicle panel All components ===============
    private  JLabel rideSubHeading,carLabel, vehicleTypeLabel;
    private JComboBox vehicleType;
    private JCheckBox musicVehicleCheck, acVehicleCheck;

    //==================== Ride Booking Components ===========================
    private JLabel bookRideHeadingLabel, pickupVenuelabel, dropVenuelabel,pickUPLoclabel, dropOffLoclabel;
    private JLabel  rideTypeLabel, reqLabel, payViaLabel, paymentHeadinglabel, accountNumber;

    private JTextField pickupVenuetextArea, dropVenuetextArea, accountNumbertextArea;
    private ButtonGroup radioRideTypeGroup;
    private JRadioButton rideEco, ridePremium,payVBox1, payVBox2, payVBox3;
    private JCheckBox cBox1, cBox2, cBox3, termsAndCondCheckBox;
    private JComboBox choosePickLoc, chooseDropLoc;
    private JButton confirmBtn, exitProgram;

    public Dummy(){
        super.setTitle("Thapao!");
        super.setBounds(350, 10, 800, 800);
        super.setResizable(false);
        super.setLayout(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        logo = new ImageIcon("images//logo.png");

        super.setIconImage(logo.getImage());
        //=================== Fonts and Colors ==========================
        headingFont = new Font("MV Boli", Font.BOLD, 30);
        subHeadingFont = new Font("MV Boli", Font.BOLD, 20);
        labelFont = new Font("MV Boli", Font.BOLD, 15);

        labelColor = new Color(33, 33, 33);
        Border border = BorderFactory.createDashedBorder(Color.BLACK, 2, 2, 2, true);

        // =================== heading panel: logo, heading text etc ===================================
        headingPanel = new JPanel();
        headingPanel.setBounds(0,0,798, 110);
        headingPanel.setBackground(new Color(30, 136, 229));
        headingPanel.setOpaque(true);
        headingPanel.setLayout(null);

        logoLabel = new JLabel(logo);
        logoLabel.setBounds(5,5,100,100);

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

        //***************************************************************************
        //###########################################################################
        // =================== Passenger Information Panel ==================================
        passangerDetailsPanel = new JPanel();
        passangerDetailsPanel.setBounds(0,110,350, 340);
        passangerDetailsPanel.setBackground(new Color(225, 225, 225));
        passangerDetailsPanel.setLayout(null);

        //========================== heading ==================================
        paassangerSubHeading = new JLabel("Passenger Information");
        paassangerSubHeading.setBorder(border);
        paassangerSubHeading.setFont(subHeadingFont);
        paassangerSubHeading.setForeground(labelColor);
        paassangerSubHeading.setHorizontalAlignment(JLabel.CENTER);
        paassangerSubHeading.setBounds(60,30, 250, 30);

        //============================================================================
        //========================= LABEL: YOUR NAME ==================================
        userName = new JLabel("Full Name: ");
        userName.setBounds(60, 80, 150, 30);
        userName.setFont(labelFont);
        userName.setForeground(labelColor);
        //========================= TextArea: YOUR NAME ==================================
        userNameTextArea = new JTextField();
        userNameTextArea.setBounds(60, 110, 180, 30);
        userNameTextArea.setFont(labelFont);


        //========================= LABEL: USER PHONE NUMBER ==================================
        userPhnLabel = new JLabel("Phone: ");
        userPhnLabel.setBounds(60, 150, 150, 30);
        userPhnLabel.setFont(labelFont);
        userPhnLabel.setForeground(labelColor);
        //========================= TextArea: USER PHONE NUMBER =================================
        userPhnTextArea = new JTextField();
        userPhnTextArea.setBounds(60, 180, 180, 30);
        userPhnTextArea.setFont(labelFont);


        //========================= LABEL: USER Emergency PHONE NUMBER ==================================
        userEmergencyPhnLabel = new JLabel("Emergency Contact: ");
        userEmergencyPhnLabel.setBounds(60, 220, 170, 30);
        userEmergencyPhnLabel.setFont(labelFont);
        userEmergencyPhnLabel.setForeground(labelColor);
        //========================= TextArea:  USER Emergency PHONE NUMBER =================================
        userEmergencyPhnTextArea = new JTextField();
        userEmergencyPhnTextArea.setBounds(60, 250, 180, 30);
        userEmergencyPhnTextArea.setFont(labelFont);

        //========================= LABEL: Gender Label ==================================
        userGender = new JLabel("Gender: ");
        userGender.setBounds(30, 290, 80, 30);
        userGender.setFont(labelFont);
        userGender.setForeground(labelColor);
        //========================== Choose gender ==================================
        userMale =  new JRadioButton("Male");
        userMale.setBounds(110, 290, 60, 30);
        userMale.setFont(labelFont);
        passangerDetailsPanel.add(userMale);

        userFemale =  new JRadioButton("Female");
        userFemale.setBounds(170, 290, 80, 30);
        userFemale.setFont(labelFont);
        passangerDetailsPanel.add(userFemale);

        userOther =  new JRadioButton("Others");
        userOther.setBounds(250, 290, 80, 30);
        userOther.setFont(labelFont);
        passangerDetailsPanel.add(userOther);

        radioGenderGroup = new ButtonGroup();
        radioGenderGroup.add(userOther);
        radioGenderGroup.add(userMale);
        radioGenderGroup.add(userFemale);
        //========================== ADDING ==================================
        passangerDetailsPanel.add(paassangerSubHeading);

        passangerDetailsPanel.add(userName);
        passangerDetailsPanel.add(userNameTextArea);

        passangerDetailsPanel.add(userPhnLabel);
        passangerDetailsPanel.add(userPhnTextArea);

        passangerDetailsPanel.add(userEmergencyPhnLabel);
        passangerDetailsPanel.add(userEmergencyPhnTextArea);

        passangerDetailsPanel.add(userGender);
        super.add(passangerDetailsPanel);
        //***************************************************************************
        //###########################################################################


        //***************************************************************************
        //###########################################################################
        // =================== Ride Details panels==================================
        rideDetailsPanel = new JPanel();
        rideDetailsPanel.setBounds(0,452,350, 307);
        rideDetailsPanel.setBackground(new Color(225, 225, 225));
        rideDetailsPanel.setLayout(null);

        //========================== ==================================
        rideSubHeading = new JLabel("Vehicle Information");
        rideSubHeading.setFont(subHeadingFont);
        rideSubHeading.setHorizontalAlignment(JLabel.CENTER);
        rideSubHeading.setForeground(labelColor);
        rideSubHeading.setBorder(border);
        rideSubHeading.setBounds(60,30, 250, 30);

        //========================== Image Added ==================================
        carDetails = new ImageIcon("images//rideDetails.png");
        carLabel = new JLabel(carDetails);
        carLabel.setBounds(70, 20, 200, 200);

        //========================== vehicle type ComboBox LABEL ==================================
        vehicleTypeLabel = new JLabel("Select Vehicle: ");
        vehicleTypeLabel.setBounds(60, 180, 150, 30);
        vehicleTypeLabel.setForeground(labelColor);
        vehicleTypeLabel.setFont(labelFont);
        //========================== vehicle type ComboBox ==================================
        String vehicle[] = new String[]
                {"", "Bike", "CNG", "SUV", "MicroBus", "Hi-ace", "Corolla v2"};
        vehicleType = new JComboBox(vehicle);
        vehicleType.setBounds(60, 210, 150, 30);
        vehicleType.setFont(labelFont);


        //===========================A/c and Music system ===================
        acVehicleCheck = new JCheckBox("A/C");
        acVehicleCheck.setBounds(60, 255, 60,30);//(x,y,width, height)
        acVehicleCheck.setFont(labelFont);


        musicVehicleCheck = new JCheckBox("Music");
        musicVehicleCheck.setBounds(120, 255, 100,30);//(x,y,width, height)
        musicVehicleCheck.setFont(labelFont);

        //============================================================
        rideDetailsPanel.add(carLabel);
        rideDetailsPanel.add(rideSubHeading);
        rideDetailsPanel.add(vehicleType);
        rideDetailsPanel.add(vehicleTypeLabel);
        rideDetailsPanel.add(acVehicleCheck);
        rideDetailsPanel.add(musicVehicleCheck);
        super.add(rideDetailsPanel);



        //***************************************************************************
        //###########################################################################
        // ===================  Booking Details panels ==================================
        bookRidePanel = new JPanel();
        bookRidePanel.setBounds(352,110,448, 650);
        bookRidePanel.setBackground(new Color(225, 225, 225));
        bookRidePanel.setLayout(null);

        //============================================================
        bookRideHeadingLabel = new JLabel("Book a Ride!");
        bookRideHeadingLabel.setFont(subHeadingFont);
        bookRideHeadingLabel.setHorizontalAlignment(JLabel.CENTER);
        bookRideHeadingLabel.setForeground(labelColor);
        bookRideHeadingLabel.setBorder(border);
        bookRideHeadingLabel.setBounds(90,30, 180, 30);
        //============================================================
        //========================= LABEL: PICKUP LOCATION ==================================
        pickupVenuelabel = new JLabel("Pickup Venue: ");
        pickupVenuelabel.setBounds(20, 80, 150, 30);
        pickupVenuelabel.setFont(labelFont);
        pickupVenuelabel.setForeground(labelColor);
        //========================= TextArea: Pickup Location ==================================
        pickupVenuetextArea = new JTextField();
        pickupVenuetextArea.setBounds(20, 110, 180, 30);
        pickupVenuetextArea.setFont(labelFont);

        //========================= LABEL: Drop Off LOCATION ==================================
        dropVenuelabel = new JLabel("Drop Off venue: ");
        dropVenuelabel.setBounds(20, 140, 180, 30);
        dropVenuelabel.setFont(labelFont);
        dropVenuelabel.setForeground(labelColor);
        //========================= TextArea: Pickup Location ==================================
        dropVenuetextArea = new JTextField();
        dropVenuetextArea.setBounds(20, 170, 180, 30);
        dropVenuetextArea.setFont(labelFont);


        //==========================Drop Down Menu: pickup Location======================================
        pickUPLoclabel = new JLabel("Pick Up Location: ");
        pickUPLoclabel.setBounds(220, 80, 150, 30);
        pickUPLoclabel.setFont(labelFont);
        pickUPLoclabel.setForeground(labelColor);

        //==========================Drop Down Menu: drop off Location======================================
        dropOffLoclabel = new JLabel("Drop Off Location: ");
        dropOffLoclabel.setBounds(220, 140, 180, 30);
        dropOffLoclabel.setFont(labelFont);
        dropOffLoclabel.setForeground(labelColor);
        //================================================================

        //========================== Location select ComboBox ==================================
        String loc[] = new String[]
                {"", "Savar", "Kuril", "Mirpur", "Gulshan", "Badda", "Dhanmondi", "Mohammadpur"};

        choosePickLoc = new JComboBox(loc);
        choosePickLoc.setBounds(220, 110, 180, 30);
        choosePickLoc.setFont(labelFont);

        chooseDropLoc = new JComboBox(loc);
        chooseDropLoc.setBounds(220, 170, 180, 30);
        chooseDropLoc.setFont(labelFont);
        //================================================================

        //========================= LABEL: Ride Type Label ==================================
        rideTypeLabel = new JLabel("Ride Type: ");
        rideTypeLabel.setBounds(20, 220, 100, 30);
        rideTypeLabel.setFont(labelFont);
        rideTypeLabel.setForeground(labelColor);
        //========================== Choose gender ==================================
        rideEco =  new JRadioButton("Economy");
        rideEco.setBounds(120, 220, 100, 30);
        rideEco.setFont(labelFont);
        bookRidePanel.add(rideEco);

        ridePremium =  new JRadioButton("Premium");
        ridePremium.setBounds(240, 220, 100, 30);
        ridePremium.setFont(labelFont);
        bookRidePanel.add(ridePremium);

        radioRideTypeGroup = new ButtonGroup();
        radioRideTypeGroup.add(rideEco);
        radioRideTypeGroup.add(ridePremium);

        //================================================================
        reqLabel = new JLabel(" Common Special Requests: ");
        reqLabel.setFont(labelFont);
        reqLabel.setHorizontalAlignment(JLabel.CENTER);
        reqLabel.setBounds(70, 260, 240, 30);
        //=========================== CheckBox ===================
        cBox1 = new JCheckBox("Luggage Carrier");
        cBox1.setBounds(120, 300, 150,30);//(x,y,width, height)
        cBox1.setFont(labelFont);


        cBox2 = new JCheckBox("Child Seat");
        cBox2.setBounds(120, 330, 150,30);//(x,y,width, height)
        cBox2.setFont(labelFont);

        cBox3 = new JCheckBox("Wheel Chair");
        cBox3.setBounds(120, 360, 150,30);//(x,y,width, height)
        cBox3.setFont(labelFont);


        //=====================payment Heading ============================
//        paymentHeadinglabel = new JLabel("Payment");
//        paymentHeadinglabel.setFont(subHeadingFont);
//        paymentHeadinglabel.setHorizontalAlignment(JLabel.CENTER);
//        paymentHeadinglabel.setForeground(labelColor);
//        paymentHeadinglabel.setBorder(border);
//        paymentHeadinglabel.setBounds(90,400, 180, 30);


        payViaLabel = new JLabel("Pay Via: ");
        payViaLabel.setBounds(20, 485, 80, 30);
        payViaLabel.setFont(labelFont);
        payViaLabel.setForeground(labelColor);
        //========================== Choose gender ==================================
        payVBox1 =  new JRadioButton("Bkash");
        payVBox1.setBounds(100, 485, 80, 30);
        payVBox1.setFont(labelFont);

        payVBox2 =  new JRadioButton("Nagad");
        payVBox2.setBounds(180, 485, 80, 30);
        payVBox2.setFont(labelFont);

        payVBox3 =  new JRadioButton("Credit/Debit");
        payVBox3.setBounds(260, 485, 120, 30);
        payVBox3.setFont(labelFont);

        radioGenderGroup = new ButtonGroup();
        radioGenderGroup.add(payVBox1);
        radioGenderGroup.add(payVBox2);
        radioGenderGroup.add(payVBox3);

        //===================== Card Phone number for payment ============
        accountNumber = new JLabel("Account No: ");
        accountNumber.setBounds(20, 520, 105, 30);
        accountNumber.setFont(labelFont);
        accountNumber.setForeground(labelColor);

        //========================= TextArea: Pickup Location ==================================
        accountNumbertextArea = new JTextField();
        accountNumbertextArea.setBounds(135, 520, 180, 30);
        accountNumbertextArea.setFont(labelFont);


        //======================== Checkbox: Terms and Condition ====================
        termsAndCondCheckBox = new JCheckBox("I accept the terms and conditions.");
        termsAndCondCheckBox.setBounds(80, 555, 250,20);//(x,y,width, height)
        termsAndCondCheckBox.setFont(new Font("MV Boli", Font.BOLD, 12));
        termsAndCondCheckBox.addActionListener(this);

        //========================== Confirm Button ======================
        confirmBtn = new JButton("Confirm");
        confirmBtn.setBounds(60, 580, 150, 40);
        confirmBtn.setFont(subHeadingFont);
        confirmBtn.setForeground(Color.WHITE);
        confirmBtn.setBackground(new Color(30, 136, 229));
        confirmBtn.setOpaque(true);
        confirmBtn.addActionListener(this);
        confirmBtn.setEnabled(false);

        //========================== Exit Button ======================
        exitProgram = new JButton("Exit");
        exitProgram.setBounds(230, 580, 150, 40);
        exitProgram.setFont(subHeadingFont);
        exitProgram.setForeground(Color.WHITE);
        exitProgram.setBackground(new Color(229, 30, 37));
        exitProgram.setOpaque(true);
        exitProgram.addActionListener(this);

        //=====================Adding =====================================
        bookRidePanel.add(pickupVenuelabel);
        bookRidePanel.add(pickupVenuetextArea);

        bookRidePanel.add(dropVenuelabel);
        bookRidePanel.add(dropVenuetextArea);

        bookRidePanel.add(pickUPLoclabel);
        bookRidePanel.add(choosePickLoc);
        bookRidePanel.add(dropOffLoclabel);
        bookRidePanel.add(chooseDropLoc);

        bookRidePanel.add(bookRideHeadingLabel);
        bookRidePanel.add(rideTypeLabel);
        bookRidePanel.add(reqLabel);

        bookRidePanel.add(cBox1);
        bookRidePanel.add(cBox2);
        bookRidePanel.add(cBox3);

//        bookRidePanel.add(paymentHeadinglabel);
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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(termsAndCondCheckBox.isSelected())
        {
            confirmBtn.setEnabled(termsAndCondCheckBox.isSelected());

        }
        else
        {
            JOptionPane.showMessageDialog(this, "First agree with term and condition");
        }

        if(e.getSource() == exitProgram)
        {
            JOptionPane.showMessageDialog(this, "Thank you For using :)");
            System.exit(0);
        }


        if(e.getSource() == confirmBtn)
        {
            int response = JOptionPane.showConfirmDialog(this, "Confirm?");

            if(response == JOptionPane.YES_OPTION)
            {
                confirmBtn.setBackground(Color.GREEN);
                confirmBtn.setText("Confirmed!");
                confirmBtn.setForeground(Color.BLACK);
            }

            else
            {
                confirmBtn.setBackground(new Color(30, 136, 229));
                confirmBtn.setText("Confirm!");
                confirmBtn.setForeground(Color.WHITE);
            }

        }

    }



    public void mouseClicked(MouseEvent me){


    }

    public void mousePressed(MouseEvent me){

    }

    public void mouseReleased(MouseEvent me){

    }
    public void mouseEntered(MouseEvent me){

    }
    public void mouseExited(MouseEvent me) {
    }
}
