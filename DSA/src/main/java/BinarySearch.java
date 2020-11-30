public class BinarySearch {

    public int binarySearch(int[] arr,int lowIndex,int highIndex,int x){

        if(highIndex >= lowIndex){
            int middleIndex = (lowIndex + highIndex) / 2;

            if(arr[middleIndex] == x)
                return middleIndex;

            if(arr[middleIndex] > x){
                return binarySearch(arr,lowIndex,middleIndex-1,x);
            }

            if(arr[middleIndex] < x){
                return binarySearch(arr,middleIndex+1,highIndex,x);
            }
        }


        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,34,45,46,57,59,70,94,112};
        int size = arr.length;
        int searchItem = 35;

        int resultIndex = new BinarySearch().binarySearch(arr,0,size-1, searchItem);

        if(resultIndex == -1)
            System.out.println("The Item found in the array");
        else
            System.out.println("The Item found at the index : "+ resultIndex);
    }
}
