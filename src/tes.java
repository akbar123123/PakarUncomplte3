
import com.fazecast.jSerialComm.SerialPort;
import java.util.Scanner;
import javax.comm.SerialPortEvent;
//import jssc.SerialPortList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mhmmdadi21
 */
public class tes {

    public static void main(String[] args) {
         SerialPort ports[] = SerialPort.getCommPorts();

        for(SerialPort port: ports){
            System.out.println(port.getDescriptivePortName());
        }
        
        
        for (SerialPort port : ports) {
            System.out.println(port);
        }
        
        Scanner i = new Scanner(System.in);
        int x = i.nextInt();

        SerialPort port = ports[x-1];

        port.setComPortParameters(9600, 8, 0, 0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        Scanner data = new Scanner(port.getInputStream());

//I just had to give it a try or guess..
        do{
            System.out.print(data.nextLine());
        }while(x<99);

    }

}
