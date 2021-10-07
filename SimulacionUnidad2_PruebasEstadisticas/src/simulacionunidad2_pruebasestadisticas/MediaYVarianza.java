
package simulacionunidad2_pruebasestadisticas;

import java.io.*;
import javax.swing.JOptionPane;
import static simulacionunidad2_pruebasestadisticas.Interfaz.Datos;
import static simulacionunidad2_pruebasestadisticas.Interfaz.sumatoria;

/**
 *
 * @author J. Mauricio
 */
public class MediaYVarianza {
    public void media(){
        Double media;
        media = Double.parseDouble(Interfaz.sumatoria.getText())/Integer.parseInt(Interfaz.Datos.getText());
        String mediapo = Double.toString(media);
        Interfaz.Media.setText(mediapo);
    }
    public Double varianza(File archivo){
        String documento="";
        Double sumar,resultado = 0.0, sumatorias = 0.0;
        int suma=0;
        try{
            Interfaz.entrada=new FileInputStream(archivo);
            String ascci;
            BufferedReader br = new BufferedReader(new InputStreamReader(Interfaz.entrada));
            while((ascci=br.readLine())!=null){
                String caracter=(String)ascci;
                documento=caracter;
                sumar = Double.parseDouble(documento);
                
                Double[] datos=new Double[suma+1];
                datos[suma]=sumar;
                
                Double totalsuma;
                int datose;
        
                datose = Integer.parseInt(Datos.getText());
                totalsuma = Double.parseDouble(sumatoria.getText());
                Double media;
                media = totalsuma/datose;
                
                sumatorias = Math.pow(datos[suma]-media,2);
                
                resultado = resultado + sumatorias;
                
                suma++;
            }
            
            resultado = resultado / (suma-1);
            
            br.close();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Aun no se han ingresado datos");
        }
        return resultado;
    }
}
