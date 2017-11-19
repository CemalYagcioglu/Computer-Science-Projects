
public class LevelSum {
    public int sum(TreeNode tree) {
        //suggested,not required
        return sumHelper(tree,1);
    }

    // suggested, not required
    private int sumHelper(TreeNode tree, int counter){
        if(tree==null) return 0;
        return counter + sumHelper(tree.left,counter+1)+sumHelper(tree.right,counter+1);
    }
}
