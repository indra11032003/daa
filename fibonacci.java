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
        System.out.println(fibo(7));
        
    }
}