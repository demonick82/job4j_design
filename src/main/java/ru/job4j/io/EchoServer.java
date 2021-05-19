package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoServer {
    private static Pattern any = Pattern.compile("=\\w*\\s");

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        Matcher m = any.matcher(str);
                        if (str.contains("=Hello ")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Hello\r\n\r\n".getBytes());
                        } else if (str.contains("=Exit ")) {
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write("Server stop\r\n\r\n".getBytes());
                            return;
                        } else if (m.find()) {
                            String answer = (m.group()).substring(1).trim();
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            out.write((answer + System.lineSeparator()).getBytes());
                        }
                    }
                }
            }
        }
    }
}
