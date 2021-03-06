import org.junit.jupiter.api.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStructureTest {

    private static Node node1 = new Node("c1", "r1");
    private static Node node2 = new Node("c2", "r2");
    private static CompsiteNote cmNode1 = new CompsiteNote("cc1","cr1");
    private static Node node3 = new Node("c3", "r3");
    private static Node node4 = new Node("c4", "r4");
    private static CompsiteNote cmNode2 = new CompsiteNote("cc2", "cr2");

    private MyStructure emptyStructure;
    private MyStructure filledStructure;

    @BeforeClass
    public void setUp() {
        cmNode1.addNode(node3);
        cmNode1.addNode(node4);

        emptyStructure = new MyStructure();

        filledStructure = new MyStructure();
        filledStructure.addNode(node1);
        filledStructure.addNode(node2);
        filledStructure.addNode(cmNode1);
    }

    //brakujące testy TODO

    @Test
    public void shouldBe0WhenEmptyStructure() {
        assertEquals(0, emptyStructure.count());
    }

    @Test
    public void shouldBeCorrectlyCountWhenNotEmptyStructure() {
        assertEquals(4, filledStructure.count());
    }

    @Test
    public void shouldBeNullWhenStructureIsEmptyUsingFIndByCode() {
        assertEquals(null, emptyStructure.findByCode("c7"));
    }

    @Test
    public void shouldBeNullWhenStructureIsEmptyUsingFIndBYRender() {
        assertEquals(null, emptyStructure.findByRenderer("c7"));
    }

    @Test
    public void shouldBeNullWhenStructureFilledUsingFIndByCode() {
        assertEquals(null, filledStructure.findByCode("c7"));
    }

    @Test
    public void shouldBeNullWhenStructureFilledUsingFIndBYRender() {
        assertEquals(null, filledStructure.findByRenderer("c7"));
    }
}
