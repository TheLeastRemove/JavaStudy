package Solutions;

public class demo {
        static int ans=0;
        static boolean[] isV=new boolean[9];
        public static void main(String[] args)
        {
            int[] num=new int[9];
            dfs(num,0);
            System.out.println(ans);
        }
        public static void dfs(int[] num,int n)
        {
            if(n==9&&num[1]*(num[6]*num[7]*num[8])+(num[3]*num[4]*num[5])*num[2]==(10-num[0])*num[2]*(num[6]*num[7]*num[8]))
            {
                ans++;
                for(int i=0;i<9;i++)
                {
                    System.out.print(num[i]+" ");
                }
                System.out.println("");
                return;
            }
            for(int i=0;i<9;i++)
            {
                if (!isV[i]&&num[n]==0)
                {
                    num[n]=i+1;
                    isV[i]=true;
                    dfs(num,n+1);
                    isV[i]=false;
                    num[n]=0;
                }
            }
        }
    }


