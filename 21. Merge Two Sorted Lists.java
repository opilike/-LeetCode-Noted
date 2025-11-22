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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode cur = dummyhead;
        ListNode list1pointer = list1;
        ListNode list2pointer = list2;
        //判斷兩個如果為空的話
        if(list1pointer == null && list2pointer == null){
            return null;
        } //其中一個為空，直接抓另一個
        if(list1pointer == null){
            return list2;
        }
        if(list2pointer == null){
            return list1;
        } //如果兩個不為空，我們就一直做
        while(list1pointer != null && list2pointer != null){
            //抓最小的一直做
            if(list1pointer.val <= list2pointer.val){
                cur.next = list1pointer;
                list1pointer = list1pointer.next;
            }else{
                cur.next = list2pointer;
                list2pointer = list2pointer.next;
            } cur = cur.next;   //移動我們的指標
        }if (list1pointer == null){
            cur.next = list2pointer;
        }if (list2pointer == null){
            cur.next = list1pointer;
    } return dummyhead.next;
}
}


/** 
需注意指標現在指到哪裡!
**/
