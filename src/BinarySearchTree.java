// Hussein's Binary Search Tree
// 27 March 2017
// Hussein Suleman
/**BinarySearchTree.java: Inherits BinaryTree and creates methods to add, remove and search through nodes, as well as count the number of key operations it takes to do so.
*/


public class BinarySearchTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType>
{

   int insertOpCount = 0;
   int searchOpCount = 0;
   
   /**Inserts the first node of a tree. Takes data of node as a parameter */
   public void insert ( dataType d )
   {
      if (root == null)
         root = new BinaryTreeNode<dataType> (d, null, null);
      else
         insert (d, root);
   }
   /**Inserts a new node at a specific node(2nd parameter), and then balances the tree. Data of node=first parameter*/
   public void insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      insertOpCount++;
      if (d.compareTo (node.data) <= 0)
      {
         if (node.left == null)
            node.left = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.left);
      }
      else
      {
         if (node.right == null)
            node.right = new BinaryTreeNode<dataType> (d, null, null);
         else
            insert (d, node.right);
      }
   }
   /**Searchers for a node in the tree with the specified data(parameter) */
   public BinaryTreeNode<dataType> find ( dataType d )
   {
      if (root == null)
         return null;
      else
         return find (d, root);
   }
   /**Searchers for a node in the tree with the specified data(parameter 1) starting at the specified node(parameter 2) */
   public BinaryTreeNode<dataType> find ( dataType d, BinaryTreeNode<dataType> node )
   {
      searchOpCount++;
      if (d.compareTo (node.data) == 0){ 
         return node;}
      searchOpCount++;
      if (d.compareTo (node.data) < 0){
         return (node.left == null) ? null : find (d, node.left);}
      else
         return (node.right == null) ? null : find (d, node.right);
   }
   /**Searchers for and eletes node with a specified datatype(parameter) */
   public void delete ( dataType d )
   {
      root = delete (d, root);
   }
   /**Searchers for and deletes node with a specified data type(parameter 1), starting search at a specified node(parameter 2)*/   
   public BinaryTreeNode<dataType> delete ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null) return null;
      if (d.compareTo (node.data) < 0)
         node.left = delete (d, node.left);
      else if (d.compareTo (node.data) > 0)
         node.right = delete (d, node.right);
      else if (node.left != null && node.right != null )
      {
         node.data = findMin (node.right).data;
         node.right = removeMin (node.right);
      }
      else
         if (node.left != null)
            node = node.left;
         else
            node = node.right;
      return node;
   }
   /**Searchers for and returns the node with the smallest data value*/
   public BinaryTreeNode<dataType> findMin ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
         while (node.left != null)
            node = node.left;
      return node;
   }
   /**Searchers for and removes node with the smallest data value*/
   public BinaryTreeNode<dataType> removeMin ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return null;
      else if (node.left != null)
      {
         node.left = removeMin (node.left);
         return node;
      }
      else
         return node.right;
   }
   
}
