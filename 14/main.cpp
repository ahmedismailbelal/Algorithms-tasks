#include <bits/stdc++.h>
using namespace std;
void printPairs(int arr[], int arr_size, int sum)
{
    unordered_set<int> s;
    int temp ;
    int f=0;

    for (int i = 0; i < arr_size; i++)
    {
        temp = sum - arr[i];

        if (s.find(temp) != s.end()){
            cout << "Pair found "<< sum << " is (" << arr[i] << ","<< temp << ")" << endl;
                     f=1;
        }

        else{
        s.insert(arr[i]);
        }
    }
    if(f==0)
    cout<<"Pair not found"<<endl;
}
int main()
{
int n = 0;
int A[n];

cout << "Enter the Array Size: "<<endl;
cin >> n;
for (int i = 0; i < n; i++) {

    cout << "Enter Array Element: "<<i+1<<" "<<endl;
    cin >> A[i];
}
    int sum ;
    cout<<"Enter Target number :"<<endl;
    cin>>sum;

    printPairs(A, n, sum);

    return 0;
}
