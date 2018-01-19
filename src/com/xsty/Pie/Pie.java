package com.xsty.Pie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XST on 15/01/2018.
 */
public class Pie {
    private String label;
    private double value;
    private boolean reversal;
    private List<Pie> pieces = new ArrayList<Pie>();

    protected Pie(){

    }

    public Pie(String label, double value){
        this.label = label;
        this.value = value;
    }

    public Pie(String label, double value, boolean reversal){
        this.label = label;
        this.value = value;
        this.reversal = reversal;
    }

    public String getLabel(){
        return this.label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public double getValue(){
        return this.value;
    }

    public void setValue(double value){
        this.value = value;
    }

    public List<Pie> getPieces(){
        return this.pieces;
    }

    public boolean isReversal() {
        return reversal;
    }

    public void setReversal(boolean reversal) {
        this.reversal = reversal;
    }

    public String toString(){
        String piecesStr = "";

        for(Pie pie: pieces){
            piecesStr += pie.toString() + ",";
        }

        piecesStr = piecesStr.length() > 0 ? piecesStr.substring(0, piecesStr.length() -1) : piecesStr;

        return "{\"label\":\""+ this.label +"\",\"value\":" + this.value + ",\"pieces\":[" + piecesStr + "]}";
    }
}