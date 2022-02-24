/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Sebastián Fernández
 */
public class Catalogue {
    //lista con todos los prductos
            //un mapa
    //Map<Integer, Book> myMap = new HashMap<Integer, Book>();
    
    private ArrayList<Book> Catalogue = new ArrayList();
    
    //private Map<Integer, Book> map = new HashMap<>();
    public Catalogue(String path) {
        Reader fileReader = new BookJSONReader();
        fileReader.addItemsFromReader(path, this);
    }

    public ArrayList<Book> getCatalogue() {
            return Catalogue;//new ArrayList<book>(map.values()); //DEVUELVE EL MISMO CATAGALO
   }
    
    private static Catalogue instance;
    
    public static Catalogue getInstance(){
        if(instance == null){
            instance = new Catalogue("C:/Users/Sebastián Fernández/OneDrive - Universidad de Las Palmas de Gran Canaria/Informatica_2021_2022/Segundo Cuatrimestre/PS/Practicas/TiendaDeLibrosOtros/OnlineStore/OnlineStore/books_ulr.json");
        }
        return instance;
    }
    public Book searchCatalogue(String isbn){
        // Set<Integer> values = map.get(ISBN);
        //return map.get(libro.getIsbn()); //new Book();
        for (Book lib : Catalogue) {
            if (lib.getIsbn().equals(isbn))
                return lib;
        }
        return null;
    }
    

    //este solo para persistencia
   public void addProductToCatalogue(Book libro) {
      //anadir al mapa el libro
      Catalogue.add(libro);
    //map.put(libro.getIsbn(),libro); //    map.put(milibro.getISBN(),milibro);
    
   }
   
   //este solo para persistencia
   public void deleteProductFromCatalogue(Book libro) {
    //map.remove(libro.getIsbn());
        Catalogue.remove(libro);
   }
   
   
   
   //despues hacemos un servlet estilo addtocart y aqui en ese servlet usamos los metodos para buscar y tal
   
   //una clase abstracta que hereden addtocart y quitefromcart | esto es lo del patron comand
}
