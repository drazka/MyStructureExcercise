import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new ArrayList<>();



    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code = null");
        }

        return findBy(n -> code.equals(n.getCode()));
    }


    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Render = null");
        }
        return findBy(n -> renderer.equals(n.getRenderer()));
    }


//    public Stream<INode> nodeStream() {
//        return Stream.concat(nodeStream(), nodes.stream().flatMap(INode::nodeStream)
//        );
//    }

    public Stream<Object> flattened() {
        return Stream.concat(Stream.of(this), nodes.stream().flatMap(INode::flattened)
        );
    }

    @Override
    public int count() {
        return (int) nodes.stream().flatMap((INode t) -> flattened()).count();
    }


//    public void addNode(INode node) {
//        nodes.add(node);
//    }

    public void addNode(Node node) {
        nodes.add(node);
    }
    public void addCNode(CompsiteNode compsiteNode) {
        nodes.add(compsiteNode);
    }

//    PRZYKLAD ZASTOSOWANIA PREDICATE
//    Book book = new Book(39.99, "twarda");
//    Predicate<Book> checkPrice = book1 -> book1.price > 29.99;
//
//    if (checkPrice.test(book)) {
//        System.out.println("Drogo!");
//    }

    private INode findBy(Predicate<INode> predicate) {
        return nodes.stream()
                .flatMap(INode::flattened)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
