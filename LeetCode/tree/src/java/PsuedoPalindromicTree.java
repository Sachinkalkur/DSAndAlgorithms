public class PsuedoPalindromicTree {
    public int check(int[] count) {
        int oddNo = 1;
        for (int j : count) {
            if (j % 2 != 0) {
                oddNo--;
            }
            if (oddNo < 0) {
                return 0;
            }
        }
        return 1;
    }

    public int palindrome(TreeBuilder.Node node, int[] count) {
        if (node == null) {
            return check(count);
        }
        count[node.val]++;
        int val = 0;
        if (node.left != null && node.right != null) {
            val += palindrome(node.left, count) + palindrome(node.right, count);;
        } else if (node.left != null) {
            val += palindrome(node.left, count);
        } else if (node.right != null) {
            val += palindrome(node.right, count);
        } else {
            val += check(count);
        }
        count[node.val]--;
        return val;
    }
    public int pseudoPalindromicPaths (TreeBuilder.Node root) {
        if (root == null) {
            return 0;
        }
        int[] count = new int[10];
        return palindrome(root, count);
    }
}
