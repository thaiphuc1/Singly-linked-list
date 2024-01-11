/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;
import Model.Book;
import View.Menu;
import Controller.NodeBook;

/**
 *
 * @author thaip
 */
public class Main extends Menu<String>{
    private static String[] mc = {"Print all book","Add book","Remove book","Search book", "Exit"};
    NodeBook node = new NodeBook();
    public Main(){
        super("CSD ASSIGNMENT 1", mc);
    }
    
    public static void main(String[] args) {
        new Main().run();
    }
    
    @Override
    public void execute(int ch) {
        
        
        
        switch(ch){
            case 1: print();break;
            case 2: addBook();break;
            case 3: removeBook();break;
            case 4: mcSearch();break;
            case 5: System.exit(0);
        }
    }
    
    
    
    
    public void mcSearch(){
        String[] mcSearch = {"By ISBN", "By Title", "By Author"};
        Menu mSearch = new Menu("Enter your choice to Search", mcSearch) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1: searchBook( n);break;
                     case 2: searchBook( n);break;   
                      case 3: searchBook( n);break;
                     
                    
                }
            }
        };
        mSearch.run();
    }
    
    public void searchBook( int ch){
        
        node.findBook( ch);
    }
    
    public void addBook(){
        
        int i = Integer.parseInt(Menu.getString("Enter your index : "));
        String id = Menu.getString("Enter your ISBN : ");
        String title = Menu.getString("Enter your Book title : ");
        String author = Menu.getString("Enter your Book author : ");
         
         node.addToMid( new Book(id, title, author), i);
         
    }
    
    public void print(){
        node.printNode();
    }
    
    public void removeBook(){
        String id = Menu.getString("Enter your ISBN you want delete : ");
        node.removeBook( id);
        
    }
    
}
