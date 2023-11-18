


import java.util.*;


public class shoppingcart {
    public static void main(String[] args) {
        List<values> cart = new ArrayList<>();
        cart.add(new values("Leather Wallet", 1100, 18, 1));
        cart.add(new values("Umbrella", 900, 12, 4));
        cart.add(new values("Cigarette", 200, 28, 3));
        cart.add(new values("Honey", 100, 0, 2));

        
        values x = MaxGST(cart);
        System.out.println("Product paid maximum GST amount: " + x.name);

       
        double y = totalamount(cart);
        System.out.println("Total amount to be paid to the shopkeeper: " + y);
    }

    public static values MaxGST(List<values> cart) 
    {
        double maxGSTAmount = 0;
        values maxGSTProduct = null;

        for (values product : cart) 
        {
            double gstAmount = product.GSTAmount();
            if (gstAmount > maxGSTAmount) 
            {
                maxGSTAmount = gstAmount;
                maxGSTProduct = product;
            }
        }

        return maxGSTProduct;
    }

    public static double totalamount(List<values> cart) 
    {
        double total = 0;

        for (values product : cart) 
        {
            total = total + product.discount() + product.GSTAmount();
        }

        return total;
    }
}


class values {
    String name;
    double price;
    double gst;
    double quantity;

    public values(String name, double price, double gst, double quantity) 
    {
        this.name = name;
        this.price = price;
        this.gst = gst;
        this.quantity = quantity;
    }

    public double GSTAmount() 
    {
        double s = (price * gst / 100);
        return  s* quantity;
    }

    public double discount() 
    {
        
        double discount = price * quantity;
            if (price >= 500) 
        {
                discount = discount*0.95; 
        }
    return discount;
    }
}







































