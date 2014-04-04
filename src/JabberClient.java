/*
 * Copyright (C) 2014 umireon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


import java.io.*;
import java.net.*;

/**
 *
 * @author umireon
 */
public class JabberClient {

    public static void main(String[] args) throws IOException {
        InetAddress addr = InetAddress.getByName("localhost"); // IPアドレスへの変換
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, JabberServer.PORT); // ソケットの生成
        try {
            System.out.println("socket = " + socket);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // データ受信用バッファの設定
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true); // 送信バッファ設定
            for (int i = 0; i < 10; i++) {
                out.println("howdy" + i);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        } finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}
