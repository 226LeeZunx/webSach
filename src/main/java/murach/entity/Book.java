package murach.entity;
public class Book {
    private String id;
    private String bookName;
    private String path;
    private String createDate;
    private String typeId;
    private String imagePath;
    
    public Book(String id, String bookName, String path, String createDate, String typeId,String imagePath) {
        this.id = id;
        this.bookName = bookName;
        this.path = path;
        this.createDate = createDate;
        this.typeId = typeId;
        this.imagePath=imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }
    
    public String getTypeId() { return typeId; }
    public void setTypeId(String typeId) { this.typeId = typeId; }

    public String getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getPath() {
        return path;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    
    
    
    
}
