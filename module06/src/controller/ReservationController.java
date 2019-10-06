package controller;

import com.msanti16.net.domain.BookingDay;
import com.msanti16.net.domain.Reservation;
import com.msanti16.net.exceptions.BadBookingDateException;
import com.msanti16.net.exceptions.BadIntegerParsingException;
import com.msanti16.net.exceptions.BadUserNameException;
import com.msanti16.net.services.InputValidationService;
import com.msanti16.net.services.ReservationService;
import com.msanti16.net.view.ReservationGui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class ReservationController {

    private ReservationGui reservationGui;

    /* Model */
    ReservationService reservationService;

    public ReservationController(
            ReservationGui reservationGui,
            String serverHost, int port
    ) {
        super();
        System.out.println("CREATING the Reservation Controller");
        reservationService = new ReservationService(serverHost, port);
        this.reservationGui = reservationGui;
    }

    public void initController() {
        System.out.println("Initiating the Reservation Controller");
        reservationGui.getTxtReservationDay().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getTxtReservationMonth().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getTxtReservationYear().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getBtnReserve().addActionListener(e -> this.createReservation());
    }

    public void createReservation() {
        reservationService.createReservation(
                reservationGui.getTxtReservationMonth().getText(),
                reservationGui.getTxtReservationDay().getText(),
                reservationGui.getTxtReservationYear().getText(),
                reservationGui.getComboBoxDuration().getItemAt(reservationGui.getComboBoxDuration()
                        .getSelectedIndex()).toString(),
                reservationGui.getTxtUsername().getText(),
                reservationGui.getComboBoxTours().getSelectedIndex()
        );
    }








}
