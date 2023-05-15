import moe._47saikyo.LeetCodeContext;
import moe._47saikyo.annotations.LeetCodeData;
import moe._47saikyo.annotations.LeetCodeExample;
import moe._47saikyo.data_structure.ListNode;
import moe._47saikyo.data_structure.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

@LeetCodeData("[1,null,0,0,1]")
@LeetCodeData("[1,2,3]")
@LeetCodeData("[[1,2,3],[1,2],[3]]")
@LeetCodeData("['A','B','C','D']")
@LeetCodeData("[['A','B','C'],['B','C'],['C']]")
@LeetCodeData("abcdefg")
@LeetCodeData("[\"tars\",\"rats\",\"arts\",\"star\"]")
@LeetCodeData("")
@LeetCodeExample("s=[1,2,3],b=[4,5,6]")
@LeetCodeExample("s=[7,8,9],b=\"abcdefg\",c=[['A','B','C'],['B','C'],['C']],d=[1,null,0,0,1]")
public class LeetCodeContextTest {
    LeetCodeContext lcc;

    @Before
    public void init() {
        lcc = new LeetCodeContext(LeetCodeContextTest.class);
    }

    @Test
    public void IntArrTest() throws Exception {
        int[] expected = {1, 2, 3};
        int[] actual = lcc.getIntArray(1);
        Assert.assertArrayEquals(expected, actual);

    }

    @Test
    public void IntArrsTest() throws Exception {
        int[][] expected = {{1, 2, 3}, {1, 2}, {3}};
        int[][] actual = lcc.getIntArrays(2);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void CharArrTest() throws Exception {
        char[] expected = {'A', 'B', 'C', 'D'};
        char[] actual = lcc.getCharArray(3);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void CharArrsTest() throws Exception {
        char[][] expected = {{'A', 'B', 'C'}, {'B', 'C'}, {'C'}};
        char[][] actual = lcc.getCharArrays(4);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void StringTest() throws Exception {
        String expected = "abcdefg";
        String actual = lcc.getString(5);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void StringArrTest() throws Exception {
        String[] expected = {"tars", "rats", "arts", "star"};
        String[] actual = lcc.getStringArray(6);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void ListNodeTest() throws Exception {
        ListNode expected = new ListNode(1);
        expected.next = new ListNode(2);
        expected.next.next = new ListNode(3);

        ListNode actual = lcc.getListNode(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void EmptyTest() throws Exception {
        Assert.assertEquals("", lcc.getString(7));
    }

    @Test
    public void BinaryTreeTest() throws Exception {
        TreeNode expected = new TreeNode(1);
        expected.right = new TreeNode(1);
        expected.right.left = new TreeNode(0);
        expected.right.right = new TreeNode(1);
        TreeNode actual = lcc.getBinaryTree(0);
    }

    @Test
    public void ExampleTest() throws Exception {
        int[] s=new int[]{7,8,9};
        String b="abcdefg";
        char[][] c = {{'A', 'B', 'C'}, {'B', 'C'}, {'C'}};
        TreeNode d = new TreeNode(1);
        d.right = new TreeNode(1);
        d.right.left = new TreeNode(0);
        d.right.right = new TreeNode(1);

        Assert.assertArrayEquals(s,lcc.getIntArray(1,0));
        Assert.assertEquals(b,lcc.getString(1,1));
        Assert.assertArrayEquals(c,lcc.getCharArrays(1,2));
        //Assert.assertEquals(d,lcc.getBinaryTree(1,3));
    }
}