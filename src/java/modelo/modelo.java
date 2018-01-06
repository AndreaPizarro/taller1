/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Duoc UC
 */
public class modelo {

    String indicador;

    private String[] columNames = {"Id", "Valor", "Variación", "Fecha"};
    DefaultTableModel tablemodel = new DefaultTableModel();

    public TableModel listarValor(String Indicador) throws MalformedURLException, IOException {

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Obteniendo variaciones de " + indicador + "...");

        URL url = new URL("http://mindicador.cl/api/" + indicador);
        InputStream is = url.openStream();
        JsonReader rdr = Json.createReader(is);
        JsonObject obj = rdr.readObject();
        Object[][] data = new JsonObject[obj.getJsonArray("serie").size()][4];
        for (int i = 0; i < obj.getJsonArray("serie").size(); i++) {

            data[i][0] = (i + 1);
            data[i][1] = (Integer.parseInt(obj.getJsonArray("serie").getJsonObject(i).get("valor").toString()));
            if (i >= 1) {
                data[i][2] = (Integer.parseInt(obj.getJsonArray("serie").getJsonObject(i).get("valor").toString())) - (Integer.parseInt(obj.getJsonArray("serie").getJsonObject(i - 1).get("valor").toString()));
            } else {
                data[i][2] = "N/A";
            }
            data[i][3] = obj.getJsonArray("serie").getJsonObject(i).get("fecha").toString();
System.out.println("dentro del array");
        }
System.out.println("sali del array");
        return tablemodel;
  

    }
}
