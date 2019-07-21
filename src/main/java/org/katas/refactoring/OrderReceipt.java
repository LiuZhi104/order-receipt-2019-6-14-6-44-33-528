package org.katas.refactoring;

import java.util.List;

public class OrderReceipt {
    private Order order;
    public static  final  double TAX_RATE=.10;
    public OrderReceipt(Order order) {
        this.order = order;
    }
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        List<LineItem> items = order.getLineItems();
        print(output);
        printCustomerInformation(output);
        printItems(items,output);
        double totalPriceWithoutTax = caculateTotalAmountWithoutTax(items);
        double salesTax = totalPriceWithoutTax*TAX_RATE;
        double totalAmount = totalPriceWithoutTax+salesTax;

        output.append("Sales Tax\t").append(salesTax);
        output.append("Total Amount\t").append(totalAmount);
        return output.toString();
    }

    void print(StringBuilder output){ output.append("======Printing Orders======\n"); }

    void printCustomerInformation(StringBuilder output){
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
    void printItems(List<LineItem> items,StringBuilder output){
        items.stream().forEach(lineItem -> output.append(lineItem.getDescription())
                .append('\t')
                .append(lineItem.getPrice())
                .append('\t')
                .append(lineItem.getQuantity())
                .append('\t')
                .append(lineItem.totalAmount())
                .append('\n'));
    }
    double caculateTotalAmountWithoutTax(List<LineItem> items){
        double totalCost = 0d;
        totalCost = items.stream().mapToDouble(LineItem::totalAmount).sum();
        return totalCost;
    }
}