package main;

import java.util.regex.Pattern;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class SystemTest {
    
    @Rule
    public final SystemOutRule systemOutMock = new SystemOutRule().enableLog();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = TextFromStandardInputStream.emptyStandardInputStream();
    
    private Controller controller;
    
    @Before
    public void setUp(){
        this.controller = new Controller();
    }
    
    private void viewHinzu(String zeichen){
        String[] inputs = {zeichen};
        this.systemInMock.provideLines(inputs);
        this.controller.neuerView();
    }
    
    private String controllerNutzen(int anzahl){
        String[] inputs = {""+anzahl};
        this.systemInMock.provideLines(inputs);
        this.systemOutMock.clearLog();
        this.controller.controllerNutzen();
        return this.systemOutMock.getLog().split("\\(0\\)")[0];
    }
    
    @Test
    public void testOhneView(){
        String erg = this.controllerNutzen(42);
        Assert.assertEquals("keine Zeichenausgabe erwartet"
                ,"neuer Modellwert: ", erg);
        System.out.println("erg: " + erg + erg.length());
    }
    
    @Test
    public void testEinView(){
        this.viewHinzu("xxxBlubb");
        String erg = this.controllerNutzen(8);
        Assert.assertTrue("genau 8 x in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^x]*xxxxxxxx[^x]*", erg));
    }
    
    @Test
    public void testMehrereViews(){
        this.viewHinzu("xxxBlubb");
        this.viewHinzu("yyyBlubb");
        this.viewHinzu("zzzBlubb");
        String erg = this.controllerNutzen(8);
        Assert.assertTrue("genau 8 x in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^x]*xxxxxxxx[^x]*", erg));
        Assert.assertTrue("genau 8 y in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^y]*yyyyyyyy[^y]*", erg));
        Assert.assertTrue("genau 8 z in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^z]*zzzzzzzz[^z]*", erg));
    }
    
    @Test
    public void testZusammen(){
        String[] inputs = {"2","4","1","qqq","2","4","1","yyy","2","9","0"};
        this.systemInMock.provideLines(inputs);
        this.controller.dialog();
        String erg = this.systemOutMock.getLog();
        Assert.assertTrue("genau 4 q  und danach 9 q in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^q]*qqqq[^q]*qqqqqqqqq[^q]*", erg));
        Assert.assertTrue("genau 9 y in Ausgabe erwartet: " +erg
                ,Pattern.matches("(?s)[^y]*yyyyyyyyy[^y]*", erg));
    }
}
