
package DB;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class Voiture extends Vehicule{
    
   private int Frais;
   private String Immatriculation,Marque,Couleur,DateE,DateS;
  
   private long Duree;
   private String Proprietaire;
  
    public Voiture(){
       
    }
    
    public Voiture(String p,String i, String m, String c, String De, int f ,String Ds, long d ){
       
      Proprietaire = p;  
      Immatriculation=i;
        Marque=m;
        Couleur=c;
        DateE=De;
        DateS=Ds;
        Duree=d;
        
    }
    
    public Voiture(String i, String m, String c){
       
        Immatriculation=i;
        Marque=m;
        Couleur=c;
    }
    
    
    @Override
    public void Insertion() {
      
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
   Date d = new Date();
 
    DateE= dateFormat.format(d);
    
    setDuree(d.getHours()*3600+d.getMinutes()*60+d.getSeconds());      
   
   
    String sql ="insert into voiture(immatriculation,Marque,Couleur,Date_heure_Entree,Duree)values('"+getImmatriculation()+"','"+getMarque()+"','"+getCouleur()+"','"+getDateE()+"','"+getDuree()+"' )";  
       
       Connect.UpdateDb(sql);
       
    }
    
    @Override
    public void Modification() {
   
        String sql;
        
      if(getProprietaire()!=null){
    sql ="update voiture set Proprietaire='"+getProprietaire()+"', immatriculation='"+getImmatriculation()+"',Marque='"+getMarque()+"',Couleur='"+getCouleur()+"' where immatriculation='"+getImmatriculation()+"' ";        
      }else{
    sql ="update voiture set immatriculation='"+getImmatriculation()+"',Marque='"+getMarque()+"',Couleur='"+getCouleur()+"' where immatriculation='"+getImmatriculation()+"' "; 
      }     
 
      Connect.UpdateDb(sql);
 JOptionPane.showMessageDialog(null,"Modification avec success");
         
    }

    @Override
    public void Suppression() {
        
        String sql ="delete from voiture where immatriculation='"+getImmatriculation()+"' "; 
    
      Connect.UpdateDb(sql);
     
    }
    
     @Override
    public void Payer() {
    
   SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm");           
  Date d1 = new Date();
   DateS=simple.format(d1);
  
 long S = d1.getHours()*3600+d1.getMinutes()*60+d1.getSeconds();      
  setDuree(S-getDuree());     

  if(Duree<=1800){
   this.Frais=2500;    
  }else{
      this.Frais=3500;
  }
 
  do{    
  setProprietaire(JOptionPane.showInputDialog("Entrer le nom du Propriétaire du "+getMarque()+":"));     
  }while(getProprietaire()==null);
 
  JOptionPane.showMessageDialog(null,"Le "+DateS+" Sortie du Parking du "+getMarque()
          +"\n Paiement de "+getFrais()
          +"fbu\n Merci de nous avoir fait confiance Mr/Mrs "+getProprietaire()+".Vous avez passez "+getDuree()/60
          +" minutes");  
          
 
  String sql = "update voiture set Proprietaire= '"+getProprietaire()+"', Frais='"+getFrais()+"',Date_heure_Sortie='"+getDateS()+"',Duree='"+getDuree()+"' where immatriculation='"+getImmatriculation()+"' ";
  
  Connect.UpdateDb(sql);
    }
    
    
    public String getImmatriculation() {
        return Immatriculation;
    }

    public void setImmatriculation(String Immatriculation) {
        this.Immatriculation = Immatriculation;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String Marque) {
        this.Marque = Marque;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String Couleur) {
        this.Couleur = Couleur;
    }

    public String getDateE() {
        return DateE;
    }

    public void setDateE(String DateE) {
        this.DateE = DateE;
    }

    public  int getFrais() {
        return Frais;
    }

    public String getDateS() {
        return DateS;
    }

    public void setDateS(String DateS) {
        this.DateS = DateS;
    }

    public long getDuree() {
        return Duree;
    }

    public void setDuree(long duree) {
        this.Duree = duree;
    }

    public String getProprietaire() {
        return Proprietaire;
    }

    public void setProprietaire(String Proprietaire) {
        this.Proprietaire = Proprietaire;
    }

   
    
}