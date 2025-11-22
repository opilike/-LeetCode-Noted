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
    public ListNode deleteMiddle(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while (cur.next != null){
            cur = cur.next;
            count = count+1;
        }
        cur = head; 
        if(count == 0 ){
            return null;
        }
        int count2 = 0;
        ListNode cur2 = head;
        if (count%2 == 0){
            count = count/2;
        }else{
            count = count/2+1;
        }
        while (cur.next != null){
            count2++;
            if(count2 == count){
                cur.next = cur.next.next;
                break;
            }cur = cur.next;  
        }
        return head;
    }
}

//**
我是不是誤會甚麼了

LIstNode cur = head;

是告訴程式我的指標 是cur

haed 是主要串，cur 是我的指標嗎

不是

cur 是複製一串一模一樣的head
  **//
  結論： cur 不是複製一串一模一樣的串列。cur 和 head 只是兩個不同的名字，指向同一個節點。因此，當您透過 cur 執行 cur.next = cur.next.next; 時，您是直接修改了 head 指向的那個鏈結串列結構。這就是為什麼您最後返回 head 時，結構的改變會被保留下來。


快慢指標作法
    ----------------------------------------------------------------------------------------------
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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        //快慢指標 slow在dummy, fast在head上
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        slow.next = head;
        ListNode fast = head;
        // 讓s停在該刪除的在前一位
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }slow.next = slow.next.next;
        return head;
    }

    }
