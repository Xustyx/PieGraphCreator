package com.xsty.Pie;

/**
 * Created by XST on 15/01/2018.
 */
public class PieValuePropagator {

    private Pie pie;

    double sum = 0;
    double product = 0;
    double productSum = 0;

    public PieValuePropagator(Pie pie){
        this.pie = pie;
    }

    public void propagateValue(){

        if(!pie.isReversal())
            sum = this.childPieSum();
        else {
            product = this.childPieProduct();
            productSum = this.childPieProductSum();
        }

        for (Pie piece: this.pie.getPieces()) {
            piece.setValue(proportionalValue(piece));
            doPropagate(piece);
        }
    }

    private void doPropagate(Pie piece){
        PieValuePropagator pieValuePropagator = new PieValuePropagator(piece);
        pieValuePropagator.propagateValue();
    }

    private double proportionalValue(Pie piece){
        if(pie.isReversal())
            return inverselyProportionalReasoning(piece);

        return directlyProportionalReasoning(piece);
    }

    private double directlyProportionalReasoning(Pie piece){
        return (pie.getValue() / sum) * piece.getValue();
    }

    private double inverselyProportionalReasoning(Pie piece){
        return (pie.getValue() / productSum) * (product / piece.getValue());
    }

    private double childPieProductSum(){
        double sum = 0;

        for(Pie piece: this.pie.getPieces()){
            sum += (product / piece.getValue());
        }

        return sum;
    }

    private double childPieSum(){
        double total = 0;

        for (Pie piece: this.pie.getPieces()) {
            total += piece.getValue();
        }

        return total;
    }


    private double childPieProduct(){
        double product = 1;

        for(Pie piece: this.pie.getPieces()){
            product *= piece.getValue();
        }

        return product;
    }
}
