class Solution {
    public boolean isSymmetric(TreeNode root) {
		
		//if root is null, then tree is symmetric
        if(root == null) return true;
        
		//make arraylist to hold the nodes, starting with root
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
		
		boolean same = false; //variable to track progress
        
		//iterate until we have no nodes left.
        while(arr.size() != 0)
        {
			//Go through the arraylist to check if the layer is symmetric
            for(int i = 0; i < arr.size() / 2; i++)
			{
				//Nodes are symmetric only if value are same or both are null. If this is true, set our progress variable to true. Otherwise, return false.
                if(arr.get(i) != null && arr.get(arr.size() - i - 1) != null && 
                   arr.get(i).val == arr.get(arr.size() - i - 1).val || arr.get(i) == null && arr.get(arr.size() - i - 1) == null) same = true;
                else return false;
            }
            
			//create a temp arraylist to hold next layer of nodes.
            ArrayList<TreeNode> temp = new ArrayList<>();
            
			//add nodes only if we are not at the end of the tree.
            for(int i = 0; i < arr.size(); i++)
            {
                if(arr.get(i) != null)
                { 
                    temp.add(arr.get(i).left);
                    temp.add(arr.get(i).right);
                }
            }
            
			//set the original arraylist to the new one we just created
            arr = temp;
        }
        
        return same;
    }
}
