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
        // 這是輸入的陣列：ListNode[] lists
        for (ListNode list : lists) {
            if(list != null){
                pq.add(list);
            }
        }
        while (!pq.isEmpty()) {
            ListNode smallest = pq.poll();
            cur.next = smallest;
            cur = cur.next;
            // 在 cur = cur.next; 之後：
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }return dummyhead.next;
    }
}
