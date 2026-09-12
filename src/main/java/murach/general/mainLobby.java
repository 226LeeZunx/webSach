
package murach.general;

import java.util.ArrayList;
import java.util.List;
import murach.entity.Book;
import murach.entity.typeBook;

public class mainLobby {
    List<typeBook>nowLobby;

    
    public mainLobby() {
        List<Book> webBooks = new ArrayList<>(List.of(
            new Book("B01", "HTML and CSS", "anh1.png", "2024-01-01","T01","anh1.png"),
            new Book("B02", "JavaScript for Web", "anh2.png", "2024-01-02","T01","anh2.png"),
            new Book("B03", "Spring Boot in Action", "anh3.png", "2024-01-03","T01","anh3.png")
        ));
        typeBook webType = new typeBook("T01", "Web", "2024-01-01");
        webType.setBooks(webBooks);

        List<Book> langBooks = new ArrayList<>(List.of(
            new Book("B04", "English Grammar", "anh6.png", "2024-02-01","T02","anh6.png"),
            new Book("B05", "Minna no Nihongo", "anh7.png", "2024-02-02","T02","anh7.png"),
            new Book("B06", "TOEIC Preparation", "anh8.png", "2024-02-03","T02","anh8.png")
        ));
        typeBook langType = new typeBook("T02", "Foreign Language", "2024-02-01");
        langType.setBooks(langBooks);

        List<Book> mathBooks = new ArrayList<>(List.of(
            new Book("B07", "Calculus I", "anh9.png", "2024-03-01","T03","anh9.png"),
            new Book("B08", "Linear Algebra", "anh10.png", "2024-03-02","T03","anh10.png"),
            new Book("B09", "Discrete Mathematics", "anh11.png", "2024-03-03","T03","anh11.png")
        ));
        typeBook mathType = new typeBook("T03", "Math", "2024-03-01");
        mathType.setBooks(mathBooks);

        List<Book> coreBooks = new ArrayList<>(List.of(
            new Book("B10", "Data Structures & Algorithms", "anh4.png", "2024-04-01","T04","anh4.png"),
            new Book("B11", "Operating Systems", "anh5.png", "2024-04-02","T04","anh5.png"),
            new Book("B12", "Computer Networks", "anh12.png", "2024-04-03","T04","anh12.png")
        ));
        typeBook coreType = new typeBook("T04", "Co so nganh", "2024-04-01");
        coreType.setBooks(coreBooks);

        this.nowLobby = new ArrayList<>(List.of(
            webType, langType, mathType, coreType
        ));
        
    }

    public List<typeBook> getNowLobby() {
        return nowLobby;
    }

    public void setNowLobby(List<typeBook> nowLobby) {
        this.nowLobby = nowLobby;
    }
    public typeBook gettypeBookbyID(String id){
        return  this.nowLobby.stream().filter(u->u.getId().equals(id)).findFirst().orElse(null);
        
    }
    
}

