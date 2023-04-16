public class FirstAndLastLocation {
    /*
    *
    * */
    public int[] firstNLastLoc(int[] arr, int startPos) {
        int target = arr[startPos];
        int[] loc = new int[2];
        if(startPos == 0) {
            for(int i = 0; i < arr.length && arr[i] == target; i++){
                loc[1] = i;
            }
        } else {
            for(int i = startPos; arr[i] == target; i++){
                loc[1] = i;
            }
            for(int i = startPos; i >= 0 && arr[i] == target; i--){
                loc[0] = i;
            }
        }

        return loc;
    }

    public int binarySearch(int start, int end, int[] arr, int target) {
        if (end == -1){
            // empty array
            return -1;
        }
        int mid = (end + start) / 2;
        if(arr[mid] == target) {
            return mid;
        } else if(start == end) {
            return -1;
        } else if(target > arr[mid]) {
            return binarySearch(mid + 1, end, arr, target);
        } else {
            return binarySearch(start, mid - 1, arr, target);
        }
    }

    public void run() {
        int[] arr = new int[]{1,1,1,1,2,2,2,2,3,5,5,6,6,7,8,9,10};
        /*
        int[] arr = new int[]{1};
         */
        // System.out.println(binarySearch(0, arr.length - 1, arr, 1));
        int pos = binarySearch(0, arr.length - 1, arr, 1);
        if (pos == -1) {
            System.out.println("[-1,-1]");
        } else {
            int[] foundPos = new int[2];
            foundPos = firstNLastLoc(arr, pos);
            System.out.println("[" + foundPos[0] + "," + foundPos[1] + "]");
        }
    }

    public static void main(String[] args) {
        FirstAndLastLocation obj = new FirstAndLastLocation();
        obj.run();
    }
}
