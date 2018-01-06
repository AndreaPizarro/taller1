/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consola;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.json.*;
import javax.swing.table.DefaultTableModel;
import vista.ventana;
import modelo.modelo;

public class MainIndicadores implements ActionListener, MouseListener {

    private ventana vistaVentana;
    modelo modelo = new modelo();

    private String[] columNames = {"Id", "Valor", "Variación", "Fecha"};
    DefaultTableModel tablemodel = new DefaultTableModel();

    

    public static void main (String [] args) {  
    new ventana().iniciar();
    }
    public enum AccionMVC {
        menuBuscar
    }

    public void iniciar() {
        try {

            vistaVentana.setVisible(true);
        } catch (Exception ex) {
        }
        this.vistaVentana.btnbuscar.setActionCommand("menuBuscar");
        this.vistaVentana.btnbuscar.addActionListener(this);
    }

    public void ActionPerformed(ActionEvent e) throws IOException {

        switch (AccionMVC.valueOf(e.getActionCommand())) {
            case menuBuscar:
                System.out.println("apreto buscar");
                this.vistaVentana.tabla.setModel(this.modelo.listarValor(this.vistaVentana.combobuscar.getSelectedItem().toString().toLowerCase()));
                System.out.println("sali del apretar");
                break;

        }
    }

   

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
