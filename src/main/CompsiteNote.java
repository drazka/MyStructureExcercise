import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

//compsite node zawiera wiele nodes/compsite nodes - przykłąd struktury złożonej
//dlatego stosowane flatMap
public class CompsiteNote extends Node implements ICompositeNode {

    private List<INode> nodes = new ArrayList<>();

    public CompsiteNote(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        return null;
    }

    public void addNode(INode node) {
        nodes.add(node);
    }


    public Stream<INode> nodeSteam() {
        return Stream.concat(
                nodeSteam(),
                nodes.stream().flatMap(INode::nodeStream)
        );
    }
}
