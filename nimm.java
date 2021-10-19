import java.util.*;

class nimm {


  static Scanner scanner = new Scanner(System.in);
  
	public static void main(String[] args) {
  spielStarten();      
  System.out.println("Nochmal? (ja/nein)");
  String antwort = scanner.next();


  if(antwort == "ja"){
    spielStarten();
  }
  else if(antwort == "nein")
  {
    return;
  }
  else{
    System.out.println("Bitte gebe ja oder nein ein!")
  }
  }

  static void spielStarten()
  {
      int anzahl = einlesenAnzahl();
    int nimmAnzahl = einlesenNehmen();

    while(nimmAnzahl >= anzahl){
      System.out.println("Es dürfen nicht gleich oder mehr stäbchen weggenommen werden als vorhanden sind!");
      nimmAnzahl = einlesenNehmen();
    }

    System.out.println("Streichhölzer Anzahl: " + anzahl);
    System.out.println("Nimm Anzahl: " + nimmAnzahl);
    
   spielstand(anzahl);
   
   int aktuelleAnzahl = anzahl;

   while(aktuelleAnzahl >= 0){

   
        
      int genommen = nehmenAnzahlSpieler1();
      
      while(!istZugKorrekt(genommen, nimmAnzahl)){
          System.out.println("Der Zug ist nicht korrekt");
          genommen = nehmenAnzahlSpieler1();
      }

        aktuelleAnzahl = aktuelleAnzahl - genommen;
        System.out.println("Neue Streichhölzer Anzahl: " + aktuelleAnzahl);

        if(aktuelleAnzahl == 0)
        {
          System.out.println("Spieler 1 gewinnt!!!");
          return;
        }
          
        spielstand(aktuelleAnzahl);

      genommen = nehmenAnzahlSpieler2();

      while(!istZugKorrekt(genommen, nimmAnzahl)){
          System.out.println("Der Zug ist nicht korrekt");
          genommen = nehmenAnzahlSpieler2();
      }

      
      aktuelleAnzahl = aktuelleAnzahl - genommen;
      System.out.println("Neue Streichhölzer Anzahl: " + aktuelleAnzahl);

      if(aktuelleAnzahl == 0)
        {
          System.out.println("Spieler 2 gewinnt!!!");
          return;
        }

      
      
      spielstand(aktuelleAnzahl);
      }
  }




  static boolean istZugKorrekt( int genommen, int nimmAnzahl   ){

    if( genommen > nimmAnzahl)
    {
      return false;
    }else
    {
      return true;

    }


  }
  

   static int einlesenAnzahl(){
        System.out.println("Wie viele Hölzer soll es geben?");
        return scanner.nextInt();
   }
   static int einlesenNehmen(){
     System.out.println("Wie viele dürfen Maximal genommen werden?");
     return scanner.nextInt();
   }
   
   
   static int nehmenAnzahlSpieler1(){
     System.out.println("Spieler 1: Wieviele willst du wegnehmen?");
     return scanner.nextInt();

  }

   static int nehmenAnzahlSpieler2(){
     System.out.println("Spieler 2: Wieviele willst du wegnehmen?");
     return scanner.nextInt();

  }

  
   

   static void spielstand( int anzahl){
     
     int i = 1;

    while(i <= anzahl){
      System.out.print("| ");
      i = i + 1;

    }
   
    System.out.println("");

   }

}
