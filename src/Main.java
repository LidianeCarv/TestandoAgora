public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        int sizeNums1  = nums1.length;
        int sizeNums2  = nums2.length;
        int sizeMerged = sizeNums1 + sizeNums2;
        int halfMerged = (sizeMerged / 2)+1;

        int index1  = 0;    int elem1 = 0;
        int index2  = 0;    int elem2 = 0;
        int half1   = 0;    int count = 0;
        int half2   = 0;

        while (count < halfMerged) {

            count++; half2 = half1;

            if (index1 == sizeNums1){
                half1 = nums2[rescueElement(nums1, nums2, index1, index2)];
                if (halfMerged - 1 > index1 + index2) half2 = nums2[(rescueElement(nums1, nums2, index1, index2))-1];
                break;
            }
            if (index2 == sizeNums2){
                half1 = nums1[rescueElement(nums1, nums2, index1, index2)];
                if (halfMerged - 1 > index1 + index2) half2 = nums1[(rescueElement(nums1, nums2, index1, index2))-1];
                break;
            }
            else {
                elem1 = nums1[index1];
                elem2 = nums2[index2];

                if (elem1 > elem2){
                    index2++; half1 = elem2;
                    continue;
                }
                if (elem2 > elem1) {
                    index1++; half1 = elem1;
                    continue;
                }
                if (elem1 == elem2){
                    index1++; index2++; count++;
                    half1 = elem1;
                }
            }
        }

        if (sizeMerged % 2 == 0) System.out.println((double) (half1 + half2) / 2);
        else System.out.println(half1);
    }
    public static int rescueElement(int[] a, int[] b, int x, int y){
        int ref = (a.length + b.length)/2; int l = 0;

        if (a.length == x) l = ref - x;
        else l = ref - y;

        return l;
    }

}
