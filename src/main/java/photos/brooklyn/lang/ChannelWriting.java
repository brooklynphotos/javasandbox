package photos.brooklyn.lang;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelWriting {
    public static void main(String[] args) throws IOException {
        File output = new File(args[0]);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1 << 16);
        byteBuffer.putInt(23);
        byteBuffer.putInt(123);
        byteBuffer.putInt(35);
        byteBuffer.flip();
        try (FileChannel fc = new FileOutputStream(output).getChannel()) {
            fc.write(byteBuffer);
        }

    }

}
