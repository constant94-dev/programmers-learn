package just_temp_code;

public class Test0509 {
    public int solution(int n, int fac){
        if (n <= 1) return fac;

        System.out.println("중간결과: "+n*fac);

        return solution(n-1, n*fac);
    }

    public static void main(String[] args) {
        Test0509 test = new Test0509();
        int result = test.solution(5,1);
        System.out.println("최종결과: "+result);
    }
}
