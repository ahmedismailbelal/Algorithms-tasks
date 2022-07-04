#include<bits/stdc++.h>
using namespace std;

//function that prints the minimum index for repeating element
void minIndex(int arr[], int n)
{
    // Initialize min index of element
    int minIdx = -1;
    // Creates an empty hash set
    unordered_set<int> hashh; //O(1)

    // Traverse the input array from right to left to get minimum
    for (int i= n-1; i>=0; i--)
    {
        // If element is already in hash set, update  minIdx
        if (hashh.find(arr[i]) != hashh.end()){
          minIdx = i;
        }
        else   // Else add element to hash set
            hashh.insert(arr[i]);
    }

    // Print the result
    if (minIdx != -1)
        cout << "The minimum index of repeating element is: " << minIdx<<endl;
    else
        cout << "Invalid Input"<<endl;
}

int main()
{
    int n;
    cout<<"Enter length of your array : ";
    cin>>n;
    int arr[n];
    cout<<endl;
    for(int i=0; i<n; i++){

        cout<<"enter number "<<i+1<<": ";
        cin>>arr[i];
    }
    cout<<endl;
    minIndex(arr,n);
}

/*
python
-----------------------
def printFirstRepeating(a, n):
    for i in range(len(a)):
        if a.count(a[i]) > 1:
            return i
    return "there is no repetition number"


arr = [1,2,3,1,2,5]
n = len(arr)
print(printFirstRepeating(arr, n))
*/
