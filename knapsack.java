class knapsack{
    public static int knapsackHelper(int w,int[] wt,int[] p, int n,int[][]result){
        if(n==0 || w==0){
            return 0;
        }
        if(result[n][w]!=-1){

            return result[n][w];
        }

        if(wt[n-1]>w){
            result[n][w]=knapsackHelper(w, wt, p, n-1, result);
          }
        else{
            result[n][w]=Math.max(p[n-1]+knapsackHelper(w-wt[n-1], wt, p, n-1, result),knapsackHelper(w, wt, p, n-1, result));
        }
        return result[n][w];
    }
    // w= capacity and n= number of object
    public static int knapsackP(int w,int[] wt,int[] p,int n){

        int[][] result= new int [n+1][w+1];

         for(int i=0;i<=n;i++){

            for(int j=0;j<=w;j++){

                result[i][j]=-1;
            }
         }
         return knapsackHelper(w,wt,p,n,result);
    }

    public static void main(String[] args) {
        int[] profit={10,12,28};
        int[] weight={1,2,4};
        int capacity=6;
        System.out.println("total profit:"+knapsackP(capacity, weight, profit, profit.length));
        
    }
}