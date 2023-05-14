import moe._47saikyo.LeetCodeContext;
import moe._47saikyo.annotations.LeetCodeData;
import moe._47saikyo.data_structure.ListNode;
import org.junit.Before;
import org.junit.Test;

@LeetCodeData(value = "[1,null,0,0,1]", index = 0)
@LeetCodeData(value = "[1,2,3]", index = 1)
@LeetCodeData(value = "[[1,2,3],[1,2],[3]]", index = 2)
@LeetCodeData(value = "['A','B','C','D']", index = 3)
@LeetCodeData(value = "[['A','B','C'],['B','C'],['C']]", index = 4)
@LeetCodeData(value = "abcdefg", index = 5)
@LeetCodeData(value = "[\"tars\",\"rats\",\"arts\",\"star\"]", index = 6)
@LeetCodeData(value="",index=7)
public class LeetCodeContextTest {
    LeetCodeContext lcc;

    @Before
    public void init() {
        lcc = new LeetCodeContext(LeetCodeContextTest.class);
    }

    @Test
    public void IntArrTest() throws Exception {
        int[] arr=lcc.getIntArray(1);
        for (int i:arr){
            System.out.print(i+" ");
        }
    }

    @Test
    public void IntArrsTest() throws Exception {
        int[][] arr=lcc.getIntArrays(2);
        for (int[] i:arr){
            for (int j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void CharArrTest() throws Exception {
        char[] arr=lcc.getCharArray(3);
        for (char i:arr){
            System.out.print(i+" ");
        }
    }

    @Test
    public void CharArrsTest() throws Exception {
        char[][] arr=lcc.getCharArrays(4);
        for (char[] i:arr){
            for (char j:i){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    @Test
    public void StringTest() throws Exception {
        System.out.println(lcc.getString(5));
    }

    @Test
    public void StringArrTest() throws Exception {
        for (String i:lcc.getStringArray(6)){
            System.out.println(i);
        }
    }

    @Test
    public void ListNodeTest() throws Exception {
        ListNode head=lcc.getListNode(1);
    }

    @Test
    public void NullTest() throws Exception {
        System.out.println(lcc.getString(7));
    }
}