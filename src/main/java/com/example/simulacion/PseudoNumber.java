package com.example.simulacion;

public class PseudoNumber {
    private int Iteracion;
    private int Valor_X;
    private int Valor_Z;
    private float decimal;

    public PseudoNumber(int Iteracion, int Valor_X, int Valor_Z, float decimal) {
        this.Iteracion = Iteracion;
        this.Valor_X = Valor_X;
        this.Valor_Z = Valor_Z;
        this.decimal = decimal;
    }
    public int getIteracion() {
        return Iteracion;
    }

    public void setIteracion(int Iteracion) {
        this.Iteracion = Iteracion;
    }

    public int getValor_X() {
        return Valor_X;
    }

    public void setValor_X(int Valor_X) {
        this.Valor_X = Valor_X;
    }

    public int getValor_Z() {
        return Valor_Z;
    }

    public void setValor_Z(int Valor_Z) {
        this.Valor_Z = Valor_Z;
    }

    public float getDecimal() {
        return decimal;
    }

    public void setDecimal(float decimal) {
        this.decimal = decimal;
    }
}
