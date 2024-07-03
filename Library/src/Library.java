import java.util.HashMap;

public class Library extends Main{
    HashMap<Integer,book> library=new HashMap<>();
    HashMap<String,book> library1=new HashMap<>();
    HashMap<String,book> Rental=new HashMap<>();
    HashMap<String,book> Buy=new HashMap<>();

    public Library(){
    }

    public void addBook(){
        System.out.println("Please enter the book name: ");
        String name= input.nextLine();
        System.out.println("Please enter the author of the book: ");
        String author= input.nextLine();
        System.out.println("Please enter the type of the book: ");
        String type= input.nextLine();
        System.out.println("Please enter the book code: ");
        int book_code= input.nextInt();
        input.nextLine();
        System.out.println("Please enter the publisher of the book: ");
        String publisher= input.nextLine();
        System.out.println("Please enter the price of the book: ");
        double price= input.nextDouble();
        input.nextLine();
        book book1=new book(name,author,type,book_code,publisher,price);
        library.put(book_code,book1);
        library1.put(name,book1);
        System.out.println("Book is successfully added into library!");
    }
    public void searchViaBookCode(){
        System.out.println("Please enter the book code: ");
        int book_code= input.nextInt();
        input.nextLine();
        if(library.containsKey(book_code)){
            System.out.println("The book is available in our library!");
            book ext_book=library.get(book_code);
            System.out.println("Book Name: "+ext_book.getTitle());
            System.out.println("Author: "+ext_book.getAuthor());
            System.out.println("Book Type: "+ext_book.getType());
            System.out.println("Publisher: "+ext_book.getPublisher());
            System.out.println("Price of the book: "+ext_book.getPrice());
        }else{
            System.out.println("The book is unfortunately is not available in our library!");
        }
    }
    public void searchViaBookName(){
        System.out.println("Please enter the book name: ");
        String book_name= input.next();
        if(library1.containsKey(book_name)){
            System.out.println("The book is available in our library!");
            book ext_book=library1.get(book_name);
            System.out.println("Book Name: "+ext_book.getTitle());
            System.out.println("Author: "+ext_book.getAuthor());
            System.out.println("Book Type: "+ext_book.getType());
            System.out.println("Book Code: "+ext_book.getBook_code());
            System.out.println("Publisher: "+ext_book.getPublisher());
            System.out.println("Price of the book: "+ext_book.getPrice());
        }else{
            System.out.println("The book is unfortunately is not available in our library!");
        }
    }
    public void ShowBooks(){
        if(library.isEmpty()){
            System.out.println("The library is empty!");
        }else{
            System.out.println("The available books are: ");
            for(book book:library.values()){
                System.out.println("Book Name: "+book.getTitle()+" Author: "+book.getAuthor()+" Book Code: "+book.getBook_code()+" Price: "+book.getPrice()+"$");}
        }
    }
    public void rentABook(){
        if(library.isEmpty()){
            System.out.println("The library is empty!");
        }else{
            System.out.println("Which book would you like to rent or buy? (For Renting press 0 and For Buying press 1)");
            int opx2= input.nextInt();
            input.nextLine();
            if(opx2==0){
                System.out.println("Book Name: ");
                String boname=input.nextLine();
                book book=library1.get(boname);
                Rental.put(boname,library1.get(boname));
                library.remove(book.getBook_code());
                library1.remove(boname);
                for(book book1:Rental.values()){
                    System.out.println("The Rented Books:\nBook Name: "+book1.getTitle()+" Author: "+book1.getAuthor()+" Book Code: "+book1.getBook_code()+" Price: "+book1.getPrice()+"$");}
            }if (opx2==1){
                System.out.println("Book Name: ");
                String boname=input.nextLine();
                book book=library1.get(boname);
                Buy.put(boname,library1.get(boname));
                library.remove(book.getBook_code());
                library1.remove(boname);
                for(book book1:Buy.values()){
                    System.out.println("The Bought Books:\nBook Name: "+book1.getTitle()+" Author: "+book1.getAuthor()+" Book Code: "+book1.getBook_code()+" Price: "+book1.getPrice()+"$");}
            }
        }
    }
    public void run(){
        while(true){
            System.out.println("Welcome to EMU Library");
            System.out.println("To see the available books press 1");
            System.out.println("To add a book into system press 2 and To search a book press 3.\nTo Rent or Buy a book press 4\nTo return to Main Page press 5\nTo Exit press 0!");
            int op= input.nextInt();
            input.nextLine();

            switch(op){
                case 1: ShowBooks(); break;
                case 2: addBook(); break;
                case 3:
                    System.out.println("To search a book via code press 1 and To search a book via name press 2");
                    int opx= input.nextInt();
                    input.nextLine();
                    if(opx==1)
                        searchViaBookCode();
                    else if (opx==2)
                        searchViaBookName();
                    else System.out.println("Invalid option!");
                    break;
                case 4: rentABook(); break;
                case 5: return;
                case 0: break;
                default: System.out.println("Enter valid operation, try again! "); break;
            }
        }
    }
}
