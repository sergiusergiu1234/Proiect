import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class FormMain extends JFrame {
    private JTextField txtActivitate;
    private JButton addButton;
    private JButton deleteButton;
    private JPanel rootPanel;
    private JLabel label1;
    private JTextField txtPrioritate;
    private JButton showButton;
    private JList listlist;
    private JButton button1;
    private JLabel label;
    public ArrayList <Activitate> list = new ArrayList<>();    //array list pt stocarea activitatilor



    public FormMain() {

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 Activitate a = new Activitate("","");          //obiect static
                String activitateText= txtActivitate.getText(); //preia textul din casuta si il stocheza in String
                String prioritateText= txtPrioritate.getText(); //preia textul din casuta si il stocheza in String


                if(a.validareNume(activitateText)==false){
                    int result=JOptionPane.showConfirmDialog(null,
                            "Spatiul nu poate sa fie gol!!! ",
                            "ATENTIE",JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
                    System.out.println(result);

                }else
                {
                    a.addLastIndex();                                    //+1 lastindex
                    a.setNume(activitateText);                           //cu Stringul de mai sus se seteaza numele
                    a.setPrioritate(prioritateText);                     //la fel ca mai sus pt prioritate
                    a.addIndex(a.getLastIndex());                       //+1 la indexul obiectului in fc de lastindex
                    list.add(a);                                       //adauga obiectul in lista
                    label1.setText("Am introdus: "+ a.toString());      //mesaj
                }




            }
        });

        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Activitate[] actArray= new Activitate[list.size()];      //Array nou de tip Activitate de marimea Arraylistului
                  list.toArray(actArray);                                     //Trece datele in Array-ul creeat
                listlist.setListData(actArray);                          //Adauga datele din Array in Jlist care apare in aplicatie
            }

        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listlist.getSelectedIndex();       //int care retine indexul elementului selectat in Jlist
                int temp = listlist.getSelectedIndex();         //daca nu este selectat nici un obiect din lista, atunci
                                                                 //se returneaza -1
                if (index == -1) {                          //verifica daca am selectat vreun obiect din lista
                    int result = JOptionPane.showConfirmDialog(null,
                            "Nu ai selectat nici un obiect din lista! ",
                            "ATENTIE", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE);
                    System.out.println(result);
                } else {
                    for (int i = temp; i < list.size(); i++) {  //de la obiectul selectat pana la sfarsitul listei, scade cu -1 fiecare index
                        list.get(i).minusIndex();
                    }
                    if (index != -1) {
                        list.remove(index);                     //sterge obiectul de la indexul selecat din lista arraylist
                    }
                    list.get(temp).minusLastIndex();
                    Activitate[] actArray = new Activitate[list.size()];      //Array nou de tip Activitate de marimea Arraylistului
                    list.toArray(actArray);                                     //Trece datele in Array-ul creeat
                    listlist.setListData(actArray);                          //Adauga datele din Array in Jlist care apare in aplicatie
                }
            }
        });

    }

    public static void main(String[] args) {


        JFrame frame= new JFrame();
        frame.setContentPane(new FormMain().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(900,300);
        frame.setVisible(true);




    }
}
