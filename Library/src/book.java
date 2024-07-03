public class book {
    String title;
    String Author;
    int book_code;
    String publisher;
    double price;
    String type;
    book(String title,String Author,String type,int book_code,String publisher,double price){
        this.title=title;
        this.Author=Author;
        this.type=type;
        this.book_code=book_code;
        this.publisher=publisher;
        this.price=price;
    }

    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return Author;
    }
    public  String getType(){
        return type;
    }
    public int getBook_code(){
        return book_code;
    }
    public String getPublisher(){
        return publisher;
    }
    public double getPrice(){
        return price;
    }
}
