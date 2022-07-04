#include<bits/stdc++.h>
using namespace std;
//use dynamic programing
int MaxSumofSubsequence(int arr[], int n)
    {
        //array that stores maximum sums
        int sum[n];
        int result=0;
        if(n==1)  //base case
        {
            if(arr[0]<0)
                return 0;
            return arr[0];
        }
        else if(n==2)
        {
            if(arr[0]&&arr[1]<0)
                return 0;
            return max(arr[0],arr[1]);

        }
        else if(n==3)
        {
           sum[0]=arr[0];
           sum[1]=arr[1];
           sum[2]=arr[2]+arr[0];
           if(arr[0]&&arr[1]&&arr[2]<0){
            return 0;
           }
           else{
            return max(sum[2],sum[1]);
           }
        }
        else
        {
           sum[0]=arr[0];
           sum[1]=arr[1];
           sum[2]=arr[2]+arr[0];
            for(int i=3;i<n;i++)
            {
                sum[i]=arr[i]+max(sum[i-2],sum[i-3]); //this equation return maximum sum in sum array
            }
            result= max(sum[n-1],sum[n-2]);  //return the maximum of last two sums

            if(result<0) //print 0 if all elements are negative
                return 0;
            return result;

        }
    }
int main()
{
    int n;
    cout<<"Enter length of your array: ";
    cin>>n;
    int arr[n];
    cout<<endl;
    for(int i=0; i<n; i++){

        cout<<"enter number "<<i+1<<": ";
        cin>>arr[i];
    }

    cout<<"Maximum sum of Subsequence is: "<<MaxSumofSubsequence(arr,n)<<endl;

    return 0;
}
