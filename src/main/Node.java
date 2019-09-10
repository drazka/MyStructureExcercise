import java.util.ArrayList;
import java.util.List;

public class Node implements ICompositeNode {

    private String code;
    private String renderer;
    private List<INode> nodes;

    public Node(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
        this.nodes = new ArrayList<>();
    }

    public void addNode(INode node) {
        nodes.add(node);
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getRenderer() {
        return renderer;
    }


    @Override
    public List<INode> getNodes() {
        return nodes;
    }
}


