package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BookJSONReader implements Reader {
    
    @Override
    public void addItemsFromReader(String path, Catalogue catalog) {
        JSONParser jsonParser;
        jsonParser = new JSONParser();
         
        try (FileReader reader = new FileReader(path))
        {
            Object obj = jsonParser.parse(reader);
            JSONArray bookList = (JSONArray) obj;
            for ( Object book : bookList) {
                JSONObject bookObj = (JSONObject) book;
                float price = (float) Math.round(Math.random() * (30 - 60) + 30 * 100)/100;
                bookObj.put("price", Float.toString(price));
                catalog.addProductToCatalogue(parseObject(bookObj));
            }
 
        } catch (FileNotFoundException e) {
        } catch (IOException | ParseException e) {
        }
    }

    private Book parseObject(JSONObject book) {
        Book newBook;
        newBook =  new Book((String) book.get("title"), (String) book.get("isbn"),
                 (String) book.get("thumbnailUrl"),(JSONArray) book.get("authors"),
                Float.parseFloat((String) book.get("price")));
       
        return newBook;
    }
}
