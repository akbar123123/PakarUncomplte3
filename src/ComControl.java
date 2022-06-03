import com.fazecast.jSerialComm.*;
import java.util.Scanner;

public class ComControl{
    public static void main (String argsp[]){

        SerialPort ports[] = SerialPort.getCommPorts();

        for(SerialPort port: ports){
            System.out.println(port.getDescriptivePortName());
        }

        Scanner i = new Scanner(System.in);
        int x = i.nextInt();

        SerialPort port = ports[x-1];

        if(port.openPort()){
            System.out.println("Port is open");
        }else{
            System.out.println("Port is not available");
            return;
        }

        port.setComPortParameters(9600, 8, 0, 0);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        Scanner data = new Scanner(port.getInputStream());

//I just had to give it a try or guess..
        do{
            System.out.print(data.nextLine());
        }while(x<99);

    }
}