package com.example.myapplication;

/**
 * Created by דביר בן שבת on 17/12/2017.
 */

import java.io.DataOutputStream;
import java.io.FilterOutputStream;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client extends AsyncTask<Void, Void, Void> {
      Socket socket = null;
      String dstAddress;
      int dstPort;
      String Message = null;
      String response = "";
      TextView textResponse;
      String message;
      static boolean isInit = false;

    Client(String addr, int port, TextView textResponse, String message) {
        dstAddress = addr;
        dstPort = port;
        Message = message;
        this.textResponse = textResponse;
    }

    public void getConnected()
    {
            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        socket = new Socket(dstAddress, dstPort);
                        if(Message!=null)
                        {
                            sendMessage(Message);
                            int bytesRead;
                            byte[] buffer = new byte[1024];

                            InputStream inputStream = socket.getInputStream();
                            ByteArrayOutputStream byteArrayOutputStream =
                                    new ByteArrayOutputStream(1024);
                            while ((bytesRead = inputStream.read(buffer)) != -1)
                            {
                                byteArrayOutputStream.write(buffer, 0, bytesRead);
                                response += byteArrayOutputStream.toString("UTF-8");
                            }
                        }
                        //closeSocket();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.execute();






            /*else
            {
                socket.close();
            }*/
/*
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "UnknownHostException: " + e.toString();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            response = "IOException: " + e.toString();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        */

    }

    @Override
    protected Void doInBackground(Void... arg0) {

        //return response;
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        textResponse.setText(response);
        super.onPostExecute(result);
    }

    public void sendMessage(String message)
    {
        try {
            DataOutputStream dOut = new DataOutputStream(socket.getOutputStream()); // Send first message
            dOut.writeUTF(message);
            dOut.flush(); // Send off the data7
            socket.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }



    public void closeSocket()
    {
        try {
            socket.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}