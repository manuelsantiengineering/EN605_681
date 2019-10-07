package com.msanti16.net.view;

import com.msanti16.net.constants.ReservationConstants;
import com.msanti16.net.utils.JTextFieldLimit;

import javax.swing.*;

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
        this.reservationFrame = new JFrame(title);
        this.reservationFrame.setContentPane(this.panelRootReserve);
        this.reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.reservationFrame.setVisible(true);

        this.comboBoxTours.addItem(ReservationConstants.TOURS[0]);
        this.comboBoxTours.addItem(ReservationConstants.TOURS[1]);
        this.comboBoxTours.addItem(ReservationConstants.TOURS[2]);
        this.labelCostPerDay.setText("$40.00");
        this.labelPremiumCostPerDay.setText("$60.00");
        for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
            this.comboBoxDuration.addItem(x);
        }

        this.txtUsername.setDocument(new JTextFieldLimit(56));
        this.txtReservationMonth.setDocument(new JTextFieldLimit(2));
        this.txtReservationDay.setDocument(new JTextFieldLimit(2));
        this.txtReservationYear.setDocument(new JTextFieldLimit(4));

        this.reservationFrame.pack();
    }

    public JFrame getReservationFrame() {
        return reservationFrame;
    }

    public JTextField getTxtUsername() {
        return this.txtUsername;
    }

    public JTextField getTxtReservationMonth() {
        return this.txtReservationMonth;
    }

    public JTextField getTxtReservationDay() {
        return this.txtReservationDay;
    }

    public JTextField getTxtReservationYear() {
        return this.txtReservationYear;
    }

    public JComboBox getComboBoxTours() {
        return this.comboBoxTours;
    }

    public JComboBox getComboBoxDuration() {
        return this.comboBoxDuration;
    }

    public JLabel getLabelCostPerDay() {
        return this.labelCostPerDay;
    }

    public JLabel getLabelPremiumCostPerDay() {
        return this.labelPremiumCostPerDay;
    }

    public JButton getBtnReserve() {
        return this.btnReserve;
    }

}
