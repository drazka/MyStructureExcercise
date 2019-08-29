import java.util.List;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    @Override
    public INode findByCode(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Code = null");
        }
        return new Node("code", "render");
    }

    @Override
    public INode findByRenderer(String renderer) {
        if (renderer == null) {
            throw new IllegalArgumentException("Render = null");
        }
        return new Node("code", "render");
    }


    @Override
    public int count() {
        return (int) nodes.stream().flatMap(INode::nodeSteam).count();
    }

    public Stream<INode> nodeStream() {
        return Stream.concat(nodeStream(), nodes.stream().flatMap(INode::nodeSteam)
        );
    }

    public void addNode(Node node) {
        nodes.add(node);
    }
}
