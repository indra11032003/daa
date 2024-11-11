import java.util.*;
class fibonacci{
    public static int fibo(int n){
        int result;
        if(n==0 || n==1){
            return n;
        }
        else{
            result= fibo(n-1)+fibo(n-2);
        }
        return result;

    }
    public static void main(String[] args) {
        System.out.println("enter numbr");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<=n;i++){
            System.out.print(fibo(i)+" ");
        }
        
    }
}