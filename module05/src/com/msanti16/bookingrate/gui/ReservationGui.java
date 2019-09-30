package com.msanti16.bookingrate.gui;


/*
    Student Name: Manuel E. Santiago Laboy
    Course: EN.605.681.81.FA19 Principles of Enterprise Web Development
*/
import com.msanti16.bookingrate.constants.ReservationConstants;
import com.msanti16.bookingrate.exceptions.BadBookingDateException;
import com.msanti16.bookingrate.exceptions.BadIntegerParsingException;
import com.msanti16.bookingrate.exceptions.BadUserNameException;
import com.msanti16.bookingrate.exceptions.OutOfSeasonException;
import com.msanti16.bookingrate.model.BookingDay;
import com.msanti16.bookingrate.model.Rates;
import com.msanti16.bookingrate.utils.JTextFieldLimit;
import com.msanti16.bookingrate.model.Reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ReservationGui extends JFrame {
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
    private JLabel labelPremiumCostPerDay;

    private final static List<Reservation> reservationsList = new ArrayList<Reservation>();

    public ReservationGui(){
        super("Reservation Panel");
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

        txtUsername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand());
            }
        });

        txtReservationMonth.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())){
                    JOptionPane.showMessageDialog(null, "Please ony use digits","Error", JOptionPane.ERROR_MESSAGE);
                    e.consume();
                }
            }
        });

        txtReservationDay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())){
                    JOptionPane.showMessageDialog(null, "Please ony use digits", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume();
                }
            }
        });

        txtReservationYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())){
                    JOptionPane.showMessageDialog(null, "Please ony use digits", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume();
                }
            }
        });

        comboBoxTours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(comboBoxTours.getSelectedIndex() == 0){
                    comboBoxDuration.removeAllItems();
                    labelCostPerDay.setText("$40.00");
                    labelPremiumCostPerDay.setText("$60.00");
                    for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
                        comboBoxDuration.addItem(x);
                    }
                }else if(comboBoxTours.getSelectedIndex() == 1){
                    comboBoxDuration.removeAllItems();
                    labelCostPerDay.setText("$35.00");
                    labelPremiumCostPerDay.setText("$52.50");
                    for(int x : ReservationConstants.DURATION_HELLROARING_PLATEAU){
                        comboBoxDuration.addItem(x);
                    }
                }else if(comboBoxTours.getSelectedIndex() == 2){
                    comboBoxDuration.removeAllItems();
                    labelCostPerDay.setText("$45.00");
                    labelPremiumCostPerDay.setText("$67.50");
                    for(int x : ReservationConstants.DURATION_BEATEN_PATH){
                        comboBoxDuration.addItem(x);
                    }
                }
            }

        });

        btnReserve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reservation reservation = new Reservation();
                try{
                    if(txtReservationMonth.getText().isEmpty()){
                        throw new BadIntegerParsingException("Reservation month can't be empty", txtReservationMonth.getText());
                    }
                    if(txtReservationDay.getText().isEmpty()){
                        throw new BadIntegerParsingException("Reservation day can't be empty", txtReservationDay.getText());
                    }
                    if(txtReservationYear.getText().isEmpty()){
                        throw new BadIntegerParsingException("Reservation year can't be empty", txtReservationYear.getText());
                    }

                    int year = Integer.parseInt(txtReservationYear.getText());
                    int month = Integer.parseInt(txtReservationMonth.getText());
                    int day = Integer.parseInt(txtReservationDay.getText());
                    BookingDay startDate = new BookingDay(year, month, day);
                    int duration = Integer.parseInt(comboBoxDuration.getItemAt(comboBoxDuration.getSelectedIndex()).toString());
                    String tourName = ReservationConstants.TOURS[comboBoxTours.getSelectedIndex()];

                    reservation.setUsername(txtUsername.getText());
                    reservation.setTourName(tourName);
                    reservation.setStartDate(startDate);
                    reservation.setDuration(duration);
                    reservation.setId(reservationsList.size());
                    reservation.setCreatedAt(new Date());

                    Rates rates;
                    switch (comboBoxTours.getSelectedIndex()){
                        case 1:
                            rates = new Rates(Rates.HIKE.HELLROARING);
                            break;
                        case 2:
                            rates = new Rates(Rates.HIKE.BEATEN);
                            break;
                        case 0:
                        default:
                            rates = new Rates(Rates.HIKE.GARDINER);
                            break;
                    }
                    rates.setBeginDate(reservation.getStartDate());
                    rates.setDuration(duration);

                    if(!rates.isValidDates()){
                        throw new OutOfSeasonException("Selected dates are out of the season.");
                    }

                    System.out.println("Begin Date: " );
                    System.out.println("Rate: " + rates.getBaseRate());
                    System.out.println("Cost: " + rates.getCost());

                    reservation.setTotalCost(rates.getCost());

                    JOptionPane.showMessageDialog(null, "Reservation Completed!\n" + reservation);
                }catch (BadUserNameException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (BadBookingDateException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (BadIntegerParsingException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (OutOfSeasonException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame reservationFrame = new JFrame("Reservation Form");
        reservationFrame.setContentPane(new ReservationGui().panelRootReserve);
        reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reservationFrame.pack();
        reservationFrame.setVisible(true);
    }

}
