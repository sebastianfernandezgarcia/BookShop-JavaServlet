package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Sebastián Fernández
 */
public class Cart {
    
    //private ArrayList<book> carrito = new ArrayList<>(); 

    //private ArrayList carro = new ArrayList();
    
    
        //private HashMap<String, Integer> carrito = new HashMap<>();
    private Map<Book, Integer> carrito = new HashMap<>();

    
    public Map<Book, Integer> getCart() {
        return carrito;
    }
           
    public void addToCart(Book book){
        if(carrito.containsKey(book)) 
            carrito.put(book, carrito.get(book) + 1); //si ya esta en carrito, sumamos su cantidad
        
        if(! carrito.containsKey(book))
            carrito.put(book,1);
    
    }
    
    public void deleteFromCart(Book book){
        //carrito.remove(libro); 
        
        if(carrito.containsKey(book))
            if(carrito.get(book) > 1)
                carrito.put(book, carrito.get(book)-1);  
        
            if(carrito.get(book)==1)
                carrito.remove(book);
        }

     
    public void emptyCart(){
        carrito.clear();
    }
    
    public Integer getUnitsBook(Book book) {
        return carrito.get(book);
    }
    //REVISTAR ESTO
    //dinvvdin
    public double getTotalPrice()
    {
        double total = 0;
        for (Book libro : carrito.keySet()) {
            //Book libro = Catalogue.getInstance().searchCatalogue(id);
            total += libro.getPrice() * carrito.get(libro);

        }
        return (double)Math.round(total * 100d) / 100d;
    }
    
    
    public double getTotalPriceWithIgic(){
        double total = getTotalPrice()+ getTotalPrice()*0.07;
        return (double)Math.round(total * 100d) / 100d;
    }
    
    
}
