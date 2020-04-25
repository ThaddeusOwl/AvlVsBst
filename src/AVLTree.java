/**
*AVLTree.java: Inherits Binary Search Tree and adds on features such as balancing
*@ThaddeusOwl, 29-03-2020
*/

public class AVLTree<dataType extends Comparable<? super dataType>> extends BinaryTree<dataType> 
{

   int insertOpCount = 0;
   int searchOpCount = 0;
   
   /**Calculates the height at a specific node(parameter) */
   public int height ( BinaryTreeNode<dataType> node ) //NEW
   {
      if (node != null)
         return node.height;
      return -1;
   }
   
   /**Calculates the difference in height of the left and right hand side of a specific node(parameter) */
   public int balanceFactor ( BinaryTreeNode<dataType> node ) //NEW
   {
      return height (node.right) - height (node.left);
   }
   
   /**Increases the height variable at a node(parameter) by 1 */
   public void fixHeight ( BinaryTreeNode<dataType> node ) //NEW
   {
      node.height = Math.max (height (node.left), height (node.right)) + 1;
   }
   
   /**Rotates the tree right at a specific node(parameter) */
   public BinaryTreeNode<dataType> rotateRight( BinaryTreeNode<dataType> p ) //NEW
   {
      BinaryTreeNode<dataType> q = p.left;
      p.left = q.right;
      q.right = p;
      fixHeight (p);
      fixHeight (q);
      return q;
   }
   
   /**Rotates the tree left at a specific node(parameter) */
   public BinaryTreeNode<dataType> rotateLeft( BinaryTreeNode<dataType> q ) //NEW
   {
      BinaryTreeNode<dataType> p = q.right;
      q.right = p.left;
      p.left = q;
      fixHeight (q);
      fixHeight (p);
      return p;
   }
   
   /**Balances the tree at a specific node(parameter) */
   public BinaryTreeNode<dataType> balance ( BinaryTreeNode<dataType> p ) //NEW
   {
      fixHeight (p);
      if (balanceFactor (p) == 2)
      {
         if (balanceFactor (p.right) < 0)
            p.right = rotateRight (p.right);
         return rotateLeft (p);
      }
      if (balanceFactor (p) == -2)
      {
         if (balanceFactor (p.left) > 0)
            p.left = rotateLeft (p.left);
         return rotateRight (p);
      }
      return p;
   }
   
   /**Inserts the first node of a tree. Takes data of node as a parameter */
   public void insert ( dataType d )
   {
      root = insert (d, root);
   }
   /**Inserts a new node at a specific node(2nd parameter), and then balances the tree. Data of node=first parameter*/
   public BinaryTreeNode<dataType> insert ( dataType d, BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return new BinaryTreeNode<dataType> (d, null, null);
      insertOpCount++;
      if (d.compareTo (node.data) <= 0)
         node.left = insert (d, node.left);
      else
         node.right = insert (d, node.right);
      return balance (node);
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