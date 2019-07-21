package org.katas.refactoring;
public class OrderReceipt {
    private Order order;
    public static  final  double TAX_RATE=.10;
    private double totalSaleTax=0d;
    private  double totalCost=0d;
    public OrderReceipt(Order order) {
        this.order = order;
    }
    public void print(StringBuilder output ){
        output.append("======Printing Orders======\n");
    }
    public void printAttributes(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }

    public void printLineItems(StringBuilder output){
        for (LineItem lineItem:order.getLineItems()) {
            printOrder(output,lineItem);
            double salesTax=lineItem.totalAmount()*TAX_RATE;
            totalSaleTax+=salesTax;
            totalCost+=lineItem.totalAmount()+salesTax;
        }

    }
    public void printOrder(StringBuilder output,LineItem lineItem){
        output.append(lineItem.getDescription());
        output.append('\t');
        output.append(lineItem.getPrice());
        output.append('\t');
        output.append(lineItem.getQuantity());
        output.append('\t');
        output.append(lineItem.totalAmount());
        output.append('\n');
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        print(output);
        printAttributes(output);
        printLineItems(output);
        output.append("Sales Tax").append('\t').append(totalSaleTax);
        output.append("Total Amount").append('\t').append(totalCost);
        return output.toString();
    }
}