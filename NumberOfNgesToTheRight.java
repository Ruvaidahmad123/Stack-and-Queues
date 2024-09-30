class Solution {
  public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    int res[]=new int[queries];
    for(int i=0;i<queries;i++){
        int start=indices[i];
        int count=0;
        int val=arr[indices[i]];
        for(int j=start+1;j<N;j++){
            if(arr[j]>val){
                count++;
            }
        }
        res[i]=count;
    }
    return res;
  }
}
