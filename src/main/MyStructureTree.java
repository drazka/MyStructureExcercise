import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public class MyStructureTree implements IMyStructure{
    private int value;
    private List<INode> nodes = new LinkedList<>();

//    public MyStructureTree(int value, List<MyStructureTree> nodes) {
//        super();
//        this.value = value;
//        this.nodes.addAll(nodes);
//    }

//    public MyStructureTree(int value, MyStructureTree... nodes) {
//        this(value, asList(nodes));
//    }
//
//    public int getValue() {
//        return value;
//    }

//    public List<MyStructureTree> getChildren() {
//        return Collections.unmodifiableList(nodes);
//    }

    public Stream<MyStructureTree> flattened() {
        return Stream.concat(
                Stream.of(this),
                nodes.stream().flatMap(MyStructureTree::flattened));
    }

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


    @Override
    public int count() {
        return (int) nodes.stream().flatMap(MyStructureTree::flattened)).count();
    }

    private INode findBy(Predicate<INode> predicate) {
        return nodes.stream()
                .flatMap(INode::flattened)
                .filter(predicate)
                .findFirst()
                .orElse(null);
    }
}