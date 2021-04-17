public class InOrderSuccessorBST {

    public TreeBuilder.Node findInOrderNode(TreeBuilder.Node node) {
        if (node == null) { return null; }
        TreeBuilder.Node ret = findInOrderNode(node.left);
        return ret != null ? ret : node;
    }

    public TreeBuilder.Node inOrderSuccessor(TreeBuilder.Node node, int target, TreeBuilder.Node parent) {
        if (node == null) { return null; }
        TreeBuilder.Node ret = null;

        if (node.val == target) {
            ret = findInOrderNode(node.right);
        } else if (target < node.val) {
            ret = inOrderSuccessor(node.left, target, node);
        } else {
            ret = inOrderSuccessor(node.right, target, node);
        }

        if(ret == null) {
            ret = parent != null && parent.val > target ? parent : null;
        }
        return ret;
    }
}
