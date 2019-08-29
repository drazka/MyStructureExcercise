import java.util.List;
import java.util.stream.Stream;

public class MyStructure implements IMyStructure {
    private List<INode> nodes;

    @Override
    public INode findByCode(String code) {
        return null;
    }

    @Override
    public INode findByRenderer(String renderer) {
        return null;
    }

    @Override
    public int count() {
        return (int) nodes.stream().flatMap(INode::nodeSteam).count();
    }

    public Stream<INode> nodeStream() {
        return Stream.concat(nodeStream(), nodes.stream().flatMap(INode::nodeSteam)
        );
    }
}
