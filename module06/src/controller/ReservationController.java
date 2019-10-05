package controller;

import com.msanti16.net.domain.BookingDay;
import com.msanti16.net.domain.Reservation;
import com.msanti16.net.exceptions.BadBookingDateException;
import com.msanti16.net.exceptions.BadIntegerParsingException;
import com.msanti16.net.exceptions.BadUserNameException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ReservationController implements ActionListener {
    private final static List<Reservation> reservationsList = new ArrayList<Reservation>();

    private JTextField txtUsername = new JTextField();
    private JTextField txtReservationMonth = new JTextField();
    private JTextField txtReservationDay = new JTextField();
    private JTextField txtReservationYear = new JTextField();
    private JComboBox comboBoxTours = new JComboBox();
    private JComboBox comboBoxDuration = new JComboBox();

    Reservation reservation = new Reservation();

    public ReservationController(JTextField txtUsername,
                                 JTextField txtReservationYear,
                                 JTextField txtReservationMonth,
                                 JTextField txtReservationDay,
                                 JComboBox comboBoxTours,
                                 JComboBox comboBoxDuration
                                 ) {
        super();
        System.out.println("CREATING the Reservation Controller");
        this.txtUsername = txtUsername;
        this.txtReservationYear = txtReservationYear;
        this.txtReservationMonth = txtReservationMonth;
        this.txtReservationDay = txtReservationDay;
        this.comboBoxTours = comboBoxTours;
        this.comboBoxDuration = comboBoxDuration;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

            reservation.setUsername(txtUsername.getText());
            reservation.setTourName(comboBoxTours.getSelectedIndex());
            reservation.setStartDate(startDate);
            reservation.setDuration(duration);
            reservation.setId(reservationsList.size());
            reservation.setCreatedAt(new Date());

//                    Rates rates;
//                    switch (comboBoxTours.getSelectedIndex()){
//                        case 1:
//                            rates = new Rates(Rates.HIKE.HELLROARING);
//                            break;
//                        case 2:
//                            rates = new Rates(Rates.HIKE.BEATEN);
//                            break;
//                        case 0:
//                        default:
//                            rates = new Rates(Rates.HIKE.GARDINER);
//                            break;
//                    }
//                    rates.setBeginDate(reservation.getStartDate());
//                    rates.setDuration(duration);
//
//                    if(!rates.isValidDates()){
//                        throw new OutOfSeasonException("Selected dates are out of the season.");
//                    }
//
//                    System.out.println("Begin Date: " );
//                    System.out.println("Rate: " + rates.getBaseRate());
//                    System.out.println("Cost: " + rates.getCost());
//
//                    reservation.setTotalCost(rates.getCost());
            reservation.setTotalCost(9999999.99);

            reservationsList.add(reservation);

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
        }
//                catch (OutOfSeasonException exception){
////                    System.out.println("Error: " + exception);
////                    JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
////                }
    }


}
