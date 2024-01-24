
package View;

public class Main extends Menu<String> {
    private static String[] mc={"Normalize text","Exit"};
    private TextMenu menu = new TextMenu();

    public Main() {
        super("Text Normalize", mc);
    }

    @Override
    public void execute(int ch) {
        switch(ch){
            case 1: menu.normalize();break;
            
            case 2: System.exit(0);
        }
    }

}
