package org.katas.refactoring;
public class OrderReceipt {
    private Order o;
    public OrderReceipt(Order o) {
        this.o = o;
    }
    public void print(StringBuilder output ){
        output.append("======Printing Orders======\n");
    }
    public void printAttributes(StringBuilder output){
        output.append(o.getCustomerName());
        output.append(o.getCustomerAddress());
    }
    public void printLineItem(StringBuilder output){
        double totSalesTx=0;
        double tot=0;
        for (LineItem lineItem : o.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
            double salesTax = lineItem.totalAmount() * .10;
            totSalesTx+= salesTax;
            tot += lineItem.totalAmount() + salesTax;
        }
        output.append("Sales Tax").append('\t').append(totSalesTx);
        output.append("Total Amount").append('\t').append(tot);
    }
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        print(output);
        printAttributes(output);
        printLineItem(output);
        return output.toString();
    }
}