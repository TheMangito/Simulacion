package com.example.simulacion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.time.LocalDate;
import java.util.Objects;
import java.util.function.UnaryOperator;

public class HelloController {
    @FXML private TextField x0;
    @FXML private Button comenzar;
    @FXML private TextField y0;
    @FXML private TextField iteraciones;
    @FXML private TableView<PseudoNumber> table;
    @FXML private TableColumn<PseudoNumber , Integer> iteracionesCol;
    @FXML private TableColumn<PseudoNumber , Integer> xCol;
    @FXML private TableColumn<PseudoNumber , Integer> zCol;
    @FXML private TableColumn<PseudoNumber , Double> decimalesCol;
    @FXML private Label zValue;
    private int x0Value;
    private int y0Value;
    private int iteracionesValue;
    private int largo;

    public void initialize(){
        iteracionesCol.setCellValueFactory(new PropertyValueFactory<PseudoNumber, Integer>("Iteracion"));
        xCol.setCellValueFactory(new PropertyValueFactory<PseudoNumber, Integer>("Valor_X"));
        zCol.setCellValueFactory(new PropertyValueFactory<PseudoNumber, Integer>("Valor_Z"));
        decimalesCol.setCellValueFactory(new PropertyValueFactory<PseudoNumber, Double>("Decimal"));

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        iteraciones.setTextFormatter(new TextFormatter<>(filter));
        y0.setTextFormatter(new TextFormatter<>(filter));
        x0.setTextFormatter(new TextFormatter<>(filter));
    }
    public static String extraerCaracteres(String numero, int cantidadCaracteres) {
        // Verificar si el número es lo suficientemente largo
        if (numero.length() > 2) {
            // Omitir los últimos 2 dígitos
            numero = numero.substring(0, numero.length() - 2);
        } else {
            // Si el número tiene 2 dígitos o menos, se convierte en vacío
            numero = "";
        }

        // Calcular la cantidad de ceros necesarios
        int cerosNecesarios = Math.max(cantidadCaracteres - numero.length(), 0);

        // Crear una cadena de ceros
        String ceros = new String(new char[cerosNecesarios]).replace("\0", "0");

        // Extraer los caracteres deseados y añadir ceros si es necesario
        String resultado = (numero.length() >= cantidadCaracteres) ? numero.substring(numero.length() - cantidadCaracteres) : ceros + numero;

        return resultado;
    }
    public void comenzar(){
        if (!Objects.equals(iteraciones.getText(), "") && !Objects.equals(x0.getText(), "") && !Objects.equals(y0.getText(), "")){
            largo = x0.getLength();
            iteracionesValue = Integer.parseInt(iteraciones.getText());
            x0Value = Integer.parseInt(x0.getText());
            y0Value = Integer.parseInt(y0.getText());
            int xant = x0Value;
            int zant = x0Value*y0Value;
            zValue.setText(String.valueOf(zant));
            int divisor= (int) Math.pow(10, largo);

            for (int i = 1; i<=iteracionesValue;i++){
                int x =  Integer.parseInt(extraerCaracteres(String.valueOf(zant), largo));
                int z = x*xant;
                float decimal = (float) x /(divisor);
                PseudoNumber number = new PseudoNumber(i, x, z, decimal);
                this.table.getItems().add(number);
                xant = x;
                zant = z;
            }
        }

    }

}
