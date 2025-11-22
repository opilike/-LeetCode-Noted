/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>((a, b) -> a.val - b.val);
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;
        if(lists == null){
            return null;
        }
        // 把每一項lists裝進去，
        // list1 1 -> 1 -> 3
        // list2 2 -> 2 -> 5
        // pq跑完會是 [1] [2]
        for (ListNode list : lists) {
            if(list != null){
                pq.add(list);
            }
        }
        
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();   //接到pq裡最小的(最有權重的)
            //優化如果只剩一個list直接抓後面這一串，然後跳出迴圈。
            if(pq.size() == 0){
                cur.next = smallest;
                break;
            }
            cur.next = smallest;             //指針只到smallest
            cur = cur.next;                  //指針前進下一步
            // 如果list的下一項不為空，我們就在抓近來
            // 例如已經做完 dummyhead 1 -> 
            // 我們會再去抓 1 -> 1 ->
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }return dummyhead.next;
    }
}

/**
把一整串丟進來
但只會抓第一項目
再透過判斷目前PQ裡面裝的東西，
做指標的移動位移
然後假設list1 還沒抓完我們會一直抓近來比較
然後一直彈出最小的值一值串下去直到都串完
**/
