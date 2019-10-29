import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

class avl_node{
    avl_node left,right;
    int balance_factor;
    int data;
    avl_node()
    {
        left=right=null;
        balance_factor=0;
        data=-1;
    }
}
class avl_op {
    public avl_node rw_r_c(avl_node a1){
        avl_node a2=null;
        return a2;
    }
    public avl_node rw_l_c(avl_node a1){
        avl_node a2=null;
        return a2;
    }
    public avl_node insert_node(avl_node head, int key) {
        avl_node a1 = new avl_node();
        a1.data = key;
        if(head.data<key){
            if(head.right==null){
                head.right=a1;
            }
            else
                head=insert_node(head.right,key);
        }
        else
        {
            if(head.left==null){
                head.left=a1;
            }
            else
                head=insert_node(head.left,key);
        }
        int balance_f=balance_factor_calc(head);
        if(balance_f==2){
            if(balance_factor_calc(head.left)>=0){
                return rw_l_c(head);
            }
            else
            {
                head.left=rw_r_c(head);
                return rw_l_c(head);
            }

        }
        if(balance_f==-2){
            if(balance_factor_calc(head.right)<=0){
                return rw_r_c(head);
            }
            else
            {
                head.left=rw_l_c(head);
                return rw_r_c(head);
            }
        }
        return head;
    }
    public int min(int a,int b){
        if(a<b)
            return a;
        else
            return b;
    }
    public int height(avl_node a) {
        int b_f = 0;
        if (a.left == null && a.right == null) {
            return 0;
        } else if (a.right == null)
            return height(a.left) + 1;
        else if (a.left == null) {
            return -1*(height(a.right) + 1);
        } else
            return (max(height(a.right), height(a.left)) + 1);
        //return b_f;
    }

    public int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public int balance_factor_calc(avl_node a1)
    {
        int bf=0;
        bf=height(a1.left)-height(a1.right);
        a1.balance_factor=bf;
        return bf;
    }
}
public class avl_tree {
    public static void main(String[] args){

    }
}
