package easy.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * 字符串中的第一个唯一字符
 *
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 案例:
 *
 * s = "leetcode"
 * 返回 0.
 *
 * s = "loveleetcode",
 * 返回 2.
 *
 *
 * 注意事项：您可以假定该字符串只包含小写字母。
 */
public class FirstUniqCharSolution {
    private class Node{
        char zifu ;
        int weizhi;
        public Node(char zifu,int weizhi){
            this.zifu = zifu;
            this.weizhi = weizhi;
        }
    }

    public int firstUniqChar(String s) {
        if(s.length() == 0)
            return -1;
        if(s.length() == 1)
            return 0;
        char[] arr = s.toCharArray();
        int index = 0;
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if (map1.containsKey(arr[i])){
                map2.remove(map1.remove(arr[i]));
            }else{
                map1.put(arr[i],i);
                map2.put(map1.get(arr[i]),index++);
            }
        }
        if(map2.size() < arr.length){
            for(int i : map2.keySet())
                //第一个不重复的
                return i;
            //说明都是重复的
            return -1;
        }else{
            //说明没有重复的
            return 0;
        }
    }

    public static void main(String[] args) {
        String s = "abcdea";
        FirstUniqCharSolution firstUniqCharSolution = new FirstUniqCharSolution();
        System.out.println(firstUniqCharSolution.firstUniqChar(s));
    }
}
