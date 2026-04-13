class VersionControl {
    static int bad = 4; // maan lo 4 se sab bad hai

    public static boolean isBadVersion(int version) {
        return version >= bad;
    }
}

public class _278_FirstBadVersion  extends VersionControl{


    public int firstBadVersion(int n){
        int low = 1;
        int high = n;

        while (low < high) {

            int mid  = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;
            }else{
                low = mid + 1;
            }
   
        }

        return low;
    }


    public static void main(String[] args) {
        _278_FirstBadVersion firstBadVersion = new _278_FirstBadVersion();

        int badVersion = firstBadVersion.firstBadVersion(5);

        System.out.println("First Bad Version : " + badVersion);
    }
}
