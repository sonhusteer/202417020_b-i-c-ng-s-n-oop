package Lab01;
import javax.swing.JOptionPane;

public class bai5  {
    public static void main(String args[]){
        String a;
        a=JOptionPane.showInputDialog(null,"a= ");
        String b;
        
        b=JOptionPane.showInputDialog(null,"b= ");
       double num1 = Double.parseDouble(a);
       double num2 = Double.parseDouble(b);
       double sum=num1+num2;
       double difference=num1-num2;
       double product=num1*num2;

        String strNotification="sum="+sum+"\n"+"difference="+difference+"\n"+"product="+product+"\n";
        if(num2!=0){
            double quotient=num1/num2;
            strNotification+="quotient="+quotient+"\n";
        }else{
            strNotification+="quotient: cant solve";
        }
       
        JOptionPane.showMessageDialog(null,strNotification,"Calculation Result",JOptionPane.INFORMATION_MESSAGE);
    }
}
