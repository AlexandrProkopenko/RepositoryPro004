package lan.lesson07;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class LANExamServer {

    /*Сервер
    *
    * 1 - 1029 - порты которые не следует использовать в
    *            сокетах, так как они являются системными
    * 8081 - 65536 - безопасные для использования порты.*/

    public static void main(String[] args) throws IOException {
        /* ServerSocketChannel - позволяет нам запустить соедение
        * и начать прослушивать порт*/
        ServerSocketChannel ssc = ServerSocketChannel.open();
        /*Порт - необходим для мониторинга подключения клиентов
        *        и установки соеденения с ними.*/
        ssc.bind(new InetSocketAddress(30000));

        System.out.println("Режим ожидания соеденения... ");

        SocketChannel client = ssc.accept();

        System.out.println("Установка соеденения с клиентом...");

        ByteBuffer bb = ByteBuffer.allocate(128);

        int bytes = 0;
        while ((bytes = client.read(bb)) > 0) {
            //System.out.println(bytes);
            bb.flip();
            System.out.println("Входящее сообщение: "
                + new String(bb.array(), 0, bytes));
            bb.clear();
            break;
        }

        System.out.println("Завершение работы сервера....");


    }
}
