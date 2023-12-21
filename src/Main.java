public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        int sizeNums1  = nums1.length;
        int sizeNums2  = nums2.length;
        int sizeMerged = sizeNums1 + sizeNums2;
        int halfMerged = sizeMerged / 2;

        int index1  = 0;    int elem1 = 0;
        int index2  = 0;    int elem2 = 0;
        int half1   = 0;    int temp  = 0;
        int half2   = 0;    int count = 0;

        while (half2 == 0) {

            count++;

            if (index1 < sizeNums1 && index2 < sizeNums2) {

                elem1 = nums1[index1];
                elem2 = nums2[index2];

                if (elem1 > elem2){
                    temp  = elem2; index2++;
                }
                if (elem2 > elem1) {
                    temp  = elem1; index1++;
                }
                if (elem1 == elem2){
                    temp  = elem1;
                    index1++; index2++; count++;
                }
                if (count == halfMerged) half1 = temp;

                if (count == halfMerged + 1){
                    half2 = temp;
                    break;
                }
            } else {

                if (index1 >= sizeNums1){
                    elem2  = nums2[index2];
                    temp   = elem2;  index2++;
                }
                if (index2 >= sizeNums2){
                    elem1  = nums1[index1];
                    temp   = elem1;  index1++;
                }
                if (count  == halfMerged) half1 = temp;
                if (count  == halfMerged + 1){
                    half2  = temp;
                    break;
                }
            }
        }
        if (sizeMerged % 2 == 0) System.out.println((double) (half1 + half2) / 2);
        else System.out.println(half2);
    }
}
