import java.util.*;
public class zeroOne{
    
    public static int helper(int w,int[] pr,int[] wt,int n,int result[][]){

        if(n==0||w==0){
            return 0;
        }

        if(result[n][w]!=-1){

            return result[n][w];
        }



        if(wt[n-1]>w){
            result[n][w]= helper(w, pr, wt, n-1,result);
        }
        else{
            result[n][w]=Math.max(helper(w, pr, wt, n-1,result),pr[n-1]+helper(w-wt[n-1], pr, wt, n-1,result));
        }

        return result[n][w];

    }

    static int knapsack(int w,int[] pr,int[] wt,int n){
        int result[][]=new int[n+1][w+1];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                result[i][j]=-1;
            }
        }
        return helper(w, pr, wt, n,result);


    }

    public static void main(String[] args) {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter number of item ");
        int N = scanner.nextInt();

        int[] profit=new int[N];
        for(int i=0;i<N;i++){
            System.out.println("profit of item"+(i+0));
            profit[i]=scanner.nextInt();
        }


        System.out.println("------Enter weight--------");
        int[] weight=new int[N];
        for(int i=0;i<N;i++){
            System.out.println("weight of item"+(i+0));
            weight[i]=scanner.nextInt();
        }
        int capacity=6;

        System.out.println("max profit:"+knapsack(capacity, profit, weight, profit.length));

        
    }
}