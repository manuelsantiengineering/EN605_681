package com.msanti16.net.view;

import com.msanti16.net.constants.ReservationConstants;
import com.msanti16.net.utils.JTextFieldLimit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationGui extends JFrame {
    private JFrame reservationFrame;
    /* Panels */
    private JPanel panelRootReserve;
    private JPanel panelSouthReserve;
    private JPanel panelEastInputReserve;
    private JPanel panelWestLabelReserve;
    private JPanel panelNorthLabelReserve;

    /* Labels */
    private JLabel labelTitle;
    private JLabel labelReserveDate;
    private JLabel labelName;
    private JLabel labelDuration;
    private JLabel labelTours;
    private JLabel labelCost;
    private JLabel labelPremiumCostPerDay;

    /* User Selections */
    private JTextField txtUsername;
    private JTextField txtReservationMonth;
    private JTextField txtReservationDay;
    private JTextField txtReservationYear;
    private JComboBox comboBoxTours;
    private JComboBox comboBoxDuration;
    private JLabel labelCostPerDay;

    /* Buttons */
    private JButton btnReserve;

    public ReservationGui(String title){
        super(title);
        reservationFrame = new JFrame(title);
        reservationFrame.setContentPane(this.panelRootReserve);
        reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reservationFrame.setVisible(true);

        comboBoxTours.addItem(ReservationConstants.TOURS[0]);
        comboBoxTours.addItem(ReservationConstants.TOURS[1]);
        comboBoxTours.addItem(ReservationConstants.TOURS[2]);
        labelCostPerDay.setText("$40.00");
        labelPremiumCostPerDay.setText("$60.00");
        for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
            comboBoxDuration.addItem(x);
        }

        txtUsername.setDocument(new JTextFieldLimit(56));
        txtReservationMonth.setDocument(new JTextFieldLimit(2));
        txtReservationDay.setDocument(new JTextFieldLimit(2));
        txtReservationYear.setDocument(new JTextFieldLimit(4));

        reservationFrame.pack();

    }



    public JTextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(JTextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public JTextField getTxtReservationMonth() {
        return txtReservationMonth;
    }

    public void setTxtReservationMonth(JTextField txtReservationMonth) {
        this.txtReservationMonth = txtReservationMonth;
    }

    public JTextField getTxtReservationDay() {
        return txtReservationDay;
    }

    public void setTxtReservationDay(JTextField txtReservationDay) {
        this.txtReservationDay = txtReservationDay;
    }

    public JTextField getTxtReservationYear() {
        return txtReservationYear;
    }

    public void setTxtReservationYear(JTextField txtReservationYear) {
        this.txtReservationYear = txtReservationYear;
    }

    public JComboBox getComboBoxTours() {
        return comboBoxTours;
    }

    public void setComboBoxTours(JComboBox comboBoxTours) {
        this.comboBoxTours = comboBoxTours;
    }

    public JComboBox getComboBoxDuration() {
        return comboBoxDuration;
    }

    public void setComboBoxDuration(JComboBox comboBoxDuration) {
        this.comboBoxDuration = comboBoxDuration;
    }

    public JLabel getLabelCostPerDay() {
        return labelCostPerDay;
    }

    public void setLabelCostPerDay(JLabel labelCostPerDay) {
        this.labelCostPerDay = labelCostPerDay;
    }

    public JLabel getLabelPremiumCostPerDay() {
        return labelPremiumCostPerDay;
    }

    public void setLabelPremiumCostPerDay(JLabel labelPremiumCostPerDay) {
        this.labelPremiumCostPerDay = labelPremiumCostPerDay;
    }

    public JButton getBtnReserve() {
        return btnReserve;
    }

    public void setBtnReserve(JButton btnReserve) {
        this.btnReserve = btnReserve;
    }
}
