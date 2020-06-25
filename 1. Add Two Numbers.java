/*
Description from https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
	Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 0 -> 8
	Explanation: 342 + 465 = 807.
*/

import java.util.LinkedList;

public class MyClass {
    public static void main(String args[]) {
		LinkedList<Integer> myL1 = new LinkedList<Integer>();
		LinkedList<Integer> myL2 = new LinkedList<Integer>();
		myL1.add(7);
		myL1.add(4);
		myL1.add(3);
		
		myL2.add(5);
		myL2.add(6);
		myL2.add(4);
		
		LinkedList<Integer> mySum = sumTwoLinkedList(myL1, myL2);
		
		for(int i = 0; i < mySum.size(); i++){
			System.out.println("Result = " + mySum.get(i));
		}
    }
	
	public static LinkedList<Integer> sumTwoLinkedList(LinkedList<Integer> list1, LinkedList<Integer> list2){
		LinkedList<Integer> listSum = new LinkedList<Integer>();
		int carry = 0;
		int final MAX_SIZE = Math.max(list1.size(), list2.size());
		for(int i = 0; i < MAX_SIZE; i++){
			int partialSum = 0;
			if(i < list1.size()){
				partialSum += list1.get(i);
			}			
			if(i < list2.size()){
				partialSum += list2.get(i);
			}
			partialSum += carry;
			carry = partialSum / 10;
			
			listSum.add(partialSum % 10);
		}		
		// check if there is a pendent carry
		if(carry != 0){
			listSum.add(carry);
		}
		return listSum;
	}
}
