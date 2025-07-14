public class AdminService {
    private String  currentuser=null;
    public void addBook(String name,int bookid,String author,int publishyear,int totalbook){
        bookService bookService=new bookService();
        bookService.booklist.add(new Book(name,bookid,author,publishyear,totalbook));
        System.out.println("Book added successfully");
        for (Book book: bookService.booklist){
            System.out.println(book);
        }
    }
    public void logoutAdmin(){
        if (currentuser!=null){
            System.out.println("Logout out"+currentuser);
        }
        currentuser=null;

    }
    public boolean isLoggedIn(){
        return currentuser!=null;
    }
    public boolean login(String username,String password){

        currentuser=username;
        System.out.println("Welcome "+currentuser);
        return true;
    }


}
