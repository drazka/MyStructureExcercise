import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {
    private List<INode> nodes = new ArrayList<>();

    //metoda napisana przy pomocy szukania w internecie
    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code = null");
        }

        return findBy(n -> code.equals(n.getCode()));
    }

    //metoda napisana przy pomocy szukania w inernecie
    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Render = null");
        }
        return findBy(n -> renderer.equals(n.getRenderer()));
    }


    @Override
    public int count() {
        return (int) nodes.stream().flatMap(INode::nodeStream).count();
    }


    public Stream<INode> nodeStream() {
        return Stream.concat(nodeStream(), nodes.stream().flatMap(INode::nodeStream)
        );
    }

    public void addNode(Node node) {
        nodes.add(node);
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
                .flatMap(INode::nodeStream)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}
