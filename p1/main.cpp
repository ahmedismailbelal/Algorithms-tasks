#include <iostream>

using namespace std;
void insertionSort(int *array, int size)
{
    int tmp ;
    int  j;
    int counter = 0 ;
    for(int i = 1; i<size; i++)
    {
        tmp = array[i];//take value
        for ( j=i ; j > 0 && array[j-1]>tmp ; j--)
        {
            swap (array [j], array[j-1]);
            counter ++ ;
        }

    }
    cout << endl ;
    cout << "The number of swap  : "<< counter ;

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


    insertionSort(arr, n);



}

