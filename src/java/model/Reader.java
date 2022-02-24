package model;

import model.Catalogue;

public interface Reader {
    void addItemsFromReader(String path, Catalogue catalog);
}
