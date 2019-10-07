package controller;

import com.msanti16.net.services.InputValidationService;
import com.msanti16.net.services.ReservationService;
import com.msanti16.net.view.ReservationGui;
import com.msanti16.net.constants.ReservationConstants;

public class ReservationController {

    private ReservationGui reservationGui;
    private ReservationService reservationService;

    public ReservationController(
            ReservationGui reservationGui,
            String serverHost, int port
    ) {
        super();
        reservationService = new ReservationService(serverHost, port);
        this.reservationGui = reservationGui;
    }

    public void initController() {
        reservationGui.getTxtReservationDay().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getTxtReservationMonth().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getTxtReservationYear().addKeyListener(
                new InputValidationService()
        );
        reservationGui.getComboBoxTours().addActionListener(e -> this.changeValuesAccordingToTour());
        reservationGui.getBtnReserve().addActionListener(e -> this.createReservation());
    }

    public void changeValuesAccordingToTour(){
        if(reservationGui.getComboBoxTours().getSelectedIndex() == 0){
            reservationGui.getComboBoxDuration().removeAllItems();
            reservationGui.getLabelCostPerDay().setText("$40.00");
            reservationGui.getLabelPremiumCostPerDay().setText("$60.00");
            for(int x : ReservationConstants.DURATION_GARDINER_LAKE){
                reservationGui.getComboBoxDuration().addItem(x);
            }
        }else if(reservationGui.getComboBoxTours().getSelectedIndex() == 1){
            reservationGui.getComboBoxDuration().removeAllItems();
            reservationGui.getLabelCostPerDay().setText("$35.00");
            reservationGui.getLabelPremiumCostPerDay().setText("$52.50");
            for(int x : ReservationConstants.DURATION_HELLROARING_PLATEAU){
                reservationGui.getComboBoxDuration().addItem(x);
            }
        }else if(reservationGui.getComboBoxTours().getSelectedIndex() == 2){
            reservationGui.getComboBoxDuration().removeAllItems();
            reservationGui.getLabelCostPerDay().setText("$45.00");
            reservationGui.getLabelPremiumCostPerDay().setText("$67.50");
            for(int x : ReservationConstants.DURATION_BEATEN_PATH){
                reservationGui.getComboBoxDuration().addItem(x);
            }
        }
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
