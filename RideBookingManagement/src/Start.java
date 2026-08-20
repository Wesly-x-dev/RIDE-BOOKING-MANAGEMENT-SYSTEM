import GUI.Dummy;
import GUI.MainFrame;

import javax.swing.*;
import java.awt.*;

public class Start{
    public static void main(String[] args){

        new MainFrame().setVisible(true);
//        new Dummy().setVisible(true);
    }
}


//// ================================ User Control - Location ==============================
////        int pickUploc = choosePickLoc.getSelectedIndex();
////        int dropOffLoc = chooseDropLoc.getSelectedIndex();
//String pickUplocString = choosePickLoc.getSelectedItem().toString();
//String dropOffLocString = chooseDropLoc.getSelectedItem().toString();
//        if(pickUplocString == "" || dropOffLocString == "" || pickUplocString == dropOffLocString){
//        if (pickUplocString == "" && dropOffLocString == "" ){
//        JOptionPane.showMessageDialog(this, "Location Cannot be empty! PLease fill them.");
//            }
//                    else if (pickUplocString == "") {
//        JOptionPane.showMessageDialog(this, "Please select Pickup Location!");
//            }
//
//                    else if(pickUplocString == dropOffLocString){
//        JOptionPane.showMessageDialog(this, "Pickup location cannot be same as drop off location");
//             }
//                     else {JOptionPane.showMessageDialog(this, "Please select Drop off Location!");}
//        }
//
////=======================================================================================S


////========================= Terms and Condition authentication - backend =======================================
//        if(termsAndCondCheckBox.isSelected()){
//        confirmBtn.setEnabled(termsAndCondCheckBox.isSelected());
//        }
//        else {
//        confirmBtn.setEnabled(false);
//        }
//                //=============================================================================================================
//
//                //========================= Confirm button - backend ======================================================
//                if(e.getSource() == confirmBtn) {
//int response = JOptionPane.showConfirmDialog(this,  "Booking a ride - Confirm?", "Confirm Ride", JOptionPane.YES_NO_OPTION);
//            if(response == JOptionPane.YES_OPTION) {
//        confirmBtn.setBackground(Color.GREEN);
//                confirmBtn.setText("Confirmed!");
//                confirmBtn.setForeground(Color.BLACK);
//                confirmBtn.setEnabled(false);
//                if (response != JOptionPane.YES_OPTION){
//        confirmBtn.setBackground(new Color(30, 136, 229));
//        confirmBtn.setText("Confirm!");
//                    confirmBtn.setForeground(Color.WHITE);
//                }
//                        }
//                        else {
//                        confirmBtn.setBackground(new Color(30, 136, 229));
//        confirmBtn.setText("Confirm!");
//                confirmBtn.setForeground(Color.WHITE);
//            }
//                    }
