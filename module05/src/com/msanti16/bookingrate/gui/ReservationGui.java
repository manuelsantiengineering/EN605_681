package com.msanti16.bookingrate.gui;




/*
This homework is going to introduce the mythical Beartooth Hiking Company (BHC).
This small tour business will give backpacking tours in the Beartooth-Absaroka wilderness during the summer months of each year.
The owner has decided that he'd like to provide a way for people to get quotes on how much a tour will cost, and has approached you to design a solution.
*/
/*
For this homework, you are to make a window (a JFrame) that will hold controls for allowing a user to set the begin date and duration of a potential tour.
Since making a Web-Start application is no longer an option, you need to learn how to bundle you application in a nice "jar" file so I can see how it works.

1) For this application, you should have controls for:
    - Setting the beginning date (Year, Month,Day)
    - Setting the duration of the hike (note that different hikes have different duration options)
    - Submitting the query (use a JButton)
    - Showing the results (DON'T use a JButton)
    - Total Cost
2) I have provided two classes to assist you in your project:
    - The first class, BookingDay, is a class that allows you to define a single BookingDay. There are two constructors
        . BookingDay() - The first constructor allows the class to be used a a Java Bean in later homeworks.
        . BookingDay(int year, int month, int day) - The second allows you to define a day based on a four digit year, a month (1-Jan, 12-Dec) and a day.
            Take a look at the source code and look at the other methods provided. There is a isValidDate() method to see if the arguments you provided describe a real date.

    - The second class, Rates, is a class that allows you to define a tour period and then get a cost for the tour.
            You need to define a begin date and a duration and then you can get the cost of the tour.
             Don't forget to call isValidDates() to verify that your input dates are within the season and are valid.

3) You are responsible for defensive programming! I should not be able to "break" your application by typing in junk to the input fields.
    In addition, use JOptionPanes to inform the user of what went wrong and how they should fix it.
    Tell them what is wrong! Don't just say an error has occurred without telling them exactly what happened!

4) If you use an awkward style of input (require two digits for a month), you must let the user what you expect them to enter. DO NOT MAKE THEM GUESS.
    Beware GridLayout. Students have been tempted to "slap something together" with GridLayout and it doesn't look very good.
    Put a little thought into your layout. Also be specific with error messages, avoid the "something isn't right" class of message, tell the user what is wrong.

4) Use the values for the hikes that were given in Week 2's homework. You will need someway for a user to select which hike they want and then based on that the duration.
 */

import com.msanti16.bookingrate.constants.ReservationConstants;
import com.msanti16.bookingrate.exceptions.BadBookingDateException;
import com.msanti16.bookingrate.exceptions.BadUserNameException;
import com.msanti16.bookingrate.model.BookingDay;
import com.msanti16.bookingrate.utils.JTextFieldLimit;
import com.msanti16.bookingrate.model.Reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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

    private final static List<Reservation> reservationsList = new ArrayList<Reservation>();

    public ReservationGui(){
        super("Reservation Panel");
        comboBoxTours.addItem(ReservationConstants.TOURS[0]);
        comboBoxTours.addItem(ReservationConstants.TOURS[1]);
        comboBoxTours.addItem(ReservationConstants.TOURS[2]);
        labelCostPerDay.setText("$40");
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
                if(!Character.isDigit(e.getKeyChar())){
                    JOptionPane.showMessageDialog(null, "Please ony use digits","Error", JOptionPane.ERROR_MESSAGE);
                    e.consume();
                }
            }
        });

        txtReservationDay.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar())){
                    JOptionPane.showMessageDialog(null, "Please ony use digits", "Error", JOptionPane.ERROR_MESSAGE);
                    e.consume();
                }
            }
        });

        txtReservationYear.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if(!Character.isDigit(e.getKeyChar())){
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
                    labelCostPerDay.setText("$40");
                    for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
                        comboBoxDuration.addItem(x);
                    }
                }else if(comboBoxTours.getSelectedIndex() == 1){
                    comboBoxDuration.removeAllItems();
                    labelCostPerDay.setText("$35");
                    for(int x : ReservationConstants.DURATION_HELLROARING_PLATEAU){
                        comboBoxDuration.addItem(x);
                    }
                }else if(comboBoxTours.getSelectedIndex() == 2){
                    comboBoxDuration.removeAllItems();
                    labelCostPerDay.setText("$45");
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
                    int year = Integer.parseInt(txtReservationYear.getText());
                    int month = Integer.parseInt(txtReservationMonth.getText());
                    int day = Integer.parseInt(txtReservationDay.getText());
                    BookingDay startDate = new BookingDay(year, month, day);
                    int duration = Integer.parseInt(comboBoxDuration.getItemAt(comboBoxDuration.getSelectedIndex()).toString());
                    String tourName = ReservationConstants.TOURS[comboBoxTours.getSelectedIndex()];

                    reservation.setUsername(txtUsername.getText());
                    reservation.setStartDate(startDate);
                    reservation.setTourName(tourName);
                    reservation.setDuration(duration);
                    reservation.setId(reservationsList.size());

                    JOptionPane.showMessageDialog(null, "Reservation Completed!");
                }catch (BadUserNameException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (BadBookingDateException exception){
                    System.out.println("Error: " + exception);
                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }catch (NumberFormatException exception){
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
