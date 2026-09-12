package murach.entity;

import java.util.List;

public class typeBook {
    private String id ;
    private String typeName;
    private List<Book> books;
    private String create_date;

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    
    

    public typeBook(String id, String typeName, String create_date) {
        this.id = id;
        this.typeName = typeName;
        this.create_date = create_date;
    }

    public String getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }
    
}
