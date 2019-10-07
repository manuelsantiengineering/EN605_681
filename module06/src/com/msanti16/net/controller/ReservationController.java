package com.msanti16.net.controller;

import com.msanti16.net.services.InputValidationService;
import com.msanti16.net.services.ReservationService;
import com.msanti16.net.view.ReservationGui;
import com.msanti16.net.constants.ReservationConstants;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class ReservationController {

    private ReservationGui reservationGui;
    private ReservationService reservationService;

    public ReservationController(
            ReservationGui reservationGui,
            String serverHost, int port
    ) {
        super();
        this.reservationService = new ReservationService(serverHost, port);
        this.reservationGui = reservationGui;
    }

    public void initController() {
        this.reservationGui.getTxtReservationDay().addKeyListener(
                new InputValidationService()
        );
        this.reservationGui.getTxtReservationMonth().addKeyListener(
                new InputValidationService()
        );
        this.reservationGui.getTxtReservationYear().addKeyListener(
                new InputValidationService()
        );
        this.reservationGui.getComboBoxTours().addActionListener(e -> this.changeValuesAccordingToTour());
        this.reservationGui.getBtnReserve().addActionListener(e -> this.createReservation());
    }

    public void changeValuesAccordingToTour(){
        if(this.reservationGui.getComboBoxTours().getSelectedIndex() == 0){
            this.reservationGui.getComboBoxDuration().removeAllItems();
            this.reservationGui.getLabelCostPerDay().setText("$40.00");
            this.reservationGui.getLabelPremiumCostPerDay().setText("$60.00");
            for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
                this.reservationGui.getComboBoxDuration().addItem(x);
            }
        }else if(this.reservationGui.getComboBoxTours().getSelectedIndex() == 1){
            this.reservationGui.getComboBoxDuration().removeAllItems();
            this.reservationGui.getLabelCostPerDay().setText("$35.00");
            this.reservationGui.getLabelPremiumCostPerDay().setText("$52.50");
            for(int x : ReservationConstants.DURATION_HELLROARING_PLATEAU){
                this.reservationGui.getComboBoxDuration().addItem(x);
            }
        }else if(this.reservationGui.getComboBoxTours().getSelectedIndex() == 2){
            this.reservationGui.getComboBoxDuration().removeAllItems();
            this.reservationGui.getLabelCostPerDay().setText("$45.00");
            this.reservationGui.getLabelPremiumCostPerDay().setText("$67.50");
            for(int x : ReservationConstants.DURATION_BEATEN_PATH){
                this.reservationGui.getComboBoxDuration().addItem(x);
            }
        }
    }

    public void createReservation() {
        if(this.reservationService.createReservation(
                this.reservationGui.getTxtReservationMonth().getText(),
                this.reservationGui.getTxtReservationDay().getText(),
                this.reservationGui.getTxtReservationYear().getText(),
                this.reservationGui.getComboBoxDuration().getItemAt(reservationGui.getComboBoxDuration()
                        .getSelectedIndex()).toString(),
                this.reservationGui.getTxtUsername().getText(),
                this.reservationGui.getComboBoxTours().getSelectedIndex()
        ) == true){
            try {
                this.reservationService.closeSocket();
            }catch(IOException exception){
                System.err.println("Unable to close socket connection");
                System.exit(1);
            }
            System.exit(0);
        }
    }

}
