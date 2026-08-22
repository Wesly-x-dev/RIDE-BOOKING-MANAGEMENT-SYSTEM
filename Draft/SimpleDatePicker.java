import java.awt.*;
import java.util.Calendar;
import javax.swing.*;

public class SimpleDatePicker extends JFrame {

    // Array of month names (index 0 = January, index 11 = December)
    String[] monthNames = {
        "January", "February", "March", "April", "May", "June",
        "July", "August", "September", "October", "November", "December"
    };

    // Plain JComboBox (no <String> or <Integer> generic types)
    JComboBox monthDropdown;
    JComboBox dayDropdown;
    JButton checkButton;

    public SimpleDatePicker() {

        // Basic window setup
        setTitle("Simple Date Picker");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        // Create the month dropdown and fill it with month names
        monthDropdown = new JComboBox(monthNames);

        // Create the day dropdown (start empty, we will fill it below)
        dayDropdown = new JComboBox();
        fillDayDropdown(); // fill days for the default selected month

        // When the user changes the month, update the days shown
        monthDropdown.addActionListener(e -> fillDayDropdown());

        // Button to check the selected date
        checkButton = new JButton("Check Date");
        checkButton.addActionListener(e -> checkIfDateIsOld());

        // Add everything to the window
        add(new JLabel("Month:"));
        add(monthDropdown);
        add(new JLabel("Day:"));
        add(dayDropdown);
        add(checkButton);
    }

    // This method figures out how many days are in the selected month
    // and fills the day dropdown with numbers 1 to that many days.
    void fillDayDropdown() {

        int monthIndex = monthDropdown.getSelectedIndex(); // 0 = Jan, 1 = Feb, ...
        int numberOfDays;

        // Simple if-else to decide number of days in each month
        if (monthIndex == 0 || monthIndex == 2 || monthIndex == 4 || monthIndex == 6 ||
            monthIndex == 7 || monthIndex == 9 || monthIndex == 11) {
            // Jan, Mar, May, Jul, Aug, Oct, Dec have 31 days
            numberOfDays = 31;
        } else if (monthIndex == 3 || monthIndex == 5 || monthIndex == 8 || monthIndex == 10) {
            // Apr, Jun, Sep, Nov have 30 days
            numberOfDays = 30;
        } else {
            // February - check for leap year
            int currentYear = getCurrentYear();
            if (isLeapYear(currentYear)) {
                numberOfDays = 29;
            } else {
                numberOfDays = 28;
            }
        }

        // Clear old items and add new day numbers
        dayDropdown.removeAllItems();
        for (int day = 1; day <= numberOfDays; day++) {
            dayDropdown.addItem(day); // autoboxed into an Object, that's fine
        }
    }

    // Checks if a year is a leap year
    boolean isLeapYear(int year) {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }

    // Gets today's year using the Calendar class
    int getCurrentYear() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.YEAR);
    }

    // Compares the selected date with today's date
    void checkIfDateIsOld() {

        int selectedMonth = monthDropdown.getSelectedIndex(); // 0 = Jan

        // dayDropdown holds plain Objects, so we cast to Integer, then unbox to int
        int selectedDay = (int) (Integer) dayDropdown.getSelectedItem();

        // Get today's date info
        Calendar today = Calendar.getInstance();
        int todayYear = today.get(Calendar.YEAR);
        int todayMonth = today.get(Calendar.MONTH); // 0 = Jan
        int todayDay = today.get(Calendar.DAY_OF_MONTH);

        // We assume the selected date is in the current year
        boolean isOld = false;

        if (selectedMonth < todayMonth) {
            isOld = true;
        } else if (selectedMonth == todayMonth && selectedDay < todayDay) {
            isOld = true;
        }

        // Show a dialogue box depending on the result
        if (isOld) {
            JOptionPane.showMessageDialog(
                this,
                "Error: The selected date is older than today!",
                "Invalid Date",
                JOptionPane.ERROR_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Selected date is today or in the future. Looks good!",
                "Valid Date",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Main method - program starts here
    public static void main(String[] args) {
        SimpleDatePicker frame = new SimpleDatePicker();
        frame.setVisible(true);
    }
}