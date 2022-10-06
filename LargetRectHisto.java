class Solution {
    public int largestRectangleArea(int[] arr) {
        int maxAns=0;
        int ps[]=previousSmaller(arr);
        int ns[]=nextSmaller(arr);
        for(int i=0;i<arr.length;i++)
        {
            maxAns=Math.max(maxAns,(ns[i]-ps[i]-1)*arr[i]);
        }
        return maxAns;
    }
    public static int[] previousSmaller(int arr[])
    {
        Stack<Integer> st=new Stack<>();
        int ps[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();
            if(st.isEmpty())
            ps[i]=-1;
            else
            ps[i]=st.peek();
            st.push(i);
        }
        return ps;
    }
    public static int[] nextSmaller(int arr[])
    {
       int ns[]=new int[arr.length];
       Stack<Integer>st=new Stack<>();
       for(int i=arr.length-1;i>=0;i--)
       {
           while(!st.isEmpty() && arr[st.peek()]>=arr[i])
            st.pop();
            if(st.isEmpty())
            ns[i]=arr.length;
            else
            ns[i]=st.peek();
            st.push(i);
       }
       return ns;
    }
}
