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
    void setUp() {
        cmNode1.addNode(node3);
        cmNode1.addNode(node4);

        emptyStructure = new MyStructure();

        filledStructure = new MyStructure();
        filledStructure.addNode(node1);
        filledStructure.addNode(node2);
        filledStructure.addNode(cmNode1);
    }

//    @Test
//    public void findByCodeTest() {
//        MyStructure myStructure = new MyStructure();
//    }

    @Test
    void shouldBe0WhenEmptySTructure() {
        assertEquals(0, emptyStructure.count());
    }
}
