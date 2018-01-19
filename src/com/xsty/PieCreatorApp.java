package com.xsty;

import com.xsty.Pie.Pie;
import com.xsty.Pie.PieBuilder;

/**
 * Created by XST on 15/01/2018.
 */
public class PieCreatorApp {

    public static void main(String[] args) {
        Pie investment =
                new PieBuilder("Investment", 1000)
                        .addDrillDownPie("Hodl", 60)
                            .addReversalDrillDownPie("Top10", 25)
                                .addPie("ETH",1013)
                                .addPie("XRP",537)
                                .addPie("ETH",103)
                            .and()
                            .addReversalDrillDownPie("Top30", 50)
                                .addPie("TRX",5027)
                                .addPie("XRB",2293)
                                .addPie("XVG",1528)
                            .and()
                            .addDrillDownPie("Top100", 25)
                                .addPie("DOGE",9075)
                                .addPie("GNT",5624)
                                .addPie("POWR",4005)
                            .and()
                        .and()
                        .addPie("Speculate", 30)
                        .addPie("Ico", 10)
                    .build();

        System.out.println(investment.toString());
    }
}
