import junit.framework.TestCase;
import model.*;
import org.junit.Test;

// Tests. En la carpeta doc del programa está una foto con todos los casos de grafos que probé.

public class BFSSearchTest extends TestCase{

    private BFSGraphController<String> controller;

    public void setupStage1(){
        controller = new BFSGraphController<>();
    }

    @Test
    public void test1(){
        setupStage1();

        controller.insertNode("x");
        controller.insertNode("y");
        controller.insertNode("z");
        controller.insertNode("w");
        controller.addAdjacency("x","z");
        controller.addAdjacency("z","y");
        controller.addAdjacency("y","x");
        controller.addAdjacency("w","w");
        controller.addAdjacency("w","y");
        controller.addAdjacency("y","w");

        assertTrue(controller.stronglyConnectedBFS());
    }

    @Test
    public void test2(){
        setupStage1();

        controller.insertNode("x");
        controller.insertNode("y");
        controller.insertNode("z");
        controller.insertNode("w");
        controller.insertNode("u");
        controller.addAdjacency("x","y");
        controller.addAdjacency("y","z");
        controller.addAdjacency("z","w");
        controller.addAdjacency("w","u");
        controller.addAdjacency("u","z");

        assertFalse(controller.stronglyConnectedBFS());
    }

    @Test
    public void test3(){
        setupStage1();

        controller.insertNode("1");
        controller.insertNode("2");
        controller.insertNode("3");
        controller.insertNode("4");
        controller.insertNode("5");
        controller.insertNode("6");
        controller.addAdjacency("3","1");
        controller.addAdjacency("5","3");
        controller.addAdjacency("2","3");
        controller.addAdjacency("3","4");
        controller.addAdjacency("4","5");
        controller.addAdjacency("6","2");
        controller.addAdjacency("1","6");

        assertTrue(controller.stronglyConnectedBFS());
    }
}
