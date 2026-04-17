package Lab01;
import javax.swing.JOptionPane;
public class bai6 {
    public static void main(String args[]){
        String a;
        a=JOptionPane.showInputDialog(null,"a= ");
        String b;
        b=JOptionPane.showInputDialog(null,"b= ");
        String c;
        c=JOptionPane.showInputDialog(null,"c= ");
        double num1 = Double.parseDouble(a);
       double num2 = Double.parseDouble(b);
       double num3=Double.parseDouble(c);
       double denta=num2*num2-4*num1*num3;
      
       String strNotification=" ";
       if(num1==0){
        if(num2!=0){
        strNotification="nghiem="+-num3/num2;}
        if(num2==0&&num3==0)strNotification="phuong trinh vo so nghiem";
        if(num2==0&&num3!=0)strNotification="phuong trinh vo nghiem";
       }
        else if(denta<0){
            strNotification="phuong trinh vo nghiem"+"\n";
        }else if(denta==0){
            strNotification="nghiem kep="+-num2/(2*num1)+"\n";
        }else if(denta>0){
            double no1=(-num2+Math.sqrt(denta))/(2*num1);
            double no2=(-num2-Math.sqrt(denta))/(2*num1);
            strNotification="nghiem1="+no1+"\n"+"nghiem2="+no2+"\n";
        }
JOptionPane.showMessageDialog(null,strNotification,"Calculation Result",JOptionPane.INFORMATION_MESSAGE);
System.exit(0);
    }
}
