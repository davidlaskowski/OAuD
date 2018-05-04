package mvc;

import java.util.Scanner;

public class Controller {

    private Model model;
    private String aendern;

    public Controller(Model model, String aendern) {
        this.model = model;
        this.aendern = aendern;
    }

    public void eingabeSteuern() {
        System.out.print(this.aendern + ": ");
        this.model.wertAendern(new Scanner(System.in).nextInt());
    }
}
