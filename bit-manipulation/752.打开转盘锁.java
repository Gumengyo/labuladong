import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    
    // 单向 BFS
    // public int openLock(String[] deadends, String target) {
    //     // 记录需要跳过的死亡密码
    //     Set<String> deads = new HashSet<>();
    //     for(String s:deadends) deads.add(s);
    //     // 记录已经穷举过的密码，防止走回头路
    //     Set<String> visited = new HashSet<>();
    //     Queue<String> q = new LinkedList<>();
    //     // 从起点开始启动广度优先搜索
    //     int step = 0;
    //     q.offer("0000");
    //     visited.add("0000");

    //     while(!q.isEmpty()){
    //         int sz = q.size();
    //         /* 将当前队列中的所有结点向周围扩散 */
    //         for(int i = 0;i < sz;i++){
    //             String cur = q.poll();

    //             /* 判断是否到达终点 */
    //             if(deads.contains(cur))
    //                 continue;
    //             if(cur.equals(target))
    //                 return step;
                
    //             /* 将一个节点的未遍历相邻节点加入队列 */
    //             for(int j = 0;j < 4;j++){
    //                 String up = plusOne(cur, j);
    //                 if(!visited.contains(up)){
    //                     q.offer(up);
    //                     visited.add(up);
    //                 }
    //                 String down = minusOne(cur, j);
    //                 if (!visited.contains(down)){
    //                     q.offer(down);
    //                     visited.add(down);
    //                 }
    //             }
    //         }
    //         /* 在这里增加步数 */
    //         step++;
    //     }
    //     // 如果穷举完都没找到目标密码，那就是找不到了
    //     return -1;
    // }

    // 双向 BFS
    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deads = new HashSet<>();
        for(String s:deadends) deads.add(s);
        // 用集合不用队列，可以快速判断元素是否存在
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q1.add("0000");
        q2.add(target);

        while(!q1.isEmpty() && !q2.isEmpty()){
            // 哈希集合在遍历的过程中不能修改，用 temp 存储扩散结果
            Set<String> temp = new HashSet<>();

            /* 将 q1 中的所有节点向周围扩散 */
            for(String cur:q1){

                /* 判断是否到达终点 */
                if(deads.contains(cur))
                    continue;
                if(q2.contains(cur))
                    return step;
                
                visited.add(cur);

                /* 将一个节点的未遍历相邻节点加入队列 */
                for(int j = 0;j < 4;j++){
                    String up = plusOne(cur, j);
                    if(!visited.contains(up)){
                        temp.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)){
                        temp.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
            // temp 相当于 q1
            // 在这里交换 q1 和 q2，下一轮 while 会扩散 q2
            q1 = q2;
            q2 = temp;
        }
        // 如果穷举完都没找到目标密码，那就是找不到了
        return -1;
    }
    

    // 将 s[j] 向上拨动一次
    private String plusOne(String s,int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '9')
            ch[j] = '0';
        else
            ch[j] += 1;
        return new String(ch);
    }

    // 将 s[j] 向下拨动一次
    private String minusOne(String s,int j){
        char[] ch = s.toCharArray();
        if(ch[j] == '0')
            ch[j] = '9';
        else
            ch[j] -= 1;
        return new String(ch);
    }
}
// @lc code=end

