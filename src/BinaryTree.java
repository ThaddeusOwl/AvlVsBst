// Hussein's Binary Tree
// 26 March 2017
// Hussein Suleman
/**BinaryTree.java: Creates a BinaryTree and methods to traverse through the BinaryTreeNode objects.
*/

public class BinaryTree<dataType>
{
   BinaryTreeNode<dataType> root;
   
   /**Initialiazes a new binary tree */
   public BinaryTree ()
   {
      root = null;
   }
   
   /**Returns the height of the whole binary tree*/
   public int getHeight ()
   {
      return getHeight (root);
   }
   /**Returns the height of the binary tree from a specified node(parameter)*/   
   public int getHeight ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return -1;
      else
         return 1 + Math.max (getHeight (node.getLeft ()), getHeight (node.getRight ()));
   }
   
   /**Returns the total size of the Binary Tree*/
   public int getSize ()
   {
      return getSize (root);
   }
   /**Returns the total size of the Binary Tree from a specified node(parameter)*/   
   public int getSize ( BinaryTreeNode<dataType> node )
   {
      if (node == null)
         return 0;
      else
         return 1 + getSize (node.getLeft ()) + getSize (node.getRight ());
   }
   
   /**Prints the data in a specified node(parameter)*/
   public void visit ( BinaryTreeNode<dataType> node )
   {
      System.out.println(node.data);
   }
   
   /**Traverses through the whole tree by visiting each node before its children*/
   public void preOrder ()
   {
      preOrder (root);
   }
   /**Traverses through the tree from a specified node(parameter) by visiting the each following node before its children*/
   public void preOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         visit (node);
         preOrder (node.getLeft ());
         preOrder (node.getRight ());
      }   
   }
   
   /**Traverses through the whole tree by visiting each node after its children*/
   public void postOrder ()
   {
      postOrder (root);
   }
   /**Traverses through the tree from a specified node(parameter) by visiting the each following node after its children*/
   public void postOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         postOrder (node.getLeft ());
         postOrder (node.getRight ());
         visit (node);
      }   
   }

   /**Traverses through the whole tree by visiting each node after its left child but before its right child (ie from left to right)*/
   public void inOrder ()
   {
      inOrder (root);
   }
   /**Traverses through the tree from a specified node(parameter) by visiting the each following node after its left child but before its right child (ie from left to right)*/
   public void inOrder ( BinaryTreeNode<dataType> node )
   {
      if (node != null)
      {
         inOrder (node.getLeft ());
         visit (node);
         inOrder (node.getRight ());
      }   
   }

   /*public void levelOrder ()
   {
      if (root == null)
         return;
      BTQueue<dataType> q = new BTQueue<dataType> ();
      q.enQueue (root);
      BinaryTreeNode<dataType> node;
      while ((node = q.getNext ()) != null)
      {
         visit (node);
         if (node.getLeft () != null)
            q.enQueue (node.getLeft ());
         if (node.getRight () != null)
            q.enQueue (node.getRight ());
      }
   }*/
   
}
