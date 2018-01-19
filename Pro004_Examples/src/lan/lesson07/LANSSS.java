
        package lan.lesson07;

        import java.io.IOException;
        import java.net.InetSocketAddress;
        import java.nio.ByteBuffer;
        import java.nio.channels.SocketChannel;
        import java.util.Scanner;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;

public class LANSSS
{
    private static String outputMessage = "";
    private static String inputMessage = "";
    public static void main(String[] args) throws IOException
    {
        SocketChannel client = SocketChannel.open(new InetSocketAddress("192.168.1.145", 30003));
        System.out.println("Connection");
        ByteBuffer bf = ByteBuffer.allocate(128);
        Scanner scan =  new Scanner(System.in);
        ExecutorService es = Executors.newFixedThreadPool(2);


        es.submit(()->{

            do {
                outputMessage =  scan.nextLine();
                bf.put(outputMessage.getBytes());
                bf.flip();
                try
                {
                    client.write(bf);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bf.clear();
            } while (!outputMessage.equals("stop"));
        });

        es.submit(()-> {
            do {
                int bytes = 0;
                try {
                    while ((bytes = client.read(bf)) > 0)
                    {
                        bf.flip();
                        inputMessage = new String(bf.array(), 0, bytes);
                        System.out.println(("Server") + inputMessage);
                        bf.clear();
                        break;
                    }
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
            } while (!inputMessage.equals("stop"));

        });

        //es.shutdownNow();
    }

}