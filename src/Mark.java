public class Mark {
    public static void main(String[] args) {
        int s1=60;
        int s2=70;
        int s3=50;
        int s4=65;
        int s5=82;

        int total=(s1+s2+s3+s4+s5);
        int average=total/5;

        System.out.println("--------------------------------------------");
        System.out.println("|      MARK          |   TOTAL  |  AVERAGE  |");
        System.out.println("---------------------------------------------");
        System.out.println("|  "+s1+" "+s2+" "+s3+" "+s4+" "+s5 +"    |"+ "   "+total+"    |"+"   " +average +"     |");
        System.out.println("--------------------------------------------");
    }
}
