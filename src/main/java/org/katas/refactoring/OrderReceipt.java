package org.katas.refactoring;
public class OrderReceipt {
    private Order o;
    public void print(StringBuilder output ){
        output.append("======Printing Orders======\n");
    }
    public void printAttributes(StringBuilder output){
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
    }
    public static double CalculateSalesTax(LineItem lineItem, double totSalesTx){
        double salesTax = lineItem.totalAmount() * .10;
        totSalesTx+= salesTax;
        return  totSalesTx;
    }
    public static  double calculateTotalAmount(LineItem lineItem,double tot){
        double salesTax = lineItem.totalAmount() * .10;
        tot += lineItem.totalAmount() + salesTax;
        return tot;
    }

    public void printLineItem(StringBuilder output){
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
            double totSalesTx=OrderReceipt.CalculateSalesTax(lineItem,0d);
            double tot=OrderReceipt.calculateTotalAmount(lineItem,0d);
            output.append("Sales Tax").append('\t').append(totSalesTx);
            output.append("Total Amount").append('\t').append(tot);
        }
    }
    public OrderReceipt(Order o) {
        this.o = o;
    }
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        print(output);
        printAttributes(output);
        printLineItem(output);
        return output.toString();
    }
}