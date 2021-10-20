package com.example.eco_practica9_cliente;

import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPConection extends Thread {

    private DatagramSocket socket;

    @Override
    public void run() {
        try {
            socket = new DatagramSocket(3021);

            while (true) {

                // Recibir mensaje
                byte[] buffer = new byte[100];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                // Esperando datagram
                Log.e(">>>", "Esperando datagram");
                socket.receive(packet);

                // Contructor de String para pasar de de bytes a string
                String msg = new String(packet.getData()).trim();
                Log.e(">>>","Datagram recibido" + msg);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendMessage(String msg) {
        new Thread(
                ()->{

                    try {
                        InetAddress ip = InetAddress.getByName("192.168.0.32");

                        //Para enviar tiene 4 parametros
                        //1.buffer, 2. tamaño de arreglo, 3. ip, 4.Puerto del otro peer
                        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, ip, 2021);
                        socket.send(packet);

                    } catch (UnknownHostException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();

    }

}

