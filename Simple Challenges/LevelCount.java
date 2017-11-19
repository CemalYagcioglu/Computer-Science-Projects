
public class LevelCount {
	int counter = 0;
    public int count(TreeNode t, int level) {
    		return helper(t,0,level);
    }
    
    public int helper(TreeNode t,int count,int level) {
    		if(t==null) return 0;
		if(count == level) return 1;
		return helper(t.left,count+1,level)+helper(t.right,count+1,level);
    }
}
