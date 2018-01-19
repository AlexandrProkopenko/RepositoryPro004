package lan.lesson07;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class LANExamClient {
    /* TCP/IP протокол:
    *
    * Transmission Control Protocol - данный функционал гарантирует
     * передачу данных между компьютерами внутри локальной сети
     *
     * Internet Protocol - данный функционал, решает комуникационные
     * вопросы между компьютерами в рамках сети
     *
     * IPv4 - адрес компьтера в сети
     * XXX.XXX.XXX.XXX
     *
     * 127.0.0.1 (localhost) - Локальный адрес компьтера
     * */

    public static void main(String[] args) throws IOException {
        SocketChannel client =
                SocketChannel.open(
                        new InetSocketAddress(
                                "127.0.0.1", 30000));
        System.out.println("Установка соеденения с сервером...");

        String sms = "Сообщение";

        System.out.println("Подготовка сообщения к отправке...");

        ByteBuffer bf = ByteBuffer.allocate(128);

        //bf.put(sms.getBytes());

        System.out.println(sms.getBytes());

        bf.flip();

        System.out.println("Отправка сообщения...");

        client.write(bf);

        System.out.println("Очистка данных...");

        bf.clear();

    }
}

