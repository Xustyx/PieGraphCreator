package com.xsty.Pie;

import java.util.List;

/**
 * Created by XST on 15/01/2018.
 */
public class PieBuilder {

    private Pie pie;
    private PieBuilder parent;
    private PieValuePropagator pieValuePropagator;

    public PieBuilder(String label, double value){
        this(label,value,false);
    }

    public PieBuilder(String label, double value, boolean reversal){
        this(label,value,reversal,null);
    }

    protected PieBuilder(String label, double value, PieBuilder parent){
        this.pie = new Pie(label, value);
        this.pieValuePropagator = new PieValuePropagator(pie);
        this.parent = parent;
    }

    protected PieBuilder(String label, double value, boolean reversal, PieBuilder parent){
        this.pie = new Pie(label, value, reversal);
        this.pieValuePropagator = new PieValuePropagator(pie);
        this.parent = parent;
    }

    public PieBuilder label(String label){
        this.pie.setLabel(label);
        return this;
    }

    public PieBuilder value(double value){
        this.pie.setValue(value);
        return this;
    }

    public PieBuilder addPie(String label, double value){
        this.addPiece(new Pie(label,value));
        return this;
    }

    public PieBuilder addDrillDownPie(String label, double value){
        PieBuilder child = new PieBuilder(label, value, this);
        this.addPiece(child.innerBuild());
        return child;
    }

    public PieBuilder addReversalDrillDownPie(String label, double value){
        PieBuilder child = new PieBuilder(label, value, true,this);
        this.addPiece(child.innerBuild());
        return child;
    }

    public PieBuilder and(){
        return parent != null ? parent: this;
    }

    private Pie innerBuild(){
        return pie;
    }

    public Pie build(){
        this.propagateValues();
        return pie;
    }

    private void addPiece(Pie piece){
        List<Pie> pieces = this.pie.getPieces();
        pieces.add(piece);
    }

    private void propagateValues(){
        this.pieValuePropagator.propagateValue();
    }
}