import java.io.File;

public class Main {
    private static int newWidth = 300;
    public static void main(String[] args) {
        String srcFolder = "C:/Users/HP/Desktop/src";
        String dstFolder = "C:/Users/HP/Desktop/dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();
        int quarter = files.length/4;

        File[] files1 = new File[files.length-quarter];
        System.arraycopy(files, 0, files1, 0, files1.length);
        ImageResizer threadOne = new ImageResizer(files1, newWidth, dstFolder, start, 1);
        new Thread(threadOne).start();

        File[] files2 = new File[files.length-quarter];
        System.arraycopy(files, quarter, files2, 0, files2.length);
        ImageResizer threadTwo = new ImageResizer(files2, newWidth, dstFolder, start, 2);
        new Thread(threadTwo).start();

        File[] files3 = new File[files.length-quarter];
        System.arraycopy(files, quarter, files3, 0, files3.length);
        ImageResizer threadThree = new ImageResizer(files3, newWidth, dstFolder, start, 3);
        new Thread(threadThree).start();

        File[] files4 = new File[files.length-quarter];
        System.arraycopy(files, quarter, files4, 0, files4.length);
        ImageResizer threadFour = new ImageResizer(files4, newWidth, dstFolder, start, 4);
        new Thread(threadFour).start();
    }
}