package exception_handling;

public class MultipleCatchBlocks {
    public static void main(String[] args) {
        int[] nums = {1, 4, 7, 2, 3, 7};

        try {
            for(int i = 0; i <=6; i++) {
                System.out.println(nums[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
