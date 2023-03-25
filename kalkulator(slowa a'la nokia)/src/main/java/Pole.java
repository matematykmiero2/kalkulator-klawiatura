import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Pole extends JFrame implements ActionListener{
    public static String tekst="";
    public boolean duze=false;
    JTextArea tekst_a;
    JButton abc;
    JButton def;
    JButton ghi;
    JButton jkl;
    JButton mno;
    JButton pqr;
    JButton stuv;
    JButton wxyz;
    JButton C;
    JButton CE;
    JButton DM;
    JButton dziel;
    JButton plus;
    JButton minus;
    JButton rowne;
    Exception x;
    Date date = new Date();
    long czas1=date.getTime()-1000;
    long czas2=date.getTime();
    int czas= 500;

    Pole(){
        //RAMKA
        super.setTitle("Kalkulator z klawiatura a'la stara Nokia");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(new Dimension(400,620));
        super.setLocationRelativeTo(null);
        super.setLayout(null);

        //

        //POLE TEKSTOWE
        tekst_a = new JTextArea();

        tekst_a.setEditable(false);
        tekst_a.setFont(new Font("Arial", Font.PLAIN, 20));
        tekst_a.setLineWrap(true);
        JScrollPane scroll=new JScrollPane(tekst_a);
        scroll.setBounds(30,30,330,100);
        //PRZYCISKI
            //abc
         abc = new JButton("abc");
        abc.setBounds(80,170,70,70);
        abc.addActionListener(this);

            //def
         def = new JButton("def");
        def.setBounds(160,170,70,70);
        def.addActionListener(this);

        //ghi
         ghi = new JButton("ghi");
        ghi.setBounds(240,170,70,70);
        ghi.addActionListener(this);


        //jkl
         jkl = new JButton("jkl");
        jkl.setBounds(80,250,70,70);
        jkl.addActionListener(this);
        //mno
         mno = new JButton("mno");
        mno.setBounds(160,250,70,70);
        mno.addActionListener(this);

        //pqr
         pqr = new JButton("pqr");
        pqr.setBounds(240,250,70,70);
        pqr.addActionListener(this);


        //stuv
         stuv = new JButton("stuv");
        stuv.setBounds(80,330,70,70);
        stuv.addActionListener(this);

        //wxyz
         wxyz = new JButton("wxyz");
        wxyz.setBounds(160,330,70,70);
        wxyz.addActionListener(this);

        //D/M
         DM = new JButton("D/M");
        DM.setBounds(240,330,70,70);
        DM.addActionListener(this);

        //plus
         plus = new JButton("+");
        plus.setFont(new Font("Arial", Font.PLAIN, 20));
        plus.setBounds(80,410,70,70);
        plus.addActionListener(this);

        //minus
         minus = new JButton("-");
        minus.setFont(new Font("Arial", Font.PLAIN, 20));
        minus.setBounds(160,410,70,70);
        minus.addActionListener(this);

        //dziel
         dziel = new JButton("/");
        dziel.setFont(new Font("Arial", Font.PLAIN, 20));
        dziel.setBounds(240,410,70,70);
        dziel.addActionListener(this);


        //CE
         CE = new JButton("CE");
        CE.setBounds(80,490,70,70);
        CE.addActionListener(this);


        //C
         C = new JButton("C");
        C.setBounds(160,490,70,70);
        C.addActionListener(this);

        //rowne
         rowne = new JButton("=");
        rowne.setFont(new Font("Arial", Font.PLAIN, 20));
        rowne.setBounds(240,490,70,70);
        rowne.addActionListener(this);

            super.add(scroll);
            super.add(abc);
            super.add(def);
            super.add(ghi);
            super.add(jkl);
            super.add(mno);
            super.add(pqr);
            super.add(stuv);
            super.add(wxyz);
            super.add(DM);
            super.add(plus);
            super.add(minus);
            super.add(dziel);
            super.add(CE);
            super.add(C);
            super.add(rowne);

          super.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==C){
            tekst="";
        }

        else if(e.getSource()==CE){
            if(tekst.length()>0){
                int ilosc=1;
                if(tekst.substring(tekst.length()-1).equals(" ")) ilosc=3;
                for(int i=0;i<ilosc;i++){
                    tekst=tekst.substring(0,tekst.length()-1);
                }

            }
            else{
                tekst="";
            }
        }

        else if(e.getSource()==plus){
            if(!znaki(tekst)){
                tekst+=" + ";
            }
        }

        else if(e.getSource()==minus){
            if(!znaki(tekst)){
                tekst+=" - ";
            }
        }
        else if(e.getSource()==dziel){
            if(!znaki(tekst)){
                tekst+=" / ";
            }
        }

        else if(e.getSource()==DM){
           duze=!duze;
        }

        else if(e.getSource()==abc){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                 ostatni =""+tekst.charAt(tekst.length()-1);
            }
      else{
                 ostatni="?";
            }
            if(!"abcABC".contains(ostatni) || "abcABC".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="a";
                }
                else{
                    tekst+="A";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='c'){
                    x='a';
                }
                else if(x=='C'){
                    x='A';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
czas1=czas2;

        }


        else if(e.getSource()==def){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"defDEF".contains(ostatni) || "defDEF".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="d";
                }
                else{
                    tekst+="D";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='f'){
                    x='d';
                }
                else if(x=='F'){
                    x='D';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }

        else if(e.getSource()==ghi){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"ghiGHI".contains(ostatni) || "ghiGHI".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="g";
                }
                else{
                    tekst+="G";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='i'){
                    x='g';
                }
                else if(x=='I'){
                    x='G';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }


        else if(e.getSource()==jkl){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"jklJKL".contains(ostatni) || "jklJKL".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="j";
                }
                else{
                    tekst+="J";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='l'){
                    x='j';
                }
                else if(x=='L'){
                    x='J';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }

        else if(e.getSource()==mno){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"mnoMNO".contains(ostatni) || "mnoMNO".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="m";
                }
                else{
                    tekst+="M";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='o'){
                    x='m';
                }
                else if(x=='O'){
                    x='M';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }

        else if(e.getSource()==pqr){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"pqrPQR".contains(ostatni) || "pqrPQR".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="p";
                }
                else{
                    tekst+="P";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='r'){
                    x='p';
                }
                else if(x=='R'){
                    x='P';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }
        else if(e.getSource()==stuv){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"stuvSTUV".contains(ostatni) || "stuvSTUV".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="s";
                }
                else{
                    tekst+="S";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='v'){
                    x='s';
                }
                else if(x=='V'){
                    x='S';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }

        else if(e.getSource()==wxyz){
            date=new Date();
            czas2=date.getTime();
            String ostatni;
            if(tekst.length()>0){
                ostatni =""+tekst.charAt(tekst.length()-1);
            }
            else{
                ostatni="?";
            }
            if(!"wxyzWXYZ".contains(ostatni) || "wxyzWXYZ".contains(ostatni) && czas2-czas1>czas){
                if(!duze){
                    tekst+="w";
                }
                else{
                    tekst+="W";
                }
            }
            else{
                char x = tekst.charAt(tekst.length()-1);
                if(x=='z'){
                    x='w';
                }
                else if(x=='Z'){
                    x='W';
                }
                else x+=1;
                tekst=tekst.substring(0,tekst.length()-1);
                tekst+=x;
            }
            czas1=czas2;

        }
        else if(e.getSource()==rowne){
            if(!tekst.contains("=")){
                tekst+=" = ";
                String t1;
                String t2;
                int znak;
                if(tekst.contains("+")){
                    znak=tekst.indexOf("+");
                    t1=tekst.substring(0,znak-1);
                    t2=tekst.substring(znak+2,tekst.length()-3);
                    tekst+=t1+t2;
                }

                else if(tekst.contains("/")) {
                    String buf1 = "";
                    String buf2 = "";
                    String buf3 = "";
                    String buf4 = "";
                    String buf5 = "";
                    znak = tekst.indexOf("/");
                    t1 = tekst.substring(0, znak - 1);
                    t2 = tekst.substring(znak + 2, tekst.length() - 3);


                    String tl1 = "";
                    String tl2 = "";
                    if (t1.length() >= t2.length()) {
                        tl1 = t1;
                        tl2 = t2;
                    } else {
                        tl1 = t2;
                        tl2 = t1;
                    }
                    if (tl1.contains(tl2)) {
                        tekst += tl2;
                    } else {
                        for (int i = 0; i < t2.length(); i++) {
                            buf1 = tl2.substring(i);
                            buf2 = tl2.substring(0, tl2.length() - i);
                            buf3 = buf2.substring(i);
                            if (tl1.contains(buf1)) {
                                tekst += buf1;
                                break;
                            } else if (tl1.contains(buf2)) {
                                tekst += buf2;
                                break;
                            } else if (tl1.contains(buf3)) {
                                tekst += buf3;
                                break;
                            }
                            if(buf3.length()>=3){
                                buf4 = buf3.substring(1);
                                buf5=buf3.substring(0, buf3.length()-1);
                                if (tl1.contains(buf4)) {
                                    tekst += buf4;
                                    break;
                                } else if (tl1.contains(buf5)) {
                                    tekst += buf5;
                                    break;
                                }
                            }

                        }
                    }


                }
                else if(tekst.contains("-")){
                    znak=tekst.indexOf("-");
                    t1=tekst.substring(0,znak-1);
                    t2=tekst.substring(znak+2,tekst.length()-3);
                    String buf="";
                        while(t1.contains(t2)){
                            int in=t1.indexOf(t2);
                            buf = t1.substring(0,in);
                            buf+=t1.substring(in+t2.length());
                            t1=buf;
                        }



tekst+=t1;


                }


                else{
                    tekst+=tekst.substring(0,tekst.length()-2);
                }
            }
        }


        tekst_a.setText(tekst);

    }

    public boolean znaki(String s){
        return s.contains("+") || s.contains("-") || s.contains("/") || s.contains("=");
    }
}
