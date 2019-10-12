package com.msanti16.servlet.services;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputValidationService extends KeyAdapter {

    @Override
    public void keyTyped(KeyEvent e){
        this.validateDigitValues(e);
    }


    public static void validateDigitValues(KeyEvent e){
        if(!Character.isDigit(e.getKeyChar()) && !Character.isISOControl(e.getKeyChar())){
            JOptionPane.showMessageDialog(null, "Please ony use digits", "Error", JOptionPane.ERROR_MESSAGE);
            e.consume();
        }
    }

}
