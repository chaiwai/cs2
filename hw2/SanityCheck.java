
public class SanityCheck
{
   public static void main(String [] args)
   {
      GenericBST<Integer> myTree = new GenericBST<Integer>();

      myTree.insert(4);
      myTree.insert(5);
      myTree.insert(1);
      myTree.insert(2);

      myTree.inorder();
      myTree.preorder();
      myTree.postorder();

      // Test method calls, but don't print anything.
      GenericBST.difficultyRating();
      GenericBST.hoursSpent();
   }
}