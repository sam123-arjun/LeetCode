class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {

        int peak = peakMountainIndex(mountainArr);

        // Search ascending part
        int ans = binarySearchAsc(mountainArr, target, 0, peak);

        if (ans != -1) {
            return ans;
        }

        // Search descending part
        return binarySearchDesc(mountainArr, target, peak + 1,
                                mountainArr.length() - 1);
    }

    static int peakMountainIndex(MountainArray arr) {

        int start = 0;
        int end = arr.length() - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) > arr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }

    static int binarySearchAsc(
        MountainArray arr,
        int target,
        int start,
        int end
    ) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (target > arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

    static int binarySearchDesc(
        MountainArray arr,
        int target,
        int start,
        int end
    ) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr.get(mid) == target) {
                return mid;
            }

            if (target < arr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}