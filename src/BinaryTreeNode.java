// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**BinaryTreeNode.java: Creates a Binary Tree node
*/

public class BinaryTreeNode<dataType>
{
   dataType data;
   BinaryTreeNode<dataType> left;
   BinaryTreeNode<dataType> right;
   int height;
   
   /**Initializes Binary Tree Node with data(first parameter), left child node pointer(2nd parameter), and right child node pointer(3rd parameter)*/
   public BinaryTreeNode ( dataType d, BinaryTreeNode<dataType> l, BinaryTreeNode<dataType> r )
   {
      data = d;
      left = l;
      right = r;
      height = -1;
   }
   
   /**Returns left child node*/
   BinaryTreeNode<dataType> getLeft () { return left; }
   /**Return right child node*/
   BinaryTreeNode<dataType> getRight () { return right; }
   
}
