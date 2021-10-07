
package simulacionunidad2_pruebasestadisticas;

/**
 *
 * @author J. Mauricio
 */
public class CorridasAyA {
    public void independencia(){
    Integer nivel;
        int datos;
        datos = Integer.parseInt(Interfaz.Datos.getText());
        nivel = Integer.parseInt((String) Interfaz.confiabilidad.getSelectedItem());
        int longi = datos-1;
        int[] Secuencia = new int[longi];
        int conta=0, si=1, an=0,aum=0, anterior=0, siguiente=1;
        while(conta!=longi){
            if(AbrirTXT.valores[si]<= AbrirTXT.valores[an]){
                Secuencia[conta]=0;
            }else if(AbrirTXT.valores[conta+1]> AbrirTXT.valores[conta]){
                Secuencia[conta]=1;
            }
            conta++;
            an++;
            si++;
        }
        int a=0;
       while(a!=longi){
           if(siguiente>=longi){
               if(Secuencia[anterior]==Secuencia[siguiente-2]){
                aum++;
               }else aum++;
            }
           else{
              if(Secuencia[anterior]==Secuencia[siguiente]){    
                siguiente++;
                anterior++;
              }else{
                siguiente++;
                anterior++;
                aum++;
              }
            }
            a++;
        }
        Double valoresperado, varianza,estadistico;
        valoresperado = (((2*datos)-1)/3.0);
        varianza = ((16*datos-29)/90.0);
        estadistico = Math.abs((aum-valoresperado)/Math.sqrt(varianza));
        
        if(nivel == 90){
            if(estadistico < 1.635){
                Interfaz.indep.setText("Los numeros del conjunto son independientes");
            }
            else{
                Interfaz.indep.setText("Los numeros del conjunto no son independientes");
            }
            Interfaz.estad.setText(String.format("%.2f",estadistico));
            Interfaz.calvalesp.setText(String.format("%.2f",valoresperado));
            Interfaz.calvarianza.setText(String.format("%.2f",varianza));
        }else if(nivel == 95){
            if(estadistico < 1.96){
                Interfaz.indep.setText("Los numeros del conjunto son independientes");
            }
            else{
                Interfaz.indep.setText("Los numeros del conjunto no son independientes");
            }
            Interfaz.estad.setText(String.format("%.2f",estadistico));
            Interfaz.calvalesp.setText(String.format("%.2f",valoresperado));
            Interfaz.calvarianza.setText(String.format("%.2f",varianza));    
        }else {
            if(estadistico < 2.575){
                Interfaz.indep.setText("Los numeros del conjunto son independientes");
            }
            else{
                Interfaz.indep.setText("Los numeros del conjunto no son independientes");
            }
            Interfaz.estad.setText(String.format("%.2f",estadistico));
            Interfaz.calvalesp.setText(String.format("%.2f",valoresperado));
            Interfaz.calvarianza.setText(String.format("%.2f",varianza));
        }
    }
}
