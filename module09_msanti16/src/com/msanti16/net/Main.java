/*
    Student Name: Manuel E. Santiago Laboy
    Course: EN.605.681.81.FA19 Principles of Enterprise Web Development
*/

package com.msanti16.net;

import com.msanti16.net.view.ReservationGui;
import com.msanti16.net.controller.ReservationController;

import javax.swing.*;
import java.io.IOException;

//TODO throw error for out of the season exception.
//TODO throw alerts

public class Main {
    private static final String SERVER_HOST = "web7.jhuep.com";
    private static final int    PORT = 20025;

    public static void main(String[] args) throws IOException {
        System.out.println("EN.605.681.81.FA19 Principles of Enterprise Web Development");
        System.out.println("Module 6 Homework");
        System.out.println("Manuel E. Santiago Laboy");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public static void createAndShowGUI() throws NullPointerException {
        try {
            ReservationGui reservationGui = new ReservationGui( "Reservation Panel");
            ReservationController reservationController =
                    new ReservationController( reservationGui, SERVER_HOST, PORT);
            reservationController.initController();
        } catch (NullPointerException exception){
            System.out.println("Unable to create UI");
            exception.printStackTrace();
        }
    }

}
