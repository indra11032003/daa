import java.util.*;
class fibo{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter number");
        int n;
        n=sc.nextInt();
        if(n ==0 || n==1){
            System.out.println(n);
        }

        else{
            int first=0; int second=1;
            System.out.print(0+" ");

            for(int i=1;i<n;i++){
                int next=first+second;
                System.out.print(next+" ");
                first=second;
                second=next;
            }
            
        }
    }

}
