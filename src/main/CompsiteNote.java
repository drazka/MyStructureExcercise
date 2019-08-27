import java.util.ArrayList;
import java.util.List;

public class CompsiteNote extends Node implements ICompositeNode {

    private List<INode> notes = new ArrayList<>();

    public CompsiteNote(String code, String renderer) {
        super(code, renderer);
    }

    @Override
    public List<INode> getNodes() {
        return null;
    }
}
