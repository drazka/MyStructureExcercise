import java.util.stream.Stream;

public class Node implements INode {

    private String code;
    private String renderer;

    public Node(String code, String renderer) {
        this.code = code;
        this.renderer = renderer;
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
    public Stream<INode> nodeSteam() {
        return Stream.of(this);
    }
}
