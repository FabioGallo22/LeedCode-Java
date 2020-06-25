/*
Description from https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.

Example 1:
	Input: "abcabcbb"
	Output: 3 
	Explanation: The answer is "abc", with the length of 3. 
	
Example 2:
	Input: "bbbbb"
	Output: 1
	Explanation: The answer is "b", with the length of 1.

Example 3:
	Input: "pwwkew"
	Output: 3
	Explanation: The answer is "wke", with the length of 3. 
				 Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/
	public int lengthOfLongestSubstring(String s){
        int maxLength = s.length() == 1 ? 1 : 0; // In case that the string has 1 character, returns 1.
        int beginIndex = 0;
        int endIndex = 0;
        while(endIndex < s.length() - 1){	
            // chek if the frontier can be extended.
            if((s.substring(beginIndex,endIndex + 1)).indexOf(s.charAt(endIndex + 1)) < 0){
                // The element in endIndex + 1 is not contained yet.
                // Thus, the frontier can be extended
                endIndex ++;
            }else{
                // The element is already contained, 
                // so the beginIndex is moved forward.
                beginIndex ++;
            }

            if(endIndex - beginIndex + 1 > maxLength){
                maxLength = endIndex - beginIndex + 1;
            }
        }
        return maxLength;
    }