package ca.bcit.cheong_ho.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.bcit.cheong_ho.enums.ISBNType;

public class IndustryIdentifiers {
    private List<ISBN>  isbnList;

    public IndustryIdentifiers() {
        isbnList = new ArrayList<>();
    }

    public IndustryIdentifiers(List<ISBN> isbnList) {
        this.isbnList = isbnList;
    }

    public void addISBN(ISBN newISBN) {
        isbnList.add(newISBN);
    }

    public List<ISBN> getIsbnList() {
        return isbnList;
    }

    public List<ISBN> getISBN(ISBNType type) {
        List<ISBN> typeList = new ArrayList<>();
        Iterator<ISBN> it = typeList.iterator();
        while (it.hasNext()) {
            ISBN temp = it.next();
            if (temp.getType() == type) {
                typeList.add(temp);
            }
        }
        return typeList;
    }
}
