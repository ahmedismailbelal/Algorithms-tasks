#include<bits/stdc++.h>
#include <iostream>


using namespace std;

void Problem16(int *array, int n)
{
    unordered_map<int,int>hashing;
    for(int i=0; i<n; i++)
    {
        hashing[array[i]]++;
    }

    for(int i=0; i<n; i++)
    {
        if(hashing[array[i]]!=0)
        {
            for(int j=0; j<hashing[array[i]]; j++)
            {
               cout <<    array[i] << " " ;
            }
            hashing[array[i]]=0;  // make this element in hashing = -1
        }
    }



}

int main()
{

    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    int arr[n];
    cout << "Enter elements:" << endl;
    for(int i = 0; i<n; i++)
    {
        cin >> arr[i];
    }
    Problem16(arr, n);

}
