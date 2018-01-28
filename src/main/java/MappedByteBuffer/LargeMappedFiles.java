package MappedByteBuffer;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class LargeMappedFiles {

    static int length = 0x8000000; // 128 Mb

    public static void main(String[] args) throws Exception{

            FileChannel fc = new RandomAccessFile("/Users/yuan/temp/test.dat", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
            //写128M的内容
            for (int i = 0; i < length; i++) {
                out.put((byte) 'x');
            }
            System.out.println("Finished writing");
            //读取文件中间6个字节内容
            for (int i = length / 2; i < length / 2 + 6; i++) {
                System.out.print((char) out.get(i));
            }
            fc.close();
        }
}
